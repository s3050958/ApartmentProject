-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2015 at 03:05 AM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apartmentproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `i_id` int(11) NOT NULL,
  `i_water` int(11) NOT NULL,
  `i_light` int(11) NOT NULL,
  `i_total` int(11) NOT NULL,
  `i_status` varchar(100) NOT NULL DEFAULT '<font color="red">Not Paid</font>',
  `u_id` int(11) NOT NULL,
  `r_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`i_id`, `i_water`, `i_light`, `i_total`, `i_status`, `u_id`, `r_id`) VALUES
(1, 200, 4500, 8200, '<font color="green">Paid</font>', 2, 101),
(2, 600, 1800, 8900, '<font color="red">Not Paid</font>', 3, 501),
(3, 1000, 4500, 12000, '<font color="red">Not Paid</font>', 0, 402),
(4, 400, 180, 4080, '<font color="green">Paid</font>', 11, 308),
(5, 1000, 4500, 9000, '<font color="red">Not Paid</font>', 25, 303),
(6, 12000, 3600, 22100, '<font color="red">Not Paid</font>', 9, 502),
(7, 0, 0, 3500, '<font color="red">Not Paid</font>', 2, 101),
(8, 0, 0, 3500, '<font color="red">Not Paid</font>', 2, 101),
(9, 0, 0, 3500, '<font color="red">Not Paid</font>', 28, 207),
(10, 0, 0, 3500, '<font color="green">Paid</font>', 26, 308),
(11, 1500, 36000, 44000, '<font color="green">Paid</font>', 30, 401),
(12, 400, 630, 7530, '<font color="green">Paid</font>', 31, 402);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `r_id` int(11) NOT NULL,
  `r_status` varchar(100) NOT NULL DEFAULT '<font color="green">Available</font>',
  `r_water` int(11) NOT NULL DEFAULT '0',
  `r_light` int(11) NOT NULL DEFAULT '0',
  `r_price` int(11) NOT NULL DEFAULT '3500',
  `u_id` int(11) DEFAULT NULL,
  `r_orid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`r_id`, `r_status`, `r_water`, `r_light`, `r_price`, `u_id`, `r_orid`) VALUES
(101, '<font color="red">Not Available</font>', 0, 0, 3500, 2, NULL),
(201, '<font color="red">Not Available</font>', 0, 0, 4500, 18, NULL),
(202, '<font color="red">Not Available</font>', 0, 0, 4500, 32, NULL),
(203, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(204, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(205, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(206, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(207, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(208, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(209, '<font color="green">Available</font>', 0, 0, 4500, NULL, NULL),
(210, '<font color="green">Available</font>', 0, 0, 4500, 0, NULL),
(301, '<font color="green">Available</font>', 0, 0, 4500, 0, NULL),
(302, '<font color="green">Available</font>', 0, 0, 4500, NULL, NULL),
(303, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(304, '<font color="green">Available</font>', 0, 0, 3500, NULL, NULL),
(305, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(306, '<font color="red">Not Available</font>', 0, 0, 3500, 17, NULL),
(307, '<font color="green">Available</font>', 0, 0, 3500, NULL, NULL),
(308, '<font color="green">Available</font>', 0, 0, 3500, 0, NULL),
(309, '<font color="green">Available</font>', 0, 0, 4500, NULL, NULL),
(310, '<font color="green">Available</font>', 0, 0, 4500, 0, NULL),
(401, '<font color="green">Available</font>', 0, 0, 6500, 0, NULL),
(402, '<font color="red">Not Available</font>', 0, 0, 6500, 31, NULL),
(403, '<font color="red">Not Available</font>', 0, 0, 6500, 10, NULL),
(404, '<font color="red">Not Available</font>', 0, 0, 6500, 16, NULL),
(501, '<font color="green">Available</font>', 0, 0, 6500, 0, NULL),
(502, '<font color="red">Not Available</font>', 0, 0, 6500, 9, NULL),
(503, '<font color="red">Not Available</font>', 0, 0, 6500, 14, NULL),
(504, '<font color="red">Not Available</font>', 0, 0, 6500, 15, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_day` int(11) NOT NULL,
  `u_month` int(11) NOT NULL,
  `u_year` int(11) NOT NULL,
  `r_id` int(11) NOT NULL,
  `u_rid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_fname`, `u_lname`, `u_day`, `u_month`, `u_year`, `r_id`, `u_rid`) VALUES
(1, 'Dara', 'Iing', 10, 11, 2015, 305, 305),
(2, 'Jay', 'Jay', 0, 0, 0, 101, 101),
(3, '123', '123', 0, 0, 0, 208, 208),
(4, 'asd', 'asd', 0, 0, 0, 0, 0),
(8, '111', '111', 10, 11, 2015, 205, 205),
(9, 'aaa', 'aaa', 0, 0, 0, 502, 502),
(10, 'sss', 'sss', 0, 0, 0, 403, 403),
(14, 'darathorn', 'titithakul', 29, 11, 2015, 503, 503),
(15, 'dara', 'iing', 10, 11, 2015, 504, 504),
(16, 'Daraiing', 'titi', 22, 11, 2015, 404, 404),
(17, 'dara', 'tit', 29, 11, 2015, 306, 306),
(18, 'dara', 'titi', 22, 11, 2015, 201, 201),
(19, 'dd', 'dd', 22, 11, 2015, 202, 202),
(21, 'aaa', 'aaa', 0, 0, 0, 208, 208),
(31, 'aaa', 'aaa', 12, 11, 2015, 402, 402),
(32, '<font color=''green'' size=''20px''>Narongrit</font>', '<strong>Pa</strong>', 3, 3, 2015, 202, 202);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`i_id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`r_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `i_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
