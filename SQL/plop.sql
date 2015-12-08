-- MySQL dump 10.13  Distrib 5.6.21, for Win64 (x86_64)
--
-- Host: localhost    Database: gestionsalles
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `autorise`
--

DROP TABLE IF EXISTS `autorise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autorise` (
  `IdentifiantSalarie` smallint(6) NOT NULL,
  `IdentifiantReservation` int(11) NOT NULL,
  PRIMARY KEY (`IdentifiantSalarie`,`IdentifiantReservation`),
  KEY `FK_Autorise_Identifiant_Reservation` (`IdentifiantReservation`),
  CONSTRAINT `FK_Autorise_Identifiant_Reservation` FOREIGN KEY (`IdentifiantReservation`) REFERENCES `reservation` (`Identifiant`) ON DELETE CASCADE,
  CONSTRAINT `FK_Autorise_Identifiant_Salarie` FOREIGN KEY (`IdentifiantSalarie`) REFERENCES `salarie` (`Identifiant`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorise`
--

LOCK TABLES `autorise` WRITE;
/*!40000 ALTER TABLE `autorise` DISABLE KEYS */;
/*!40000 ALTER TABLE `autorise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disponibilite`
--

DROP TABLE IF EXISTS `disponibilite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disponibilite` (
  `IdentifiantJour` tinyint(4) NOT NULL,
  `IdentifiantSalle` smallint(6) NOT NULL,
  `HoraireDebMat` time NOT NULL,
  `HoraireFinMat` time NOT NULL,
  `HoraireDebSoir` time NOT NULL,
  `HoraireFinSoir` time NOT NULL,
  PRIMARY KEY (`IdentifiantJour`,`IdentifiantSalle`),
  KEY `FK_Disponibilite_Identifiant_Salle` (`IdentifiantSalle`),
  CONSTRAINT `FK_Disonibilite_Identifiant_Jour` FOREIGN KEY (`IdentifiantJour`) REFERENCES `jour` (`Identifiant`) ON DELETE CASCADE,
  CONSTRAINT `FK_Disponibilite_Identifiant_Salle` FOREIGN KEY (`IdentifiantSalle`) REFERENCES `salle` (`Identifiant`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disponibilite`
--

LOCK TABLES `disponibilite` WRITE;
/*!40000 ALTER TABLE `disponibilite` DISABLE KEYS */;
INSERT INTO `disponibilite` VALUES (1,1,'19:00:00','03:00:22','00:00:00','00:37:00'),(2,1,'08:54:41','13:54:42','03:54:45','05:54:46');
/*!40000 ALTER TABLE `disponibilite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historiqueacces`
--

DROP TABLE IF EXISTS `historiqueacces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historiqueacces` (
  `IdentifiantSalarie` smallint(6) NOT NULL,
  `IdentifiantSalle` smallint(6) NOT NULL,
  `DateAcces` datetime NOT NULL,
  `Autorise` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdentifiantSalarie`,`IdentifiantSalle`,`DateAcces`),
  KEY `FK_HistoriqueAcces_Identifiant_Salle` (`IdentifiantSalle`),
  CONSTRAINT `FK_HistoriqueAcces_Identifiant_Salarie` FOREIGN KEY (`IdentifiantSalarie`) REFERENCES `salarie` (`Identifiant`),
  CONSTRAINT `FK_HistoriqueAcces_Identifiant_Salle` FOREIGN KEY (`IdentifiantSalle`) REFERENCES `salle` (`Identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historiqueacces`
--

LOCK TABLES `historiqueacces` WRITE;
/*!40000 ALTER TABLE `historiqueacces` DISABLE KEYS */;
INSERT INTO `historiqueacces` VALUES (10,1,'2015-12-05 16:51:06',0),(10,2,'2015-12-07 12:21:02',1);
/*!40000 ALTER TABLE `historiqueacces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jour`
--

DROP TABLE IF EXISTS `jour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jour` (
  `Identifiant` tinyint(4) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jour`
--

LOCK TABLES `jour` WRITE;
/*!40000 ALTER TABLE `jour` DISABLE KEYS */;
INSERT INTO `jour` VALUES (1,'Lundi'),(2,'Mardi');
/*!40000 ALTER TABLE `jour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `Identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `DateRes` date NOT NULL,
  `HoraireDeb` time NOT NULL,
  `HoraireFin` time NOT NULL,
  `IdentifiantJour` tinyint(4) NOT NULL,
  `IdentifiantSalarie` smallint(6) NOT NULL,
  `IdentifiantSalle` smallint(6) NOT NULL,
  PRIMARY KEY (`Identifiant`),
  KEY `FK_Reservation_Identifiant_Jour` (`IdentifiantJour`),
  KEY `FK_Reservation_Identifiant_Salarie` (`IdentifiantSalarie`),
  KEY `FK_Reservation_Identifiant_Salle` (`IdentifiantSalle`),
  CONSTRAINT `FK_Reservation_Identifiant_Jour` FOREIGN KEY (`IdentifiantJour`) REFERENCES `jour` (`Identifiant`),
  CONSTRAINT `FK_Reservation_Identifiant_Salarie` FOREIGN KEY (`IdentifiantSalarie`) REFERENCES `salarie` (`Identifiant`) ON DELETE CASCADE,
  CONSTRAINT `FK_Reservation_Identifiant_Salle` FOREIGN KEY (`IdentifiantSalle`) REFERENCES `salle` (`Identifiant`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salarie`
--

DROP TABLE IF EXISTS `salarie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salarie` (
  `Identifiant` smallint(6) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Badge` varchar(50) NOT NULL,
  `MotDePasse` varchar(150) NOT NULL,
  `EstAdmin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Identifiant`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salarie`
--

LOCK TABLES `salarie` WRITE;
/*!40000 ALTER TABLE `salarie` DISABLE KEYS */;
INSERT INTO `salarie` VALUES (8,'zefez','zef','zfez','',1),(9,'zefzfe','efzf','efzefz','',1),(10,'aaaaa','aaaa','aaa','',1),(11,'aaaaa','aaaa','aaaaa','',0),(12,'fscstg','hs','sthtr','',0),(13,'ugfjgt','trdhd','djdut','',0),(14,'dtcfghvjbj','xrdcfgvh bj','xtcfgvhbj','',1),(15,'frqeters','gsrg','gser','',0),(16,'yjfu','uyjhg','tyjhg','',0),(17,'eqe','erz','erz','',0),(18,'t','t','t','',0),(19,'zfeze','fez','zefz','',0),(20,'zadza','dazza','zdza','',0),(21,'zef','ezf','ezf','',0),(22,'ezf','zef','ezf','',0),(23,'ze','ezf','zef','',0),(24,'rerere','rgrgeg','grggrz','',0),(25,'ezfqe','zeez','ezafazf','',0),(26,'tz','e','e','',1),(27,'ez','ez','ee','',0),(28,'ez','ez','eee','',1),(29,'SENE','Massambaaa','0125','0144414401',1),(30,'SENE','Aminata','123','[B@57627c5f',1),(33,'erqre','reqg','456','01010414',0);
/*!40000 ALTER TABLE `salarie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salle` (
  `Identifiant` smallint(6) NOT NULL AUTO_INCREMENT,
  `NumeroTerminal` varchar(50) NOT NULL,
  `NomSalle` varchar(50) NOT NULL,
  `NombrePortes` tinyint(4) NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salle`
--

LOCK TABLES `salle` WRITE;
/*!40000 ALTER TABLE `salle` DISABLE KEYS */;
INSERT INTO `salle` VALUES (1,'006','tata',5),(2,'002','Titi',1);
/*!40000 ALTER TABLE `salle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-08 14:44:03
