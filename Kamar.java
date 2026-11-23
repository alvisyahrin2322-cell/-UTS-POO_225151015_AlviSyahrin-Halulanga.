public class Kamar {
    private String nomorKamar;
    private String tipeKamar;
    private double harga;
    private boolean tersedia;

    public Kamar() {
        this.nomorKamar = "";
        this.tipeKamar = "";
        this.harga = 0;
        this.tersedia = true;
    }

    public Kamar(String nomorKamar, String tipeKamar,
                 double harga) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        setHarga(harga);
        this.tersedia = true;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga harus lebih dari 0!");
        }
    }

    public void ubahStatus(boolean status) {
        this.tersedia = status;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor: " + nomorKamar);
        System.out.println("Tipe: " + tipeKamar);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Tersedia: " + tersedia);
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public double getHarga() {
        return harga;
    }

    public boolean isTersedia() {
        return tersedia;
    }
}
