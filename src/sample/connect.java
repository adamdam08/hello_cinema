//package sample;
//
////Mysql
//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import javax.swing.JOptionPane;
//
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author GL522VXK
// */
//public class connect {
//    public Connection conn;
//    public Statement stmt;
//    public ResultSet rs;
//    
//    //Mysql Config
//    public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    public final String DB_URL = "jdbc:mysql://localhost/hello_cinema";
//    public final String USER = "root";
//    public final String PASS = "";
//    public void config(){
//        try{
//            Class.forName(JDBC_DRIVER);
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            stmt = conn.createStatement();
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
//        }
//    }
//}
