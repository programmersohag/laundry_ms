-- MySQL dump 10.13  Distrib 9.3.0, for macos15.2 (arm64)
--
-- Host: 127.0.0.1    Database: laundry_db
-- ------------------------------------------------------
-- Server version	9.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` varchar(150) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` text NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('P001','Brenda Roach','2','3641 Frum Street','081243568387'),('P0010','Larry Meuller','1','85 Stom Avenue','72566600150'),('P0011','Akhter Hossain','1','Dhaka Bangladesh','01788990077'),('P002','Gerald Whisler','1','1005 Heliport Loop','08234454345'),('P003','Johnny Smith','1','4327 Nuzum Court','082284003073'),('P004','Misti R Hurd','2','398 Central Avenue','082282553856'),('P005','Antonio Waree','1','704 Brown Street','08236749827'),('P006','Amber Slank','2','1518 Wilkinson Court','085634872555'),('P007','Joseph Howie','1','2254 Norma Avenue','085544338866'),('P008','James Smith','3','7125 Demo Street','01478541000'),('P009','Karen Peige','2','4552 Poling Farm Road','74100025690');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` text NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `monthly_salary` int NOT NULL,
  `joining_date` date NOT NULL,
  `quit_date` date DEFAULT NULL,
  `employee_status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('K000','Liam Moore','1','7869 Ralph Street','096001588696',0,'2018-01-01','2025-05-01',2),('K001','Cythia Eddy','2','2902 Drainer Avenue','08123456792',1360,'2019-10-06','2021-01-25',0),('K0010','Sajedul Islam','1','Dhaka Bangladesh','01788990068',12000,'2025-04-02','2025-12-31',1),('K002','Curt Payne','1','2277 Elsie Drive','087840927394',1450,'2019-12-04','2021-02-22',0),('K003','William Fransen','1','3178 Roy Alley','08128349834',1450,'2019-12-10','2021-03-09',0),('K004','Christine Moore','2','8600 Allace Avenue','08122334458',1400,'2020-02-03','2025-04-30',1),('K005','Clea Randolph','2','3914 Dennison Street','78500014714',1600,'2021-05-04','2025-04-30',1),('K006','Thomas','1','4572 Emily Drive','71400000250',1560,'2021-08-01','2025-04-30',1),('K008','Rejaul Korim','1','Dhaka','01788990066',10000,'2025-05-02',NULL,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `production`
--

DROP TABLE IF EXISTS `production`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `production` (
  `id` varchar(14) NOT NULL,
  `total` int NOT NULL,
  `details` varchar(100) NOT NULL,
  `date_of_issue` date NOT NULL,
  `employee_id` varchar(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `production_employee_id_fk` (`employee_id`),
  CONSTRAINT `production_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `production`
--

LOCK TABLES `production` WRITE;
/*!40000 ALTER TABLE `production` DISABLE KEYS */;
INSERT INTO `production` VALUES ('1746207424341',10000,'Employee Salary Paymen','2025-05-02','K005'),('1746208264582',10000,'Employee Salary Payment Apr 2025','2025-05-02','K005'),('1746208335266',10000,'Employee Salary Payment for the month of April 2025','2025-05-02','K0010'),('1746208723677',5000,'Misc Expense','2025-05-01','K0010'),('1746209497023',7888,'Employee Salary Payment for the month of April 2025','2025-05-03','K004'),('20210130093105',5503,'Washers Bought','2021-01-01','K004'),('20210130110802',466,'Electricity Bills','2021-06-16','K004');
/*!40000 ALTER TABLE `production` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` varchar(14) NOT NULL,
  `customer_id` char(7) NOT NULL,
  `employee_id` char(6) NOT NULL,
  `weight` int NOT NULL,
  `total` int NOT NULL,
  `date_of_order` date NOT NULL,
  `date_of_delivery` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `transaction_customer_id_fk` (`customer_id`),
  KEY `transaction_employee_id_fk` (`employee_id`),
  CONSTRAINT `transaction_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `transaction_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES ('1746159987282','P005','K006',10,300,'2025-05-02','2025-05-02'),('1746460367558','P0011','K0010',50,1500,'2025-05-05','2025-05-05'),('1746460444050','P0010','K0010',100,3000,'2025-05-05','2025-05-05'),('1746460476245','P001','K0010',75,2250,'2025-05-05','2025-05-05'),('1746460513566','P002','K005',80,2400,'2025-05-05','2025-05-05'),('1746460542814','P004','K005',120,3600,'2025-05-05','2025-05-05'),('1746460566151','P006','K006',800,24000,'2025-05-05','2025-05-05'),('1746460620943','P008','K005',1000,30000,'2025-05-05','2025-05-05'),('1746460649140','P007','K004',200,6000,'2025-05-05',NULL),('1746460711185','P006','K004',300,9000,'2025-05-05','2025-05-05'),('1746462749002','P0011','K0010',10,300,'2025-05-05',NULL),('1746462797032','P008','K004',5,150,'2025-05-05',NULL),('1746462823216','P006','K006',6,180,'2025-05-05',NULL),('20210130151203','P001','K004',12,46,'2021-01-01','2025-05-01'),('20210130151243','P002','K004',15,58,'2021-01-01','2025-04-30'),('20210130151304','P003','K004',15,58,'2021-01-02','2021-01-04'),('20210130151345','P004','K004',20,77,'2021-01-02','2025-05-02'),('20210130164704','P002','K004',25,96,'2021-01-05','2021-01-08'),('20210130164722','P005','K004',25,96,'2021-01-07','2021-01-09'),('20210130164748','P003','K004',18,69,'2021-01-08','2021-01-10'),('20210130164804','P001','K004',19,73,'2021-01-10','2021-01-12'),('20210130164821','P004','K004',20,77,'2021-01-11','2021-01-13'),('20210130164855','P003','K004',22,85,'2021-01-13','2021-01-15'),('20210130164918','P002','K004',11,42,'2021-01-16','2021-01-18'),('20210130170149','P005','K004',15,58,'2021-01-17','2021-01-19'),('20210130170220','P001','K004',8,31,'2021-01-17','2021-01-20'),('20210130170251','P004','K004',18,69,'2021-01-20','2021-01-22'),('20210130170310','P003','K004',29,112,'2021-01-21','2021-01-23'),('20210130171108','P006','K004',20,77,'2021-01-21','2021-01-23'),('20210130171129','P007','K004',18,69,'2021-01-22','2021-01-24'),('20210130171209','P005','K004',17,65,'2021-01-23','2021-01-25'),('20210130171253','P002','K004',19,73,'2021-01-24','2021-01-26'),('20210130171310','P004','K004',20,77,'2021-01-25','2021-01-27'),('20210130171348','P001','K004',17,65,'2021-01-26','2021-01-28'),('20210130171433','P006','K004',8,31,'2021-01-26','2021-01-28'),('20210130171537','P003','K004',15,58,'2021-01-27','2021-01-29'),('20210130171617','P007','K004',10,39,'2021-01-27','2021-01-29'),('20210130171846','P005','K004',46,177,'2021-08-03','2021-08-05'),('20210130172114','P004','K004',21,81,'2021-08-02','2021-08-05'),('20210627232518','P008','K004',5,19,'2021-06-26','2021-06-27'),('20210805150525','P009','K004',14,54,'2021-08-05','2021-08-05'),('20210805153848','P007','K005',73,281,'2021-07-07','2021-08-05'),('20210805211713','P002','K005',36,139,'2021-08-05','2021-08-05'),('20210806005743','P0010','K006',19,73,'2021-08-05','2021-08-05');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` char(4) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `level` char(16) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('U001','Liam Moore','admin','$2a$12$agPGh9aPpADCGi8HlvOYUeOsy2Yp.vaVmoAIT6hMO1x/wFZrKWf16','superuser');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-05 23:07:53
