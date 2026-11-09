
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Rekening {

    private String nomor;
    private String pemilik;
    private int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }

        saldo += jumlah;
        return true;
    }
    protected void kurangiSaldo(int jumlah) {
        saldo -= jumlah;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }

        kurangiSaldo(jumlah);
        return true;
    }

    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        tarik(biaya);
        return biaya;
    }

    public String getKeterangan() {
        return "Rekening";
    }

    public void cetakInfo() {
        System.out.printf(
                "%-3s | %-6s | %12s       %s%n",
                nomor,
                pemilik,
                formatRupiah(saldo),
                getKeterangan()
        );
    }

    protected String formatRupiah(int jumlah) {
        NumberFormat format =
                NumberFormat.getNumberInstance(new Locale("id", "ID"));

        return "Rp" + format.format(jumlah);
    }
}
