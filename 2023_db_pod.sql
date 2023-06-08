-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 08, 2023 at 03:02 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

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

DROP TABLE IF EXISTS `barang`;
CREATE TABLE IF NOT EXISTS `barang` (
  `kode` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `harga` float NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB AUTO_INCREMENT=1115 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kode`, `nama`, `harga`) VALUES
(1, 'Chitato mini', 15000),
(2, 'Oreo', 12000),
(3, 'Aqua', 4000),
(4, 'FruitTea', 8000);

-- --------------------------------------------------------

--
-- Table structure for table `keuangan`
--

DROP TABLE IF EXISTS `keuangan`;
CREATE TABLE IF NOT EXISTS `keuangan` (
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
(127000, 180000, 53000);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `makanan`
--

DROP TABLE IF EXISTS `makanan`;
CREATE TABLE IF NOT EXISTS `makanan` (
  `kode` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) NOT NULL,
  `harga` float NOT NULL,
  `kadaluarsa` date NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`kode`, `nama`, `harga`, `kadaluarsa`) VALUES
(5, 'Oreo', 10000, '2024-06-11');

-- --------------------------------------------------------

--
-- Table structure for table `pulsa`
--

DROP TABLE IF EXISTS `pulsa`;
CREATE TABLE IF NOT EXISTS `pulsa` (
  `kode` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) NOT NULL,
  `harga` float NOT NULL,
  `operator` varchar(100) NOT NULL,
  `nominal` float NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

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

DROP TABLE IF EXISTS `rincian_transaksi`;
CREATE TABLE IF NOT EXISTS `rincian_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga_satuan` float NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `harga_total` float NOT NULL,
  KEY `id_transaksi` (`id_transaksi`)
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
(21, 9, 'PLN100 12345', 102000, 1, 102000);

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
CREATE TABLE IF NOT EXISTS `token` (
  `kode` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(11) NOT NULL,
  `harga` float NOT NULL,
  `nominal` float NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

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

DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `total_harga` float NOT NULL,
  PRIMARY KEY (`id_transaksi`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

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
(21, 127000);

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
