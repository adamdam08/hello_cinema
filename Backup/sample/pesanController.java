package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.Random;

public class pesanController extends homeController {
    @FXML
    private TextField filmid, nama, total_harga,jumlah_seat; 
    public String names;
    int p_key;

    public void sendData(int a){
        filmid.setText(filmname[a]);
        total_harga.setText(String.valueOf(f_harga[a]));
        System.out.println("PesanController");
        System.out.println("kode film : "+a);
        p_key = a;
    }

    @FXML
    private void cetakAction(ActionEvent event) {
        Node source1 = (Node) event.getSource();
        Stage stage1 = (Stage)  source1.getScene().getWindow();
        stage1.close();
        changeScene("cetak.fxml");
    }
    
    public int randomCode(){
        Random rand = new Random();
        int b = rand.nextInt(1000);
        b += 50;
        return b;
    }

    private void changeScene(String f) {
        try {
            names = nama.getText();
            String mou = jumlah_seat.getText();
            int seat_data = Integer.parseInt(mou);
            System.out.println("KodeFilm_send : "+p_key);
            System.out.println("Nama : "+names);
            System.out.println("Jumlah Kursi Dipesan : "+seat_data);
            System.out.println("PesanControllerEnd");
            FXMLLoader loader = new FXMLLoader(getClass().getResource(f));
            Parent root = loader.load();

            cetakController scnd = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scnd.sendData(p_key,seat_data, names);

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
            System.out.println("error saat change stages pesan");
            e.printStackTrace();
        }
    }

}
