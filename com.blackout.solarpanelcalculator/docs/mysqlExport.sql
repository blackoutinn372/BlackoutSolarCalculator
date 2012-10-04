CREATE DATABASE  IF NOT EXISTS `solar` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `solar`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: solar
-- ------------------------------------------------------
-- Server version	5.1.59-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `states` (
  `StateCode` char(6) NOT NULL,
  `StateName` varchar(45) NOT NULL,
  `FeedInTariff` double NOT NULL,
  `AvgElectricityCost` double NOT NULL,
  `PostcodeMin` char(5) NOT NULL,
  `PostcodeMax` char(5) NOT NULL,
  PRIMARY KEY (`StateCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES ('ACT','Australian Capital Territory',20,20,'2600','2920'),('NSW','New South Wales',6,22.6,'2000','2999'),('NT','Northern Territory',20,19,'0800','0899'),('QLD','Queensland',44,25,'4000','4999'),('SA','South Australia',44,23,'5000','5799'),('TAS','Tasmania',20,23,'7000','7799'),('VIC','Victoria',60,25,'3000','3999'),('WA','Western Australia',7,20,'6000','6797');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `CityID` int(11) NOT NULL,
  `CityName` varchar(18) NOT NULL,
  `Postcode` char(6) NOT NULL,
  `ZoneRating` double DEFAULT NULL,
  `CapitalCity` char(6) NOT NULL DEFAULT 'False',
  `StateCode` char(6) NOT NULL,
  `OptimalYearRound` int(11) NOT NULL,
  `BestWinter` int(11) NOT NULL,
  `BestSummer` int(11) NOT NULL,
  `Jan` double NOT NULL,
  `Feb` double NOT NULL,
  `Mar` double NOT NULL,
  `Apr` double NOT NULL,
  `May` double NOT NULL,
  `Jun` double NOT NULL,
  `Jul` double NOT NULL,
  `Aug` double NOT NULL,
  `Sep` double NOT NULL,
  `Oct` double NOT NULL,
  `Nov` double NOT NULL,
  `Dec` double NOT NULL,
  `AvgProducePerkw` double DEFAULT NULL,
  PRIMARY KEY (`CityID`),
  KEY `StateCode` (`StateCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Sydney','2000',1.382,'True','NSW',56,41,71,5.91,5.25,4.48,3.56,2.73,2.49,2.68,3.49,4.6,5.41,5.88,6.24,3.9),(2,'Newcastle','2300',NULL,'false','NSW',57,42,72,6.21,5.47,4.69,3.77,2.87,2.62,2.82,3.66,4.37,5.63,6.08,6.49,NULL),(3,'Wollongong','2500',NULL,'false','NSW',56,41,71,6.19,5.44,4.64,3.53,2.68,2.34,2.58,3.34,4.48,5.42,6,6.44,NULL),(4,'Canberra','2600',1.382,'True','ACT',55,40,70,6.78,6.01,5,3.68,2.68,2.23,2.45,3.19,4.37,5.48,6.36,6.86,4.3),(5,'Melbourne','3000',1.185,'True','VIC',52,37,67,5.91,5.83,4.51,3.23,2.23,1.78,1.94,2.59,3.55,4.72,5.74,6.22,3.6),(6,'Geelong','3200',NULL,'false','VIC',52,37,67,6.41,5.78,4.44,3.12,2.17,1.81,1.99,2.68,3.78,5.03,6.03,6.39,NULL),(7,'Brisbane','4000',1.382,'True','QLD',58,43,73,6.19,5.39,4.95,3.98,3.23,3.02,3.22,4.04,5.12,5.52,6.07,6.35,4.2),(8,'Gold Coast','4217',NULL,'false','QLD',62,47,77,6.19,5.44,4.95,3.98,3.27,3.03,3.22,4.04,4.77,5.52,6.07,6.35,NULL),(9,'Toowoomba','4350',NULL,'false','QLD',62,47,77,6.69,5.8,5.31,4.31,3.49,3.26,3.47,4.38,5.52,5.99,6.59,6.82,NULL),(10,'Townsville','4810',NULL,'false','QLD',71,56,86,6.35,5.56,5.56,4.79,4.27,4,4.39,5.13,6.18,6.59,6.62,6.71,NULL),(11,'Cairns','4870',NULL,'false','QLD',73,58,88,5.83,5.18,5.07,4.81,4.35,4.24,4.47,5.07,5.98,6.59,6.5,6.27,4.2),(12,'Adelaide','5000',1.382,'True','SA',55,40,70,8.41,7.49,5.93,4.34,3.09,2.62,2.82,3.62,5.12,6.41,7.71,8.45,4.2),(13,'Perth','6000',1.382,'True','WA',58,43,73,8.41,7.49,5.93,4.34,3.09,2.62,2.82,3.62,5.04,6.41,7.71,8.45,4.4),(14,'Hobart','7000',1.185,'True','TAS',47,32,62,5.78,5.18,3.92,2.61,1.8,1.46,1.62,2.33,3.39,4.62,5.52,6,3.5),(15,'Darwin','0800',1.536,'True','NT',78,78,93,5.52,5.2,5.9,5.99,5.82,5.55,5.76,6.36,6.87,7.07,6.79,5.84,4.4),(16,'Alice Springs','0870',NULL,'False','NT',66,51,81,7.5,6.78,6.33,5.47,4.33,3.98,4.35,5.27,6.17,6.77,7.26,7.37,5),(17,'Burnie','7320',NULL,'False','TAS',49,34,64,5.8,5.25,3.91,2.54,1.73,1.38,1.54,2.16,3.17,4.36,5.49,5.99,NULL),(18,'Bendigo','3550',NULL,'False','VIC',53,38,68,7.07,6344,5.18,3.77,2.55,2.01,2.18,2.92,4.05,5.3,6.49,6.96,NULL),(19,'Albany','6330',NULL,'False','WA',55,40,70,6.88,6.16,4.71,3.51,2.52,2.2,2.36,2.93,4.01,5.04,6.07,6.81,NULL),(20,'Mount Gambier','5290',NULL,'False','SA',52,37,67,6.55,5.92,4.58,3.22,2.27,1.87,2.08,2.77,3.84,5.07,6.11,6.43,NULL);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solarproducts`
--

DROP TABLE IF EXISTS `solarproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solarproducts` (
  `ProductID` smallint(6) NOT NULL AUTO_INCREMENT,
  `Type` varchar(45) NOT NULL,
  `Brand` varchar(45) NOT NULL,
  `Descriptions` text NOT NULL,
  `Power` double NOT NULL,
  `Efficiency` double DEFAULT NULL,
  `Price` double NOT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=544 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solarproducts`
--

LOCK TABLES `solarproducts` WRITE;
/*!40000 ALTER TABLE `solarproducts` DISABLE KEYS */;
INSERT INTO `solarproducts` VALUES (12,'Inverters','Aurora','PVI-4.2-AU Outdoor Grid Connect  IP65 rated ',4200,0.96,2376),(20,'Inverters','Aurora','PVI-3.6-AU Outdoor Grid Connect IIP65 rated ',3600,0.97,1980),(21,'Solar panels','SolarOne',' 24V, 5 inch cell Monocrystalline Cell Solar Module',195,0.1512,418),(23,'Inverters','Fronius','IG TL 3.0 Indoor and Outdoor - ',3313,0.98,2046),(29,'Inverters','Aurora','PVI-2000-AU Outdoor Grid Connect  IP65 rated',2000,0.96,1174),(32,'Solar panels','REC Solar',' Peak Energy Series, polycrystalline cell Black Frame',250,0.151,412),(43,'Inverters','Fronius','IG15 Outdoor -  Grid Connect ',1500,0.94,1575),(44,'Solar panels','Sharp',' 12V Polycrystalline',130,0.1599,554),(45,'Solar panels','Panasonic',' HIT Solar Module',235,0.186,882),(543,'Solar panels','Suntech','12V Polycrystalline ',140,0.151,421);
/*!40000 ALTER TABLE `solarproducts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-03 18:31:55
