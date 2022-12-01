package gui;

import data.TrainData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import data.UserData;
import train.Train;
import train.TrainCar;
import user.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.scene.input.DataFormat.URL;

public class SceneController implements Initializable {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    //DATA
    protected UserData userData = new UserData();
    protected TrainData trainData = new TrainData();
    protected ArrayList<TrainCar> cars = new ArrayList<>();
    //authorization
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label authCheck;

    //creation of train
    @FXML
    private TextField limitOfBaggageField;
    @FXML
    private TextField trainNameField;

    //adding cars
    @FXML
    private ScrollBar amountOfBaggageChoice;
    @FXML
    private ChoiceBox<String> levelOfComfortChoice = new ChoiceBox<>();
    @FXML
    private ScrollBar numberOfPlacesChoice;

    private String[] levelsOfComfort = {"First class", "Sleep", "Second class", "Chair"};

    //see trains
    @FXML
    private ListView<String> ListViewOfTrains = new ListView<>();
    @FXML
    private Label MyTrainId;
    @FXML
    private Label SelectedTrainId;

    //selected train
    @FXML
    private ListView<String> ListViewOfCars;

    //Find by range
    @FXML
    private ListView<String> ListViewRangedCars;
    @FXML
    private Label SelectedToRangeId;
    @FXML
    private TextField maxId;
    @FXML
    private TextField minId;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        levelOfComfortChoice.getItems().addAll(levelsOfComfort);
    }



    public void switchToStarterScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("starterMenu.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLoggingScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRegisterScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToActionMenuScene(ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("actionMenu.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTrainCreationScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("traincreation-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSeeTrainsScene(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("seeTrains-view.fxml"));
        root = loader.load();
        SceneController sceneController = loader.getController();
        sceneController.showTrains();
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTrainMenuScene(ActionEvent actionEvent) throws IOException {
        String SelectedTrain = MyTrainId.getText();
        int i = 0;
        i = Character.getNumericValue(SelectedTrain.charAt(0));
        Train t = trainData.getTrainByNumber(i);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trainMenu.fxml"));
        root = loader.load();
        SceneController sceneController = loader.getController();
        sceneController.displaySelectedTrain(t);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSortScene(ActionEvent actionEvent) throws IOException {
        Train train = trainData.getSelectedTrain();
        train.sortCarsByLevelOfComfort();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sort-view.fxml"));
        root = loader.load();
        SceneController sceneController = loader.getController();
        sceneController.showCars(train);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFindRangeScene(ActionEvent actionEvent) throws IOException {
        String SelectedTrain = SelectedTrainId.getText();
        Train train = trainData.getSelectedTrain();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("findByRange-view.fxml"));
        root = loader.load();
        SceneController sceneController = loader.getController();
        sceneController.displaySelectedToRange(SelectedTrain);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ExitScene(ActionEvent actionEvent) throws IOException {
        System.exit(0);
    }


    public void Authorization(ActionEvent actionEvent) throws IOException {

        if(userData.logIn(usernameField.getText(), passwordField.getText())){
            switchToActionMenuScene(actionEvent);
        } else {
            authCheck.setText("You entered an incorrect username or password");
        }
    }

    public void Registration(ActionEvent actionEvent) throws IOException {
        if(userData.signUp(usernameField.getText(), passwordField.getText())){
            switchToLoggingScene(actionEvent);
        } else {
            authCheck.setText("This username is already taken..");
        }
    }

    public void TrainCreation(ActionEvent actionEvent) throws IOException {
        String trainName = trainNameField.getText();

        trainData.insertTrain(new Train(trainName, cars));

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("actionMenu.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addTrainCar() {
        cars.add(new TrainCar(levelOfComfortChoice.getValue(),
                (int)(numberOfPlacesChoice.getValue()),
                (int) (amountOfBaggageChoice.getValue())));
        levelOfComfortChoice.setValue("");
        numberOfPlacesChoice.setValue(1);
        amountOfBaggageChoice.setValue(1);
    }

    public void showCars(Train t) throws  IOException {
        ArrayList<String> carsList = new ArrayList<>();
        int counter = 1;
        for (TrainCar car : t.getCars()){
            StringBuilder stringBuilder = new StringBuilder();
            carsList.add(stringBuilder.append(counter).append(" ").append(car.toString()).append("\n").toString());
            counter++;
        }
        ListViewOfCars.getItems().addAll(carsList);
    }

    public void findingByRange(ActionEvent actionEvent) {
        Train t = trainData.getSelectedTrain();
        ArrayList<String> carsList = new ArrayList<>();
        int counter = 1;
        for (TrainCar car : t.getCars()){
            if(Integer.parseInt(minId.getText()) <= car.getNumberOfPlaces()
                    && car.getNumberOfPlaces() <= Integer.parseInt(maxId.getText())) {
                StringBuilder stringBuilder = new StringBuilder();
                carsList.add(stringBuilder.append(counter).append(" ").append(car.toString()).append("\n").toString());
                counter++;
            }
        }
        ListViewRangedCars.getItems().clear();
        ListViewRangedCars.getItems().addAll(carsList);
    }

    public void showTrains() throws IOException {
        ArrayList<String>trainsList = trainData.showAllTrainsFromDB();
        ListViewOfTrains.getItems().addAll(trainsList);

        ListViewOfTrains.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                String temp = ListViewOfTrains.getSelectionModel().getSelectedItem();
                MyTrainId.setText(temp);
            }
        });
    }

    public Train displaySelectedTrain(Train t){
        SelectedTrainId.setText(t.getTrainName());
        return t;
    }

    public void displaySelectedToRange(String name){
        SelectedToRangeId.setText(name);
    }


}