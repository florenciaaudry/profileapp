# ProfileApp - Tugas UTS Pemrograman Mobile

Aplikasi Profil Interaktif yang dibangun menggunakan Kotlin dan XML Material Design. Aplikasi ini memiliki fitur autentikasi, manajemen profil, dan integrasi picker gambar.

## 👤 Identitas Mahasiswa
- **Nama**: Florencia Audry
- **Username App**: florenciaa
- **Tugas**: UTS / Pemrograman Mobile

## 🎥 Video Demo & Penjelasan
[GANTI_LINK_INI_DENGAN_LINK_VIDEO_KAMU]
*(Contoh: https://youtube.com/link_video_kamu atau link Google Drive)*

## 📱 Fitur Utama
- **Custom Authentication**: Login dengan proteksi username `florenciaa` dan password `audry`.
- **Interactive Dashboard**: Tampilan profil menggunakan `CardView` dan `ShapeableImageView` (Foto Bulat).
- **Update Profile**: Form pengubahan data diri lengkap dengan `DatePickerDialog`.
- **Image Picker**: Fitur mengganti foto profil dengan pilihan dari Galeri atau warna default (Pink/Blue).
- **Options Menu**: Menu navigasi titik tiga (Update Profile & Logout) di Toolbar.

## 🛠️ Teknologi yang Digunakan
- **Bahasa**: Kotlin
- **UI Framework**: Material Design 3
- **Layout**: XML (ScrollView, CardView, ShapeableImageView)
- **Data Communication**: `ActivityResultLauncher` untuk update data secara real-time antar Activity.

## 📄 Penjelasan Singkat Kode
1. **MainActivity.kt**: Menangani form edit profil dan pemilihan gambar. Menggunakan `Intent` untuk mengirim balik data ke Dashboard.
2. **DashboardActivity.kt**: Menampilkan data profil dan menangani menu navigasi. Menggunakan `registerForActivityResult` untuk menangkap perubahan data.
3. **LoginActivity.kt**: Validasi sederhana untuk akses masuk ke aplikasi.
4. **Layout XML**: Menggunakan `fitsSystemWindows` agar tampilan tidak terpotong status bar jam di HP.
