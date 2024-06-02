-- Buat database
CREATE DATABASE IF NOT EXISTS rental_ps;

-- Gunakan database
USE rental_ps;

-- Buat tabel untuk pengguna
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role ENUM('admin', 'member') NOT NULL
);

-- Tambah pengguna admin sebagai contoh
INSERT INTO users (username, password, role) VALUES ('admin', 'admin', 'admin') ON DUPLICATE KEY UPDATE username=username;
INSERT INTO users (username, password, role) VALUES ('qul', 'qul', 'admin') ON DUPLICATE KEY UPDATE username=username;

-- Buat tabel untuk konsol PS yang tersedia
CREATE TABLE IF NOT EXISTS consoles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    console_name VARCHAR(50) NOT NULL,
    price_per_hour INT NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE
);

-- Buat tabel untuk transaksi rental
CREATE TABLE IF NOT EXISTS rentals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    console_id INT,
    hours_rented INT,
    total_price INT,
    rent_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (console_id) REFERENCES consoles(id)
);

-- Tambah data konsol PS
INSERT INTO consoles (console_name, price_per_hour) VALUES ('PS1', 2000) ON DUPLICATE KEY UPDATE console_name=console_name;
INSERT INTO consoles (console_name, price_per_hour) VALUES ('PS2', 3000) ON DUPLICATE KEY UPDATE console_name=console_name;
INSERT INTO consoles (console_name, price_per_hour) VALUES ('PS3', 4000) ON DUPLICATE KEY UPDATE console_name=console_name;
INSERT INTO consoles (console_name, price_per_hour) VALUES ('PS4', 5000) ON DUPLICATE KEY UPDATE console_name=console_name;
INSERT INTO consoles (console_name, price_per_hour) VALUES ('PS5', 6000) ON DUPLICATE KEY UPDATE console_name=console_name;

-- Include other script
SOURCE '/path/to/your/other_script.sql';

-- Modularisasi: Pisahkan skrip Anda menjadi beberapa file yang lebih kecil berdasarkan fungsinya
-- Environment Variables untuk Konfigurasi: Gunakan variabel lingkungan untuk mengatur parameter yang mungkin berbeda antara lingkungan pengembangan, pengujian, dan produksi
-- Error Handling: Pastikan skrip Anda memiliki penanganan kesalahan yang baik untuk mengatasi masalah saat mencoba membaca atau mengeksekusi perintah dari file lain
-- Version Control: Gunakan sistem kontrol versi seperti Git untuk mengelola perubahan pada skrip SQL Anda dan memastikan bahwa semua file terkait tetap sinkron
-- Dokumentasi: Dokumentasikan bagaimana berbagai skrip SQL saling terkait dan bagaimana seharusnya mereka dijalankan atau disertakan
