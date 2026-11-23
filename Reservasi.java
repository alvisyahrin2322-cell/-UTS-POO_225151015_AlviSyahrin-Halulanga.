
/**
 * Class untuk mengelola reservasi hotel.
 */
public class Reservasi {
    private String kodeReservasi;
    private Tamu tamu;
    private Kamar kamar;
    private int jumlahMalam;
    private double totalBiaya;
    private String status;

    public Reservasi() {
        this.kodeReservasi = "";
        this.tamu = null;
        this.kamar = null;
        this.jumlahMalam = 0;
        this.totalBiaya = 0;
        this.status = "Menunggu";
    }

    public Reservasi(String kodeReservasi, Tamu tamu,
                     Kamar kamar, int jumlahMalam) {
        this.kodeReservasi = kodeReservasi;
        this.tamu = tamu;
        this.kamar = kamar;
        setJumlahMalam(jumlahMalam);
        this.status = "Menunggu";
    }

    public void setJumlahMalam(int jumlahMalam) {
        if (jumlahMalam > 0) {
            this.jumlahMalam = jumlahMalam;
            hitungBiaya();
        } else {
            System.out.println("Jumlah malam harus lebih dari 0!");
        }
    }

    public void hitungBiaya() {
        if (kamar != null && jumlahMalam > 0) {
            totalBiaya = kamar.getHarga() * jumlahMalam;
        }
    }

    public void ubahStatus(String status) {
        this.status = status;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Reservasi: " + kodeReservasi);
        System.out.println("Nama Tamu: " +
                (tamu != null ? tamu.getNama() : "-"));
        System.out.println("Nomor Kamar: " +
                (kamar != null ? kamar.getNomorKamar() : "-"));
        System.out.println("Jumlah Malam: " + jumlahMalam);
        System.out.println("Total Biaya: Rp" + totalBiaya);
        System.out.println("Status: " + status);
    }

    public String getKodeReservasi() {
        return kodeReservasi;
    }

    public Tamu getTamu() {
        return tamu;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public int getJumlahMalam() {
        return jumlahMalam;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public String getStatus() {
        return status;
    }
}
