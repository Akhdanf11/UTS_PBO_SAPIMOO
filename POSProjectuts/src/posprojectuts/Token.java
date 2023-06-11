/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posprojectuts;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class Token {
    
    public String kode;
    public String nama;
    public float harga;
    Date kadaluarsa;
    String operator;
    float nominal;
    static String noMeteran;
    static String token;
    
    static ArrayList<Token> daftarToken;
    
    public static void loadBarangFromDB()
    {

        Item token;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            
            String sql = "Select * from token";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                token = new Item();
                token.kode = Integer.toString(rs.getInt("kode"));
                token.nama = rs.getString("nama");
                token.harga = rs.getFloat("harga");
                token.kadaluarsa = null;
                token.operator = null;
                token.nominal = rs.getFloat("nominal");
                
               
                Item.daftarItem.add(token);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
