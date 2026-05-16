-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: plataforma_difusion_video
-- ------------------------------------------------------
-- Server version	8.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `codigo` int NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `lugar_residencia` varchar(30) NOT NULL,
  `nacionalidad` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (1,'Leonardo DiCaprio','1974-11-11','Los Angeles','Estadounidense'),(2,'Kate Winslet','1975-10-05','West Sussex','Británica'),(3,'Russell Crowe','1964-04-07','Sydney','Neozelandés'),(4,'Bryan Cranston','1956-03-07','Hollywood','Estadounidense'),(5,'Emilia Clarke','1986-10-23','London','Británica'),(6,'Tom Hardy','1977-09-15','London','Británica'),(7,'Ana Torres','1990-06-12','Madrid','Española');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `codigo` int NOT NULL,
  `titulo` varchar(35) NOT NULL,
  `director` varchar(25) NOT NULL,
  `año_estreno` int NOT NULL,
  `duracion` int NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'Inception','Christopher Nolan',2010,148),(2,'Titanic','James Cameron',1997,195),(3,'Gladiator','Ridley Scott',2000,155),(4,'Interstellar','Christopher Nolan',2014,169),(5,'Misterio en la Noche','Director X',2015,130);
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje_pelicula`
--

DROP TABLE IF EXISTS `personaje_pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje_pelicula` (
  `codigo_pelicula` int NOT NULL,
  `codigo_actor_P` int NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo_pelicula`,`codigo_actor_P`),
  KEY `codigo_ActorP_fk` (`codigo_actor_P`),
  CONSTRAINT `personaje_pelicula_ibfk_1` FOREIGN KEY (`codigo_pelicula`) REFERENCES `pelicula` (`codigo`),
  CONSTRAINT `personaje_pelicula_ibfk_2` FOREIGN KEY (`codigo_actor_P`) REFERENCES `actor` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje_pelicula`
--

LOCK TABLES `personaje_pelicula` WRITE;
/*!40000 ALTER TABLE `personaje_pelicula` DISABLE KEYS */;
INSERT INTO `personaje_pelicula` VALUES (1,1,'Cobb','Protagonista'),(1,4,'Cooper','Protagonista'),(2,1,'Jack Dawson','Protagonista'),(2,2,'Rose','Protagonista'),(3,3,'Maximus','Protagonista'),(5,7,'El Investigador','Protagonista');
/*!40000 ALTER TABLE `personaje_pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje_serie`
--

DROP TABLE IF EXISTS `personaje_serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje_serie` (
  `codigo_serie` int NOT NULL,
  `codigo_actor_S` int NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `episodios` int NOT NULL,
  `duracion` varchar(25) NOT NULL,
  PRIMARY KEY (`codigo_serie`,`codigo_actor_S`),
  KEY `codigos_ActoresS_fk` (`codigo_actor_S`),
  CONSTRAINT `personaje_serie_ibfk_1` FOREIGN KEY (`codigo_serie`) REFERENCES `serie` (`codigo`),
  CONSTRAINT `personaje_serie_ibfk_2` FOREIGN KEY (`codigo_actor_S`) REFERENCES `actor` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje_serie`
--

LOCK TABLES `personaje_serie` WRITE;
/*!40000 ALTER TABLE `personaje_serie` DISABLE KEYS */;
INSERT INTO `personaje_serie` VALUES (1,4,'Walter White','Protagonista',62,'Completa'),(2,5,'Daenerys Targaryen','Protagonista',62,'Completa'),(3,4,'Heisenberg','Secundario',10,'Incompleta');
/*!40000 ALTER TABLE `personaje_serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serie` (
  `codigo` int NOT NULL,
  `titulo` varchar(35) NOT NULL,
  `creador` varchar(25) NOT NULL,
  `años_emision` varchar(9) NOT NULL,
  `temporadas` int NOT NULL,
  `episodios` int NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
INSERT INTO `serie` VALUES (1,'Breaking Bad','Vince Gilligan','2008-2013',5,62),(2,'Game of Thrones','David Benioff','2011-2019',8,73),(3,'Dark','Baran bo Odar','2017-2020',3,26);
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-16 13:21:47
