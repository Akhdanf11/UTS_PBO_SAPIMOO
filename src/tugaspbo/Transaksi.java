/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspbo;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Transaksi {
    public int totalTransaksi;
    public int bayarTransaksi;
    public int kembalianTransaksi;
    public String waktuTransaksi;
    
    public String informasiBarang(String nama, int jumlah) {
        String deskripsi = "";
        deskripsi = nama + " x" + Integer.toString(jumlah) + "\n";
        return deskripsi;
    }
}
