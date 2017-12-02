-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2017 at 04:03 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cashbond`
--

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `Absen` int(11) NOT NULL,
  `Nama` varchar(200) NOT NULL,
  `Saldo` int(20) NOT NULL,
  `tanggal` date NOT NULL,
  `jk` enum('Laki - Laki','Perempuan') NOT NULL,
  `tempat` varchar(200) NOT NULL,
  `alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`Absen`, `Nama`, `Saldo`, `tanggal`, `jk`, `tempat`, `alamat`) VALUES
(24, 'Muhammad Bhuwana Putra', 2000, '2001-07-17', 'Laki - Laki', 'Bandung', 'Malang'),
(25, 'Muhammad Bhuwana Putra', 12000, '2001-07-17', 'Laki - Laki', 'Bandung', 'Malang'),
(26, 'Muhammad Rezki Ananda', 2000, '2001-11-24', 'Laki - Laki', 'Kediri', 'Malang');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`Absen`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
