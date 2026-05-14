package RentalGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; // Untuk menampung banyak data
import javax.swing.JOptionPane;

public class RentalGUI extends TransaksiRental implements Pembayaran {

    Frame frame;
    TextField txtNama, txtMerk, txtDurasi, txtHarga;
    TextArea txtHasil;
    Button btnProses, btnKeluar;
    
    // List untuk menampung riwayat transaksi
    ArrayList<String> riwayatTransaksi = new ArrayList<>();

    RentalGUI() {
        super(""); 

        frame = new Frame("Premium Rental Motor System");

        // Warna Tema
        Color bgGelap = new Color(30, 30, 30);
        Color bgInput = new Color(50, 50, 50);
        Color teksPutih = new Color(240, 240, 240);
        Color aksenUngu = new Color(138, 43, 226);

        // Header Title
        Label lblTitle = new Label("MOTORBIKE RENTAL", Label.CENTER);
        lblTitle.setBounds(0, 40, 430, 40);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTitle.setForeground(aksenUngu);

        // Labels Setup
        String[] labelNames = {"Nama Penyewa", "Merk Motor", "Durasi (Hari)", "Harga /Hari"};
        int yLabel = 100;
        for (String name : labelNames) {
            Label lbl = new Label(name);
            lbl.setBounds(50, yLabel, 120, 25);
            lbl.setForeground(teksPutih);
            frame.add(lbl);
            yLabel += 40;
        }

        // Input Fields Setup
        txtNama = new TextField();
        txtMerk = new TextField();
        txtDurasi = new TextField();
        txtHarga = new TextField();

        TextField[] fields = {txtNama, txtMerk, txtDurasi, txtHarga};
        int yField = 100;
        for (TextField fld : fields) {
            fld.setBounds(180, yField, 180, 25);
            fld.setBackground(bgInput);
            fld.setForeground(Color.WHITE);
            frame.add(fld);
            yField += 40;
        }

        // Buttons
        btnProses = new Button("PROSES BOOKING");
        btnProses.setBounds(50, 265, 150, 35);
        btnProses.setBackground(aksenUngu);
        btnProses.setForeground(Color.WHITE);

        btnKeluar = new Button("KELUAR");
        btnKeluar.setBounds(210, 265, 150, 35);
        btnKeluar.setBackground(new Color(180, 0, 0));
        btnKeluar.setForeground(Color.WHITE);

        // Text Area Output
        txtHasil = new TextArea();
        txtHasil.setBounds(50, 320, 330, 140);
        txtHasil.setBackground(Color.BLACK);
        txtHasil.setForeground(new Color(0, 255, 100)); // Hijau Matrix
        txtHasil.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtHasil.setEditable(false);

        // Add to Frame
        frame.add(lblTitle);
        frame.add(btnProses);
        frame.add(btnKeluar);
        frame.add(txtHasil);

        // Event Listeners
        btnProses.addActionListener(e -> prosesRental());
        btnKeluar.addActionListener(e -> frame.dispose());
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { frame.dispose(); }
        });

        // Frame Final Setup
        frame.setSize(430, 500);
        frame.setLayout(null);
        frame.setBackground(bgGelap);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    int hitungTotal(int durasi, int hargaSewa) {
        return durasi * hargaSewa;
    }

    @Override
    public void prosesBayar() {
        txtHasil.append("\nStatus: Verified (QRIS)");
    }

    void prosesRental() {
        try {
            // Ambil data
            namaPenyewa = txtNama.getText();
            String merk = txtMerk.getText();
            int durasi = Integer.parseInt(txtDurasi.getText());
            int harga = Integer.parseInt(txtHarga.getText());

            // Hitung total
            int total = hitungTotal(durasi, harga);

            // Simpan ke ArrayList riwayat
            String dataStr = "- " + namaPenyewa + " [" + merk + "] -> Rp" + String.format("%,d", total);
            riwayatTransaksi.add(dataStr);

            // Refresh Tampilan JTextArea
            txtHasil.setText("===== DAFTAR TRANSAKSI =====\n");
            for (String row : riwayatTransaksi) {
                txtHasil.append(row + "\n");
            }
            
            prosesBayar();

            // Reset Field agar bisa input data baru
            txtNama.setText("");
            txtMerk.setText("");
            txtDurasi.setText("");
            txtHarga.setText("");
            txtNama.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: Masukkan angka valid pada Durasi/Harga!");
        }
    }

    public static void main(String[] args) {
        new RentalGUI();
    }
}