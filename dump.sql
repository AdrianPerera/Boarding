-- MySQL dump 10.13  Distrib 5.7.28, for Win64 (x86_64)
--
-- Host: localhost    Database: boarding
-- ------------------------------------------------------
-- Server version	5.7.28

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
-- Current Database: `boarding`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `boarding` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `boarding`;

--
-- Table structure for table `boarding`
--

DROP TABLE IF EXISTS `boarding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boarding` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `availability` bit(1) DEFAULT NULL,
  `no_of_rooms` int(11) DEFAULT NULL,
  `user_user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc9rwqsv1p07bjqyx5onummcyn` (`user_user_name`),
  CONSTRAINT `FKc9rwqsv1p07bjqyx5onummcyn` FOREIGN KEY (`user_user_name`) REFERENCES `user` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boarding`
--

LOCK TABLES `boarding` WRITE;
/*!40000 ALTER TABLE `boarding` DISABLE KEYS */;
INSERT INTO `boarding` VALUES (8,'Some address',_binary '',1,'adrian'),(10,'Some address',_binary '',3,'admin'),(11,'Some address',_binary '',3,'admin'),(12,'Some address',_binary '',3,'admin');
/*!40000 ALTER TABLE `boarding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (13);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `availability` bit(1) DEFAULT NULL,
  `no_of_beds` int(11) DEFAULT NULL,
  `boarding_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1c350yf2n91gqmi7999js9qbb` (`boarding_id`),
  CONSTRAINT `FK1c350yf2n91gqmi7999js9qbb` FOREIGN KEY (`boarding_id`) REFERENCES `boarding` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (4,_binary '',3,8),(5,_binary '',3,8),(6,_binary '',3,8),(10,_binary '',3,11),(11,_binary '',3,11),(12,_binary '',3,11),(13,_binary '',3,12),(14,_binary '',2,12),(15,_binary '',1,12),(16,_binary '',1,12);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_name` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin',_binary '','$2a$10$rgEar.YfGaTJ0SdSlG.DH.ap9LedrNErS1Kk/6R4gA7Jjr43o9Xby'),('adrian',_binary '','$2a$10$VahLds6wEhu0nPcVGghjgeYOihxolrG/Acf129ny8A/tMKA9T0Xqu');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-17  2:55:36
