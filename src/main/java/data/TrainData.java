package data;

import train.Train;
import train.TrainCar;
import java.sql.*;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.substringBetween;

public class TrainData {
    private final String url = "jdbc:postgresql://localhost:5432/TransportDB";
    private final String userDB = "postgres";
    private final String passwordDB = "Loco9969";


    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, userDB, passwordDB);
    }

    private static Train selectedTrain;

    public Train getSelectedTrain(){
        return selectedTrain;
    }

    public void createTrain(String name, ArrayList<TrainCar> cars){
        insertTrain(new Train(name, cars));
    }

    public long insertTrain(Train train) {
        String SQL = "INSERT INTO public.train(train_name,train_cars) "
                + "VALUES(?,?)";

        long id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            StringBuilder sb = new StringBuilder();
            ArrayList<String> cars = new ArrayList<>();
            for (TrainCar car : train.getCars()){
                cars.add(car.toString());
                sb.append(car.toString()).append(" ,\n");
            };

            pstmt.setString(1, train.getTrainName());
            pstmt.setString(2, sb.toString());


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public ArrayList<String> showAllTrainsFromDB() {

        String SQL = "SELECT train_name, train_cars FROM public.train";
        ArrayList<String> trainsList = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            trainsList = displayTrain(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return trainsList;
    }

    private  ArrayList<String> displayTrain(ResultSet rs) throws SQLException {
        ArrayList<String> trainsList = new ArrayList<>();
        int counter = 1;
        while (rs.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                trainsList.add(stringBuilder.append(counter).append(" ").append(rs.getString("train_name"))
                        .append("\n").append(rs.getString("train_cars")).append("\n").toString());
                counter++;
            System.out.println("\n");
        }
        return trainsList;
    }

    public Train getTrainByNumber(int number) {
         ArrayList<String> trains = showAllTrainsFromDB();
         for (String train : trains) {
             if(getTrainNumber(train) == number){
                 selectedTrain = TrainStringToObj(train);
                 return TrainStringToObj(train);
             }
         }
         return null;
    }

    public Train TrainStringToObj(String trainString) {
        String trainName = substringBetween(trainString, " ", "\nTrainCar");
        int numberOfCars = Collections.frequency(Arrays.asList(trainString.split("\n")), "TrainCar");

        ArrayList<TrainCar> cars = new ArrayList<>();
        String[] arr = trainString.split("TrainCar");

        for (int i = 0, j = 1; i < numberOfCars; i++, j++) {
            String levelOfComfort = substringBetween(arr[j], "comfort: ", "\n");
            String numberOfPlaces = substringBetween(arr[j], "places: ", "\n");
            String amountOfBaggage = substringBetween(arr[j], "baggage: ", " ,");
            cars.add(new TrainCar(levelOfComfort, Integer.parseInt(numberOfPlaces), Integer.parseInt(amountOfBaggage)));
        }

        return new Train(trainName, cars);

    }

    public static int getTrainNumber(String SelectedTrain) {
        String arr[] = SelectedTrain.split(" ");
        return Integer.parseInt(arr[0]);
    }
}