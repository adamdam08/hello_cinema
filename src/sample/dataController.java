package sample;

import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class dataController extends commonController implements Initializable{

        public int key;
        public String p_nama, p_jumlahKursi;
        public String text;
        public int last_key;
        public int last_data;
        public int[] save_data = null;
        
        //Mysql
        public Connection conn;
        public Statement stmt;
        public ResultSet rs;
    
        //Mysql Config
        public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        public final String DB_URL = "jdbc:mysql://localhost/hello_cinema";
        public final String USER = "root";
        public final String PASS = "";
        
        public void config(){
            try{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Koneksi Ke database Gagal"+e.getMessage());
            }
        }
        
        @Override
        public void initialize(URL location, ResourceBundle resources) { }

        public int setKey(int key) {
            return this.key = key ;
        }
        public void setText(String t) {
          text = t;
        }
        public void setData(String nama, String jumlah_kursi) {
            p_nama = nama;
            p_jumlahKursi = jumlah_kursi;
        }
}
