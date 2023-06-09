/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posprojectuts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */

public class QRIS implements PembayaranInterface {
    private float totalHarga;
    private int IDPembayaran;
    private String waktuPembayaran;
   
    String jenisPembayaran = "QRIS";
    
    @Override
    public float getTotalHarga() {
        return totalHarga;
    }

    @Override
    public void setTotalHarga(float totalHarga) {
        this.totalHarga = totalHarga;
    }

    @Override
    public String getWaktuPembayaran() {
        return waktuPembayaran;
    }

    @Override
    public void setWaktuPembayaran(String waktuPembayaran) {
        this.waktuPembayaran = waktuPembayaran;
    }

    @Override
    public int getIDPembayaran() {
        return IDPembayaran;
    }

    @Override
    public void setIDPembayaran(int IDPembayaran) {
        this.IDPembayaran = IDPembayaran;
    }
    
     public void simpanDatabase() throws SQLException{
         try{
            Connection conn = DBConnector.initDBConnection();
            String sql = "INSERT INTO transaksi(id, total_harga, waktu_pembayaran, jenis_pembayaran) VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
           
            stmt.setInt(1,IDPembayaran);
            stmt.setFloat(2, totalHarga);
            stmt.setString(3, waktuPembayaran);
            stmt.setString(4, jenisPembayaran);
            stmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.print(e);
        }
    }
    
    
}
