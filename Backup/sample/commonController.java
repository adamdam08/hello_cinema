package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class commonController  {
    public double x, y;
    @FXML
    private javafx.scene.control.Button closebtn;

    @FXML
    private javafx.scene.control.Button back;

    @FXML
    private javafx.scene.control.Button minimizebtn;
    @FXML
    public void closebtnAction(ActionEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void minimizebtnAction(ActionEvent event) {
        Stage stage = (Stage) minimizebtn.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void b_back(ActionEvent event) {
        try {
            Stage stage1 = (Stage) back.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cetakAction(ActionEvent event) {
        changeScene();
    }

    private void changeScene() {
        try {
            Stage stage1 = (Stage) back.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cetak.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
