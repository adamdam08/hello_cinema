package sample;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

//inheritance + abstract + interface
public class cetakController extends pesanController implements remus{

    @FXML
    //enkapsulasi  
    private Button homebtn;
    @FXML
    //enkapsulasi
    private Label t_film;
    @FXML
    //enkapsulasi
    private Label t_nama;
    @FXML
    //enkapsulasi
    private Label t_kodebook;
    @FXML
    //enkapsulasi
    private Label total_pembayaran;
    
    int temp_a, temp_b;
    
    @FXML
    //enkapsulasi
    private void homebtnAction(ActionEvent event) {
        Stage stage = (Stage) homebtn.getScene().getWindow();
        stage.close();
        changeScene("home.fxml");
    }
    
    //Overriding
    @Override
    public int randomCode(){
        Random rand = new Random();
        int b = rand.nextInt(1000);
        b += 50;
        return b;
    }
    
    //overloading
    @Override
    public void sendData(int a,int b,String n){
        t_kodebook.setText(String.valueOf(randomCode()));
        t_film.setText(filmname[a]);
        t_nama.setText(n);
        temp_a = a;
        temp_b = b;
        //Mutator
        int moux = f_harga[a]; 
        int mou = b * moux;
        
        //Assessor
        total_pembayaran.setText(String.valueOf(mou));
    }

    //polymorpism
    private void changeScene(String f) {
        try {
            System.out.println("cetakController");
            System.out.println(key);
            System.out.println("cetakControllerEnd");
            temp_a = key;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(f));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            
            dataController scnd = loader.getController();
//            Pass whatever data you want. You can have multiple method calls here
            scnd.sendDataUp(temp_a,temp_b);
//            super.sendDataUp(temp_a,temp_b);
            root.setOnMousePressed(event -> {
                x = event.getX();
                y = event.getY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });
            stage.show();
        
        //exception handling
        } catch (IOException e) {
            System.out.println("error saat change stages");
            e.printStackTrace();
        }
    }
}
