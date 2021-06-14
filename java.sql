-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 14 juin 2021 à 12:46
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `java`
--

CREATE DATABASE IF NOT EXISTS java;

-- --------------------------------------------------------

--
-- Structure de la table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `idT` smallint(6) NOT NULL AUTO_INCREMENT,
  `NomC` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`idT`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `test`
--

INSERT INTO `test` (`idT`, `NomC`) VALUES
(1, 'Bonjour, Veuillez entrer votre nom'),
(2, 'Veuillez entrer votre ville');

-- --------------------------------------------------------

--
-- Structure de la table `testme`
--

DROP TABLE IF EXISTS `testme`;
CREATE TABLE IF NOT EXISTS `testme` (
  `idT` smallint(6) NOT NULL AUTO_INCREMENT,
  `NomT` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `DoneT` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idT`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `testme`
--

INSERT INTO `testme` (`idT`, `NomT`, `DoneT`) VALUES
(1, 'Install NOTEPAD++', 1),
(2, 'Install CODEBLOCKS', 1),
(3, 'AVOID ECLIPSE AT ALL COSTS', 0),
(4, 'Testing text', 1),
(10, 'Test \'Toggle Done\' function', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
