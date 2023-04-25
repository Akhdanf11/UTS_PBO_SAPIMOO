/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspbo;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author LENOVO
 */
public class Transaksi {
    public int totalTransaksi;
    public int bayarTransaksi;
    public int kembalianTransaksi;
    public String waktuTransaksi;
    
    public String informasiBarang(String kode, String nama, int jumlah) {
        String deskripsi = "";
        deskripsi = nama + " x" + Integer.toString(jumlah) + "\n";
//        Statement stmt = DBConnector.connection.createStatement();
//        String sql = "INSERT INTO tb_barang values (null,"+kode+","+totalTransaksi+","+bayarTransaksi+","+kembalianTransaksi+",null)";
//        ResultSet rs = stmt.executeQuery(sql);

        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        s.setTimeZone(TimeZone.getTimeZone("GMT+7"));  
        
        try {
            Statement stmt = DBConnector.connection.createStatement();
//            java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(waktuTransaksi);
            String waktu = s.format(date);
            System.out.println(waktu);
            
            String sql = "INSERT INTO tb_transaksi values (null,"+kode+","+totalTransaksi+","+bayarTransaksi+","+kembalianTransaksi+",'"+waktu+"')";
            stmt.executeUpdate(sql);
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return deskripsi;
    }
}
