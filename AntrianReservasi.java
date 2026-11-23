
/**
 * Class untuk mengelola antrean reservasi hotel.
 * Menggunakan struktur data Queue (FIFO).
 */
public class AntrianReservasi {
    private Reservasi[] data;
    private int depan;
    private int belakang;
    private int jumlah;
    private int kapasitas;


    public AntrianReservasi() {
        this(10);
    }

    public AntrianReservasi(int kapasitas) {
        if (kapasitas <= 0) {
            throw new IllegalArgumentException(
                    "Kapasitas harus lebih dari 0"
            );
        }

        this.kapasitas = kapasitas;
        data = new Reservasi[kapasitas];
        depan = 0;
        belakang = -1;
        jumlah = 0;
    }

    // Menambahkan antrean
    public boolean enqueue(Reservasi reservasi) {
        if (isFull()) {
            System.out.println("Antrean penuh!");
            return false;
        }

        if (reservasi == null) {
            System.out.println("Reservasi tidak valid!");
            return false;
        }

        belakang = (belakang + 1) % kapasitas;
        data[belakang] = reservasi;
        jumlah++;

        System.out.println("Reservasi masuk antrean!");
        return true;
    }

    // Menghapus antrean terdepan
    public Reservasi dequeue() {
        if (isEmpty()) {
            System.out.println("Antrean kosong!");
            return null;
        }

        Reservasi hasil = data[depan];
        data[depan] = null;
        depan = (depan + 1) % kapasitas;
        jumlah--;

        return hasil;
    }

    // Melihat antrean terdepan
    public Reservasi front() {
        if (isEmpty()) {
            System.out.println("Antrean kosong!");
            return null;
        }

        return data[depan];
    }

    // Memeriksa antrean kosong
    public boolean isEmpty() {
        return jumlah == 0;
    }

    // Memeriksa antrean penuh
    public boolean isFull() {
        return jumlah == kapasitas;
    }

    // Menghitung jumlah antrean
    public int size() {
        return jumlah;
    }

    // Menampilkan seluruh antrean
    public void tampilkan() {
        if (isEmpty()) {
            System.out.println("Antrean masih kosong!");
            return;
        }

        System.out.println("=== DAFTAR ANTREAN ===");

        for (int i = 0; i < jumlah; i++) {
            int indeks = (depan + i) % kapasitas;

            System.out.println(
                    (i + 1) + ". " +
                            data[indeks].getKodeReservasi()
            );
        }
    }
}
