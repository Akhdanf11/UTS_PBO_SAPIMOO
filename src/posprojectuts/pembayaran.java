/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package posprojectuts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.io.File;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author LENOVO
 */
public class Pembayaran extends javax.swing.JFrame {

    private float totalHarga;
    private String jenisBarang;

    /**
     * Creates new form Pembayaran
     */
    public Pembayaran() {
        initComponents();
        DBConnector.initDBConnection();
        Timer timer = new Timer(1000, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(formatter);
            waktuPembayaranTextField.setText(formattedDate);
        });
        timer.start();
        
        //set ID Pembayaran
//        try {
//            Statement stmt = DBConnector.connection.createStatement();
//            String sql = "SELECT COUNT(*) FROM pembayaran as jumlahData";
//            ResultSet rs = stmt.executeQuery(sql);
//            rs.next();
//            int jumlah = rs.getInt("jumlahData");
//            // System.out.println(JumlahData);
//            int intID = jumlah+1;
//            String stringID = String.valueOf(intID);
//
//            idPembayaranTextField.setText(stringID);   
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, ex);
//              
//        }
    }
    
    public Pembayaran(float totalHarga, String jenisBarang) {
        this.totalHarga = totalHarga;
        this.jenisBarang = jenisBarang;
        int totalHargaInt = (int)totalHarga;
        
        DBConnector.initDBConnection();
        
        totalHargaTextField.setText(String.format("%,d",totalHargaInt));
        // String qrCodeString = "ID Pembayaran " + idPembayaranTextField.getText() + " dengan Total Harga : " + totalHargaTextField.getText() 
        //                                    + "telah berhasil dibayar!";
        String qrCodeString = "ID Pembayaran  dengan Total Harga : telah berhasil dibayar!";
        setQRCodeImage(qrCodeString, qrLabel, 217, 185);
        
//        try {
//            //        String qrCodeString = "ID Pembayaran " + idPembayaranTextField.getText() + " dengan Total Harga : " + totalHargaTextField.getText() 
//            //                                + "telah berhasil dibayar!";
//            String qrCodeString = "ID Pembayaran  dengan Total Harga : telah berhasil dibayar!";
//            String filePath = "D:\\kuliah\\sem 4\\pbo\\sapi moo\\UTS\\UTS_PBO_SAPIMOO\\src\\qrCode.png"; 
//            String charset = "UTF-8";
//            
//            Map <EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel>();
//            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//            BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeString.getBytes(charset), charset),
//                    BarcodeFormat.QR_CODE, 200, 200, hintMap);
//            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
//            
//            System.out.println("QR Code berhasil dibuat");
//            ImageIcon qrIcon = new ImageIcon("D:\\kuliah\\sem 4\\pbo\\sapi moo\\UTS\\UTS_PBO_SAPIMOO\\src\\kokomi.jpg");
//            qrLabel.setIcon(qrIcon);
//           
//        } catch (Exception e) {
//            System.err.println(e);
//        }

    }
    
    public static void setQRCodeImage(String qrText, JLabel label, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrText, BarcodeFormat.QR_CODE, width, height, getQRCodeHints());

            int qrCodeWidth = bitMatrix.getWidth();
            int qrCodeHeight = bitMatrix.getHeight();

            BufferedImage qrImage = new BufferedImage(qrCodeWidth, qrCodeHeight, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < qrCodeWidth; x++) {
                for (int y = 0; y < qrCodeHeight; y++) {
                    qrImage.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF); // Black and white colors
                }
            }

            ImageIcon imageIcon = new ImageIcon(qrImage);
            label.setIcon(imageIcon);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private static java.util.Map<EncodeHintType, Object> getQRCodeHints() {
        java.util.Map<EncodeHintType, Object> hints = new java.util.EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // Error correction level: L (7%)
        return hints;
    }
    
    private void generateIDPembayaran(){
          try {
            Statement stmt = DBConnector.connection.createStatement();
            String sql = "SELECT COUNT(*) FROM pembayaran as jumlahData";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int jumlahData = rs.getInt("jumlahData");
            System.out.println(jumlahData);
            int GeneralID = jumlahData+1;
            String idTransString = String.format("CASHIER-%03d", GeneralID);

            idPembayaranTextField.setText(idTransString);   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
              
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idPembayaranTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalHargaTextField = new javax.swing.JTextField();
        waktuPembayaranTextField = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        kasTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kembalianTextField = new javax.swing.JTextField();
        kasBayar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        qrLabel = new javax.swing.JLabel();
        qrSubmitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(822, 482));
        setResizable(false);

        JPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PEMBAYARAN");

        idPembayaranTextField.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOTAL :");

        totalHargaTextField.setEditable(false);
        totalHargaTextField.setToolTipText("");

        waktuPembayaranTextField.setBackground(new java.awt.Color(102, 102, 102));
        waktuPembayaranTextField.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        waktuPembayaranTextField.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idPembayaranTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalHargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(waktuPembayaranTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel1)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        JPanel1Layout.setVerticalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPembayaranTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(totalHargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waktuPembayaranTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        kasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasTextFieldActionPerformed(evt);
            }
        });
        kasTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kasTextFieldKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("CASH :");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("CHANGE :");

        kembalianTextField.setEditable(false);

        kasBayar.setBackground(new java.awt.Color(51, 51, 51));
        kasBayar.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        kasBayar.setForeground(new java.awt.Color(255, 255, 255));
        kasBayar.setText("BAYAR");
        kasBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kembalianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(kasBayar)))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kembalianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(kasBayar)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kas", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Debit", jPanel7);

        jPanel5.setPreferredSize(new java.awt.Dimension(822, 482));

        qrLabel.setBackground(new java.awt.Color(51, 51, 51));

        qrSubmitBtn.setBackground(new java.awt.Color(51, 51, 51));
        qrSubmitBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        qrSubmitBtn.setForeground(new java.awt.Color(255, 255, 255));
        qrSubmitBtn.setText("SUBMIT");
        qrSubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrSubmitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(qrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(qrSubmitBtn)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(qrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qrSubmitBtn)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("QRIS", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qrSubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrSubmitBtnActionPerformed
        // TODO add your handling code here:
//        QRIS qris = new QRIS();
//
//        String totalHargaString = totalHargaTextField.getText();
//        totalHargaString = totalHargaString.replace(",", "");
//        float totalHargaFloat = Float.parseFloat(totalHargaString);
//        qris.setTotalHarga(totalHargaFloat);
//
//        String waktuPembayaran = waktuPembayaranTextField.getText();
//        qris.setWaktuPembayaran(waktuPembayaran);
//
//        String IDPembayaran = idPembayaranTextField.getText();
//        String formattedOutput = IDPembayaran.substring(2);
//        int result = Integer.parseInt(formattedOutput);
//        qris.setIDPembayaran(result);
//
//        String jenis = jenisPembelian.substring(0,2);
//
//        if(jenis.equals("PL")){
//            JOptionPane.showMessageDialog(this,"Pulsa Telah Terkirim");
//        } else if(jenis.equals("TN")){
//            TokenFrame frame = new TokenFrame();
//            frame.setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(this, "Pembayaran Berhasil");
//
//        }
//
//        try {
//            qris.simpanDatabase();
//            generateIDPembayaran();
//        } catch (SQLException ex) {
//            Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        MainWindow frame = new MainWindow();
//        frame.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_qrSubmitBtnActionPerformed

    private void kasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasTextFieldActionPerformed
        //mengambil textbox dan menjadikan string
        String totalHargaString = totalHargaTextField.getText();
        //menghilangkan koma
        totalHargaString = totalHargaString.replace(",","");

        //mengubah menjadi bilbul
        int totalHargaInt = Integer.valueOf(totalHargaString);

        String bayar = kasTextField.getText();
        bayar = bayar.replace(",", "");

        int dibayarInt = Integer.valueOf(bayar);

        if (dibayarInt < totalHargaInt) {
            JOptionPane.showMessageDialog(null, "Jumlah pembayaran kurang dari total belanja.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        int kembalian = dibayarInt - totalHargaInt;
        if (kembalian < 0){
            kembalianTextField.setForeground(Color.red);
        }else
            kembalianTextField.setForeground(Color.green);

        kembalianTextField.setText(String.format("%,d",kembalian));
    }//GEN-LAST:event_kasTextFieldActionPerformed

    private void kasTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kasTextFieldKeyReleased
        String kasString = kasTextField.getText();
        kasString = kasString.replace(",", "");
        
        int kasInput = Integer.valueOf(kasString);
        kasTextField.setText(String.format("%,d", kasInput));
    }//GEN-LAST:event_kasTextFieldKeyReleased

    private void kasBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasBayarActionPerformed
        String kasString = kasTextField.getText();
        kasString = kasString.replace(",", "");
        float kasFloat = Float.parseFloat(kasString);

        String kembalianString = kembalianTextField.getText();
        kembalianString = kembalianString.replace(",", "");
        float kembalianFloat = Float.parseFloat(kembalianString);

        Cash kas = new Cash(kembalianFloat, kasFloat);

        String totalHargaString = totalHargaTextField.getText();
        totalHargaString = totalHargaString.replace(",", "");
        float totalHargaFloat = Float.parseFloat(totalHargaString);
        kas.setTotalHarga(totalHargaFloat);

        String waktuPembayaran = waktuPembayaranTextField.getText();
        kas.setWaktuPembayaran(waktuPembayaran);

        String idString = idPembayaranTextField.getText();
        int idInt = Integer.parseInt(idString);
        kas.setIDPembayaran(idInt);

        String jenis = jenisBarang;
        
        if(jenis.equals("Pulsa")){
            JOptionPane.showMessageDialog(this,"Pulsa Telah Terkirim");
        } else if(jenis.equals("Token")){
//            beliTokenFrame frame = new beliTokenFrame();
//            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Pembayaran Berhasil");

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
    }//GEN-LAST:event_kasBayarActionPerformed

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
    private javax.swing.JPanel JPanel1;
    private javax.swing.JTextField idPembayaranTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton kasBayar;
    private javax.swing.JTextField kasTextField;
    private javax.swing.JTextField kembalianTextField;
    private javax.swing.JLabel qrLabel;
    private javax.swing.JButton qrSubmitBtn;
    private javax.swing.JTextField totalHargaTextField;
    private javax.swing.JLabel waktuPembayaranTextField;
    // End of variables declaration//GEN-END:variables
}
