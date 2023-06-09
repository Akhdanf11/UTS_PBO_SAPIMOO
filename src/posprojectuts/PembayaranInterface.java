/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posprojectuts;

import java.time.LocalDateTime;

/**
 *
 * @author LENOVO
 */

public interface PembayaranInterface {
    float getTotalHarga();
    void setTotalHarga(float totalHarga);
    
    String getWaktuPembayaran();
    void setWaktuPembayaran(String waktuPembayaran);
    
    int getIDPembayaran();
    void setIDPembayaran(int IDPembayaram);
}
