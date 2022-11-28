package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import data.UserData;
import user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SceneController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    protected UserData userData = new UserData();

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label authCheck;

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

    public void ExitScene(ActionEvent actionEvent) throws IOException {
        System.exit(0);
    }

    public void Authorization(ActionEvent actionEvent) throws IOException {

        if(userData.logIn(usernameField.getText(), passwordField.getText())){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("actionMenu.fxml")));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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
}