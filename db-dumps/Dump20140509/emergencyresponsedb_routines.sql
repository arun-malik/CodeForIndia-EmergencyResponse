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

-- Dump completed on 2014-05-09 12:49:21
