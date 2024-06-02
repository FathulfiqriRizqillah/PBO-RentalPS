package rentalps;

import java.awt.Dimension;
import java.awt.Toolkit;
import rentalps.GUI.MainMenu;

/**
 * Creator by Kelompok 9
 * nama NPM
 * 1.Fathulfiqri Rizqillah 2010631250090
 * 2.Widya Dwi Putri Rahayu 2010631250025
 * 3.Putri Harumsari 2010631250072
 * 4.Muhammad Nur Ihsan 2010631250093
 *
 * @author
 */

public class RentalPS {
    private Dimension layarUtama;

    private int hargaPS1 = 2000;
    private int hargaPS2 = 3000;
    private int hargaPS4 = 4000;
    private int hargaPS5 = 5000;

    public RentalPS() {
        MainMenu utama = new MainMenu();
        utama.setSize(getLayarUtama().width, getLayarUtama().height - 30);
        utama.setVisible(true);
    }

    public Dimension getLayarUtama() {
        layarUtama = Toolkit.getDefaultToolkit().getScreenSize();
        return layarUtama;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new RentalPS();
    }
}
