-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: kriterienkatalog
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `auspraegungen`
--

DROP TABLE IF EXISTS `auspraegungen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auspraegungen` (
  `Auspr_id` int(11) NOT NULL,
  `Auspr_Nr` varchar(200) NOT NULL,
  `Auspr_Beschreibung` varchar(200) NOT NULL,
  `Krit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Auspr_id`),
  KEY `Krit_id` (`Krit_id`),
  CONSTRAINT `Krit_id` FOREIGN KEY (`Krit_id`) REFERENCES `kriterien` (`Krit_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auspraegungen`
--

LOCK TABLES `auspraegungen` WRITE;
/*!40000 ALTER TABLE `auspraegungen` DISABLE KEYS */;
INSERT INTO `auspraegungen` VALUES (1,'A11','Ja',1),(2,'A12','Nein',1),(3,'A21','Nötig',2),(4,'A22','Nicht nötig',2),(5,'A31','Nötig',3),(6,'A32','Nicht nötig',3),(7,'A41','Einstellenkontakt',4),(8,'A42','Mehrstellenkontakt: Ausrichten mehrerer Einzelelemente erforderlich',4),(9,'A43','Mehrstellenkontakt: System starr, Fügepassung > Werkstücktoleranz',4),(10,'A51','nicht erforderlich',5),(11,'A52','teilweise erforderlich',5),(12,'A61','nicht nötig',6),(13,'A62','von Mensch und Roboter durchführbar',6),(14,'A63','vom Menschen durchführbar, Robotersysteme benötigen Zusatzinvest',6),(15,'A64','vom Roboter durchführbar, Mensch benötigt Zusatzinvest',6),(16,'A71','kein Umrüstaufwand',7),(17,'A72','Umrüstaufwand nur bei Automatisierung',7),(18,'A73','Umrüstaufwand automatisiert < manuell',7),(19,'A74','Umrüstaufwand automatisiert > manuell',7),(20,'A75','Umrüstaufwand automatisiert = manuell',7),(21,'A81','durch Bauteilgeometrie erzwungen',8),(22,'A82','durch Führung Fügewerkzeug',8),(23,'A91','Spielpassung',9),(24,'A92','Grenzpassung',9),(25,'A93','Übernaßpassung (ist jeweils nur durch Einlegen in eine Pressvorrichtung möglich)',9),(26,'A101','nicht nötig',10),(27,'A102','visuelle Unterstützung nötig',10),(28,'A103','taktile Unterstützung nötig',10),(29,'A111','unschädlich',11),(30,'A112','bei Berührung',11),(31,'A113','bei Gegenwart',11),(32,'A121','aktuelle zulässige MAK-Werte nicht überschritten',12),(33,'A122','aktuelle zulässige MAK-Werte  überschritten',12),(34,'A131','T < 0 °C',13),(35,'A132','0 °C <  T <  44 °C',13),(36,'A133','T >= 44 °C',13),(37,'A141','gering',14),(38,'A142','mittel',14),(39,'A143','hoch',14),(40,'A151','LR < 85 dB(A)',15),(41,'A152','85 dB(A) < LR < 90 dB(A)',15),(42,'A153','LR > 90 dB(A)',15),(43,'A161','Sichtkontrolle und Werkzeugfreiräume gegeben',16),(44,'A162','keine Sichtkontrolle möglich, Werkzeugfreiräume gegeben',16),(45,'A163','Sichtkontrolle gegeben, keine Werkzeugfreiräume vorhanden',16),(46,'A164','keine Sichtkontrolle möglich, keine Werkzeugfreiräume vorhanden',16),(47,'A171','gegeben',17),(48,'A172','nicht gegeben',17),(49,'A181','Material unempfindlich',18),(50,'A182','Material kratz-, bruch-, formempfindlich',18),(51,'A191','starr',19),(52,'A192','elastisch',19),(53,'A193','biegeschlaff',19),(54,'A201','starr',20),(55,'A202','elastisch',20),(56,'A203','biegeschlaff',20),(57,'A211','ja ( Korrektur von Bauteilposition, Bauteilorientierung, Fügeposition, Fügeorientierung)',21),(58,'A212','nein',21),(59,'A221','positioniert und orientiert bereitgestellt',22),(60,'A222','einfach und prozesssicher automatisierbar',22),(61,'A223','nicht prozesssicher automatisierbar',22);
/*!40000 ALTER TABLE `auspraegungen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kriterien`
--

DROP TABLE IF EXISTS `kriterien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kriterien` (
  `Krit_id` int(11) NOT NULL,
  `Krit_Nr` varchar(45) DEFAULT NULL,
  `Krit_Beschreibung` varchar(255) CHARACTER SET cp1250 DEFAULT NULL,
  PRIMARY KEY (`Krit_id`),
  UNIQUE KEY `Krit_Nr_UNIQUE` (`Krit_Nr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kriterien`
--

LOCK TABLES `kriterien` WRITE;
/*!40000 ALTER TABLE `kriterien` DISABLE KEYS */;
INSERT INTO `kriterien` VALUES (1,'K1','Möglichkeit des Verhakens beim Fügen'),(2,'K2','Während des Fügens Parallelprozess sichern'),(3,'K3','Sichern nach dem Fügen'),(4,'K4','Kontakt Werkstück / Fügeteile (einzelne Bauteile sollen zueinander eine möglichst geringe Anzahl Fügestellen haben)'),(5,'K5','Zusätzliche Prozessschritte durch Anpassarbeiten (z.B. Durch mangelnde Bauteilqualität)'),(6,'K6','Prozesskontrolle, sensorische'),(7,'K7','Umrüstaufwand für Prozesseinrichtung'),(8,'K8','Fügebewegung (möglichst einfach)'),(9,'K9','Fügepassungen'),(10,'K10','Sensorische Unterstützung des Prozesses Fähigkeiten'),(11,'K11','Hilfs-/ Betriebs-/ Werkstoffe gesundheitsschädlich'),(12,'K12','Schadstoffeinwirkung von Luftinhaltsstoffen ( Stäube, Rauche, Nebel, Gase, Dämpfe,…)'),(13,'K13','Bauteiltemperatur'),(14,'K14','Physiologische Dauerbelastung des Menschen bei schwerer dynamischer Muskelarbeit'),(15,'K15','Lärmbelästigung am Arbeitsplatz'),(16,'K16','Zugänglichkeit des Fügeorts'),(17,'K17','Greif- und/oder Zentriermöglichkeiten der Bauteile'),(18,'K18','Oberflächenempfindlichkeit des Bauteils'),(19,'K19','Steifigkeit des Fügeteils'),(20,'K20','Steifigkeit des Basisteils'),(21,'K21','Prozessanpassung aufgrund der Bauteiltoleranz'),(22,'K22','Bereitstellung der Basis- /Fügeteile');
/*!40000 ALTER TABLE `kriterien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projekte`
--

DROP TABLE IF EXISTS `projekte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projekte` (
  `idProjekte` int(11) NOT NULL AUTO_INCREMENT,
  `Projekt_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idProjekte`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projekte`
--

LOCK TABLES `projekte` WRITE;
/*!40000 ALTER TABLE `projekte` DISABLE KEYS */;
INSERT INTO `projekte` VALUES (1,'test1'),(2,'test2'),(3,'test3'),(4,'test4');
/*!40000 ALTER TABLE `projekte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `used_auspr`
--

DROP TABLE IF EXISTS `used_auspr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `used_auspr` (
  `idused_Auspr` int(11) NOT NULL,
  PRIMARY KEY (`idused_Auspr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `used_auspr`
--

LOCK TABLES `used_auspr` WRITE;
/*!40000 ALTER TABLE `used_auspr` DISABLE KEYS */;
/*!40000 ALTER TABLE `used_auspr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `used_krits`
--

DROP TABLE IF EXISTS `used_krits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `used_krits` (
  `idused_Krits` int(11) NOT NULL,
  PRIMARY KEY (`idused_Krits`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `used_krits`
--

LOCK TABLES `used_krits` WRITE;
/*!40000 ALTER TABLE `used_krits` DISABLE KEYS */;
/*!40000 ALTER TABLE `used_krits` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-09 12:13:04
