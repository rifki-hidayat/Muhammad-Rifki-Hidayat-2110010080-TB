/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rifki
 */
public final class AppPenyewaanPC extends javax.swing.JFrame {

    String[] Judulnya = {"ID PC", "No Series", "Merek PC", "Jumlah PC", "Biaya"};
    int[] LebarKolomOW = {100, 200, 200, 200, 200};
    String SQL = "SELECT*FROM pc";

    String[] Namanya = {"ID Pelanggan", "Nama Pelanggan", "Jenis Kelamin", "Alamat", "Telepon"};
    int[] LebarKolomPengunjung = {100, 200, 200, 300, 300};
    String SQL1 = "SELECT*FROM penyewa";

    String[] Transaksi = {"ID Transaksi", "Merek PC", "Nama Penyewa", "Tanggal Sewa", "Tanggal Kembali", "Total Biaya"};
    int[] LebarKolomTransaksi = {120, 200, 200, 100, 100, 100};
    String SQL2 = "SELECT trs.id AS id, pc.merek_pc AS merek, pny.nama_penyewa AS nama, trs.tgl_keluar AS sewa, trs.tgl_masuk AS kembali, DATEDIFF(trs.tgl_masuk, trs.tgl_keluar) * pc.biaya AS total FROM transaksi AS trs JOIN pc ON trs.pc_id = pc.id JOIN penyewa AS pny ON trs.penyewa_id = pny.id;";

    /**
     * Creates new form AppPenyewaanPC
     */
    public AppPenyewaanPC() {
        initComponents();
        Tampil_Jam();
        Tampil_Tanggal();
        this.setLocationRelativeTo(null);
        new configDBOW().setJudulKolom(tabelPc, Judulnya);
        new configDBOW().setTampilTabel(tabelPc, Judulnya, SQL);
        new configDBOW().setLebarJudulKolom(tabelPc, LebarKolomOW);
        this.setLocationRelativeTo(null);
        new configDBOW().setJudulKolom(tabelPenyewa, Namanya);
        new configDBOW().setTampilTabel(tabelPenyewa, Namanya, SQL1);
        new configDBOW().setLebarJudulKolom(tabelPenyewa, LebarKolomPengunjung);
        this.setLocationRelativeTo(null);
        new configDBOW().setJudulKolom(tabelTransaksi, Transaksi);
        new configDBOW().setTampilTabel(tabelTransaksi, Transaksi, SQL2);
        new configDBOW().setLebarJudulKolom(tabelPenyewa, LebarKolomTransaksi);
    }

    public void updateCombo() {
        String pc = "SELECT * FROM pc";
        String penyewa = "SELECT * FROM penyewa";
        try {
            PreparedStatement pst1 = new configDBOW().getKoneksi().prepareStatement(pc);
            ResultSet rs1 = pst1.executeQuery();
            PreparedStatement pst2 = new configDBOW().getKoneksi().prepareStatement(penyewa);
            ResultSet rs2 = pst2.executeQuery();
//            System.out.println(pst + " testing");
            while (rs1.next()) {
                jCbPc.addItem(rs1.getString("id"));
            }
            while (rs2.next()) {
                jCbPenyewa.addItem(rs2.getString("id"));
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    public void reset() {
        textNoSeries.setText(null);
        textMerek.setText(null);
        textJmlhpc.setText(null);
        textBiaya.setText(null);
        textPencarianPc.setText(null);
        textID.setText(null);
    }

    public void reset1() {
        textIDPenyewa.setText(null);
        textNamaLengkap.setText(null);
        textAlamat1.setText(null);
        textTelepon.setText(null);
    }

    public void reset2() {
        textIDTransaksi.setText(null);
        jDateSewa.setDate(null);
        jDateKembali.setDate(null);
    }

    //penampil waktu secara realtime pada label waktu
    public void Tampil_Jam() {
        ActionListener taskPerformer;
        taskPerformer = (ActionEvent evt) -> {
            String nol_jam = "", nol_menit = "", nol_detik = "";
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
            if (nilai_jam <= 9) {
                nol_jam = "0";
            }
            if (nilai_menit <= 9) {
                nol_menit = "0";
            }
            if (nilai_detik <= 9) {
                nol_detik = "0";
            }
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
            waktu.setText(jam + ":" + menit + ":" + detik + "");
        };
        new Timer(1000, taskPerformer).start();
    }
//penampil tanggal secara realtime pada label tanggal

    public void Tampil_Tanggal() {
        java.util.Date tglsekarang = new java.util.Date();
        SimpleDateFormat smpdtfmt;
        smpdtfmt = new SimpleDateFormat("dd MMMMMMMM yyyy", Locale.getDefault());
        String tanggal = smpdtfmt.format(tglsekarang);
        jtabletanggal.setText(tanggal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtabletanggal = new javax.swing.JLabel();
        waktu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();
        panelBeranda = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        panelPC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textNoSeries = new javax.swing.JTextField();
        textMerek = new javax.swing.JTextField();
        textJmlhpc = new javax.swing.JTextField();
        textBiaya = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textPencarianPc = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPanel1 = new javax.swing.JScrollPane();
        tabelPc = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        panelPenyewa = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textIDPenyewa = new javax.swing.JTextField();
        textNamaLengkap = new javax.swing.JTextField();
        textAlamat1 = new javax.swing.JTextField();
        textTelepon = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        textPencarianPenyewa = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPenyewa = new javax.swing.JTable();
        cbJenisKelamin = new javax.swing.JComboBox<>();
        panelTransaksi = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        textIDTransaksi = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        textPencarianTransaksi = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jCbPc = new javax.swing.JComboBox<>();
        jCbPenyewa = new javax.swing.JComboBox<>();
        jDateSewa = new com.toedter.calendar.JDateChooser();
        jDateKembali = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("APLIKASI PENYEWAAN PC KYY");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Penyewaan PC Termurah dan Terbaik di Kota Rantau");

        jtabletanggal.setBackground(new java.awt.Color(51, 51, 51));
        jtabletanggal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtabletanggal.setForeground(new java.awt.Color(255, 255, 255));
        jtabletanggal.setText("tanggal");
        jtabletanggal.setName(""); // NOI18N

        waktu.setBackground(new java.awt.Color(51, 51, 51));
        waktu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        waktu.setForeground(new java.awt.Color(255, 255, 255));
        waktu.setText("waktu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtabletanggal)
                .addGap(62, 62, 62)
                .addComponent(waktu)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtabletanggal)
                    .addComponent(waktu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jButton1.setText("Beranda");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money-transfer.png"))); // NOI18N
        jButton2.setText("Transaksi");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cust.png"))); // NOI18N
        jButton3.setText("Pelanggan");
        jButton3.setToolTipText("");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pc.png"))); // NOI18N
        jButton4.setText("PC");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log-out.png"))); // NOI18N
        jButton5.setText("LOG OUT");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBody.setLayout(new java.awt.CardLayout());

        panelBeranda.setBackground(new java.awt.Color(0, 0, 255));
        panelBeranda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Aplikasi Penyewaan PC KYY adalah Aplikasi untuk penyewaan PC berbasis GUI Java");
        panelBeranda.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("menu panel. untuk memudahkan dalam memilih navigasi menu dalam satu frame dengan 4 panel ");
        panelBeranda.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 20));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Penyewaan PC Terbaik di wiliyah Kabupaten Tapin, provinsi kalimantan selatan.  ");
        panelBeranda.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 17)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Aplikasi ini sangat user friendly dengan menggunakan GUI Dynamic ");
        panelBeranda.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 17)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Implementasi dari CRUD dan menggunakan Database Mysql yang menyediakan info");
        panelBeranda.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 73, -1, -1));

        panelBody.add(panelBeranda, "card2");

        panelPC.setBackground(new java.awt.Color(0, 0, 255));
        panelPC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID");
        panelPC.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Merek");
        panelPC.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jumlah PC");
        panelPC.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 108, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Biaya");
        panelPC.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 108, -1));

        textNoSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNoSeriesActionPerformed(evt);
            }
        });
        panelPC.add(textNoSeries, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 426, -1));
        panelPC.add(textMerek, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 426, -1));
        panelPC.add(textJmlhpc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 426, -1));
        panelPC.add(textBiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 430, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cari Data PC ");
        panelPC.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 331, -1, -1));

        textPencarianPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPencarianPcActionPerformed(evt);
            }
        });
        textPencarianPc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPencarianPcKeyPressed(evt);
            }
        });
        panelPC.add(textPencarianPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 332, 673, -1));

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jButton6.setText("Delete");
        jButton6.setToolTipText("");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panelPC.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 196, 159, 40));

        jButton7.setBackground(new java.awt.Color(153, 153, 153));
        jButton7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        jButton7.setText("Save");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panelPC.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 64, 159, 40));

        jButton8.setBackground(new java.awt.Color(153, 153, 153));
        jButton8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        jButton8.setText("Edit");
        jButton8.setToolTipText("");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panelPC.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 129, 159, 40));

        tabelPc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "No Series", "Merek PC", "Jumlah PC", "Harga Sewa"
            }
        ));
        tabelPc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPcMouseClicked(evt);
            }
        });
        jScrollPanel1.setViewportView(tabelPc);

        panelPC.add(jScrollPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 910, 170));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nomor Series");
        panelPC.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });
        panelPC.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 426, -1));

        panelBody.add(panelPC, "card3");

        panelPenyewa.setBackground(new java.awt.Color(0, 0, 255));
        panelPenyewa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID Penyewa");
        panelPenyewa.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 150, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nama Lengkap");
        panelPenyewa.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jenis Kelamin");
        panelPenyewa.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, -1));

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Alamat");
        panelPenyewa.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 108, -1));

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("telepon");
        panelPenyewa.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 108, -1));
        panelPenyewa.add(textIDPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 165, -1));
        panelPenyewa.add(textNamaLengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 426, -1));
        panelPenyewa.add(textAlamat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 430, 50));
        panelPenyewa.add(textTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 164, -1));

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Cari Data Pengunjung");
        panelPenyewa.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 331, -1, -1));

        textPencarianPenyewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPencarianPenyewaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textPencarianPenyewaKeyReleased(evt);
            }
        });
        panelPenyewa.add(textPencarianPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 673, -1));

        jButton10.setBackground(new java.awt.Color(153, 153, 153));
        jButton10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jButton10.setText("Delete");
        jButton10.setToolTipText("");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        panelPenyewa.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 196, 159, 40));

        jButton11.setBackground(new java.awt.Color(153, 153, 153));
        jButton11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        jButton11.setText("Save");
        jButton11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        panelPenyewa.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 64, 159, 40));

        jButton12.setBackground(new java.awt.Color(153, 153, 153));
        jButton12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        jButton12.setText("Edit");
        jButton12.setToolTipText("");
        jButton12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        panelPenyewa.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 129, 159, 40));

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tabelPenyewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelPenyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPenyewaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPenyewa);

        panelPenyewa.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 910, 170));

        cbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan", " " }));
        cbJenisKelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisKelaminActionPerformed(evt);
            }
        });
        panelPenyewa.add(cbJenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 170, -1));

        panelBody.add(panelPenyewa, "card4");

        panelTransaksi.setBackground(new java.awt.Color(0, 0, 255));
        panelTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("ID Transaksi");
        panelTransaksi.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 59, 130, -1));

        jLabel24.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Penyewa");
        panelTransaksi.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel25.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("PC");
        panelTransaksi.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tanggal Sewa");
        panelTransaksi.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 170, -1));

        jLabel27.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Tanggal Kembali");
        panelTransaksi.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 170, -1));
        panelTransaksi.add(textIDTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 60, 165, -1));

        jLabel29.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Cari Data Transaksi");
        panelTransaksi.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 331, -1, -1));

        textPencarianTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPencarianTransaksiActionPerformed(evt);
            }
        });
        textPencarianTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPencarianTransaksiKeyPressed(evt);
            }
        });
        panelTransaksi.add(textPencarianTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 673, -1));

        jButton14.setBackground(new java.awt.Color(153, 153, 153));
        jButton14.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jButton14.setText("Delete");
        jButton14.setToolTipText("");
        jButton14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        panelTransaksi.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 196, 159, 40));

        jButton15.setBackground(new java.awt.Color(153, 153, 153));
        jButton15.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        jButton15.setText("Save");
        jButton15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        panelTransaksi.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 64, 159, 40));

        jButton16.setBackground(new java.awt.Color(153, 153, 153));
        jButton16.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 13)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        jButton16.setText("Edit");
        jButton16.setToolTipText("");
        jButton16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        panelTransaksi.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 129, 159, 40));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelTransaksi);

        panelTransaksi.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 910, 180));

        jCbPc.setActionCommand("test");
        jCbPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbPcActionPerformed(evt);
            }
        });
        panelTransaksi.add(jCbPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        panelTransaksi.add(jCbPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));
        panelTransaksi.add(jDateSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));
        panelTransaksi.add(jDateKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        panelBody.add(panelTransaksi, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // remove panel
        panelBody.removeAll();
        panelBody.repaint();
        panelBody.revalidate();

        // add panel
        panelBody.add(panelBeranda);
        panelBody.repaint();
        panelBody.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jCbPc.removeAllItems();
        jCbPenyewa.removeAllItems();
        updateCombo();
        panelBody.removeAll();
        panelBody.repaint();
        panelBody.revalidate();

        // add panel
        panelBody.add(panelTransaksi);
        panelBody.repaint();
        panelBody.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        panelBody.removeAll();
        panelBody.repaint();
        panelBody.revalidate();

        // add panel
        panelBody.add(panelPenyewa);
        panelBody.repaint();
        panelBody.revalidate();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        panelBody.removeAll();
        panelBody.repaint();
        panelBody.revalidate();

        // add panel
        panelBody.add(panelPC);
        panelBody.repaint();
        panelBody.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void textPencarianPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPencarianPcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPencarianPcActionPerformed

    private void textPencarianPcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPencarianPcKeyPressed
        // TODO add your handling code here:
        String SQLCari = "SELECT*FROM pc WHERE no_seri LIKE '%" + textPencarianPc.getText() + "%' OR merek_pc LIKE '%" + textPencarianPc.getText() + "%' ";
        new configDBOW().setJudulKolom(tabelPc, Judulnya);
        new configDBOW().cariData(tabelPc, Judulnya, SQLCari);
        new configDBOW().setLebarJudulKolom(tabelPc, LebarKolomOW);
    }//GEN-LAST:event_textPencarianPcKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new configDBOW().HapusDinamis("pc", "id", textID.getText());

        new configDBOW().setJudulKolom(tabelPc, Judulnya);
        new configDBOW().setTampilTabel(tabelPc, Judulnya, SQL);
        new configDBOW().setLebarJudulKolom(tabelPc, LebarKolomOW);
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (textID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No Id Belum diisi");
            textID.requestFocus();
        } else if (textNoSeries.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No Seri Belum diisi");
            textNoSeries.requestFocus();
        } else if (textMerek.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Merek PC Belum diisi");
            textMerek.requestFocus();
        } else if (textJmlhpc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah PC Belum diisi");
            textJmlhpc.requestFocus();
        } else if (textBiaya.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Sewa Belum diisi");
            textBiaya.requestFocus();
        } else if (new configDBOW().getDuplikasiKey("pc", "id", textID.getText())) {
            JOptionPane.showMessageDialog(null, "ID PC sudah terdaftar");
        } else {

            // area koding simpan
            String[] F = {"id", "no_seri", "merek_pc", "jmlh_pc", "biaya"};
            String[] isinya = {textID.getText(), textNoSeries.getText(), textMerek.getText(), textJmlhpc.getText(), textBiaya.getText()};
            new configDBOW().SimpanDinamis("pc", F, isinya);

            new configDBOW().setJudulKolom(tabelPc, Judulnya);
            new configDBOW().setTampilTabel(tabelPc, Judulnya, SQL);
            new configDBOW().setLebarJudulKolom(tabelPc, LebarKolomOW);
            reset();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String tId = textID.getText();
        String tJudul = textNoSeries.getText();
        String tGenre = textMerek.getText();
        String tTahun = textJmlhpc.getText();
        String tAsal = textBiaya.getText();

        String fieldnya[] = {"id", "no_seri", "merek_pc", "jmlh_pc", "biaya"};
        String isinya[] = {tId, tJudul, tGenre, tTahun, tAsal};

        new configDBOW().UbahDinamis("pc", "id", tId, fieldnya, isinya);

        new configDBOW().setJudulKolom(tabelPc, Judulnya);
        new configDBOW().setTampilTabel(tabelPc, Judulnya, SQL);
        new configDBOW().setLebarJudulKolom(tabelPc, LebarKolomOW);
        reset();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void textPencarianPenyewaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPencarianPenyewaKeyPressed
        // TODO add your handling code here:
        String SQLCari1 = "SELECT*FROM penyewa WHERE id LIKE '%" + textPencarianPenyewa.getText() + "%' OR nama_penyewa LIKE '%" + textPencarianPenyewa.getText() + "%' ";
        new configDBOW().setJudulKolom(tabelPenyewa, Namanya);
        new configDBOW().cariData(tabelPenyewa, Namanya, SQLCari1);
        new configDBOW().setLebarJudulKolom(tabelPenyewa, LebarKolomPengunjung);
    }//GEN-LAST:event_textPencarianPenyewaKeyPressed

    private void textPencarianPenyewaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPencarianPenyewaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textPencarianPenyewaKeyReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

        if ((textIDPenyewa.getText().isEmpty()) && (textNamaLengkap.getText().isEmpty()) && (textAlamat1.getText().isEmpty()) && (textTelepon.getText().isEmpty()) && (cbJenisKelamin.getSelectedItem() == ".:Pilih Data:.")) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data sebelum proses hapus ");
            tabelPenyewa.requestFocus();
        } else {

            new configDBOW().HapusDinamis("penyewa", "id", textIDPenyewa.getText());
            new configDBOW().setTampilTabel(tabelPenyewa, Namanya, SQL1);
            new configDBOW().setLebarJudulKolom(tabelPenyewa, LebarKolomPengunjung);
            reset1();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            if (textIDPenyewa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID Penyewa belum diisi");
                textIDPenyewa.requestFocus();
            } else if (textNamaLengkap.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama Lengkap Penyewa belum diisi");
                textNamaLengkap.requestFocus();
            } else if (cbJenisKelamin.getSelectedItem() == ".: Pilih Data :.") {
                JOptionPane.showMessageDialog(null, "Jenis Kelamin Penyewa belum diisi");
                cbJenisKelamin.requestFocus();
            } else if (textAlamat1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ALamat Penyewa belum diisi");
                textAlamat1.requestFocus();
            } else if (textTelepon.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nomor Telp Penyewa belum diisi");
                textTelepon.requestFocus();
            } else if (new configDBOW().getDuplikasiKey("penyewa", "id", textIDPenyewa.getText()) == true) {
                JOptionPane.showMessageDialog(null, "ID Penyewa sudah terdaftar");
                java.sql.Statement st = new configDBOW().getKoneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery("SELECT*FROM penyewa WHERE id='" + textIDPenyewa.getText() + "'");
                if (rs.next()) {
                    textNamaLengkap.setText(rs.getString("nama_penyewa"));
                    cbJenisKelamin.setSelectedItem(String.valueOf(rs.getString("jk")));
                    textAlamat1.setText(rs.getString("alamat"));
                    textTelepon.setText(rs.getString("no_telp"));
                }
            } else {
                String[] F = {"id", "nama_penyewa", "jk", "alamat", "no_telp"};
                String[] isinya = {textIDPenyewa.getText(), textNamaLengkap.getText(), String.valueOf(cbJenisKelamin.getSelectedItem()), textAlamat1.getText(), textTelepon.getText()};
                new configDBOW().SimpanDinamis("penyewa", F, isinya);
                new configDBOW().setJudulKolom(tabelPenyewa, Namanya);
                new configDBOW().setTampilTabel(tabelPenyewa, Namanya, SQL1);
                new configDBOW().setLebarJudulKolom(tabelPenyewa, LebarKolomPengunjung);

            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        reset1();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try {

            if ((textIDPenyewa.getText().isEmpty()) && (textNamaLengkap.getText().isEmpty()) && (textAlamat1.getText().isEmpty()) && (textTelepon.getText().isEmpty()) && (cbJenisKelamin.getSelectedItem() == ".: Pilih Data :.")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih data sebelum proses ubah");
                tabelPenyewa.requestFocus();
            } else {
                String[] F = {"id", "nama_penyewa", "jk", "alamat", "no_telp"};
                String[] isinya = {textIDPenyewa.getText(), textNamaLengkap.getText(), String.valueOf(cbJenisKelamin.getSelectedItem()), textAlamat1.getText(), textTelepon.getText()};
                new configDBOW().UbahDinamis("penyewa", "id", textIDPenyewa.getText(), F, isinya);
                new configDBOW().setJudulKolom(tabelPenyewa, Namanya);
                new configDBOW().setTampilTabel(tabelPenyewa, Namanya, SQL1);
                new configDBOW().setLebarJudulKolom(tabelPenyewa, LebarKolomPengunjung);
            }
        } catch (Exception e) {
            System.out.print(e.toString());

        }
        reset1();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void cbJenisKelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisKelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisKelaminActionPerformed

    private void textPencarianTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPencarianTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPencarianTransaksiActionPerformed

    private void textPencarianTransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPencarianTransaksiKeyPressed
        // TODO add your handling code here:
        String SQLCari2 = "SELECT*FROM transaksi WHERE id LIKE '%" + textPencarianTransaksi.getText() + "%' OR penyewa_id LIKE '%" + textPencarianTransaksi.getText() + "%' ";
        new configDBOW().setJudulKolom(tabelTransaksi, Transaksi);
        new configDBOW().cariData(tabelTransaksi, Transaksi, SQLCari2);
        new configDBOW().setLebarJudulKolom(tabelTransaksi, LebarKolomTransaksi);
    }//GEN-LAST:event_textPencarianTransaksiKeyPressed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        try {
            if ((textIDTransaksi.getText().isEmpty()) && (jCbPc.getSelectedItem() == ".: Pilih Data :.") && (jCbPenyewa.getSelectedItem() == ".: Pilih Data :.") && (jDateSewa.getDate().equals(null)) && (jDateKembali.getDate().equals(null))) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih data sebelum proses hapus ");
                tabelTransaksi.requestFocus();
            } else {

                new configDBOW().HapusDinamis("transaksi", "id", textIDTransaksi.getText());
                new configDBOW().setTampilTabel(tabelTransaksi, Transaksi, SQL2);
                new configDBOW().setLebarJudulKolom(tabelTransaksi, LebarKolomTransaksi);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        reset2();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        try {
            if (textIDTransaksi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID Transaksi belum diisi");
                textIDTransaksi.requestFocus();
            } else if (jCbPc.getSelectedItem() == ".: Pilih Data :.") {
                JOptionPane.showMessageDialog(null, "ID Penyewa belum diisi");
                jCbPc.requestFocus();
            } else if (jCbPenyewa.getSelectedItem() == ".: Pilih Data :.") {
                JOptionPane.showMessageDialog(null, "ID PC belum diisi");
                jCbPenyewa.requestFocus();
            } else if (jDateSewa.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Tanggal Sewa Belum diisi");
                jDateSewa.requestFocus();
            } else if (jDateKembali.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Tanggal Pengembalian Belum diisi");
                jDateKembali.requestFocus();
            } else if (new configDBOW().getDuplikasiKey("transaksi", "id", textIDTransaksi.getText()) == true) {
                JOptionPane.showMessageDialog(null, "ID Transaksi sudah terdaftar");
                java.sql.Statement st = new configDBOW().getKoneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery("SELECT*FROM transaksi WHERE id ='" + textIDTransaksi.getText() + "'");
                if (rs.next()) {
                    jCbPc.setSelectedItem(String.valueOf(rs.getString("pc_id")));
                    jCbPenyewa.setSelectedItem(String.valueOf(rs.getString("penyewa_id")));
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    jDateSewa.setDate(dt.parse(rs.getString("tgl_keluar")));
                    jDateKembali.setDate(dt.parse(rs.getString("tgl_masuk")));
                }
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String TGL1 = sdf.format(jDateSewa.getDate());
                String TGL2 = sdf.format(jDateKembali.getDate());
                String[] F = {"id", "pc_id", "penyewa_id", "tgl_keluar", "tgl_masuk"};
                String[] isinya = {textIDTransaksi.getText(), String.valueOf(jCbPc.getSelectedItem()), String.valueOf(jCbPenyewa.getSelectedItem()), TGL1, TGL2};
                new configDBOW().SimpanDinamis("transaksi", F, isinya);

                new configDBOW().setTampilTabel(tabelTransaksi, Transaksi, SQL2);
                new configDBOW().setLebarJudulKolom(tabelTransaksi, LebarKolomTransaksi);

            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }reset2();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        try {

            if ((textIDTransaksi.getText().isEmpty()) && (jCbPc.getSelectedItem() == ".: Pilih Data :.") && (jCbPenyewa.getSelectedItem() == ".: Pilih Data :.") && (jDateSewa.getDate().equals(null)) && (jDateKembali.getDate().equals(null))) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih data sebelum proses ubah");
                tabelTransaksi.requestFocus();
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String TGL1 = sdf.format(jDateSewa.getDate());
                String TGL2 = sdf.format(jDateKembali.getDate());
                String[] F = {"id", "pc_id", "penyewa_id", "tgl_keluar", "tgl_masuk"};
                String[] isinya = {textIDTransaksi.getText(), String.valueOf(jCbPc.getSelectedItem()), String.valueOf(jCbPenyewa.getSelectedItem()), TGL1, TGL2};
                new configDBOW().UbahDinamis("transaksi", "id", textIDTransaksi.getText(), F, isinya);
                new configDBOW().setTampilTabel(tabelTransaksi, Transaksi, SQL2);
                new configDBOW().setLebarJudulKolom(tabelTransaksi, LebarKolomTransaksi);
            }
        } catch (Exception e) {
            System.out.print(e.toString());

        }reset2();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void textNoSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNoSeriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNoSeriesActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    private void tabelPcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPcMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabelPc.getModel();
        textID.setText(model.getValueAt(tabelPc.getSelectedRow(), 0).toString());
        textNoSeries.setText(model.getValueAt(tabelPc.getSelectedRow(), 1).toString());
        textMerek.setText(model.getValueAt(tabelPc.getSelectedRow(), 2).toString());
        textJmlhpc.setText(model.getValueAt(tabelPc.getSelectedRow(), 3).toString());
        textBiaya.setText(model.getValueAt(tabelPc.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tabelPcMouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void tabelPenyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPenyewaMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabelPenyewa.getModel();
        textIDPenyewa.setText(model.getValueAt(tabelPenyewa.getSelectedRow(), 0).toString());
        textNamaLengkap.setText(model.getValueAt(tabelPenyewa.getSelectedRow(), 1).toString());
        cbJenisKelamin.setSelectedItem(model.getValueAt(tabelPenyewa.getSelectedRow(), 2));
        textAlamat1.setText(model.getValueAt(tabelPenyewa.getSelectedRow(), 3).toString());
        textTelepon.setText(model.getValueAt(tabelPenyewa.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tabelPenyewaMouseClicked

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabelTransaksi.getModel();
        textIDTransaksi.setText(model.getValueAt(tabelTransaksi.getSelectedRow(), 0).toString());

    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void jCbPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbPcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbPcActionPerformed

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
            java.util.logging.Logger.getLogger(AppPenyewaanPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppPenyewaanPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppPenyewaanPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppPenyewaanPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppPenyewaanPC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbJenisKelamin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jCbPc;
    private javax.swing.JComboBox<String> jCbPenyewa;
    private com.toedter.calendar.JDateChooser jDateKembali;
    private com.toedter.calendar.JDateChooser jDateSewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPanel1;
    private javax.swing.JLabel jtabletanggal;
    private javax.swing.JPanel panelBeranda;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelPC;
    private javax.swing.JPanel panelPenyewa;
    private javax.swing.JPanel panelTransaksi;
    private javax.swing.JTable tabelPc;
    private javax.swing.JTable tabelPenyewa;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTextField textAlamat1;
    private javax.swing.JTextField textBiaya;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textIDPenyewa;
    private javax.swing.JTextField textIDTransaksi;
    private javax.swing.JTextField textJmlhpc;
    private javax.swing.JTextField textMerek;
    private javax.swing.JTextField textNamaLengkap;
    private javax.swing.JTextField textNoSeries;
    private javax.swing.JTextField textPencarianPc;
    private javax.swing.JTextField textPencarianPenyewa;
    private javax.swing.JTextField textPencarianTransaksi;
    private javax.swing.JTextField textTelepon;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables
}
