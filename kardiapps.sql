-- phpMyAdmin SQL Dump
-- version 4.7.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 20, 2018 at 11:27 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kardiapps`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_jawaban`
--

CREATE TABLE `tbl_jawaban` (
  `id_jawaban` int(10) NOT NULL,
  `id_pertanyaan` int(10) NOT NULL,
  `jawaban` varchar(20) NOT NULL,
  `value` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_jawaban`
--

INSERT INTO `tbl_jawaban` (`id_jawaban`, `id_pertanyaan`, `jawaban`, `value`) VALUES
(1, 1, 'ya', ''),
(2, 1, 'tidak', '3');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kategori`
--

CREATE TABLE `tbl_kategori` (
  `id_kategori` int(10) NOT NULL,
  `nama_kategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_kategori`
--

INSERT INTO `tbl_kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Programmer'),
(2, 'Networking'),
(3, 'Multimedia'),
(4, 'Data Science');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_loker`
--

CREATE TABLE `tbl_loker` (
  `id_loker` bigint(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `salary` int(11) NOT NULL,
  `deskripsi` text NOT NULL,
  `image` text NOT NULL,
  `id_kategori` int(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_loker`
--

INSERT INTO `tbl_loker` (`id_loker`, `title`, `salary`, `deskripsi`, `image`, `id_kategori`, `created`, `updated`) VALUES
(21, 'Loker PT. GITS Yogyakarta', 10000000, 'ana mnnm', 'jkak.jpg', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pekerja`
--

CREATE TABLE `tbl_pekerja` (
  `id` int(20) NOT NULL,
  `umur` int(20) NOT NULL,
  `lulusan` varchar(20) NOT NULL,
  `bidang` varchar(20) NOT NULL,
  `created` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pekerja`
--

INSERT INTO `tbl_pekerja` (`id`, `umur`, `lulusan`, `bidang`, `created`) VALUES
(77, 25, 'Sarjana S1/D4', 'Teknologi Informasi', '2018-05-12 12:19:33'),
(78, 0, '--Pilih Lulusan--', '--Pilih Bidang--', '2018-05-12 20:50:15'),
(79, 0, '--Pilih Lulusan--', '--Pilih Bidang--', '2018-05-12 20:54:41');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pertanyaan`
--

CREATE TABLE `tbl_pertanyaan` (
  `id_pertanyaan` int(10) NOT NULL,
  `id_kategori` int(10) NOT NULL,
  `pertanyaan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pertanyaan`
--

INSERT INTO `tbl_pertanyaan` (`id_pertanyaan`, `id_kategori`, `pertanyaan`) VALUES
(1, 1, 'Seberapa sering anda menggunakan komputer dalam keseharian anda ?\r\n'),
(2, 1, 'Sistem Operasi apa yang anda gunakan ?'),
(3, 2, 'Software apa yang ada di laptop anda / sering anda gunakan ?');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `firstname`, `lastname`, `email`, `password`, `created_at`) VALUES
(2, 'bayu', 'adi', 'ggh@gmail.com', '599a273ce6afa9487ca10655a32d079eaa3f686ef761b175d3b4030f3247eb37', '2018-05-11 23:15:48'),
(3, 'azka', 'wildan', 'azka@gmail.com', 'b338fe1c48306c85d64a8c2bbaae8a6113aa8d4657481c00772ce1f5062982b7', '2018-05-11 23:19:08'),
(4, 'hhjj', 'ggh', 'hhh@gmail.com', '84fc2cc512c084e19765ff95ace33ad8108d9ac73e307633b3d267e2dd72c49b', '2018-05-12 00:47:18'),
(5, 'anggi', 'wibowo', 'anggi@gmail.com', 'b85fd3b2f0b4ed774d0fa8f00f1c79b3acd7c51c8e4f8588c94dda63d9a06de0', '2018-05-12 00:49:19'),
(6, 'dhiyo', 'reksa', 'dhiyo@gmail.com', '7c89a7d9b74c6662b15ee6f6802c638c7a88e7b6c596f41ad126bd1cb39a1f0d', '2018-05-12 11:25:55'),
(7, 'reksa', 'dhiyo', 'reksa@gmail.com', '44740b842cbc00166e0e547ddf97b1c15d3024475a20b0e8b796fcb4f6646ad6', '2018-05-12 11:38:11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_jawaban`
--
ALTER TABLE `tbl_jawaban`
  ADD PRIMARY KEY (`id_jawaban`);

--
-- Indexes for table `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `tbl_loker`
--
ALTER TABLE `tbl_loker`
  ADD PRIMARY KEY (`id_loker`);

--
-- Indexes for table `tbl_pekerja`
--
ALTER TABLE `tbl_pekerja`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_pertanyaan`
--
ALTER TABLE `tbl_pertanyaan`
  ADD PRIMARY KEY (`id_pertanyaan`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_jawaban`
--
ALTER TABLE `tbl_jawaban`
  MODIFY `id_jawaban` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  MODIFY `id_kategori` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_loker`
--
ALTER TABLE `tbl_loker`
  MODIFY `id_loker` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tbl_pekerja`
--
ALTER TABLE `tbl_pekerja`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT for table `tbl_pertanyaan`
--
ALTER TABLE `tbl_pertanyaan`
  MODIFY `id_pertanyaan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
