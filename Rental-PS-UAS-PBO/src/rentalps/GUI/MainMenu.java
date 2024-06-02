
package rentalps.GUI;

import javax.swing.JInternalFrame;

/**
 * Kelas MainMenu adalah kelas utama yang mewakili menu utama dalam aplikasi.
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Konstruktor untuk membuat instance baru dari MainMenu.
     */
    public MainMenu() {
        initComponents();
        jendelaDalam(new formRent());
    }

    /**
     * Metode untuk mendapatkan harga sewa per jam berdasarkan nomor PS.
     * 
     * @param nomorPS nomor PS yang digunakan
     * @return harga sewa per jam
     */
    public int getHargaPS(int nomorPS) {
        int harga = 0;

        switch (nomorPS) {
            case 1:
                harga = 2000;
                break;
            case 2:
                harga = 3000;
                break;
            case 4:
                harga = 4000;
                break;
            case 5:
                harga = 5000;
                break;
            default:
                harga = 0;
                break;
        }

        return harga;
    }

    /**
     * Metode untuk menampilkan internal frame di dalam desktop.
     */
    public void jendelaDalam(JInternalFrame frame) {
        frame.setVisible(true);
        frame.setResizable(true);
        desktop.add(frame);
        this.setContentPane(desktop);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mniNew = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuFile.setText("File");

        mniNew.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniNew.setText("New");
        mniNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNewActionPerformed(evt);
            }
        });
        mnuFile.add(mniNew);
        mnuFile.add(jSeparator1);

        mniExit.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuFile.add(mniExit);

        mnuBar.add(mnuFile);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE));

        pack();
    }

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {
        //
        System.exit(0);
    }//

    private void mniNewActionPerformed(java.awt.event.ActionEvent evt) {

        jendelaDalam(new formRent());
    }

    /**
     * @param args argumen baris perintah
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Membuat dan menampilkan formulir */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniNew;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuFile;

}
