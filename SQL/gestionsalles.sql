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

--Création DB
CREATE DATABASE gestionsalles CHARACTER SET utf8 COLLATE utf8_bin;
use gestionsalles;

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
  CONSTRAINT `FK_Autorise_Identifiant_Reservation` FOREIGN KEY (`IdentifiantReservation`) REFERENCES `reservation` (`Identifiant`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Autorise_Identifiant_Salarie` FOREIGN KEY (`IdentifiantSalarie`) REFERENCES `salarie` (`Identifiant`) ON DELETE CASCADE ON UPDATE CASCADE
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
INSERT INTO `disponibilite` VALUES (1,1,'08:00:00','12:00:00','14:00:00','17:00:04'),(1,2,'08:00:00','12:00:00','14:00:00','17:00:04'),(2,1,'08:00:00','12:00:00','14:00:00','17:00:04'),(2,2,'08:00:00','12:00:00','14:00:00','17:00:04'),(3,1,'08:00:00','12:00:00','14:00:00','17:00:04'),(3,2,'08:00:00','12:00:00','14:00:00','17:00:04'),(4,1,'08:00:00','12:00:00','14:00:00','17:00:04'),(4,2,'08:00:00','12:00:00','14:00:00','17:00:04'),(5,1,'08:00:00','12:00:00','14:00:00','17:00:04'),(5,2,'08:00:00','12:00:00','14:00:00','17:00:04'),(6,1,'08:00:00','12:00:00','14:00:00','17:00:04'),(6,2,'08:00:00','12:00:00','14:00:00','17:00:04'),(7,1,'08:00:00','12:00:00','14:00:00','17:00:04'),(7,2,'08:00:00','12:00:00','14:00:00','17:00:04');
/*!40000 ALTER TABLE `disponibilite` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Tr_Disponibilite AFTER UPDATE

ON Disponibilite FOR EACH ROW


BEGIN
	
	 DECLARE idResa SMALLINT;
	 DECLARE dateResa DATE;
	 DECLARE heureDebResa TIME;
	 DECLARE heureFinResa TIME;
    DECLARE fin TINYINT DEFAULT 0;   
    

   
	
    
    DECLARE curs_resa CURSOR

        FOR SELECT Identifiant, DateRes, HoraireDeb, HoraireFin

        FROM Reservation 
        
        WHERE Reservation.IdentifiantSalle = NEW.IdentifiantSalle AND DAYOFWEEK(DateRes) = (SELECT NumJour FROM Jour INNER JOIN Disponibilite ON Jour.Identifiant = Disponibilite.IdentifiantJour WHERE Disponibilite.IdentifiantJour = NEW.IdentifiantJour);


    

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1; 


    OPEN curs_resa;                                    


    loop_curseur: LOOP                                                

        FETCH curs_resa INTO idResa, dateResa, heureDebResa, heureFinResa;

             
               
		   IF (TIMESTAMPDIFF(MINUTE,NEW.HoraireDebMat, heureDebResa) < 0 OR TIMESTAMPDIFF(MINUTE,NEW.HoraireFinMat,heureFinResa) > 0 OR TIMESTAMPDIFF(MINUTE,NEW.HoraireDebSoir, heureDebResa) < 0 OR TIMESTAMPDIFF(MINUTE,NEW.HoraireFinSoir,heureFinResa) > 0) THEN
	           
				DELETE FROM Reservation WHERE Identifiant = idResa;
				
			END IF;
        

        IF fin = 1 THEN 

            LEAVE loop_curseur;

        END IF;


    END LOOP;


    CLOSE curs_resa; 

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
INSERT INTO `historiqueacces` VALUES (2,1,'2015-12-10 11:00:00',1),(2,2,'2015-12-10 00:34:10',0);
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
  `NumJour` int(11) NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jour`
--

LOCK TABLES `jour` WRITE;
/*!40000 ALTER TABLE `jour` DISABLE KEYS */;
INSERT INTO `jour` VALUES (1,'Lundi',2),(2,'Mardi',3),(3,'Mercredi',4),(4,'Jeudi',5),(5,'Vendredi',6),(6,'Samedi',7),(7,'Dimanche',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salarie`
--

LOCK TABLES `salarie` WRITE;
/*!40000 ALTER TABLE `salarie` DISABLE KEYS */;
INSERT INTO `salarie` VALUES (1,'KELOUD','Yann','0123','1144010000',1),(2,'SENE','Massamba','4567','000400',0);
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
  PRIMARY KEY (`Identifiant`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salle`
--

LOCK TABLES `salle` WRITE;
/*!40000 ALTER TABLE `salle` DISABLE KEYS */;
INSERT INTO `salle` VALUES (1,'001','Salle1'),(2,'002','Salle2');
/*!40000 ALTER TABLE `salle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gestionsalles'
--
/*!50003 DROP PROCEDURE IF EXISTS `ProcStockPassageBadge` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ProcStockPassageBadge`(IN IdSalarie INT, IN IdSalle INT )
BEGIN 
	DECLARE fin TINYINT DEFAULT 0;
	DECLARE Ouvrir INT DEFAULT 0;
	
        SET Ouvrir = ( SELECT COUNT(Identifiant)
		FROM Reservation 
		INNER JOIN autorise ON autorise.IdentifiantReservation = Reservation.Identifiant
        WHERE Reservation.IdentifiantSalarie=IdSalarie OR Autorise.IdentifiantSalarie = Idsalarie AND DateRes = NOW() AND TIMESTAMPDIFF(MINUTE,NOW(), HoraireDeb) <= 0 AND TIMESTAMPDIFF(MINUTE,NOW(),HoraireFin) >= 0);
	
	IF Ouvrir = 0 THEN
	INSERT INTO historiqueacces(IdentifiantSalarie, IdentifiantSalle, DateAcces, Autorise) VALUES (IdSalarie, IdSalle, NOW(), 0);
	SELECT Ouvrir as Test;
	ELSE
	INSERT INTO historiqueacces(IdentifiantSalarie, IdentifiantSalle, DateAcces, Autorise) VALUES (IdSalarie, IdSalle, NOW(), 1);
	SELECT Ouvrir as Ouverture;
	END IF;
	
   END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-10  0:41:15
