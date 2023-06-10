/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posprojectuts;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author xpopow
 */
public class DBConnector {
    static Connection connection;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/2023_db_pos";
    static final String USER = "root";
    static final String PASSWORD = "";

    
    public static Connection initDBConnection()
    {
     try {
         Class.forName(JDBC_DRIVER);
         connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
         return connection;
         
        
         
     } catch (Exception ex) {
         System.out.println(ex);
    }
        return null;
     
    }

    static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}