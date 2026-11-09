
public class Tabungan extends Rekening implements BerBunga {

    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo,
                    double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int biayaAdminBulanan() {
        if (getSaldo() >= 1000000) {
            return 0;
        }

        return 5000;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) (getSaldo() * bungaPersen / 100.0);
        setor(bunga);
        return bunga;
    }

    @Override
    public String getKeterangan() {
        return "Tabungan, bunga " + bungaPersen + "% per bulan";
    }
}
