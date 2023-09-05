-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 05, 2023 at 09:57 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `D_kiganjani`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `username` varchar(70) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `date_registered` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `lastname`, `username`, `phone`, `role`, `password`, `date_registered`) VALUES
(7, 'Charles', 'Jumamosi', 'chars@gmail.com', '255653415623', 'user', 'de8c80eded672b57a65fa91866994cd0', '2023-08-31'),
(10, 'Melckzedeck', 'James', 'melckzedeck063@gmail.com', '255744219981', 'admin', '9b3ef3af7fe61c2cd598cb308c26041f', '2023-09-01'),
(11, 'Merry', 'Gobeka', 'merrygobs@gmail.com', '255614236598', 'user', 'bbe85d5a90564f90b37248d478065f8b', '2023-09-01'),
(12, 'Loveness', 'James', 'loveness@gmail.com', '255742535362', 'user', '18c9682703041dad62103e35887e537a', '2023-09-01'),
(13, 'mbegu', 'Mabiwi', 'mbegumabiwi@gmail.com ', '0655831169', 'user', '25d55ad283aa400af464c76d713c07ad', '2023-09-05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
