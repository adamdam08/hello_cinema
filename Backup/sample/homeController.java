package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class homeController extends dataController implements Initializable{
    public int key;
    @FXML
    private ImageView filmimg;
    @FXML
    private Label title, harga, seat;
    @FXML
    private TextArea filmsinopsis;
    @FXML
    private Button avengerbtn, spidermanbtn;
    @FXML
    private void avengerbtnAction(ActionEvent event) {
        setFilm(film[0], sinopsis[0],filmname[0],f_harga[0],f_seat[0]);
        key = 0;
        System.out.println("HomeController");
        System.out.println("key : "+key);
        System.out.println("HomeControllerEnd");

    }
    @FXML
    private void spidermanbtnAction(ActionEvent event) {
        setFilm(film[1], sinopsis[1],filmname[1],f_harga[1],f_seat[1]);
        key = 1;
        System.out.println("HomeController");
        System.out.println("key : "+key);
        System.out.println("HomeControllerEnd");
    }

    @FXML
    private void pesanbtnAction(ActionEvent event) {
        Node source1 = (Node) event.getSource();
        Stage stage1 = (Stage)  source1.getScene().getWindow();
        stage1.close();
        changeScene();
    }


    private void setFilm(String filmname ,String sinopsis, String judul, int prices, int kursi) {
        String i_ikursi = String.valueOf(kursi);
        String i_harga = String.valueOf(prices);
        filmimg.setImage(new Image(String.valueOf(this.getClass().getResource(filmname))));
        filmsinopsis.setText(sinopsis);
        title.setText(judul);
        harga.setText(i_harga);
        seat.setText(i_ikursi);
    }

    private void changeScene() {
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("pesan.fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pesan.fxml"));
            Parent root = loader.load();

            pesanController scnd = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scnd.sendData(key);

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
            System.out.println("error saat change stages home");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            setFilm(film[0], sinopsis[0],filmname[0],f_harga[0],f_seat[0]);
        }
        catch (Exception e){
            
        }
    }
}
