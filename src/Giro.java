
public class Giro extends Rekening {

    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo,
                int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public int biayaAdminBulanan() {
        return 15000;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > getSaldo() + batasOverdraft) {
            return false;
        }

        kurangiSaldo(jumlah);
        return true;
    }

    @Override
    public String getKeterangan() {
        return "Giro, batas overdraft " + formatRupiah(batasOverdraft);
    }
}
