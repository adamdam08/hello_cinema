/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Scanner;
/**
 *
 * @author GL522VXK
 */
public class kursiController extends pesanController implements Initializable{
    
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
    public int jumlah = 0;
//    public String a_save[] = new String[jumlah];
//    public int xz = 0;

    
    boolean a1_stat = false,a2_stat = false ,a3_stat = false,a4_stat = false,a5_stat = false,a6_stat = false,a7_stat = false,a8_stat = false,a9_stat = false;
    boolean b1_stat = false,b2_stat = false,b3_stat = false,b4_stat = false,b5_stat = false,b6_stat = false,b7_stat = false,b8_stat = false,b9_stat = false;
    boolean c1_stat = false,c2_stat = false,c3_stat = false,c4_stat = false,c5_stat = false,c6_stat = false,c7_stat = false,c8_stat = false,c9_stat = false;
    boolean d1_stat = false,d2_stat = false,d3_stat = false,d4_stat = false,d5_stat = false,d6_stat = false,d7_stat = false,d8_stat = false,d9_stat = false;
    boolean e1_stat = false,e2_stat = false,e3_stat = false,e4_stat = false,e5_stat = false,e6_stat = false,e7_stat = false,e8_stat = false,e9_stat = false;
    
    String seat_true = "..\\img\\chairRed.png";
    String seat_false = "..\\img\\chairBlack.png";
    
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
    
    public void savedata(int jumlah) {   
//       do{
//            a_save[xz] = a[xz];
//            xz++;
//        }while(xz < jumlah);
//       System.out.println("Savedata : "+Arrays.toString(a_save));
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
        if(a1_stat == false){
            a1.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a1";
            x += 1;
            jumlah += 1;
            a1_stat = true;
        }else{
            a1.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a1_stat = false;
            jumlah -= 1;
        }
    }
    
    @FXML
    private void a2Action(ActionEvent event) {
        if(a2_stat == false){
            a2.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a2";
            x += 1;
            jumlah += 1;
            a2_stat = true;
        }else{
            a2.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a2_stat = false;
            jumlah -= 1;
        }
    }
    
    @FXML
    private void a3Action(ActionEvent event) {
        if(a3_stat == false){
            a3.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a3";
            x += 1;
            jumlah += 1;
            a3_stat = true;
        }else{
            a3.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a3_stat = false;
            jumlah -= 1;
        }
    }
    
    @FXML
    private void a4Action(ActionEvent event) {
        if(a4_stat == false){
            a4.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a4";
            x += 1;
            jumlah += 1;
            a4_stat = true;
        }else{
            a4.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a4_stat = false;
            jumlah -= 1;
        }
    }
    
    @FXML
    private void a5Action(ActionEvent event) {
        if(a5_stat == false){
            a5.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a5";
            x += 1;
            jumlah += 1;
            a5_stat = true;
        }else{
            a5.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a5_stat = false;
            jumlah -= 1;
        }
    }
    
    @FXML
    private void a6Action(ActionEvent event) {
        if(a6_stat == false){
            a6.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a6";
            x += 1;
            jumlah += 1;
            a6_stat = true;
        }else{
            a1.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a1_stat = false;
            jumlah -= 1;
        }
    }
    
    @FXML
    private void a7Action(ActionEvent event) {
        if(a7_stat == false){
            a7.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a7";
            x += 1;
            jumlah += 1;
            a7_stat = true;
        }else{
            a7.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a7_stat = false;
            jumlah -= 1;
        }
    }
    
    @FXML
    private void a8Action(ActionEvent event) {
        if(a8_stat == false){
            a8.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a8";
            x += 1;
            jumlah += 1;
            a8_stat = true;
        }else{
            a8.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a8_stat = false;
            jumlah -= 1;
        }
    }
    
    @FXML
    private void a9Action(ActionEvent event) {
        if(a9_stat == false){
            a9.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = "a9";
            x += 1;
            jumlah += 1;
            a9_stat = true;
        }else{
            a9.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            a9_stat = false;
            jumlah -= 1;
        }
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
            savedata(jumlah);
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
