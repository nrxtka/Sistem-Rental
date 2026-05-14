package RentalGUI;

public abstract class TransaksiRental {
    protected String namaPenyewa;

    public TransaksiRental(String nama) {
        this.namaPenyewa = nama;
    }

    abstract int hitungTotal(int durasi, int hargaSewa);

    // Inner Class untuk Detail Motor
    class DetailMotor {
        String merk;
        int durasi;

        DetailMotor(String merk, int durasi) {
            this.merk = merk;
            this.durasi = durasi;
        }

        String tampilDetail() {
            return "--- DATA INPUT TERAKHIR ---\n" +
                   "Penyewa : " + namaPenyewa + "\n" +
                   "Unit    : " + merk + "\n" +
                   "Durasi  : " + durasi + " Hari";
        }
    }
}