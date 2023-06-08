/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspbo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Item {
    
    public String code;
    public String name;
    public Float price;
    Date kadaluarsa;
    String operator;
    float nominal;
     static ArrayList<Item> itemlist;
    
    public static ArrayList<Item> daftarItem = new ArrayList<Item>();
    
}
