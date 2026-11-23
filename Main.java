
import java.util.Scanner;

/**
 * Program utama Sistem Manajemen Hotel.
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Hotel hotel = new Hotel("Hotel Alvi", "Kendari");
        AntrianReservasi antrean = new AntrianReservasi(10);

        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM MANAJEMEN HOTEL =====");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Tampilkan Kamar");
            System.out.println("3. Tambah Tamu");
            System.out.println("4. Tampilkan Tamu");
            System.out.println("5. Buat Reservasi");
            System.out.println("6. Proses Antrean");
            System.out.println("7. Tampilkan Antrean");
            System.out.println("8. Laporan Hotel");
            System.out.println("9. Keluar");
            System.out.print("Pilih Menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {

                case 1: {
                    System.out.print("Nomor Kamar: ");
                    String nomor = input.nextLine();

                    System.out.print("Tipe Kamar: ");
                    String tipe = input.nextLine();

                    System.out.print("Harga Kamar: ");

                    try {
                        double harga = Double.parseDouble(input.nextLine());

                        Kamar kamar = new Kamar(nomor, tipe, harga);

                        if (!kamar.isTersedia()) {
                            System.out.println("Data kamar tidak valid!");
                        } else {
                            hotel.tambahKamar(kamar);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Harga harus berupa angka!");
                    }
                    break;
                }

                case 2: {
                    hotel.tampilkanKamar();
                    break;
                }

                case 3: {
                    System.out.print("ID Tamu: ");
                    String id = input.nextLine();

                    System.out.print("Nama Tamu: ");
                    String nama = input.nextLine();

                    System.out.print("Alamat: ");
                    String alamat = input.nextLine();

                    System.out.print("Nomor Telepon: ");
                    String telepon = input.nextLine();

                    System.out.print("Umur: ");

                    try {
                        int umur = Integer.parseInt(input.nextLine());

                        if (id.trim().isEmpty()
                                || nama.trim().isEmpty()
                                || alamat.trim().isEmpty()
                                || telepon.trim().isEmpty()
                                || umur < 0 || umur > 120
                                || hotel.cariTamu(id) != null) {

                            System.out.println("Data tamu tidak valid!");
                            break;
                        }

                        Tamu tamu = new Tamu(
                                id, nama, alamat, telepon, umur
                        );

                        hotel.tambahTamu(tamu);

                    } catch (NumberFormatException e) {
                        System.out.println("Umur harus berupa angka!");
                    }
                    break;
                }

                case 4: {
                    hotel.tampilkanTamu();
                    break;
                }

                case 5: {
                    if (antrean.isFull()) {
                        System.out.println("Antrean sudah penuh!");
                        break;
                    }

                    System.out.print("ID Tamu: ");
                    String idTamu = input.nextLine();

                    System.out.print("Nomor Kamar: ");
                    String nomorKamar = input.nextLine();

                    Tamu tamu = hotel.cariTamu(idTamu);
                    Kamar kamar = hotel.cariKamar(nomorKamar);

                    if (tamu == null || kamar == null) {
                        System.out.println("Data tidak ditemukan!");
                        break;
                    }

                    if (!kamar.isTersedia()) {
                        System.out.println("Kamar sudah dipesan!");
                        break;
                    }

                    System.out.print("Jumlah Malam: ");

                    try {
                        int malam = Integer.parseInt(input.nextLine());

                        if (malam <= 0) {
                            System.out.println("Jumlah malam tidak valid!");
                            break;
                        }

                        System.out.print("Kode Reservasi: ");
                        String kode = input.nextLine();

                        if (kode.trim().isEmpty()) {
                            System.out.println("Kode tidak boleh kosong!");
                            break;
                        }

                        Reservasi reservasi = new Reservasi(
                                kode, tamu, kamar, malam
                        );

                        if (hotel.tambahReservasi(reservasi)) {
                            antrean.enqueue(reservasi);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Jumlah malam harus berupa angka!");
                    }
                    break;
                }

                case 6: {
                    Reservasi reservasi = antrean.dequeue();

                    if (reservasi != null) {
                        reservasi.ubahStatus("Diproses");

                        System.out.println("Reservasi berhasil diproses!");
                        reservasi.tampilkanInfo();
                    }
                    break;
                }

                case 7: {
                    antrean.tampilkan();

                    System.out.println(
                            "Jumlah Antrean: " + antrean.size()
                    );
                    break;
                }

                case 8: {
                    hotel.tampilkanLaporan();
                    break;
                }

                case 9: {
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;
                }

                default: {
                    System.out.println("Pilihan menu tidak tersedia!");
                }
            }

        } while (pilihan != 9);

        input.close();
    }
}
