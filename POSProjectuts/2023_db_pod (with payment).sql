-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2023 at 09:35 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2023_db_pod`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_item` varchar(10) NOT NULL,
  `nama_item` varchar(100) NOT NULL,
  `harga_satuan` float NOT NULL,
  `expired` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_item`, `nama_item`, `harga_satuan`, `expired`) VALUES
('1', 'Aqua', 1000, '2026-06-04'),
('2', 'Chitato', 10000, '2023-08-31');

-- --------------------------------------------------------

--
-- Table structure for table `keuangan`
--

CREATE TABLE `keuangan` (
  `total` int(11) NOT NULL,
  `dibayar` float NOT NULL,
  `kembalian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `keuangan`
--

INSERT INTO `keuangan` (`total`, `dibayar`, `kembalian`) VALUES
(4000, 5000, 1000),
(60000, 70000, 10000),
(45000, 50000, 5000),
(60000, 70000, 10000),
(239, 250000, 249761),
(239000, 250000, 11000),
(85000, 90000, 5000),
(49000, 50000, 1000),
(27000, 30000, 3000),
(27000, 30000, 3000),
(39000, 40000, 1000),
(141000, 200000, 59000),
(141000, 250000, 109000),
(129000, 200000, 71000),
(15000, 20000, 5000),
(15000, 20000, 5000),
(12000, 30000, 18000),
(102000, 200000, 98000),
(127000, 180000, 53000),
(8000, 10000, 2000),
(12000, 15000, 3000),
(12000, 15000, 3000),
(49000, 50000, 1000),
(15000, 18000, 3000),
(12000, 30000, 18000);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `total_harga` int(15) NOT NULL,
  `waktu_pembayaran` date NOT NULL,
  `jenis_pembayaran` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `total_harga`, `waktu_pembayaran`, `jenis_pembayaran`) VALUES
(1, 1000, '2023-06-11', 'Cash');

-- --------------------------------------------------------

--
-- Table structure for table `pulsa`
--

CREATE TABLE `pulsa` (
  `kode` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `harga` float NOT NULL,
  `operator` varchar(100) NOT NULL,
  `nominal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pulsa`
--

INSERT INTO `pulsa` (`kode`, `nama`, `harga`, `operator`, `nominal`) VALUES
(6, 'TELKOMSEL A', 12000, 'TELKOMSEL', 10000),
(7, 'INDOSAT A', 12000, 'INDOSAT', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `rincian_transaksi`
--

CREATE TABLE `rincian_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga_satuan` float NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `harga_total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rincian_transaksi`
--

INSERT INTO `rincian_transaksi` (`id_transaksi`, `id_barang`, `nama_barang`, `harga_satuan`, `jumlah_barang`, `harga_total`) VALUES
(2, 2, 'Oreo', 12000, 3, 36000),
(3, 2, 'Oreo', 12000, 3, 36000),
(6, 3, 'Aqua', 4000, 1, 4000),
(8, 1, 'Chitato mini', 15000, 1, 15000),
(8, 1, 'Chitato mini', 15000, 1, 15000),
(8, 1, 'Chitato mini', 15000, 1, 15000),
(9, 1, 'Chitato mini', 15000, 1, 15000),
(9, 1, 'Chitato mini', 15000, 1, 15000),
(9, 1, 'Chitato mini', 15000, 1, 15000),
(9, 1, 'Chitato mini', 15000, 1, 15000),
(10, 1, 'Chitato mini', 15000, 1, 15000),
(10, 2, 'Oreo', 12000, 1, 12000),
(11, 1, 'Chitato mini', 15000, 1, 15000),
(11, 6, 'TELKOMSEL A 082121212121', 12000, 1, 12000),
(11, 2, 'Oreo', 12000, 1, 12000),
(12, 1, 'Chitato mini', 15000, 1, 15000),
(12, 7, 'INDOSAT A 082121212121', 12000, 1, 12000),
(12, 9, 'PLN100 9999999999', 102000, 1, 102000),
(13, 1, 'Chitato mini', 15000, 1, 15000),
(13, 2, 'Oreo', 12000, 1, 12000),
(13, 7, 'INDOSAT A 082121212121', 12000, 1, 12000),
(13, 9, 'PLN100 222222222222', 102000, 1, 102000),
(14, 1, 'Chitato mini', 15000, 1, 15000),
(14, 2, 'Oreo', 12000, 1, 12000),
(14, 7, 'INDOSAT A 08212121212192', 12000, 1, 12000),
(14, 9, 'PLN100 123123121342424', 102000, 1, 102000),
(15, 1, 'Chitato mini', 15000, 1, 15000),
(15, 2, 'Oreo', 12000, 1, 12000),
(15, 7, 'INDOSAT A 089292929292', 12000, 1, 12000),
(15, 9, 'PLN100 1232174621874216', 102000, 1, 102000),
(16, 1, 'Chitato mini', 15000, 1, 15000),
(16, 2, 'Oreo', 12000, 1, 12000),
(16, 7, 'INDOSAT A 089292929292', 12000, 1, 12000),
(16, 9, 'PLN100 1232174621874216', 102000, 1, 102000),
(16, 1, 'Chitato mini', 15000, 1, 15000),
(16, 2, 'Oreo', 12000, 1, 12000),
(16, 9, 'PLN100 999999999999', 102000, 1, 102000),
(17, 1, 'Chitato mini', 15000, 1, 15000),
(17, 2, 'Oreo', 12000, 1, 12000),
(17, 7, 'INDOSAT A 089292929292', 12000, 1, 12000),
(17, 9, 'PLN100 1232174621874216', 102000, 1, 102000),
(17, 1, 'Chitato mini', 15000, 1, 15000),
(17, 2, 'Oreo', 12000, 1, 12000),
(17, 9, 'PLN100 999999999999', 102000, 1, 102000),
(17, 1, 'Chitato mini', 15000, 1, 15000),
(18, 1, 'Chitato mini', 15000, 1, 15000),
(19, 7, 'INDOSAT A 21321321213321', 12000, 1, 12000),
(20, 9, 'PLN100 132131221321313', 102000, 1, 102000),
(21, 5, 'Oreo', 10000, 1, 10000),
(21, 1, 'Chitato mini', 15000, 1, 15000),
(21, 9, 'PLN100 12345', 102000, 1, 102000),
(22, 4, 'FruitTea', 8000, 1, 8000),
(23, 4, 'FruitTea', 8000, 1, 8000),
(24, 6, 'TELKOMSEL A 082268593974', 12000, 1, 12000),
(25, 6, 'TELKOMSEL A 082268593974', 12000, 1, 12000),
(26, 4, 'FruitTea', 8000, 1, 8000),
(27, 1, 'Chitato mini', 15000, 1, 15000),
(27, 2, 'Oreo', 12000, 1, 12000),
(27, 3, 'Aqua', 4000, 1, 4000),
(27, 4, 'FruitTea', 8000, 1, 8000),
(27, 5, 'Oreo', 10000, 1, 10000),
(28, 1, 'Chitato mini', 15000, 1, 15000),
(28, 7, 'INDOSAT A 081397854102', 12000, 1, 12000);

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE `token` (
  `kode` int(11) NOT NULL,
  `nama` varchar(11) NOT NULL,
  `harga` float NOT NULL,
  `nominal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`kode`, `nama`, `harga`, `nominal`) VALUES
(8, 'PLN50', 52000, 50000),
(9, 'PLN100', 102000, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `total_harga` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `total_harga`) VALUES
(2, 36000),
(3, 36000),
(4, 111000),
(5, 15000),
(6, 4000),
(7, 60000),
(8, 45000),
(9, 60000),
(10, 27000),
(11, 27000),
(12, 27000),
(13, 39000),
(14, 141000),
(15, 141000),
(16, 129000),
(17, 15000),
(18, 15000),
(19, 12000),
(20, 102000),
(21, 127000),
(22, 8000),
(23, 8000),
(24, 12000),
(25, 12000),
(26, 8000),
(27, 49000),
(28, 27000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_item`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pulsa`
--
ALTER TABLE `pulsa`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `rincian_transaksi`
--
ALTER TABLE `rincian_transaksi`
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- Indexes for table `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pulsa`
--
ALTER TABLE `pulsa`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `token`
--
ALTER TABLE `token`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rincian_transaksi`
--
ALTER TABLE `rincian_transaksi`
  ADD CONSTRAINT `rincian_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
