package sample;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class loginController extends commonController{
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button loginbtn;
    @FXML
    private void loginAction(ActionEvent event) {
        if (validasi() == true) {
            Node source = (Node) event.getSource();
            Stage stage = (Stage)  source.getScene().getWindow();
            stage.close();
            changeScene();
        } else {
            errorLabel.setVisible(true);
        }
    }
    private boolean validasi() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.equals("saya") && password.equals("saya")) {
            return true;
        } else {
            return false;
        }
    }

    private void changeScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);

            root.setOnMousePressed(event -> {
                x = event.getX();
                y = event.getY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });
            stage.show();
        } catch (IOException e) {
            System.out.println("error saat change stages");
        }
    }

}
