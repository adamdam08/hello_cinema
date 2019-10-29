/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author GL522VXK
 */
public class kursiController extends pesanController{
    @FXML
    private ImageView a1,a2,a3,a4,a5,a6,a7,a8,a9;
    @FXML
    private ImageView b1,b2,b3,b4,b5,b6,b7,b8,b9;
    @FXML
    private ImageView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    @FXML
    private ImageView d1,d2,d3,d4,d5,d6,d7,d8,d9;
    @FXML
    private ImageView e1,e2,e3,e4,e5,e6,e7,e8,e9;
    @FXML
    private Label count_seat,data_kursi;
    int x = 0;
    public String a[] = new String[45];
    int jumlah = 0;
    
    
    @Override
    public void sendData(int a) {
        setKey(a);
        int kursi = 0;
        try {
        dataController DB = new dataController();
        DB.config();
        
        con = DB.conn;
        stat = DB.stmt;
        
        
        sql = "SELECT * FROM data where id = "+key+"";
        rs = stat.executeQuery(sql);
        
        while (rs.next()) {
            kursi  = rs.getInt("f_seat");
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void finishAction(ActionEvent event) {
        Node source1 = (Node) event.getSource();
        Stage stage1 = (Stage)  source1.getScene().getWindow();
        stage1.close();
        changeScene();
        System.out.println(Arrays.toString(a));
        System.out.println("Jumlah : " + jumlah);
        
    }
    
    @FXML
    private void a1Action(ActionEvent event) {
        a[x] = "a1";
        x += 1;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void a2Action(ActionEvent event) {
        a[x] = "a2";
        x += 1;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void a3Action(ActionEvent event) {
        a[x] = "a3";
        x += 1;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void a4Action(ActionEvent event) {
        a[x] = "a4";
        x += 1;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void a5Action(ActionEvent event) {
        a[x] = "a5";
        x += 1;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void a6Action(ActionEvent event) {
        a[x] = "a6";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void a7Action(ActionEvent event) {
        a[x] = "a7";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void a8Action(ActionEvent event) {
        a[x] = "a8";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void a9Action(ActionEvent event) {
        a[x] = "a9";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b1Action(ActionEvent event) {
        a[x] = "b1";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b2Action(ActionEvent event) {
        a[x] = "b2";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b3Action(ActionEvent event) {
        a[x] = "b3";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b4Action(ActionEvent event) {
        a[x] = "b4";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b5Action(ActionEvent event) {
        a[x] = "b5";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b6Action(ActionEvent event) {
        a[x] = "b6";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b7Action(ActionEvent event) {
        a[x] = "b7";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b8Action(ActionEvent event) {
        a[x] = "b8";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void b9Action(ActionEvent event) {
        a[x] = "b9";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c1Action(ActionEvent event) {
        a[x] = "c1";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c2Action(ActionEvent event) {
        a[x] = "c2";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c3Action(ActionEvent event) {
        a[x] = "c3";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c4Action(ActionEvent event) {
        a[x] = "c4";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c5Action(ActionEvent event) {
        a[x] = "c5";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c6Action(ActionEvent event) {
        a[x] = "c6";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c7Action(ActionEvent event) {
        a[x] = "c7";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c8Action(ActionEvent event) {
        a[x] = "c8";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void c9Action(ActionEvent event) {
        a[x] = "c9";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d1Action(ActionEvent event) {
        a[x] = "d1";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d2Action(ActionEvent event) {
        a[x] = "d2";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d3Action(ActionEvent event) {
        a[x] = "d3";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d4Action(ActionEvent event) {
        a[x] = "d4";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d5Action(ActionEvent event) {
        a[x] = "d5";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d6Action(ActionEvent event) {
        a[x] = "d6";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d7Action(ActionEvent event) {
        a[x] = "d7";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d8Action(ActionEvent event) {
        a[x] = "d8";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void d9Action(ActionEvent event) {
        a[x] = "d9";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e1Action(ActionEvent event) {
        a[x] = "e1";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e2Action(ActionEvent event) {
        a[x] = "e2";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e3Action(ActionEvent event) {
        a[x] = "e3";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e4Action(ActionEvent event) {
        a[x] = "e4";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e5Action(ActionEvent event) {
        a[x] = "e5";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e6Action(ActionEvent event) {
        a[x] = "e6";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e7Action(ActionEvent event) {
        a[x] = "e7";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e8Action(ActionEvent event) {
        a[x] = "e8";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    @FXML
    private void e9Action(ActionEvent event) {
        a[x] = "e9";
        x++;
        jumlah += 1;
        showData();
        showJumlah();
    }
    
    public void showData(){
//        data_kursi.setText(Arrays.toString(a));
    }
    
    public void showJumlah(){
//        count_seat.setText(String.valueOf(jumlah));
    }
    
    private void changeScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pesan.fxml"));
            Parent root = loader.load();

            pesanController scnd = loader.getController();
//          Pass whatever data you want. You can have multiple method calls here
            scnd.SendseatData(jumlah,key,a);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);

            root.setOnMousePressed(event -> {
                x = (int) event.getX();
                y = event.getY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });
            stage.show();
        } catch (IOException e) {
            System.out.println("error saat change stages kursi");
            e.printStackTrace();
        }
    }
}
