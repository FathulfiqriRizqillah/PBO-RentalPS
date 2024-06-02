package Operation;

import java.util.Date;

/**
 *
 * @author
 */
public class DateAndTime {
    public String[] bulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September",
            "Oktober", "November", "Desember" };

    private int jam, menit, detik, hariInt, bulanInt, tahun;

    public String[] getBulan() {
        return bulan;
    }

    public void setBulan(String[] bulan) {
        this.bulan = bulan;
    }

    public int getJam() {
        return jam;
    }

    // Mendapatkan jam saat ini
    public void setJam() {
        Object aJam = new Date().getHours();
        this.jam = Integer.valueOf(aJam.toString());
    }

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

    public int getMenit() {
        return menit;
    }

    // Mendapatkan menit saat ini
    public void setMenit() {
        Object aMenit = new Date().getMinutes();
        this.menit = Integer.valueOf(aMenit.toString());
    }

    public int getDetik() {
        return detik;
    }

    // Mendapatkan detik saat ini
    public void setDetik() {
        Object aSeconds = new Date().getSeconds();
        this.detik = Integer.valueOf(aSeconds.toString());
    }

    public int getHariInt() {
        return hariInt;
    }

    // Mendapatkan hari dalam bentuk integer
    public void setHariInt() {
        Object aDays = new Date().getDate();
        this.hariInt = Integer.valueOf(aDays.toString());
    }

    public int getBulanInt() {
        return bulanInt;
    }

    // Mendapatkan bulan dalam bentuk integer
    public void setBulanInt() {
        Object aMonth = new Date().getMonth();
        this.bulanInt = Integer.valueOf(aMonth.toString());
    }

    public int getTahun() {
        return tahun;
    }

    // Mendapatkan tahun dalam bentuk integer
    public void setTahun() {
        Object aYear = new Date().toString().substring(24, 28);
        this.tahun = Integer.valueOf(aYear.toString());
    }

}
