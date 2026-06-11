# 📱 ProfileApp - Tugas UTS Pemrograman Mobile

Aplikasi **ProfileApp** adalah aplikasi manajemen profil berbasis Android yang dikembangkan menggunakan **Kotlin** dan **Material Design**. Aplikasi ini menerapkan sistem autentikasi, pengelolaan data profil secara dinamis, dan fitur ganti foto profil.

---

## 👤 Identitas Mahasiswa
- **Nama Lengkap**: Florencia Audry
- **Tempat, Tanggal Lahir**: Medan, 14 April 2006
- **Hobi**: habisin duit
- **Bio**: hai aku floren
- **Username App**: florenciaa

---

## 🎥 Video Demo & Penjelasan
https://youtu.be/cgfWIQb05kk

---

## 🚀 Fitur & Cara Penggunaan

### 1. Halaman Login (`LoginActivity`)
- **UI**: Menampilkan judul "Login UTS" dengan desain minimalis sesuai permintaan.
- **Autentikasi**: Menggunakan validasi internal yang aman.
- **Kredensial**: Username: `florenciaa` | Password: `audry`.

### 2. Dashboard Profil (`DashboardActivity`)
- **Circular Image**: Foto profil berbentuk bulat sempurna menggunakan `ShapeableImageView`.
- **CardView UI**: Informasi profil (Nama, Username, Tempat/Tgl Lahir, Hobi, Bio) ditampilkan di dalam kartu dengan efek bayangan (elevation) agar terlihat modern.
- **Status Bar Fix**: Menggunakan fitur `fitsSystemWindows="true"` agar tampilan aplikasi tidak tertutup oleh bar jam/status pada perangkat.
- **Options Menu (Titik 3)**: Navigasi cepat untuk **Update Profile** dan **Logout**.

### 3. Edit Profile (`MainActivity`)
- **Form Filling**: Data dari Dashboard otomatis terisi (Pre-filled) saat masuk ke halaman edit.
- **DatePicker**: Memudahkan penginputan Tanggal Lahir menggunakan `DatePickerDialog` (Kalender).
- **Smart Image Picker**: Tombol "CHANGE IMAGE" memberikan 3 pilihan interaktif:
  - Mengambil foto dari **Galeri** HP.
  - Menggunakan warna default **Pink**.
  - Menggunakan warna default **Blue**.
- **Action**: Tombol **SAVE PROFILE** berwarna hijau (`#4CAF50`) untuk menyimpan perubahan.

---

## 🛠️ Detail Teknis (Tech Stack)
- **Bahasa**: Kotlin
- **UI Framework**: Material Design 3 & AppCompat
- **Komunikasi Data**: Menggunakan **ActivityResultLauncher** (modern implementation dari startActivityForResult) untuk sinkronisasi data antar Activity secara real-time.
- **Layouting**: ScrollView (responsif untuk berbagai ukuran layar), LinearLayout, dan CardView.

---

## 📄 Penjelasan Kode Program Utama

1. **`LoginActivity.kt`**: Logika validasi untuk berpindah ke Dashboard menggunakan `Intent`.
2. **`DashboardActivity.kt`**: Bertindak sebagai pusat data. Menggunakan `registerForActivityResult` untuk memperbarui tampilan secara instan setelah profil diedit.
3. **`MainActivity.kt`**: Mengatur logika `AlertDialog` untuk pilihan gambar dan dialog kalender.
4. **`themes.xml`**: Berisi konfigurasi `CircleShapeAppearance` untuk memproses gambar menjadi bulat (50% corner size).

---
