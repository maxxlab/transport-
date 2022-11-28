package data;

import train.Train;
import train.TrainCar;
import train.TrainCarLevelsEnum;

import java.io.IOException;
import java.util.*;
import java.util.List;

import static usermenu.TrainMenu.trainMenu;

public class TrainData {
    List<Train> trains = new ArrayList<>();

    public List<Train> getTrains() {
        return trains;
    }

    public void showAllTrains() throws IOException {
        System.out.println("*ALL TRAINS*");
        if (trains.size()!=0) {
            int counter = 1;
            for (Train train : trains){
                System.out.println(counter + " " + train);
                System.out.println("\n");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose train number: ");
            int trainNumber = scanner.nextInt();

            trainMenu(trains.get(--trainNumber));
        } else {
            System.out.println("There are no trains now..");
        }

    }

    public void createTrain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of train: ");
        String trainName = scanner.next();
        System.out.println("Enter the limit of baggage: ");
        int limitOfBaggage = scanner.nextInt();
        List<TrainCar> cars = new ArrayList<>();
        System.out.println("Add cars: ");
        int choice = 1;
        do {
            System.out.println("Enter level of comfort(FirstClass,\n" +
                    "    Sleep,\n" +
                    "    SecondClass,\n" +
                    "    Chair): ");
            String levelOfComfort = scanner.next();
            try {
                TrainCarLevelsEnum.valueOf(levelOfComfort);
                System.out.println("Enter number of places: ");
                int numberOfPlaces = scanner.nextInt();
                System.out.println("Enter amount of baggage: ");
                int amountOfBaggage = scanner.nextInt();
                cars.add(new TrainCar(TrainCarLevelsEnum.valueOf(levelOfComfort), numberOfPlaces, amountOfBaggage));
                System.out.println("Do you want to add another one?(1-yes/0-no)");
            } catch (IllegalArgumentException ex) {
                System.out.println("*Error*\n try again..");
                System.out.println("Do you want to add another one?(1-yes/0-no)");
            }

        } while(scanner.nextInt()!=0);
        trains.add(new Train(trainName, limitOfBaggage, cars));
    }


}
