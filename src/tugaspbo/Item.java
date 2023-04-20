/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspbo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Item {
    
    public String code;
    public String name;
    public Float price;
    
     static ArrayList<Item> itemlist;
    
    public static void loadBarangFromDB()
    {
        itemlist = new ArrayList<Item>();
        Item item;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            
            String sql = "Select * from tb_barang";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                item = new Item();
                item.code = Integer.toString(rs.getInt("kode"));
                item.name = rs.getString("nama");
                item.price = rs.getFloat("harga");
                
                itemlist.add(item);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
