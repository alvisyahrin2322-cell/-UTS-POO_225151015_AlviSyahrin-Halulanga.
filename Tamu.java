
/**
 * Class untuk mengelola data tamu hotel.
 */
public class Tamu {
    private String idTamu;
    private String nama;
    private String alamat;
    private String nomorTelepon;
    private int umur;

    public Tamu() {
        this.idTamu = "";
        this.nama = "";
        this.alamat = "";
        this.nomorTelepon = "";
        this.umur = 0;
    }

    public Tamu(String idTamu, String nama,
                String alamat, String nomorTelepon,
                int umur) {
        this.idTamu = idTamu;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        setUmur(umur);
    }

    public void setUmur(int umur) {
        if (umur >= 0 && umur <= 120) {
            this.umur = umur;
        } else {
            System.out.println("Umur tidak valid!");
        }
    }

    public void ubahAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void ubahNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public void tampilkanInfo() {
        System.out.println("ID Tamu: " + idTamu);
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Telepon: " + nomorTelepon);
        System.out.println("Umur: " + umur);
    }

    public String getIdTamu() {
        return idTamu;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public int getUmur() {
        return umur;
    }
}
