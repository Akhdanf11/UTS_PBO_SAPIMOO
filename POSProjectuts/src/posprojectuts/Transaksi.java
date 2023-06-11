/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posprojectuts;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Zaki
 */
public class Transaksi {
    public static int id_transaksi;
    public static float total_harga;
    public static float kembalian;
    
    public static ArrayList<rincian_transaksi> listItem = new ArrayList<>();
    
    public Transaksi(int id_transaksi, float total_harga){
      this.id_transaksi = id_transaksi;
      this.total_harga = total_harga;
      this.kembalian = kembalian;
    }
    
    public static void addItem(rincian_transaksi item){
        listItem.add(item);
    }
    
    public static void simpanDatabase() throws SQLException{
        
        try{
            Connection conn = DBConnector.initDBConnection();
            String sql = "INSERT INTO transaksi(id_transaksi,total_harga) VALUES(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_transaksi);
            stmt.setFloat(2, total_harga);           
            stmt.executeUpdate();
            
            
            sql = "INSERT INTO rincian_transaksi (id_transaksi, id_barang, nama_barang, harga_satuan, jumlah_barang, harga_total) VALUES(?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            for(rincian_transaksi item : listItem){
                stmt.setInt(1, id_transaksi);
                stmt.setInt(2, item.id_barang);
                stmt.setString(3, item.nama_barang);
                stmt.setFloat(4,item.harga_satuan);
                stmt.setInt(5, item.jumlah_barang);
                stmt.setFloat(6, item.harga_total);
                stmt.executeUpdate();
            }
             
            
        } catch(SQLException e){
            System.out.print(e);
        }
    }
            


     static class rincian_transaksi {
        public int id_barang;
        public String nama_barang;
        public float harga_satuan;
        public int jumlah_barang;
        public float harga_total;
        
        
        public rincian_transaksi(int id_barang, String nama_barang, float harga_satuan, int jumlah_barang, float harga_total) {
            this.id_barang = id_barang;
            this.nama_barang = nama_barang;
            this.harga_satuan = harga_satuan;
            this.jumlah_barang = jumlah_barang;
            this.harga_total = harga_total;
          
        }
    }
     
     
     

}
