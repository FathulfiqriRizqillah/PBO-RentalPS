package rentalps.GUI;

import Operation.DateAndTime;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class formRent extends javax.swing.JInternalFrame {
        private DefaultTableModel tabModel;

        /**
         * Membuat from sewa
         */
        public formRent() {
                initComponents();
                setTabel();
        }

        public String[] bulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus",
                        "September",
                        "Oktober", "November", "Desember" };

        private String no, nama, tanggal, waktu, paket, product, property;

        public String getNo() {
                this.no = TextNo.getText();
                return no;
        }

        public String getNama() {
                this.nama = TextNama.getText();
                return nama;
        }

        public String getTanggal() {
                this.tanggal = cbTgl.getSelectedItem().toString() + " / " +
                                cbBulan.getSelectedItem().toString() + " / " +
                                cbThn.getSelectedItem().toString();
                return tanggal;
        }

        public String getWaktu() {
                this.waktu = cbHours.getSelectedItem().toString() + " : " +
                                cbMinutes.getSelectedItem().toString();
                return waktu;
        }

        public String getPaket() {
                if (jrPlay.isSelected()) {
                        this.paket = cbPlay.getSelectedItem().toString();
                } else if (jrHome.isSelected()) {
                        this.paket = cbTake.getSelectedItem().toString();
                }

                return paket;

        }

        public String getProduct() {
                this.product = cbProduct.getSelectedItem().toString();
                return product;
        }

        public String getProperty() {
                if (cbProperty.isEnabled()) {
                        this.property = cbProperty.getSelectedItem().toString();
                } else {
                        this.property = "-";
                }
                return property;
        }

        private void setTabel() {
                String[] JudulKolom = { "NO ID", "NAMA", "TANGAL", "WAKTU", "PAKET", "PRODUCT", "PROPERTY" };
                tabModel = new DefaultTableModel(null, JudulKolom) {
                        boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                };
                tabel.setModel(tabModel);
                tabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                tabel.getColumnModel().getColumn(0).setPreferredWidth(100);
                tabel.getColumnModel().getColumn(1).setPreferredWidth(200);
                tabel.getColumnModel().getColumn(2).setPreferredWidth(150);
                tabel.getColumnModel().getColumn(3).setPreferredWidth(50);
                tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
                tabel.getColumnModel().getColumn(5).setPreferredWidth(150);
                tabel.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        DateAndTime opDate = new DateAndTime();

        @SuppressWarnings("unchecked")

        private void initComponents() {

                grupPaket = new javax.swing.ButtonGroup();
                panelUser = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                TextNoHP = new javax.swing.JTextField();
                TextAlamat = new javax.swing.JTextField();
                TextNama = new javax.swing.JTextField();
                TextNo = new javax.swing.JTextField();
                panelRental = new javax.swing.JPanel();
                cbTgl = new javax.swing.JComboBox();
                cbBulan = new javax.swing.JComboBox();
                cbThn = new javax.swing.JComboBox();
                cbPlay = new javax.swing.JComboBox();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jrHome = new javax.swing.JRadioButton();
                jrPlay = new javax.swing.JRadioButton();
                cbTake = new javax.swing.JComboBox();
                jLabel8 = new javax.swing.JLabel();
                cbHours = new javax.swing.JComboBox();
                jLabel9 = new javax.swing.JLabel();
                cbMinutes = new javax.swing.JComboBox();
                btnEditStartAt = new javax.swing.JToggleButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                tabel = new javax.swing.JTable();
                btnExit = new javax.swing.JButton();
                panelProduct = new javax.swing.JPanel();
                jLabel7 = new javax.swing.JLabel();
                cbProduct = new javax.swing.JComboBox();
                jLabel10 = new javax.swing.JLabel();
                cbProperty = new javax.swing.JComboBox();
                btnProses = new javax.swing.JButton();
                btnClose = new javax.swing.JButton();

                setClosable(true);
                setIconifiable(true);
                setMaximizable(true);
                setResizable(true);

                panelUser.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Diri"));

                jLabel1.setText("No KTP");

                jLabel2.setText("Nama");

                jLabel3.setText("Alamat");

                jLabel4.setText("No Handphone");

                javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
                panelUser.setLayout(panelUserLayout);
                panelUserLayout.setHorizontalGroup(
                                panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelUserLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelUserLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel1))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(panelUserLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                false)
                                                                                .addComponent(TextAlamat,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                125, Short.MAX_VALUE)
                                                                                .addComponent(TextNama,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(TextNo,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(TextNoHP))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                panelUserLayout.setVerticalGroup(
                                panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelUserLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(
                                                                                panelUserLayout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jLabel1)
                                                                                                .addComponent(TextNo,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(
                                                                                panelUserLayout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jLabel2)
                                                                                                .addComponent(TextNama,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(
                                                                                panelUserLayout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jLabel3)
                                                                                                .addComponent(TextAlamat,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(
                                                                                panelUserLayout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jLabel4)
                                                                                                .addComponent(TextNoHP,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(49, Short.MAX_VALUE)));

                panelRental.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Rental"));

                for (int a = 1; a <= 30; a++) {
                        cbTgl.addItem(a <= 9 ? "0" + a : a);
                }

                Calendar tgl = Calendar.getInstance();
                int th = tgl.get(Calendar.DAY_OF_MONTH);
                cbTgl.setSelectedItem(th);

                for (int a = 0; a < 12; a++) {
                        cbBulan.addItem(bulan[a]);
                }

                Calendar bln = Calendar.getInstance();
                int bl = bln.get(Calendar.MONTH);
                cbBulan.setSelectedItem(bulan[bl]);

                for (int t = 2006; t <= 2024; t++) {
                        cbThn.addItem(t);
                }

                Calendar thn = Calendar.getInstance();
                int tahun = thn.get(Calendar.YEAR);
                cbThn.setSelectedItem(tahun);

                for (int i = 1; i <= 24; i += 2) {
                        cbPlay.addItem(i + " Jam");
                }
                cbPlay.setSelectedItem(1);

                jLabel5.setText("Tanggal");

                jLabel6.setText("Paket");

                grupPaket.add(jrHome);
                jrHome.setText("Take Home");
                jrHome.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                jrHomeItemStateChanged(evt);
                        }
                });

                grupPaket.add(jrPlay);
                jrPlay.setSelected(true);
                jrPlay.setText("Play");
                jrPlay.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                jrPlayItemStateChanged(evt);
                        }
                });

                cbTake.setEnabled(false);
                for (int i = 1; i <= 30; i++) {
                        cbTake.addItem(i + " Hari");
                }

                cbTake.setSelectedIndex(1);

                jLabel8.setText("Start At");

                for (int i = 0; i <= 24; i++) {
                        cbHours.addItem(i);
                }

                opDate.setJam();
                cbHours.setSelectedIndex(opDate.getJam());
                cbHours.setEnabled(false);

                jLabel9.setText(":");

                int hargaPS = opDate.getHargaPS(1);

                jLabel10.setText("Harga Sewa");
                jLabel10.setVisible(true);
                jLabel10.setEnabled(true);
                jLabel10.setToolTipText("Harga Sewa per Jam");

                int hargaPS1 = 2000;
                int hargaPS2 = 3000;
                int hargaPS4 = 4000;
                int hargaPS5 = 5000;
                for (int i = 0; i <= 60; i++) {
                        cbMinutes.addItem(i);
                }

                opDate.setMenit();
                cbMinutes.setSelectedIndex(opDate.getMenit());
                cbMinutes.setEnabled(false);

                btnEditStartAt.setText("Edit");
                btnEditStartAt.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                btnEditStartAtMouseClicked(evt);
                        }
                });
                btnEditStartAt.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                btnEditStartAtItemStateChanged(evt);
                        }
                });

                javax.swing.GroupLayout panelRentalLayout = new javax.swing.GroupLayout(panelRental);
                panelRental.setLayout(panelRentalLayout);
                panelRentalLayout.setHorizontalGroup(
                                panelRentalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRentalLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelRentalLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelRentalLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel8)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(panelRentalLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(panelRentalLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel6)
                                                                                                                .addGroup(panelRentalLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(panelRentalLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel5)
                                                                                                                                                .addComponent(jrPlay,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                87,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jrHome))
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addGroup(panelRentalLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                false)
                                                                                                                                                .addGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                panelRentalLayout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(cbHours,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                65,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                                .addComponent(jLabel9)
                                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                                .addComponent(cbMinutes,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                65,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                                .addComponent(btnEditStartAt,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                79,
                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                .addGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                panelRentalLayout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(cbTgl,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                70,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                                .addComponent(cbThn,
                                                                                                                                                                                                0,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                .addComponent(cbBulan,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                0,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(cbPlay,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                0,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(cbTake,
                                                                                                                                                                0,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE))))
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))));
                panelRentalLayout.setVerticalGroup(
                                panelRentalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRentalLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelRentalLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(cbTgl,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(cbThn,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(cbBulan,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                14,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(panelRentalLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel8)
                                                                                .addComponent(cbHours,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel9)
                                                                                .addComponent(cbMinutes,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnEditStartAt))
                                                                .addGap(13, 13, 13)
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(
                                                                                panelRentalLayout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(cbPlay,
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jrPlay))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(panelRentalLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jrHome)
                                                                                .addComponent(cbTake,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap()));

                tabel.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null }
                                },
                                new String[] {
                                                "Title 1", "Title 2", "Title 3", "Title 4"
                                }));
                jScrollPane1.setViewportView(tabel);

                btnExit.setText("Exit");
                btnExit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnExitActionPerformed(evt);
                        }
                });

                panelProduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Information Product"));

                jLabel7.setText("Product");

                cbProduct.setModel(new javax.swing.DefaultComboBoxModel(
                                new String[] { "Playstation 1", "Playstation 2", "Playstation 3", "Playstation 4",
                                                "Playstation 5" }));
                cbProduct.setSelectedIndex(2);

                jLabel10.setText("Property");

                cbProperty.setModel(
                                new javax.swing.DefaultComboBoxModel(
                                                new String[] { "Hardisk", "CD/DVD Book Paket" }));
                cbProperty.setEnabled(false);

                btnProses.setText("Proses");
                btnProses.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnProsesActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelProductLayout = new javax.swing.GroupLayout(panelProduct);
                panelProduct.setLayout(panelProductLayout);
                panelProductLayout.setHorizontalGroup(
                                panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelProductLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelProductLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelProductLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(panelProductLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel10)
                                                                                                                .addComponent(jLabel7))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(panelProductLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(cbProduct,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(cbProperty,
                                                                                                                                0,
                                                                                                                                173,
                                                                                                                                Short.MAX_VALUE)))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                panelProductLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(btnProses)))
                                                                .addContainerGap()));
                panelProductLayout.setVerticalGroup(
                                panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelProductLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelProductLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(cbProduct,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(panelProductLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel10)
                                                                                .addComponent(cbProperty,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnProses)
                                                                .addContainerGap()));

                btnClose.setText("Close");
                btnClose.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCloseActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(btnClose,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                70,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(btnExit,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                70,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(panelUser,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(panelRental,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(panelProduct,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(panelUser,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(panelRental,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(panelProduct,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                358, Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnExit)
                                                                                .addComponent(btnClose))
                                                                .addContainerGap()));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jrPlayItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jrPlayItemStateChanged
                // TODO add your handling code here:
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                        cbPlay.setEnabled(true);
                        cbTake.setEnabled(false);

                } else {

                        cbPlay.setEnabled(false);
                        cbTake.setEnabled(false);
                }
        }

        private void jrHomeItemStateChanged(java.awt.event.ItemEvent evt) {

                if (evt.getStateChange() == ItemEvent.SELECTED) {
                        cbTake.setEnabled(true);
                        cbPlay.setEnabled(false);
                        cbProperty.setEnabled(true);

                } else {

                        cbTake.setSelectedIndex(1);
                        cbProperty.setEnabled(false);
                        cbPlay.setEnabled(false);
                        cbTake.setEnabled(false);
                }
        }

        private void btnEditStartAtMouseClicked(java.awt.event.MouseEvent evt) {

        }

        private void btnEditStartAtItemStateChanged(java.awt.event.ItemEvent evt) {

                if (evt.getStateChange() == ItemEvent.SELECTED) {
                        cbHours.setEnabled(true);
                        cbMinutes.setEnabled(true);
                } else {
                        cbHours.setEnabled(false);
                        cbMinutes.setEnabled(false);
                }
        }

        private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {

                int i = JOptionPane.showOptionDialog(null, "Apakah Anda Yakin Ingin Keluar dari Program!!",
                                "Konfirmasi",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (1 != i) {
                        System.exit(0);
                }

        }

        private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
                int i = JOptionPane.showOptionDialog(null, "Apakah Anda Yakin kembali Ke Menu Utama?", "Konfirmasi",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (1 != i) {
                        this.dispose();
                }
        }

        private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {
                Object Data[] = { getNo(), getNama(), getTanggal(), getWaktu(), getPaket(), getProduct(),
                                getProperty() };
                tabModel.addRow(Data);
        }

        private javax.swing.JTextField TextAlamat;
        private javax.swing.JTextField TextNama;
        private javax.swing.JTextField TextNo;
        private javax.swing.JTextField TextNoHP;
        private javax.swing.JButton btnClose;
        private javax.swing.JToggleButton btnEditStartAt;
        private javax.swing.JButton btnExit;
        private javax.swing.JButton btnProses;
        private javax.swing.JComboBox cbBulan;
        private javax.swing.JComboBox cbHours;
        private javax.swing.JComboBox cbMinutes;
        private javax.swing.JComboBox cbPlay;
        private javax.swing.JComboBox cbProduct;
        private javax.swing.JComboBox cbProperty;
        private javax.swing.JComboBox cbTake;
        private javax.swing.JComboBox cbTgl;
        private javax.swing.JComboBox cbThn;
        private javax.swing.ButtonGroup grupPaket;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JRadioButton jrHome;
        private javax.swing.JRadioButton jrPlay;
        private javax.swing.JPanel panelProduct;
        private javax.swing.JPanel panelRental;
        private javax.swing.JPanel panelUser;
        private javax.swing.JTable tabel;
}
