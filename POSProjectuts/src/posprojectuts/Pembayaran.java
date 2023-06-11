/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package posprojectuts;




import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author LENOVO
 */
public class Pembayaran extends javax.swing.JFrame {
    float totalHarga;
    String jenisPembelian;
    private boolean beliToken;
    
     public Pembayaran(){
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DBConnector.initDBConnection();
    }
    
    public Pembayaran(float totalHarga, boolean beliToken) {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DBConnector.initDBConnection();
        this.totalHarga = totalHarga;
        this.beliToken = beliToken;
        int totalBelanjaInt = (int)totalHarga;
        
        totalTextField.setText(String.format("%,d",totalBelanjaInt));
        
        generateIDPembayaran();
        Timer timer = new Timer(1000, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(formatter);
            waktuPembayaranLabel.setText(formattedDate);
        });
        timer.start();

        String qrCodeText = "ID Pembayaran : "+ idTextField.getText() +" dan Total Harga : " + totalTextField.getText() + " behasil dibayar!"; 

        String fileType = "png";
        String filePath = "qr_code.png";

            try {
                    
                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, 200, 200);

                BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
                bufferedImage.createGraphics();

               for (int x = 0; x < 200; x++) {
                    for (int y = 0; y < 200; y++) {
                        int grayValue = (bitMatrix.get(x, y) ? 0 : 1) & 0xff;
                        bufferedImage.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
                        }
                    }

                    Image scaledImage = bufferedImage.getScaledInstance(qrisLabel.getWidth(), qrisLabel.getHeight(), Image.SCALE_SMOOTH);
                    qrisLabel.setIcon(new ImageIcon(scaledImage));

                    File qrFile = new File(filePath);
                    ImageIO.write(bufferedImage, fileType, qrFile);
                } catch (WriterException | IOException ex) {
                    ex.printStackTrace();   
            }
    }
    
    private void generateIDPembayaran(){
          try {
            Statement stmt = DBConnector.connection.createStatement();
            String sql = "SELECT COUNT(*) as jumlah_pembayaran FROM pembayaran";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int JumlahData = rs.getInt("jumlah_pembayaran");
            System.out.println(JumlahData);
            int GeneralID = JumlahData+1;
            String idTransString = String.format("PAY-%d", GeneralID);

            idTextField.setText(idTransString);   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
              
        }
    }
    
    public void generateToken(){
        Random rand = new Random(); 
            int angka1 = rand.nextInt(10);
            int angka2 = rand.nextInt(10);
            int angka3 = rand.nextInt(10);
            int angka4 = rand.nextInt(10);
            int angka5 = rand.nextInt(10);
            int angka6 = rand.nextInt(10);
            int angka7 = rand.nextInt(10);
            int angka8 = rand.nextInt(10);
            int angka9 = rand.nextInt(10);
            int angka10 = rand.nextInt(10);
            int angka11 = rand.nextInt(10);
            int angka12 = rand.nextInt(10);
            int angka13 = rand.nextInt(10);
            int angka14 = rand.nextInt(10);
            int angka15 = rand.nextInt(10);
            int angka16 = rand.nextInt(10);
            int angka17 = rand.nextInt(10);
            int angka18 = rand.nextInt(10);
            int angka19 = rand.nextInt(10);
            int angka20 = rand.nextInt(10);
            
        String nomorToken = String.valueOf(angka1)+String.valueOf(angka2)+String.valueOf(angka3)+String.valueOf(angka4)+String.valueOf(angka5)+String.valueOf(angka6)+String.valueOf(angka7)+String.valueOf(angka8)+String.valueOf(angka9)+String.valueOf(angka10)+String.valueOf(angka11)+String.valueOf(angka12)+String.valueOf(angka13)+String.valueOf(angka14)+String.valueOf(angka15)+String.valueOf(angka16)+String.valueOf(angka17)+String.valueOf(angka18)+String.valueOf(angka19)+String.valueOf(angka20);
        JOptionPane.showMessageDialog(this,"Pembayaran berhasil! Nomor Token : " + nomorToken);
    }
    
    
    
       

       
    
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        totalTextField = new javax.swing.JTextField();
        waktuPembayaranLabel = new javax.swing.JLabel();
        BayarDebit = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kasBayarTextField = new javax.swing.JTextField();
        kasKembalianTextField = new javax.swing.JTextField();
        kasButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        noKartuTextField = new javax.swing.JTextField();
        bankTextField = new javax.swing.JTextField();
        debitButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        qrisLabel = new javax.swing.JLabel();
        qrisButton = new javax.swing.JToggleButton();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PEMBAYARAN");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" ID : ");

        idTextField.setEditable(false);
        idTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOTAL :");

        totalTextField.setEditable(false);
        totalTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        waktuPembayaranLabel.setBackground(new java.awt.Color(102, 102, 102));
        waktuPembayaranLabel.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        waktuPembayaranLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(294, 294, 294))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(waktuPembayaranLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waktuPembayaranLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        BayarDebit.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel4.setText("CASH :");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel5.setText("CHANGE :");

        kasBayarTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kasBayarTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kasBayarTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasBayarTextFieldActionPerformed(evt);
            }
        });
        kasBayarTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kasBayarTextFieldKeyReleased(evt);
            }
        });

        kasKembalianTextField.setEditable(false);
        kasKembalianTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kasKembalianTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        kasButton.setBackground(new java.awt.Color(0, 0, 0));
        kasButton.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        kasButton.setForeground(new java.awt.Color(255, 255, 255));
        kasButton.setText("BAYAR");
        kasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(kasBayarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(kasKembalianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(kasButton)
                .addGap(322, 322, 322))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kasBayarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasKembalianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(kasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        BayarDebit.addTab("Kas", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel11.setText("CARD NUMBER :");

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel12.setText("BANK :");

        debitButton.setBackground(new java.awt.Color(0, 0, 0));
        debitButton.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        debitButton.setForeground(new java.awt.Color(255, 255, 255));
        debitButton.setText("BAYAR");
        debitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noKartuTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(bankTextField))
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(debitButton)
                .addGap(317, 317, 317))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noKartuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bankTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(debitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        BayarDebit.addTab("Debit", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        qrisLabel.setBackground(new java.awt.Color(255, 255, 255));

        qrisButton.setBackground(new java.awt.Color(0, 0, 0));
        qrisButton.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        qrisButton.setForeground(new java.awt.Color(255, 255, 255));
        qrisButton.setText("BAYAR");
        qrisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(qrisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(314, 314, 314))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(qrisButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(qrisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(qrisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        BayarDebit.addTab("QRIS", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BayarDebit)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BayarDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void kasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasButtonActionPerformed
        boolean konfirmToken = beliToken;
        
        String uangDiterima = kasBayarTextField.getText();
        uangDiterima = uangDiterima.replace(",", "");
        float totalBelanja = Float.parseFloat(uangDiterima);
        
        String kembalian = kasKembalianTextField.getText();
        kembalian = kembalian.replace(",", "");
        float kembalianFloat = Float.parseFloat(kembalian);
     
        Cash kas = new Cash(kembalianFloat, totalBelanja);
        
        String totalHargaString = totalTextField.getText();
        totalHargaString = totalHargaString.replace(",", "");
        float totalHargaFloat = Float.parseFloat(totalHargaString);
        kas.setTotalHarga(totalHargaFloat);
        
        String waktuPembayaran = waktuPembayaranLabel.getText();
        kas.setWaktuPembayaran(waktuPembayaran);
        
        String IDPembayaran = idTextField.getText();
        String formattedOutput = IDPembayaran.substring(4);
        int result = Integer.parseInt(formattedOutput);
        kas.setIDPembayaran(result);
        
        
        if(konfirmToken) {
            generateToken();
        } else {
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");  
        }

        try {
            kas.simpanDatabase();
            generateIDPembayaran();
        } catch (SQLException ex) {
            Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        POSFrame frame = new POSFrame();
        frame.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_kasButtonActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void debitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debitButtonActionPerformed
        boolean konfirmToken = beliToken;
        String namaBank = bankTextField.getText();
        String noKartu = noKartuTextField.getText();
        
        Debit debit = new Debit(namaBank, noKartu);
        
        String totalHargaString = totalTextField.getText();
        totalHargaString = totalHargaString.replace(",", "");
        float totalHargaFloat = Float.parseFloat(totalHargaString);
        debit.setTotalHarga(totalHargaFloat);
        
        String waktuPembayaran = waktuPembayaranLabel.getText();
        debit.setWaktuPembayaran(waktuPembayaran);
        
        String IDPembayaran = idTextField.getText();
        String formattedOutput = IDPembayaran.substring(4);
        int result = Integer.parseInt(formattedOutput);
        debit.setIDPembayaran(result);
        
        
        if(konfirmToken) {
            generateToken();
        } else {
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");  
        }

        try {
            debit.simpanDatabase();
            generateIDPembayaran();
        } catch (SQLException ex) {
            Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        POSFrame frame = new POSFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_debitButtonActionPerformed

    private void kasBayarTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasBayarTextFieldActionPerformed
        String totalbelanja = totalTextField.getText();
        String stringTotalBelanja = totalbelanja.replace(",", "");

        float totalBelanja = Float.parseFloat(stringTotalBelanja);
        int totalBelanjaInt = (int)totalBelanja;

        String bayar = kasBayarTextField.getText();
        String stringBayar = bayar.replace(",", "");

        float dibayar = Float.parseFloat(stringBayar);
        int dibayarInt = (int)dibayar;

        int uang_kembali = dibayarInt - totalBelanjaInt;
        if(dibayar >= totalBelanjaInt){
             kasKembalianTextField.setText(String.format("%,d",uang_kembali));
        } 
        else {
             JOptionPane.showMessageDialog(this, "Uang Anda Kurang","ERROR MONEY",JOptionPane.ERROR_MESSAGE);
             kasKembalianTextField.setText("");
            }
    }//GEN-LAST:event_kasBayarTextFieldActionPerformed

    private void kasBayarTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kasBayarTextFieldKeyReleased
        String dibayarCash = kasBayarTextField.getText();
        dibayarCash = dibayarCash.replace(",", "");

        if (dibayarCash.matches("\\d+")) {
            long dibayarInput = Long.parseLong(dibayarCash);
            String formattedInput = String.format("%,d", dibayarInput);
            kasBayarTextField.setText(formattedInput);
        } else {
            JOptionPane.showMessageDialog(this, "Anda memasukkan huruf, silakan masukkan angka", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            kasBayarTextField.setText("");
        }
    }//GEN-LAST:event_kasBayarTextFieldKeyReleased

    private void qrisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrisButtonActionPerformed
        boolean konfirmToken = beliToken;
        QRIS qris = new QRIS();
        
        String totalHargaString = totalTextField.getText();
        totalHargaString = totalHargaString.replace(",", "");
        float totalHargaFloat = Float.parseFloat(totalHargaString);
        qris.setTotalHarga(totalHargaFloat);
        
        String waktuPembayaran = waktuPembayaranLabel.getText();
        qris.setWaktuPembayaran(waktuPembayaran);
        
        String IDPembayaran = idTextField.getText();
        String formattedOutput = IDPembayaran.substring(4);
        int result = Integer.parseInt(formattedOutput);
        qris.setIDPembayaran(result);
        
        if(konfirmToken) {
            generateToken();
        } else {
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");  
        }

        try {
            qris.simpanDatabase();
            generateIDPembayaran();
        } catch (SQLException ex) {
            Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        POSFrame frame = new POSFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_qrisButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane BayarDebit;
    private javax.swing.JTextField bankTextField;
    private javax.swing.JButton debitButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField kasBayarTextField;
    private javax.swing.JButton kasButton;
    private javax.swing.JTextField kasKembalianTextField;
    private javax.swing.JTextField noKartuTextField;
    private javax.swing.JToggleButton qrisButton;
    private javax.swing.JLabel qrisLabel;
    private javax.swing.JTextField totalTextField;
    private javax.swing.JLabel waktuPembayaranLabel;
    // End of variables declaration//GEN-END:variables
}
