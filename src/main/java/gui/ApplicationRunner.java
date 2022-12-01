package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ApplicationRunner extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("starterMenu.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Transport App");
        stage.getIcons().add(new Image("Train_Logo.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

//        try{
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportDB",
//                    "postgres", "Loco9969");
//            System.out.println("Connected successfully");
//        } catch(SQLException exception) {
//            System.out.println("Failed Connection!");
//            exception.printStackTrace();
//        }

    }
}