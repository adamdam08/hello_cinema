package sample;

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

import java.io.IOException;

public class loginController extends commonController{
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;
    @FXML
    private Label LoadingLabel;
    @FXML
    private Button loginbtn;
    @FXML
    
    private void loginAction(ActionEvent event)  {
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
        boolean key = false;
        String email = emailField.getText();
        String password = passwordField.getText();
        
        dataController DB = new dataController();
        DB.config();
        
        con = DB.conn;
        stat = DB.stmt;
        
        try {
            
            sql = "SELECT * FROM admin WHERE username='"+email+"' AND password='"+password+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(email.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    key = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    
    private void changeScene() {
        try {     
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();
            
            homeController scnd = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            
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
