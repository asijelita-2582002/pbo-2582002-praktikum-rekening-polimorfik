
import java.text.NumberFormat;
import java.util.Locale;

public class BankPolimorfik {

    public static void main(String[] args) {

        // 1. Membuat tiga objek rekening
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        // Rekening tidak bisa dibuat langsung karena merupakan abstract class.
        // Rekening r = new Rekening("999", "Eko", 0);

        // 2. Membuat array semua rekening
        Rekening[] semua = { ani, citra, budi };

        // 3. Membuat array khusus rekening berbunga
        BerBunga[] berbunga = { ani, citra };

        // 4. Menampilkan rekening awal
        System.out.println("========== REKENING AWAL ==========");

        for (Rekening r : semua) {
            r.cetakInfo();
        }

        // 5. Memotong biaya admin semua rekening
        System.out.println("========== AKHIR BULAN ============");

        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();

            System.out.println(
                    r.getNomor() + " biaya admin  : " + formatRupiah(biaya)
            );
        }

        // 6. Menambahkan bunga untuk rekening yang berbunga
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();

            System.out.println(
                    b.getNomor() + " bunga        : " + formatRupiah(bunga)
            );
        }

        // 7. Menampilkan rekening akhir
        System.out.println("========== REKENING AKHIR =========");

        int totalDana = 0;

        for (Rekening r : semua) {
            r.cetakInfo();
            totalDana += r.getSaldo();
        }

        // 8. Menampilkan total dana bank
        System.out.println("-----------------------------------");
        System.out.println(
                "Total dana bank : " + formatRupiah(totalDana)
        );
    }

    // Method untuk format rupiah
    private static String formatRupiah(int jumlah) {
        NumberFormat format =
                NumberFormat.getNumberInstance(new Locale("id", "ID"));

        return "Rp" + format.format(jumlah);
    }
}
