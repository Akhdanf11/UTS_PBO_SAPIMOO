/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspbo;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author xpopow
 */
public class barang extends Item{
    
    
    public static void loadBarangFromDB()
    {
        Item makanan;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            
            String sql = "Select * from makanan";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                makanan = new Item();
                makanan.code = Integer.toString(rs.getInt("kode"));
                makanan.name = rs.getString("nama");
                makanan.price = rs.getFloat("harga");
                makanan.kadaluarsa = rs.getDate("kadaluarsa");
                makanan.operator = null;
                makanan.nominal = 0;
                
               
                Item.daftarItem.add(makanan);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }    
}
