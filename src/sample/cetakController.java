package sample;



//FXML + JAVA
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

//inheritance + abstract + interface
public class cetakController extends dataController implements Initializable {
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
    private Label data_kursi;
    
    int temp_a, temp_b;
    
    @FXML
    //enkapsulasi
    private void homebtnAction(ActionEvent event) {
        Stage stage = (Stage) homebtn.getScene().getWindow();
        stage.close();
        changeScene();
    }
    
    //OVERLOADING
    public void sendData(int key, String nama,String ax[]) {
        String title = null;
        //set key
        setKey(key);
        try {
        dataController DB = new dataController();
        DB.config();
        
        con = DB.conn;
        stat = DB.stmt;
        
        
        sql = "SELECT * FROM data where id = "+key+"";
        rs = stat.executeQuery(sql);
        
        while (rs.next()) {
            int id = rs.getInt("id");  
            title = rs.getString("f_name");          
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
        t_film.setText(title);
        t_nama.setText(nama);
       
        data_kursi.setText(Arrays.toString(ax));
    }
    
    public int randomCode(){
        Random rand = new Random();
        int b = rand.nextInt(1000);
        return b += 50;
    }

    //polymorpism
    private void changeScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();
            
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
        
        //exception handling
        } catch (IOException e) {
            System.out.println("error saat change stages");
            e.printStackTrace();
        }
    }
    
    //    onload scene execute
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t_kodebook.setText(String.valueOf(randomCode()));
    }
}
