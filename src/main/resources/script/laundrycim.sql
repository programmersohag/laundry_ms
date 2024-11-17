SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundrycim`
--

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `employee` (
  `id` char(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` text NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `monthly_salary` int(11) NOT NULL,
  `joining_date` date NOT NULL,
  `quit_date` date NOT NULL,
  `is_active` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `gender`, `address`, `phone_no`, `monthly_salary`, `joining_date`, `quit_date`, `is_active`) VALUES
('K000', 'Liam Moore', 'Male', '7869 Ralph Street', '096001588696', 0, '2018-01-01', '0000-00-00', 2),
('K001', 'Cythia Eddy', 'Female', '2902 Drainer Avenue', '08123456792', 1360, '2019-10-06', '2021-01-25', 0),
('K002', 'Curt Payne', 'Male', '2277 Elsie Drive', '087840927394', 1450, '2019-12-04', '2021-02-22', 0),
('K003', 'William Fransen', 'Male', '3178 Roy Alley', '08128349834', 1450, '2019-12-10', '2021-03-09', 0),
('K004', 'Christine Moore', 'Female', '8600 Allace Avenue', '08122334458', 1400, '2020-02-03', '0000-00-00', 1),
('K005', 'Clea Randolph', 'Female', '3914 Dennison Street', '78500014714', 1600, '2021-05-04', '0000-00-00', 1),
('K006', 'Thomas', 'Male', '4572 Emily Drive', '71400000250', 1560, '2021-08-01', '0000-00-00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `customer_code` char(150) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` text NOT NULL,
  `phone_no` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `customer_code`, `name`, `gender`, `address`, `phone_no`) VALUES
(1, 'P001', 'Brenda Roach', 'Female', '3641 Frum Street', '081243568387'),
(10, 'P0010', 'Larry Meuller', 'Male', '85 Stom Avenue', '72566600150'),
(2, 'P002', 'Gerald Whisler', 'Male', '1005 Heliport Loop', '08234454345'),
(3, 'P003', 'Johnny Smith', 'Male', '4327 Nuzum Court', '082284003073'),
(4, 'P004', 'Misti R Hurd', 'Female', '398 Central Avenue', '082282553856'),
(5, 'P005', 'Antonio Waree', 'Male', '704 Brown Street', '08236749827'),
(6, 'P006', 'Amber Slank', 'Female', '1518 Wilkinson Court', '085634872555'),
(7, 'P007', 'Joseph Howie', 'Male', '2254 Norma Avenue', '085544338866'),
(8, 'P008', 'James Smith', 'Laki-Laki', '7125 Demo Street', '01478541000'),
(9, 'P009', 'Karen Peige', 'Female', '4552 Poling Farm Road', '74100025690');

-- --------------------------------------------------------

--
-- Table structure for table `production`
--

CREATE TABLE `production` (
  `id` varchar(14) NOT NULL,
  `total` int(11) NOT NULL,
  `details` varchar(100) NOT NULL,
  `date_of_issue` date NOT NULL,
  `employee_id` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `production`
--

INSERT INTO `production` (`id`, `total`, `details`, `date_of_issue`, `employee_id`) VALUES
('20210130093105', 5503, 'Washers Bought', '2021-01-01', 'K004'),
('20210130104609', 4260, 'Salary Payment January 2021', '2021-01-30', 'K000'),
('20210130110802', 466, 'Electricity Bills', '2021-06-16', 'K004'),
('20210805095557', 3000, 'Employee Salary Payment July 2021', '2021-07-02', 'K000'),
('20210805095931', 3000, 'Employee Salary Payment August 2021', '2021-08-05', 'K000');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` varchar(14) NOT NULL,
  `customer_id` char(7) NOT NULL,
  `employee_id` char(6) NOT NULL,
  `weight` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `date_order` date NOT NULL,
  `date_delivery` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `customer_id`, `employee_id`, `weight`, `total`, `date_order`, `date_delivery`) VALUES
('20210130151203', 'P001', 'K004', 12, 46, '2021-01-01', '2021-01-03'),
('20210130151243', 'P002', 'K004', 15, 58, '2021-01-01', '2021-01-04'),
('20210130151304', 'P003', 'K004', 15, 58, '2021-01-02', '2021-01-04'),
('20210130151345', 'P004', 'K004', 20, 77, '2021-01-02', '2021-01-05'),
('20210130164704', 'P002', 'K004', 25, 96, '2021-01-05', '2021-01-08'),
('20210130164722', 'P005', 'K004', 25, 96, '2021-01-07', '2021-01-09'),
('20210130164748', 'P003', 'K004', 18, 69, '2021-01-08', '2021-01-10'),
('20210130164804', 'P001', 'K004', 19, 73, '2021-01-10', '2021-01-12'),
('20210130164821', 'P004', 'K004', 20, 77, '2021-01-11', '2021-01-13'),
('20210130164855', 'P003', 'K004', 22, 85, '2021-01-13', '2021-01-15'),
('20210130164918', 'P002', 'K004', 11, 42, '2021-01-16', '2021-01-18'),
('20210130170149', 'P005', 'K004', 15, 58, '2021-01-17', '2021-01-19'),
('20210130170220', 'P001', 'K004', 8, 31, '2021-01-17', '2021-01-20'),
('20210130170251', 'P004', 'K004', 18, 69, '2021-01-20', '2021-01-22'),
('20210130170310', 'P003', 'K004', 29, 112, '2021-01-21', '2021-01-23'),
('20210130171108', 'P006', 'K004', 20, 77, '2021-01-21', '2021-01-23'),
('20210130171129', 'P007', 'K004', 18, 69, '2021-01-22', '2021-01-24'),
('20210130171209', 'P005', 'K004', 17, 65, '2021-01-23', '2021-01-25'),
('20210130171253', 'P002', 'K004', 19, 73, '2021-01-24', '2021-01-26'),
('20210130171310', 'P004', 'K004', 20, 77, '2021-01-25', '2021-01-27'),
('20210130171348', 'P001', 'K004', 17, 65, '2021-01-26', '2021-01-28'),
('20210130171433', 'P006', 'K004', 8, 31, '2021-01-26', '2021-01-28'),
('20210130171537', 'P003', 'K004', 15, 58, '2021-01-27', '2021-01-29'),
('20210130171617', 'P007', 'K004', 10, 39, '2021-01-27', '2021-01-29'),
('20210130171846', 'P005', 'K004', 46, 177, '2021-08-03', '2021-08-05'),
('20210130172114', 'P004', 'K004', 21, 81, '2021-08-02', '2021-08-05'),
('20210627232518', 'P008', 'K004', 5, 19, '2021-06-26', '2021-06-27'),
('20210805150525', 'P009', 'K004', 14, 54, '2021-08-05', '2021-08-05'),
('20210805153848', 'P007', 'K005', 73, 281, '2021-07-07', '2021-08-05'),
('20210805211713', 'P002', 'K005', 36, 139, '2021-08-05', '2021-08-05'),
('20210806005743', 'P0010', 'K006', 19, 73, '2021-08-05', '2021-08-05');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `users` (
  `user_id` char(4) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `level` char(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `users` (`user_id`, `name`, `username`, `password`, `level`) VALUES
('U001', 'Liam Moore', 'admin', 'D00F5D5217896FB7FD601412CB890830', 'superuser');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQUE` (`customer_code`);

--
-- Indexes for table `production`
--
ALTER TABLE `production`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
