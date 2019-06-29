-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fatih
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `kayit`
--

DROP TABLE IF EXISTS `kayit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `kayit` (
  `Kalori` int(11) NOT NULL,
  `Protein` int(11) NOT NULL,
  `Yag` int(11) NOT NULL,
  `Karbonhidrat` int(11) NOT NULL,
  PRIMARY KEY (`Kalori`,`Protein`,`Yag`,`Karbonhidrat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kayit`
--

LOCK TABLES `kayit` WRITE;
/*!40000 ALTER TABLE `kayit` DISABLE KEYS */;
/*!40000 ALTER TABLE `kayit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yemekler`
--

DROP TABLE IF EXISTS `yemekler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `yemekler` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Yemek` varchar(45) NOT NULL,
  `Kalori` int(11) NOT NULL,
  `Protein` int(11) NOT NULL,
  `Yag` int(11) NOT NULL,
  `Karbonhidrat` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`Yemek`,`Kalori`,`Protein`,`Yag`,`Karbonhidrat`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yemekler`
--

LOCK TABLES `yemekler` WRITE;
/*!40000 ALTER TABLE `yemekler` DISABLE KEYS */;
INSERT INTO `yemekler` VALUES (1,'et',120,22,2,0),(2,'patates',100,50,20,10),(3,'havuc',100,50,120,10),(4,'lale',1,2,2,2),(5,'hindi',150,22,15,0),(6,'brokoli',50,10,4,4),(7,'tavuk',150,22,10,0),(8,'domates',100,5,2,10),(9,'bulgur',100,5,4,50),(10,'salatalık',100,4,4,56),(11,'peynir',100,40,1,2),(12,'zeytin',100,50,2,4),(13,'bal',150,2,3,4),(14,'karpuz',100,20,5,1),(15,'su',0,0,0,0),(16,'kavun',19,19,19,10);
/*!40000 ALTER TABLE `yemekler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-29 17:58:00
