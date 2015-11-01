-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: GestionSalles
-- ------------------------------------------------------
-- Server version	5.5.44-0+deb8u1

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
-- Database
--

DROP DATABASE IF EXISTS GestionSalles;
CREATE DATABASE GestionSalles CHARSET=UTF8;
USE GestionSalles;


--
-- Table structure for table `Autorise`
--

DROP TABLE IF EXISTS `Autorise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Autorise` (
  `identifiant_salarie_res` smallint(6) NOT NULL,
  `identifiant_salarie_aut` smallint(6) NOT NULL,
  PRIMARY KEY (`identifiant_salarie_res`,`identifiant_salarie_aut`),
  KEY `identifiant_salarie_aut` (`identifiant_salarie_aut`),
  CONSTRAINT `Autorise_ibfk_1` FOREIGN KEY (`identifiant_salarie_res`) REFERENCES `Salarie` (`identifiant`),
  CONSTRAINT `Autorise_ibfk_2` FOREIGN KEY (`identifiant_salarie_aut`) REFERENCES `Salarie` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autorise`
--

LOCK TABLES `Autorise` WRITE;
/*!40000 ALTER TABLE `Autorise` DISABLE KEYS */;
/*!40000 ALTER TABLE `Autorise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Disponibilite`
--

DROP TABLE IF EXISTS `Disponibilite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Disponibilite` (
  `identifiant` smallint(6) NOT NULL AUTO_INCREMENT,
  `horaire_deb_matin` time NOT NULL,
  `horaire_fin_matin` time NOT NULL,
  `horaire_deb_soir` time NOT NULL,
  `horaire_fin_soir` time NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Disponibilite`
--

LOCK TABLES `Disponibilite` WRITE;
/*!40000 ALTER TABLE `Disponibilite` DISABLE KEYS */;
/*!40000 ALTER TABLE `Disponibilite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jour`
--

DROP TABLE IF EXISTS `Jour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Jour` (
  `identifiant` smallint(6) NOT NULL AUTO_INCREMENT,
  `jour` varchar(50) NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jour`
--

LOCK TABLES `Jour` WRITE;
/*!40000 ALTER TABLE `Jour` DISABLE KEYS */;
/*!40000 ALTER TABLE `Jour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reserve`
--

DROP TABLE IF EXISTS `Reserve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reserve` (
  `horaire_deb_res` time NOT NULL,
  `horaire_fin_res` time NOT NULL,
  `identifiant_terminal` smallint(6) NOT NULL,
  `identifiant_salarie` smallint(6) NOT NULL,
  `identifiant_jour` smallint(6) NOT NULL,
  PRIMARY KEY (`identifiant_terminal`,`identifiant_salarie`,`identifiant_jour`),
  KEY `identifiant_jour` (`identifiant_jour`),
  KEY `identifiant_salarie` (`identifiant_salarie`),
  CONSTRAINT `Reserve_ibfk_1` FOREIGN KEY (`identifiant_terminal`) REFERENCES `Terminal` (`identifiant`),
  CONSTRAINT `Reserve_ibfk_2` FOREIGN KEY (`identifiant_jour`) REFERENCES `Jour` (`identifiant`),
  CONSTRAINT `Reserve_ibfk_3` FOREIGN KEY (`identifiant_salarie`) REFERENCES `Salarie` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reserve`
--

LOCK TABLES `Reserve` WRITE;
/*!40000 ALTER TABLE `Reserve` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reserve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Salarie`
--

DROP TABLE IF EXISTS `Salarie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Salarie` (
  `identifiant` smallint(6) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `badge` varchar(50) NOT NULL,
  `est_admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Salarie`
--

LOCK TABLES `Salarie` WRITE;
/*!40000 ALTER TABLE `Salarie` DISABLE KEYS */;
/*!40000 ALTER TABLE `Salarie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Schedule`
--

DROP TABLE IF EXISTS `Schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Schedule` (
  `identifiant_jour` smallint(6) NOT NULL,
  `identifiant_disponibilite` smallint(6) NOT NULL,
  PRIMARY KEY (`identifiant_jour`,`identifiant_disponibilite`),
  KEY `identifiant_disponibilite` (`identifiant_disponibilite`),
  CONSTRAINT `Schedule_ibfk_1` FOREIGN KEY (`identifiant_jour`) REFERENCES `Jour` (`identifiant`),
  CONSTRAINT `Schedule_ibfk_2` FOREIGN KEY (`identifiant_disponibilite`) REFERENCES `Disponibilite` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Schedule`
--

LOCK TABLES `Schedule` WRITE;
/*!40000 ALTER TABLE `Schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `Schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Terminal`
--

DROP TABLE IF EXISTS `Terminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Terminal` (
  `identifiant` smallint(6) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) NOT NULL,
  `nom_salle` varchar(50) NOT NULL,
  `nb_portes` tinyint(4) NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Terminal`
--

LOCK TABLES `Terminal` WRITE;
/*!40000 ALTER TABLE `Terminal` DISABLE KEYS */;
/*!40000 ALTER TABLE `Terminal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-01 20:07:31
