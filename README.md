# Premium Rental Motor System 🏍️

Aplikasi manajemen penyewaan motor berbasis Desktop menggunakan bahasa pemrograman **Java**. Aplikasi ini dirancang dengan antarmuka grafis (GUI) yang modern bertema *dark mode* dan mengimplementasikan konsep **Object-Oriented Programming (OOP)** secara mendalam.

## 🚀 Fitur Utama
*   **Antarmuka Modern**: Menggunakan skema warna *Dark Grey* dan *Violet* untuk tampilan yang elegan.
*   **Manajemen Riwayat**: Menggunakan `ArrayList` untuk menampung banyak data transaksi dalam satu sesi tanpa menghapus input sebelumnya.
*   **Validasi Input**: Dilengkapi dengan *exception handling* untuk mencegah error saat pengguna memasukkan format data yang salah.
*   **Struk Digital**: Output ringkasan transaksi ditampilkan secara rapi pada terminal-style TextArea.

## 🛠️ Konsep OOP yang Digunakan
Proyek ini mengimplementasikan pilar-pilar utama Java OOP:
1.  **Inheritance (Pewarisan)**: `RentalGUI` mewarisi properti dari `TransaksiRental`.
2.  **Abstraction**: Menggunakan *abstract class* dan *abstract method* untuk perhitungan total biaya.
3.  **Interface**: Mengimplementasikan interface `Pembayaran` untuk standarisasi proses transaksi.
4.  **Inner Class**: Menggunakan class di dalam class (`DetailMotor`) untuk merangkum data spesifik unit.
5.  **Encapsulation**: Penggunaan akses kontrol seperti `protected` dan `private` pada variabel tertentu.

## 📂 Struktur File
Berdasarkan file yang terlihat pada `image_cb09a0.png`, struktur proyek adalah sebagai berikut:
```text
RentalGUI/
├── Pembayaran.java        # Interface untuk metode pembayaran
├── TransaksiRental.java   # Abstract class (Parent) & Inner Class
├── RentalGUI.java        # Class Utama (Logic & GUI)
└── README.md              # Dokumentasi Proyek
