CREATE DATABASE  IF NOT EXISTS `emergencyresponsedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `emergencyresponsedb`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: emergencyresponsedb
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminKey` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(55) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`adminKey`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'arun','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidentReported`
--

DROP TABLE IF EXISTS `incidentReported`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidentReported` (
  `incidentReportedKey` int(11) NOT NULL AUTO_INCREMENT,
  `userKey` int(11) DEFAULT NULL,
  `lat` varchar(55) DEFAULT NULL,
  `long` varchar(55) DEFAULT NULL,
  `reportedMessage` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`incidentReportedKey`),
  KEY `incidentReportedUserDetailsUserKey_idx` (`userKey`),
  CONSTRAINT `incidentReportedUserDetailsUserKey` FOREIGN KEY (`userKey`) REFERENCES `userDeatils` (`userDeatilsKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidentReported`
--

LOCK TABLES `incidentReported` WRITE;
/*!40000 ALTER TABLE `incidentReported` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidentReported` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificationHistory`
--

DROP TABLE IF EXISTS `notificationHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificationHistory` (
  `notificationHistoryKey` int(11) NOT NULL AUTO_INCREMENT,
  `adminKey` int(11) DEFAULT NULL,
  `channelKey` varchar(55) DEFAULT NULL,
  `messageText` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`notificationHistoryKey`),
  KEY `notificationHistoryAdminKey_idx` (`adminKey`),
  CONSTRAINT `notificationHistoryAdminKey` FOREIGN KEY (`adminKey`) REFERENCES `admin` (`adminKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificationHistory`
--

LOCK TABLES `notificationHistory` WRITE;
/*!40000 ALTER TABLE `notificationHistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificationHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracking`
--

DROP TABLE IF EXISTS `tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tracking` (
  `trackingKey` int(11) NOT NULL AUTO_INCREMENT,
  `userDetailsKey` int(11) DEFAULT NULL,
  `lat` varchar(50) DEFAULT NULL,
  `long` varchar(50) DEFAULT NULL,
  `modifiedDateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `accuracyRadius` int(11) DEFAULT '0',
  PRIMARY KEY (`trackingKey`),
  KEY `userDetailKey_idx` (`userDetailsKey`),
  CONSTRAINT `trackingUserDetailKey` FOREIGN KEY (`userDetailsKey`) REFERENCES `userDeatils` (`userDeatilsKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracking`
--

LOCK TABLES `tracking` WRITE;
/*!40000 ALTER TABLE `tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `tracking` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tracking_AINS` AFTER INSERT ON `tracking` FOR EACH ROW

BEGIN

INSERT INTO `emergencyresponsedb`.`trackingHistory`
(
`trackingKey`,
`userDetailsKey`,
`lat`,
`long`,
`modifiedDateTime`,
`accuracyRadius`,
`triggerAction`)
VALUES
(
NEW.trackingKey,
NEW.userDetailsKey,
NEW.lat,
NEW.long,
NEW.modifiedDateTime,
NEW.accuracyRadius,
'INSERTED');

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tracking_AUPD` AFTER UPDATE ON `tracking` FOR EACH ROW
begin

UPDATE `emergencyresponsedb`.`trackingHistory`
SET

`trackingKey` = NEW.trackingKey,
`userDetailsKey` = NEW.userDetailsKey,
`lat` = NEW.lat,
`long` = NEW.long,
`modifiedDateTime` = NEW.modifiedDateTime,
`accuracyRadius` =NEW.accuracyRadius,
`triggerAction` = 'UPDATED';

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `trackingHistory`
--

DROP TABLE IF EXISTS `trackingHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trackingHistory` (
  `trackingHistoryKey` int(11) NOT NULL AUTO_INCREMENT,
  `trackingKey` int(11) NOT NULL,
  `userDetailsKey` int(11) DEFAULT NULL,
  `lat` varchar(50) DEFAULT NULL,
  `long` varchar(50) DEFAULT NULL,
  `modifiedDateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `accuracyRadius` int(11) DEFAULT '0',
  `triggerAction` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trackingHistoryKey`),
  KEY `userDetailKey_idx` (`userDetailsKey`),
  CONSTRAINT `trackingHistoryuserDetailKey` FOREIGN KEY (`userDetailsKey`) REFERENCES `userDeatils` (`userDeatilsKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trackingHistory`
--

LOCK TABLES `trackingHistory` WRITE;
/*!40000 ALTER TABLE `trackingHistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `trackingHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userDeatils`
--

DROP TABLE IF EXISTS `userDeatils`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userDeatils` (
  `userDeatilsKey` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(55) DEFAULT NULL,
  `lastName` varchar(55) DEFAULT NULL,
  `fathersName` varchar(55) DEFAULT NULL,
  `mothersName` varchar(55) DEFAULT NULL,
  `mobileNumber` bigint(20) DEFAULT NULL,
  `emergencyContactName` varchar(55) DEFAULT NULL,
  `emergencyContactNumber` bigint(20) DEFAULT NULL,
  `bloodGroup` varchar(45) DEFAULT NULL,
  `fellowPassengerCount` int(11) DEFAULT NULL,
  `trackStatus` bit(1) DEFAULT b'0',
  `modifiedDateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userDeatilsKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userDeatils`
--

LOCK TABLES `userDeatils` WRITE;
/*!40000 ALTER TABLE `userDeatils` DISABLE KEYS */;
/*!40000 ALTER TABLE `userDeatils` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vwuserdetails`
--

DROP TABLE IF EXISTS `vwuserdetails`;
/*!50001 DROP VIEW IF EXISTS `vwuserdetails`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vwuserdetails` (
  `userDeatilsKey` tinyint NOT NULL,
  `userCode` tinyint NOT NULL,
  `firstName` tinyint NOT NULL,
  `lastName` tinyint NOT NULL,
  `fathersName` tinyint NOT NULL,
  `mothersName` tinyint NOT NULL,
  `mobileNumber` tinyint NOT NULL,
  `emergencyContactName` tinyint NOT NULL,
  `emergencyContactNumber` tinyint NOT NULL,
  `bloodGroup` tinyint NOT NULL,
  `fellowPassengerCount` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vwuserdetails`
--

/*!50001 DROP TABLE IF EXISTS `vwuserdetails`*/;
/*!50001 DROP VIEW IF EXISTS `vwuserdetails`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vwuserdetails` AS select `userdeatils`.`userDeatilsKey` AS `userDeatilsKey`,(case when isnull(`userdeatils`.`mobileNumber`) then (((`userdeatils`.`firstName` + `userdeatils`.`lastName`) + `userdeatils`.`fathersName`) + `userdeatils`.`mothersName`) else `userdeatils`.`mobileNumber` end) AS `userCode`,`userdeatils`.`firstName` AS `firstName`,`userdeatils`.`lastName` AS `lastName`,`userdeatils`.`fathersName` AS `fathersName`,`userdeatils`.`mothersName` AS `mothersName`,`userdeatils`.`mobileNumber` AS `mobileNumber`,`userdeatils`.`emergencyContactName` AS `emergencyContactName`,`userdeatils`.`emergencyContactNumber` AS `emergencyContactNumber`,`userdeatils`.`bloodGroup` AS `bloodGroup`,`userdeatils`.`fellowPassengerCount` AS `fellowPassengerCount` from `userdeatils` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-09 17:21:02
