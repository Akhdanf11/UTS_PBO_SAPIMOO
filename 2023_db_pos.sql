-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 25, 2023 at 05:14 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2023_db_pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id` int NOT NULL AUTO_INCREMENT,
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
-- Table structure for table `tb_barang`
--

DROP TABLE IF EXISTS `tb_barang`;
CREATE TABLE IF NOT EXISTS `tb_barang` (
  `kode` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `harga` int NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`kode`, `nama`, `harga`) VALUES
(1, 'Apa Bohlam LED 3watt 270lm - cool daylight', 10500),
(2, 'Stora Hanger Plastik 10pcs - hitam', 29900),
(3, 'Stora Hanger Plastik 10pcs - abu abu', 29900),
(4, 'Tpempat Beras Press OPEN 5ltr', 112500),
(5, 'Krisbow Dispenser Sabun Cair - silver', 89900),
(6, 'Krisbow Dispenser Sabun Cair - gold', 89900),
(7, 'Kris 10 ltr Oven Toast 350 watt - Hitam ', 339900),
(8, 'Ataru Holder Id Card - rose gold', 59900),
(9, 'Ataru Holder Id Card - blue', 59900),
(10, 'Sleeplite set 2 pcs Bantal guling - putih', 109000),
(11, 'Sleeplite set 2 pcs Bantal guling - krem', 109000),
(12, 'Kris 125 ml Coffee Maker', 150000),
(13, 'Kris 90x180 cm Venetian Blinds 25mm - putih', 152900),
(14, 'Kris 40x180 cm Venetian Blinds 25mm - putih', 90000),
(15, 'Odi Meja lipat Laptop - hitam', 179000),
(16, 'Odi Meja lipat Laptop - pink', 179000),
(17, 'Odi Meja lipat Laptop - biru', 179000),
(18, 'Odi Meja lipat Laptop - hijau ', 179000),
(19, 'Kris 2.1 ltr Stoples Kaca', 45000),
(20, 'Soleil Kursi Lipat - hitam', 139900),
(21, 'Soleil Kursi Lipat - silver', 139900),
(22, 'Porclean Alat pel Spray - abu abu', 99900),
(23, 'Masterspace Rak  Troli Minimalis 4 tingkat - putih ', 175500),
(24, 'Stora Gantungan Pakaian Single 94x44x154 cm - hitam', 197500),
(25, 'Stora Gantungan Pakaian Single 94x44x154 cm - putih', 197500),
(26, 'Rak sepatu besi 2 tingkat 80x30x37cm - putih', 64900),
(27, 'Rak sepatu besi 2 tingkat 80x30x37cm - hitam', 64900),
(28, 'Kris Pemanggang Roti 2 slice 700 watt', 269000),
(29, 'Kris 21 ltr Oven Toaster 1000 watt - hitam', 674900),
(30, 'Kris 21 ltr Oven Toaster 1000 watt - silver', 674900),
(31, 'Kris Coffee Maker 1.5ltr - hitam', 299900),
(32, 'Kris Coffee Maker 0.75ltr 600watt - hitam', 269500),
(33, 'Kris Tempat beras double seal 10kg', 134900),
(34, 'Kris Tempat beras double seal 15kg', 155000),
(35, 'Sleeplite 210x220 cm Bed Cover freesia - krem', 300000),
(36, 'Sleeplite 210x220 cm Bed Cover freesia - putih', 300000),
(37, 'Sleeplite 210x220 cm Bed Cover freesia - abu abu', 300000),
(38, 'Stora Lemari Pakaian Lipat - Abu abu', 228700),
(39, 'Stora Lemari Pakaian Lipat - krem', 228700),
(40, 'Stora Lemari Pakaian Lipat - pink', 228700),
(41, 'Stora Lemari Pakaian Lipat - hijau', 228700),
(42, 'Kris 150ml Mason Mug Jar set 4pcs', 44800),
(43, 'Sleeplite 180x200 cm Sprei King Freesia - krem', 179600),
(44, 'Sleeplite 180x200 cm Sprei King Freesia - putih', 179600),
(45, 'Sleeplite 180x200 cm Sprei King Freesia - abu abu', 179600),
(46, 'Krisbow Lampu Led UV disinfektan portabel 2watt', 20700),
(47, 'Stora Gantungan Pankaian Metal - abu abu', 175900),
(48, 'Stora Gantungan Pankaian Metal - putih', 175900),
(49, 'Stora Gantungan Pankaian Metal - hitam', 175900),
(50, 'Jam Dinding 3cm Monokrom - putih', 99900),
(51, 'Stora Gantungan Pankaian Metal - hitam', 99900),
(52, 'Stora Gantungan Pankaian Metal - abu abu', 99900),
(53, 'Ataru Hanger Minim 9 lubang pengait - putih', 5000),
(54, 'Ataru Hanger Minim 9 lubang pengait - krem', 5000),
(55, 'Krisbow Rak Galon single', 129800),
(56, 'Proclean Sapu dan Pengki Lipat ', 79900),
(57, 'Masterspace Rak Sepatu 3 tingkat - Cokelat', 1349000),
(58, 'Masterspace Rak Sepatu 3 tingkat - hitam', 1349000),
(59, 'Kris 1.4ltr Teko Minum ', 34200),
(60, 'Stora Keranjang Laundri X Shape ', 148900),
(61, 'Eglo Up li Lampu Lantai - Nickle', 300500),
(62, 'Sarung Koper - pink', 149800),
(63, 'Sarung Koper - biru', 149800),
(64, 'Sarung Koper - hijau', 149800),
(65, 'Sarung Koper - maroon', 149800),
(66, 'Sarung Koper - hitam', 149800),
(67, 'Tempat Pensil Meja - Hitam', 15000),
(68, 'Tempat Pensil Meja - putih\r\n', 15000),
(69, 'Kris 4r Bingkai foto 9 Frame -hitam ', 77000),
(70, 'Kris Timbangan Badan Mekanik - abu abu', 127900),
(71, 'Kris Timbangan Badan Mekanik - hitam', 127900),
(72, 'Kris Timbangan Badan Mekanik - pink', 127900),
(73, 'Kris Timbangan Badan Mekanik - biru', 127900),
(74, 'Kris Timbangan Badan Mekanik - oren', 127900),
(75, 'Kris 4r Bingkai foto 24 Frame -hitam ', 189900),
(76, 'Kris 4r Bingkai foto 24 Frame - putih', 189900),
(77, 'Kris 4r Bingkai foto 24 Frame - pink', 189900),
(78, 'Kris 4r Bingkai foto 24 Frame - abu abu', 189900),
(79, 'Soleil set 4cs Wicker Marcoco kursi dan meja', 13599000),
(80, 'Tunturi Smart Treadmill 1.5hp T40', 14449500),
(81, 'Orans Kloset Duduk Smart It-626 ', 15199800),
(82, 'Orans Kloset Duduk Smart It-808', 17599800),
(83, 'Orans Bathtub Whirpool Bt-62118m', 31449000),
(84, 'Orans Kmar Sauna Infrared Sn-96116i', 35000000),
(85, 'Kinetik Motorized Smart Treadmill 3 Hp 99p', 1305000),
(86, 'Soleil Vasco Set Kursi dan Meja Teras - abu abu', 12799900),
(87, 'Kris Bathtub Classic Chrone Legs C-3015', 11890000),
(88, 'Krischef 160ltr Showcase Pendingin Rtw', 9999000),
(89, 'Schwinn Sepeda Statis My20 510u ', 9999000),
(90, 'Krisbow Tangga Ekstensi Fiberglass 8.4m - oren', 7196000),
(91, 'Krisbow Tangga Ekstensi Fiberglass 8.4m - hitam', 7196000),
(92, 'Krisbow Tangga Ekstensi Fiberglass 8.4m - silver', 7196000),
(93, 'Krisbow Tangga Ekstensi Fiberglass 8.4m - merah', 7196000),
(94, 'Krisbow Rak Besi 5 Tingkat Heavy Duty - biru', 7299000),
(95, 'Boyu Pompa Kolam Slb25000 15000I/H - merah', 5000000),
(96, 'Boyu Pompa Kolam Slb25000 15000I/H - hiaju', 5000000),
(97, 'Boyu Pompa Kolam Slb25000 15000I/H - oren', 5000000),
(98, 'Fixsteps tangga teleskopik aluminium 17 step', 4798000),
(99, 'Klaz Smart Pembersih Lantai Robotik - putih', 5499900),
(100, 'Klaz Smart Pembersih Lantai Robotik - Hitam', 5499900),
(101, 'Soleil Luke Set Kursi dan Meja teras - putih abu', 4799000),
(102, 'Novis 1.9ltr Pro Blender - krem', 4490000),
(103, 'Novis 1.9ltr Pro Blender - hitam', 4490000),
(104, 'Novis 1.9ltr Pro Blender - maroon', 4490000),
(105, 'Novis 1.9ltr Pro Blender - silver', 4490000),
(106, 'Krisbow Kipas Uap 30inci 60ltr ', 5499000),
(107, 'Lexata Pemijat Kaki ', 4199000),
(108, 'Westinghouse kipas angin plafon 52inci 35 watt - cokelat', 4139900),
(109, 'Westinghouse kipas angin plafon 52inci 35 watt - putih', 4139900),
(110, 'Westinghouse kipas angin plafon 52inci 35 watt - silver', 4139900),
(111, 'Masterspace Lemari Pakaian 3 pintu - cokelat', 4099000),
(112, 'Masterspace Lemari Pakaian 3 pintu - putih', 4099000),
(113, 'Masterspace Lemari Pakaian 3 pintu - abu abu', 4099000),
(114, 'Tunturi Multi GYM hG 20', 8549100),
(115, 'Masterspace Lemari Pakaian 3 pintu - hitam', 4099000),
(116, 'Krisbow Tempat Sampah Marmer ', 3999000),
(117, 'CharBroil Pemanggang Arang ', 3999000),
(118, 'Lockly Kunci Digital Deadbolt 728f - hitam', 3498900),
(119, 'Lockly Kunci Digital Deadbolt 728f - silver', 3498900),
(120, 'Novis Vita Juicer 4 in 1 - hitam', 2999000),
(121, 'Novis Vita Juicer 4 in 1 - maroon', 2999000),
(122, 'Soleil Kursi Ayunan Gantung Rotan Double ', 6199700),
(123, 'Acepresso 2.7ltr espresso coffee maker grinder', 6157000),
(124, 'Hurom Slow Juicer H310a - hitam', 4997000),
(125, 'Jbl Filter Eksternal Akuarium Cristalprofi Greenline', 4999000),
(126, 'Hurom Slow Juicer H310a - putih', 4997000),
(127, 'Hurom Slow Juicer H100 - hitam', 6499000),
(128, 'Hurom Slow Juicer H100 - maroon', 6499000),
(129, 'Dahon Seepeda Lipat QIX D3 - hitam', 8999000),
(130, 'Dahon Sepeda Lipat QIX D3 - putih', 8999000),
(131, 'Dahon Sepeda Lipat QIX D3 - gold', 8999000),
(132, 'Dahon Sepeda Lipat QIX D3 - hijau', 8999000),
(133, 'Perfect Aire Dehumidifier 30ltr - putih', 4999000),
(134, 'Kris Set CCTV Ahd 8 kamera 1080p H265', 6999000),
(135, 'Igloo Cooler BOX Sunset Glide 110qt - putih', 489900),
(136, 'Igloo Cooler BOX Sunset Glide 110qt - biru', 489900),
(137, 'Eglare Nicole Lampu Gantung Hias Dinin 8l E114 - French gold', 5499000),
(138, 'Dahon Sepeda Lipat K3 Plus 16 inci - abu abu', 8699000),
(139, 'Dahon Sepeda Lipat K3 Plus 16 inci - abu abu', 8699000),
(140, 'Dahon Sepeda Lipat K3 Plus 16 inci - hitam', 8699000),
(141, 'Dahon Sepeda Lipat K3 Plus 16 inci - gold', 8699000),
(142, 'Dahon Sepeda Lipat K3 Plus 16 inci - kuning', 8699000),
(143, 'Klaz Angel Pemurni Air Ultra Filtrasi ', 9999000),
(144, 'Eglare Barka Lampu Gantung Hias 16l', 9499800),
(145, 'Eglare Lampu Gantun Hias 18l9', 9998900),
(146, 'Galena Kursi Roda Exta Padding - hitam', 2999000),
(147, 'Acroz Set Shower Mandi T9902', 2799000),
(148, 'Krisbow Mesin Absensi ', 2799800),
(149, 'Nilfisk High Pressure Cleaner Cold Home', 2759000),
(150, 'Bestway Kolam Renang Frame 400x211x81 cm', 2699100);

-- --------------------------------------------------------

--
-- Table structure for table `tb_transaksi`
--

DROP TABLE IF EXISTS `tb_transaksi`;
CREATE TABLE IF NOT EXISTS `tb_transaksi` (
  `kode_transaksi` int NOT NULL AUTO_INCREMENT,
  `kode` int NOT NULL,
  `deskripsi` text NOT NULL,
  `total_belanja` int NOT NULL,
  `jumlah_bayar` int NOT NULL,
  `kembalian` int NOT NULL,
  `waktu` varchar(100) NOT NULL,
  PRIMARY KEY (`kode_transaksi`),
  KEY `kode_fk` (`kode`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD CONSTRAINT `kode_fk` FOREIGN KEY (`kode`) REFERENCES `tb_barang` (`kode`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
