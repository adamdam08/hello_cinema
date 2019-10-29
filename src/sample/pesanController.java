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
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.control.Label;

public class pesanController extends dataController {
    public int harga;
    String title = null;
    int kursi = 0;
   
    @FXML
    private TextField filmid, nama, harga_kursi, jumlah_seat;
    public String namaPembeli;
    public String jumlahKursiPembeli;
    
    @FXML
    private Label data_kursi;

    @FXML
    private void cetakAction(ActionEvent event) throws SQLException, IOException {
        Node source1 = (Node) event.getSource();
        Stage stage1 = (Stage)  source1.getScene().getWindow();
        stage1.close();
        namaPembeli = nama.getText();
        jumlahKursiPembeli = jumlah_seat.getText();
        setData(namaPembeli, jumlahKursiPembeli);
        changeScene();
    }
    
    @FXML
    private void pickseatAction(ActionEvent event) {
        Node source1 = (Node) event.getSource();
        Stage stage1 = (Stage)  source1.getScene().getWindow();
        stage1.close();
        addScene();
    }
    
    public void sendData(int a) {
        setKey(a);
        System.out.println(a);
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
            harga = rs.getInt("f_harga");          
            kursi  = rs.getInt("f_seat");
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
        data_kursi.setText(String.valueOf(kursi));
        filmid.setText(title);
        harga_kursi.setText(String.valueOf(harga));
    }
    public int f_data;
    public String a_data[] = new String[45];
    
    public void SendseatData(int a,int key,String axz[]) {
        sendData(key);
        int data =  a * harga;
        if(data != 0){
            harga_kursi.setText(String.valueOf(data));
        }
        f_data = kursi - a;
        jumlah_seat.setText(String.valueOf(a));
        a_data = axz.clone();
    }
    
    public void updateData(int a,int b){
        try {
            System.out.println("KEY : "+a);
            System.out.println("KEY : "+b);
            dataController DB = new dataController();
            DB.config();
        
            con = DB.conn;
            stat = DB.stmt;
            
            String sql = "UPDATE `data` SET `f_seat`="+a+" WHERE id = "+b;
            stat.executeUpdate(sql);
        } catch(Exception e){
           e.printStackTrace();
        }
    }

    private void changeScene() throws SQLException, IOException {
        try{
            updateData(f_data,key);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cetak.fxml"));
            Parent root = loader.load();

            cetakController scnd = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scnd.sendData(key,namaPembeli,a_data);

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
    
    private void addScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("kursi.fxml"));
            Parent root = loader.load();

            kursiController scnd = loader.getController();
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
            System.out.println("error saat change stages pesan");
            e.printStackTrace();
        }
    }
   
}