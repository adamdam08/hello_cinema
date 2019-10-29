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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class homeController extends dataController implements Initializable {
    @FXML
    private AnchorPane welcome_page,info_page;
    @FXML
    private ImageView filmimg;
    @FXML
    private ImageView Studio1Banner,Studio2Banner,Studio3Banner,Studio4Banner,Studio5Banner;
    @FXML
    private Label title, harga, seat;
    @FXML
    private TextArea filmsinopsis;
    @FXML
    private Button Studio1,Studio2,Studio3,Studio4,Studio5;
    @FXML
    private void Studio1Action(ActionEvent event) throws SQLException {
        welcome_page.setVisible(false);
        info_page.setVisible(true);
        setKey(1);
        setDefault(key);
        
    }
    @FXML
    private void Studio2Action(ActionEvent event) throws SQLException {
        welcome_page.setVisible(false);
        info_page.setVisible(true);
        setKey(2);
        setDefault(key);
    }
    @FXML
    private void Studio3Action(ActionEvent event) throws SQLException {
        welcome_page.setVisible(false);
        info_page.setVisible(true);
        setKey(3);
        setDefault(key);
    }
    @FXML
    private void Studio4Action(ActionEvent event) throws SQLException {
        welcome_page.setVisible(false);
        info_page.setVisible(true);
        setKey(4);
        setDefault(key);
    }
    @FXML
    private void Studio5Action(ActionEvent event) throws SQLException {
        welcome_page.setVisible(false);
        info_page.setVisible(true);
        setKey(5);
        setDefault(key);
    }

    @FXML
    private void pesanbtnAction(ActionEvent event) {
        Node source1 = (Node) event.getSource();
        Stage stage1 = (Stage)  source1.getScene().getWindow();
        stage1.close();
        changeScene("pesan.fxml");
    }
    
    @FXML
    private void logoutAction(ActionEvent event) {
        Node source1 = (Node) event.getSource();
        Stage stage1 = (Stage)  source1.getScene().getWindow();
        stage1.close();
        changeScene("login.fxml");
    }

    private void setFilm(String image ,String sinopsis, String judul, int prices, int kursi) {
        String i_ikursi = String.valueOf(kursi);
        String i_harga = String.valueOf(prices);
        filmimg.setImage(new Image(String.valueOf(this.getClass().getResource(image))));
        filmsinopsis.setText(sinopsis);
        title.setText(judul);
        harga.setText(i_harga);
        seat.setText(i_ikursi);
    }

    private void changeScene(String link) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(link));
            Parent root = loader.load();
            if("pesan.fxml".equals(link)){
                pesanController scnd = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scnd.sendData(key);
            }
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
    
    public void setDefault(int key) {
        try {
        dataController DB = new dataController();
        DB.config();
        
        con = DB.conn;
        stat = DB.stmt;
        
        
        sql = "SELECT * FROM data where id = "+key+"";
        rs = stat.executeQuery(sql);
        
        while (rs.next()) {
            int id = rs.getInt("id");  
            String title = rs.getString("f_name");          
            int harga = rs.getInt("f_harga");          
            int kursi  = rs.getInt("f_seat");         
            String sinopsis = rs.getString("sinopsis");         
            String iamge = rs.getString("image_link");      
            setFilm(iamge, sinopsis ,title ,harga ,kursi);      
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setBanner() {
        int temp_id;
        String st1banner = null;
        String st2banner = null;
        String st3banner = null;
        String st4banner = null;
        String st5banner = null;
        try {
            dataController DB = new dataController();
            DB.config();
        
            con = DB.conn;
            stat = DB.stmt;
            
            sql = "SELECT * FROM data";
        rs = stat.executeQuery(sql);
        while(rs.next()){
            temp_id = rs.getInt("id");
                switch (temp_id) {
                    case 1:
                        st1banner = rs.getString("image_link");
                        break;
                    case 2:
                        st2banner = rs.getString("image_link");
                        break;
                    case 3:
                        st3banner = rs.getString("image_link");
                        break;
                    case 4:
                        st4banner = rs.getString("image_link");
                        break;
                    case 5:
                        st5banner = rs.getString("image_link");
                        break;
                    default:
                        break;
                }
               
        }
//        Set image banner
        Studio1Banner.setImage(new Image(String.valueOf(this.getClass().getResource(st1banner))));
        Studio2Banner.setImage(new Image(String.valueOf(this.getClass().getResource(st2banner))));
        Studio3Banner.setImage(new Image(String.valueOf(this.getClass().getResource(st3banner))));
        Studio4Banner.setImage(new Image(String.valueOf(this.getClass().getResource(st4banner))));
        Studio5Banner.setImage(new Image(String.valueOf(this.getClass().getResource(st5banner))));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
//    onload scene execute
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBanner();
    }
    
}
