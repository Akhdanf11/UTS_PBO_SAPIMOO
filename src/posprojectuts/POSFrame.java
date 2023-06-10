/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package posprojectuts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.util.Random;
import posprojectuts.Transaksi.rincian_transaksi;

/**
 *
 * @author LENOVO
 */
public class POSFrame extends javax.swing.JFrame {

    ArrayList<Item> daftarItem;
    
    TableModel daftarModel;
    
    static int jumlahBelanja = 0;
    static Item tempItem;
    boolean beliToken = false;
    /**
     * Creates new form POSFrame
     */
    
    public POSFrame() {
        DBConnector.initDBConnection();
        
//        daftarBarang = new ArrayList<Barang>();
        Barang.loadBarangFromDB();
        Pulsa.loadBarangFromDB();
        Token.loadBarangFromDB();
        
        System.err.println(Item.daftarItem.size());
        
        daftarItem = Item.daftarItem;
        
        
        System.out.println(daftarItem.size());
        

//        Date date = new Date();
//        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            Timer timer = new Timer(1000, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(formatter);
            txTanggal.setText(formattedDate);
        });
        timer.start();
        initComponents();
        kodetransaksi(); //fungsi
        
        
        daftarModel = daftarTable.getModel();
        daftarModel.addTableModelListener(new TableModelListener()
        {
            @Override //membuat ulang kelas baru
            public void tableChanged(TableModelEvent tme) {
                
                if(tme.getColumn() == 4)
                {
                    int baris = tme.getFirstRow();
                    
                    float harga = (float)daftarModel.getValueAt(baris, 3);
                    int jumlah = (int)daftarModel.getValueAt(baris, 4);
                    
                    float total = harga * jumlah;
                    daftarModel.setValueAt(total, baris, 8);
                    
                    float totalBelanja = 0.0f;
                    total = 0.0f;
                    
                    for (int i = 0; i < jumlahBelanja+1; i++) 
                    {
                        total = (float)daftarModel.getValueAt(i, 8);
                        totalBelanja = totalBelanja + total;
                    } 
                    
                    int totalBelanjaInt = (int)totalBelanja;
                    totalBelanjaTextField.setText(String.valueOf(totalBelanjaInt));
                    
                    
                }
            }
                    
        }
                
        );
    }
private void kodetransaksi(){
        try {
            Statement stmt = DBConnector.connection.createStatement();
            String sql = "SELECT COUNT(*) as jumlah_pembayaran FROM pembayaran";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int JumlahData = rs.getInt("jumlah_pembayaran");
            System.out.println(JumlahData);
            int idtransaksi = JumlahData+1;
            String idTransString = String.format("CASHIER-%03d", idtransaksi);
            id_transaksi.setText(idTransString);
        } catch (SQLException ex) {
            Logger.getLogger(POSFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jpanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id_transaksi = new javax.swing.JTextField();
        kodeTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        hargaTextField = new javax.swing.JTextField();
        NoTelpTextField = new javax.swing.JTextField();
        NoMeteranTextField = new javax.swing.JTextField();
        totalBelanjaTextField = new javax.swing.JTextField();
        btn_bayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        daftarTable = new javax.swing.JTable();
        txTanggal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jpanel1.setBackground(new java.awt.Color(51, 51, 51));
        jpanel1.setPreferredSize(new java.awt.Dimension(720, 720));

        jLabel11.setFont(new java.awt.Font("Stencil", 0, 55)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("GODAM");
        jLabel11.setToolTipText("");
        jLabel11.setFocusable(false);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kembalian");

        jLabel4.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Belanja");

        jLabel10.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("No Meteran");

        jLabel9.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("No Hp");

        jLabel3.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Barang");

        jLabel2.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Harga");

        jLabel1.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode");

        jLabel8.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kode transaksi");

        id_transaksi.setBackground(new java.awt.Color(204, 204, 204));
        id_transaksi.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        id_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_transaksiActionPerformed(evt);
            }
        });

        kodeTextField.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        kodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeTextFieldActionPerformed(evt);
            }
        });

        namaTextField.setEditable(false);
        namaTextField.setBackground(new java.awt.Color(204, 204, 204));
        namaTextField.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        namaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTextFieldActionPerformed(evt);
            }
        });

        hargaTextField.setEditable(false);
        hargaTextField.setBackground(new java.awt.Color(204, 204, 204));
        hargaTextField.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        hargaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaTextFieldActionPerformed(evt);
            }
        });

        NoTelpTextField.setEditable(false);
        NoTelpTextField.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        NoTelpTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoTelpTextFieldActionPerformed(evt);
            }
        });

        NoMeteranTextField.setEditable(false);
        NoMeteranTextField.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        NoMeteranTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoMeteranTextFieldActionPerformed(evt);
            }
        });

        totalBelanjaTextField.setEditable(false);
        totalBelanjaTextField.setBackground(new java.awt.Color(204, 204, 204));
        totalBelanjaTextField.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        totalBelanjaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBelanjaTextFieldActionPerformed(evt);
            }
        });

        btn_bayar.setFont(new java.awt.Font("ROG Fonts", 0, 18)); // NOI18N
        btn_bayar.setText("Bayar");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        daftarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode", "Nama", "Harga Satuan", "Jumlah", "Kadaluarsa", "Operator", "Nominal", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(daftarTable);
        if (daftarTable.getColumnModel().getColumnCount() > 0) {
            daftarTable.getColumnModel().getColumn(0).setResizable(false);
            daftarTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            daftarTable.getColumnModel().getColumn(1).setResizable(false);
            daftarTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            daftarTable.getColumnModel().getColumn(2).setResizable(false);
            daftarTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            daftarTable.getColumnModel().getColumn(3).setResizable(false);
            daftarTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            daftarTable.getColumnModel().getColumn(4).setResizable(false);
            daftarTable.getColumnModel().getColumn(4).setPreferredWidth(20);
            daftarTable.getColumnModel().getColumn(5).setResizable(false);
            daftarTable.getColumnModel().getColumn(6).setResizable(false);
            daftarTable.getColumnModel().getColumn(7).setResizable(false);
            daftarTable.getColumnModel().getColumn(8).setResizable(false);
            daftarTable.getColumnModel().getColumn(8).setPreferredWidth(50);
        }

        txTanggal.setEditable(false);
        txTanggal.setBackground(new java.awt.Color(204, 204, 204));
        txTanggal.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTanggalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(jpanel1);
        jpanel1.setLayout(jpanel1Layout);
        jpanel1Layout.setHorizontalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(138, 138, 138)
                        .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hargaTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_bayar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(totalBelanjaTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoMeteranTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoTelpTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaTextField)))
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(266, 266, 266)
                        .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jpanel1Layout.setVerticalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpanel1Layout.createSequentialGroup()
                                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NoTelpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NoMeteranTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalBelanjaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addGroup(jpanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_bayar)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void namaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaTextFieldActionPerformed

    private void kodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeTextFieldActionPerformed
        // TODO add your handling code here:

        try {
            String kodeInput = kodeTextField.getText();       
            NoTelpTextField.setEditable(false);
            NoMeteranTextField.setEditable(false);
            NoTelpTextField.setText("");
            NoMeteranTextField.setText("");
            boolean isFound = false;
            for (int i = 0; i < daftarItem.size(); i++) {
                tempItem = daftarItem.get(i);
                if (tempItem.kode.equals(kodeInput)) {
                    if (tempItem.operator != null){
                        isFound = true;
                        System.out.println("Barang Ditemukan");
                        i = daftarItem.size();
                        namaTextField.setText(tempItem.nama);
                        hargaTextField.setText(Float.toString(tempItem.harga));
                        NoTelpTextField.setEditable(true);
                        
                    }else if(tempItem.nominal != 0){
                        isFound = true;
                        System.out.println("Barang Ditemukan");
                        i = daftarItem.size();
                        namaTextField.setText(tempItem.nama);
                        hargaTextField.setText(Float.toString(tempItem.harga));
                        NoMeteranTextField.setEditable(true);
                        
                    }else{
                        isFound = true;
                        System.out.println("Barang Ditemukan");
                        i = daftarItem.size();
                        namaTextField.setText(tempItem.nama);
                        hargaTextField.setText(Float.toString(tempItem.harga));
                        daftarModel.setValueAt(jumlahBelanja+1, jumlahBelanja, 0);
                        daftarModel.setValueAt(kodeInput, jumlahBelanja, 1);
                        daftarModel.setValueAt(tempItem.nama, jumlahBelanja, 2);
                        daftarModel.setValueAt(tempItem.harga, jumlahBelanja, 3);
                        daftarModel.setValueAt(1, jumlahBelanja, 4);
                        if(tempItem.kadaluarsa == null){
                            daftarModel.setValueAt("-------------------------", jumlahBelanja, 5);
                        }else{
                            daftarModel.setValueAt(tempItem.kadaluarsa, jumlahBelanja, 5);
                        }

                        if(tempItem.operator == null){
                            daftarModel.setValueAt("-------------------------", jumlahBelanja, 6);
                        }else{
                            daftarModel.setValueAt(tempItem.operator, jumlahBelanja, 6);
                        }

                        if(tempItem.nominal == 0){
                            daftarModel.setValueAt("-------------------------", jumlahBelanja, 7);
                        }else{
                            daftarModel.setValueAt(String.valueOf(tempItem.nominal), jumlahBelanja, 7);
                        }
                        jumlahBelanja++;
                    }
                    
                }
            }
            if (!isFound) {
                throw new Exception("Kode barang tidak ditemukan!");
            }
        } catch (NumberFormatException ex) {
            // menangani kesalahan jika pengguna memasukkan kode dalam bentuk string
            JOptionPane.showMessageDialog(null, "Kode barang harus dalam bentuk angka!");
        } catch (Exception ex) {
            // menangani kesalahan jika kode barang yang dimasukkan pengguna tidak ada
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_kodeTextFieldActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        String totalHarga = totalBelanjaTextField.getText();
        String stringTotalBelanja = totalHarga.replace(",", "");
        float totalHargaFloat = Float.parseFloat(stringTotalBelanja);
        
        boolean ambilToken = beliToken;
        
        Pembayaran frame = new Pembayaran(totalHargaFloat, ambilToken);
        frame.setVisible(true);
        this.dispose();
        kodetransaksi();
        
        jumlahBelanja = 0;
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void totalBelanjaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBelanjaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBelanjaTextFieldActionPerformed

    private void hargaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaTextFieldActionPerformed

    private void txTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTanggalActionPerformed

    private void id_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_transaksiActionPerformed

    private void NoTelpTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoTelpTextFieldActionPerformed
        // TODO add your handling code here:
        Pulsa.noTelp = NoTelpTextField.getText();
        daftarModel.setValueAt(jumlahBelanja+1, jumlahBelanja, 0);
        daftarModel.setValueAt(tempItem.kode, jumlahBelanja, 1);
        daftarModel.setValueAt((tempItem.nama+" "+Pulsa.noTelp), jumlahBelanja, 2);
        daftarModel.setValueAt(tempItem.harga, jumlahBelanja, 3);
        daftarModel.setValueAt(1, jumlahBelanja, 4);
        if(tempItem.kadaluarsa == null){
            daftarModel.setValueAt("-------------------------", jumlahBelanja, 5);
        }else{
            daftarModel.setValueAt(tempItem.kadaluarsa, jumlahBelanja, 5);
        }

        if(tempItem.operator == null){
            daftarModel.setValueAt("-------------------------", jumlahBelanja, 6);
        }else{
            daftarModel.setValueAt(tempItem.operator, jumlahBelanja, 6);
        }

        if(tempItem.nominal == 0){
            daftarModel.setValueAt("-------------------------", jumlahBelanja, 7);
        }else{
            daftarModel.setValueAt(String.valueOf(tempItem.nominal), jumlahBelanja, 7);
        }
        jumlahBelanja++;
        
    }//GEN-LAST:event_NoTelpTextFieldActionPerformed

    private void NoMeteranTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoMeteranTextFieldActionPerformed
        // TODO add your handling code here:
        beliToken = true;
        Token.noMeteran = NoMeteranTextField.getText();
        daftarModel.setValueAt(jumlahBelanja+1, jumlahBelanja, 0);
        daftarModel.setValueAt(tempItem.kode, jumlahBelanja, 1);
        daftarModel.setValueAt((tempItem.nama+" "+Token.noMeteran), jumlahBelanja, 2);
        daftarModel.setValueAt(tempItem.harga, jumlahBelanja, 3);
        daftarModel.setValueAt(1, jumlahBelanja, 4);
        if(tempItem.kadaluarsa == null){
            daftarModel.setValueAt("-------------------------", jumlahBelanja, 5);
        }else{
            daftarModel.setValueAt(tempItem.kadaluarsa, jumlahBelanja, 5);
        }

        if(tempItem.operator == null){
            daftarModel.setValueAt("-------------------------", jumlahBelanja, 6);
        }else{
            daftarModel.setValueAt(tempItem.operator, jumlahBelanja, 6);
        }

        if(tempItem.nominal == 0){
            daftarModel.setValueAt("-------------------------", jumlahBelanja, 7);
        }else{
            daftarModel.setValueAt(String.valueOf(tempItem.nominal), jumlahBelanja, 7);
        }
        jumlahBelanja++;
    }//GEN-LAST:event_NoMeteranTextFieldActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POSFrame().setVisible(true);
            }
        });
    }
                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NoMeteranTextField;
    private javax.swing.JTextField NoTelpTextField;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JTable daftarTable;
    private javax.swing.JTextField hargaTextField;
    private javax.swing.JTextField id_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanel1;
    private javax.swing.JTextField kodeTextField;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JTextField totalBelanjaTextField;
    private javax.swing.JTextField txTanggal;
    // End of variables declaration//GEN-END:variables
}
