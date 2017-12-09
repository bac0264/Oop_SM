/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PQD
 */
public class DBConnection {
    
    private Connection conn = null;
    private static String url = "jdbc:mysql://localhost:3306/database1";
    private static String user = "root";
    private static String password = "";
    
    public Connection ketNoi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(url, user, password);
   
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Load Driver khong thanh cong.");
        }
        catch (SQLException ex) {
            System.out.println("Loi:" + ex.getMessage());
        }
        return conn;
    } 
    public static boolean isExist(String str1, String str2) {
        Connection conn = null;
        DBConnection db = new DBConnection();
        conn = db.ketNoi();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement(str1);
            prst.setString(1, str2);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public static boolean isAccountExist(String str2, String str3){
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from sinhvien,admin where " + str2 +" = ?";
        Connection conn;

        try {
            conn = db.ketNoi();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str3);
            ResultSet rs = ptmt.executeQuery();
            if(rs.next()){
                conn.close();
                return true;
            }
            else{
                conn.close();
                return false; 
            }       
        } catch (SQLException ex) {
            System.out.println("Loi:" + ex.getMessage());
        }
        
        return false;
    }
}
