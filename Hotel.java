
import java.util.ArrayList;

/**
 * Class untuk mengelola sistem manajemen hotel.
 */
public class Hotel {
    private String namaHotel;
    private String alamat;
    private ArrayList<Kamar> daftarKamar;
    private ArrayList<Tamu> daftarTamu;
    private ArrayList<Reservasi> daftarReservasi;

    public Hotel() {
        this.namaHotel = "Hotel Alvi";
        this.alamat = "Kendari";
        this.daftarKamar = new ArrayList<>();
        this.daftarTamu = new ArrayList<>();
        this.daftarReservasi = new ArrayList<>();
    }

    public Hotel(String namaHotel, String alamat) {
        this.namaHotel = namaHotel;
        this.alamat = alamat;
        this.daftarKamar = new ArrayList<>();
        this.daftarTamu = new ArrayList<>();
        this.daftarReservasi = new ArrayList<>();
    }

    public void tambahKamar(Kamar kamar) {
        if (kamar != null) {
            daftarKamar.add(kamar);
            System.out.println("Kamar berhasil ditambahkan!");
        }
    }

    public void tambahTamu(Tamu tamu) {
        if (tamu != null) {
            daftarTamu.add(tamu);
            System.out.println("Tamu berhasil ditambahkan!");
        }
    }

    public boolean tambahReservasi(Reservasi reservasi) {
        if (reservasi == null || reservasi.getTamu() == null
                || reservasi.getKamar() == null) {
            System.out.println("Data reservasi tidak valid!");
            return false;
        }

        if (!reservasi.getKamar().isTersedia()) {
            System.out.println("Kamar sudah dipesan!");
            return false;
        }

        daftarReservasi.add(reservasi);
        reservasi.getKamar().ubahStatus(false);

        System.out.println("Reservasi berhasil dibuat!");
        return true;
    }

    public Kamar cariKamar(String nomor) {
        for (Kamar k : daftarKamar) {
            if (k.getNomorKamar().equalsIgnoreCase(nomor)) {
                return k;
            }
        }
        return null;
    }

    public void tampilkanKamar() {
        for (Kamar k : daftarKamar) {
            k.tampilkanInfo();
            System.out.println("----------------");
        }
    }

    public void tampilkanTamu() {
        for (Tamu t : daftarTamu) {
            t.tampilkanInfo();
            System.out.println("----------------");
        }
    }

    public void tampilkanLaporan() {
        System.out.println("===== LAPORAN HOTEL =====");
        System.out.println("Nama Hotel: " + namaHotel);
        System.out.println("Alamat: " + alamat);
        System.out.println("Jumlah Kamar: " + daftarKamar.size());
        System.out.println("Jumlah Tamu: " + daftarTamu.size());
        System.out.println("Jumlah Reservasi: " + daftarReservasi.size());
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public String getAlamat() {
        return alamat;
    }


    public Tamu cariTamu(String idTamu) {
        for (Tamu t : daftarTamu) {
            if (t.getIdTamu().equalsIgnoreCase(idTamu)) {
                return t;
            }
        }
        return null;

    }

}