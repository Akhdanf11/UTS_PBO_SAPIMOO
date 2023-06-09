/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posprojectuts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Barang {
    public String kode;
    public String nama;
    public float harga;
    Date kadaluarsa;
    String operator;
    float nominal;
  
    public static void loadBarangFromDB()
    {

        Item barang;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            
            String sql = "Select * from barang";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                barang = new Item();
                barang.kode = Integer.toString(rs.getInt("kode"));
                barang.nama = rs.getString("nama");
                barang.harga = rs.getFloat("harga");
                barang.kadaluarsa = null;
                barang.operator = null;
                barang.nominal = 0;
                
               
                Item.daftarItem.add(barang);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}