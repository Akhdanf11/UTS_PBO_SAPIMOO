/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posprojectuts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author xpopow
 */

public class Cash implements PembayaranInterface {
    
    private float totalHarga;
    private int IDPembayaran;
    private String waktuPembayaran;
    
    public float kembalian;
    public float uangDiterima;
    public final String jenisPembayaran = "Cash";
    
    public Cash(float kembalian, float uangDiterima){
        this.kembalian = kembalian;
        this.uangDiterima = uangDiterima;
    }
    
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
    public void setIDPembayaran(int IDPembayaram) {
        this.IDPembayaran = IDPembayaran;
    }
    
    
    public void simpanDatabase() throws SQLException{
         try{
            Connection conn = DBConnector.initDBConnection();
            String sql = "INSERT INTO pembayaran(id_pembayaran, total_belanja, waktu_pembayaran,jenis_pembayaran) VALUES(?, ?, ?, ?)";
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
