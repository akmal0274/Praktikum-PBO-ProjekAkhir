-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Jun 2022 pada 21.48
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `program_vaksin`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_vaksin`
--

CREATE TABLE `data_vaksin` (
  `nik` varchar(20) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `vaksinke` int(11) NOT NULL,
  `jenisvaksin` varchar(15) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_vaksin`
--

INSERT INTO `data_vaksin` (`nik`, `nama`, `vaksinke`, `jenisvaksin`, `tanggal`) VALUES
('123', 'rey', 2, 'Sinovac', '2022-05-18'),
('123200012', 'akmal', 2, 'Moderna', '2022-06-04'),
('21321324', 'yanto', 2, 'Pfizer', '2022-05-18');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data_vaksin`
--
ALTER TABLE `data_vaksin`
  ADD PRIMARY KEY (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
