-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2020 at 03:02 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_zakat`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id_user` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id_user`, `username`, `password`, `nama`) VALUES
(1, 'fauzanagra', 'agra1', 'Fauzan Agra'),
(2, 'rizkydwi', 'rizky1', 'Rizky Dwi'),
(3, 'miranti', 'miranti1', 'Miranti Zulya'),
(4, 'adminku', '[C@ddcde16', 'Admin Agra'),
(5, 'Joker', 'joker1', 'JokerMan'),
(6, 'Zan123', 'Zan12', 'Zan'),
(7, 'sule1', 'sule1', 'suleee');

-- --------------------------------------------------------

--
-- Table structure for table `zakat`
--

CREATE TABLE `zakat` (
  `id_zakat` int(11) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `alamat` varchar(256) NOT NULL,
  `jml_jiwa` int(11) NOT NULL,
  `total_zakat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `zakat`
--

INSERT INTO `zakat` (`id_zakat`, `nama`, `alamat`, `jml_jiwa`, `total_zakat`) VALUES
(1, 'Fauzan Agra', 'JL Candi Mutiara Timur I/1594', 4, 120000),
(2, 'Rizky Dwi', 'JL Sri Rejeki', 3, 90000),
(3, 'Miranti Alysha', 'JL Pemuda Raya 1', 5, 150000),
(4, 'Zaky', 'JL Siliwangi 2', 6, 180000),
(5, 'Radityo', 'JL Sriwijaya', 3, 90000),
(6, 'Murdianto', 'JL Bukit Kencana', 5, 150000),
(7, 'Rudy', 'JL Kembang Raya', 6, 180000),
(8, 'Nur Afifah', 'JL Wr Supratman', 6, 180000),
(9, 'Jamal', 'JL Pusponjolo Timur', 7, 210000),
(10, 'Dian', 'JL Puspowarno', 3, 90000),
(14, 'Satrio', 'JL Sarowedi', 6, 180000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `zakat`
--
ALTER TABLE `zakat`
  ADD PRIMARY KEY (`id_zakat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `zakat`
--
ALTER TABLE `zakat`
  MODIFY `id_zakat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
