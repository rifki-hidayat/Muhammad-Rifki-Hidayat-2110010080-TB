-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2024 at 10:52 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penyewaanpc`
--

-- --------------------------------------------------------

--
-- Table structure for table `pc`
--

CREATE TABLE `pc` (
  `id` int(5) NOT NULL,
  `no_seri` int(5) NOT NULL,
  `merek_pc` varchar(20) NOT NULL,
  `jmlh_pc` int(2) NOT NULL,
  `biaya` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pc`
--

INSERT INTO `pc` (`id`, `no_seri`, `merek_pc`, `jmlh_pc`, `biaya`) VALUES
(1, 123, 'Acer', 2, 10000),
(2, 321, 'Asus', 1, 20000),
(3, 225, 'HP', 2, 25000),
(4, 235, 'Lenovo', 3, 40000),
(5, 555, 'Dell', 1, 60000);

-- --------------------------------------------------------

--
-- Table structure for table `penyewa`
--

CREATE TABLE `penyewa` (
  `id` int(5) NOT NULL,
  `nama_penyewa` varchar(20) NOT NULL,
  `jk` enum('Laki-laki','Perempuan','','') NOT NULL,
  `alamat` text NOT NULL,
  `no_telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penyewa`
--

INSERT INTO `penyewa` (`id`, `nama_penyewa`, `jk`, `alamat`, `no_telp`) VALUES
(1, 'Rifki', 'Laki-laki', 'Rantau', '085522'),
(2, 'Fahri', 'Laki-laki', 'Kandangan', '081212'),
(3, 'Hilda', 'Perempuan', 'Rantau', '087755'),
(4, 'Raesya', 'Perempuan', 'Kandangan', '083251'),
(5, 'Faisal', 'Laki-laki', 'Rantau', '085156');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(10) NOT NULL,
  `penyewa_id` int(5) NOT NULL,
  `pc_id` int(5) NOT NULL,
  `tgl_keluar` date NOT NULL,
  `tgl_masuk` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `penyewa_id`, `pc_id`, `tgl_keluar`, `tgl_masuk`) VALUES
(1, 3, 2, '2024-01-01', '2024-01-07'),
(2, 2, 3, '2024-01-08', '2024-01-14'),
(3, 1, 1, '2024-01-03', '2024-01-10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pc`
--
ALTER TABLE `pc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penyewa`
--
ALTER TABLE `penyewa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `penyewa_id` (`penyewa_id`),
  ADD KEY `pc_id` (`pc_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pc`
--
ALTER TABLE `pc`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `penyewa`
--
ALTER TABLE `penyewa`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`pc_id`) REFERENCES `pc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`penyewa_id`) REFERENCES `penyewa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
