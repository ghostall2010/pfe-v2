-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 14 juin 2020 à 15:25
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pfe-v2`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` bigint(20) NOT NULL,
  `COEFFISSION` double DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `ETATCOURS_ID` bigint(20) DEFAULT NULL,
  `MODULE_ID` bigint(20) DEFAULT NULL,
  `NIVEAUDIFFECULTE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_COURS_MODULE_ID` (`MODULE_ID`),
  KEY `FK_COURS_NIVEAUDIFFECULTE_ID` (`NIVEAUDIFFECULTE_ID`),
  KEY `FK_COURS_ETATCOURS_ID` (`ETATCOURS_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID`, `COEFFISSION`, `DESCRIPTION`, `NOM`, `ETATCOURS_ID`, `MODULE_ID`, `NIVEAUDIFFECULTE_ID`) VALUES
(204, 12, 'cours1', 'cours1', 54, 202, 51),
(205, 10, 'cours 2', 'cours 2', 54, 202, 53),
(206, 9, 'cours 3', 'cours 3', 56, 203, 53),
(207, 7, 'cours 4', 'cours 4', 55, 203, 52);

-- --------------------------------------------------------

--
-- Structure de la table `coursinscription`
--

DROP TABLE IF EXISTS `coursinscription`;
CREATE TABLE IF NOT EXISTS `coursinscription` (
  `ID` bigint(20) NOT NULL,
  `DATEINSCRIPTION` date DEFAULT NULL,
  `COURS_ID` bigint(20) DEFAULT NULL,
  `INSCRIPTION_ID` bigint(20) DEFAULT NULL,
  `MODULEINSCRIPTION_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_COURSINSCRIPTION_COURS_ID` (`COURS_ID`),
  KEY `FK_COURSINSCRIPTION_INSCRIPTION_ID` (`INSCRIPTION_ID`),
  KEY `FK_COURSINSCRIPTION_MODULEINSCRIPTION_ID` (`MODULEINSCRIPTION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etatcours`
--

DROP TABLE IF EXISTS `etatcours`;
CREATE TABLE IF NOT EXISTS `etatcours` (
  `ID` bigint(20) NOT NULL,
  `COLOR` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etatcours`
--

INSERT INTO `etatcours` (`ID`, `COLOR`, `LIBELLE`) VALUES
(1, 'red', 'termine avec s'),
(54, 'green', 'pas encore demare'),
(55, 'red', 'echeque'),
(56, 'yellow', 'en cours');

-- --------------------------------------------------------

--
-- Structure de la table `etatinscription`
--

DROP TABLE IF EXISTS `etatinscription`;
CREATE TABLE IF NOT EXISTS `etatinscription` (
  `ID` bigint(20) NOT NULL,
  `COLOR` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etatinscription`
--

INSERT INTO `etatinscription` (`ID`, `COLOR`, `LIBELLE`) VALUES
(57, 'green', 'terminer'),
(58, 'blue', 'demarer');

-- --------------------------------------------------------

--
-- Structure de la table `etatmodule`
--

DROP TABLE IF EXISTS `etatmodule`;
CREATE TABLE IF NOT EXISTS `etatmodule` (
  `ID` bigint(20) NOT NULL,
  `COLOR` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fillier`
--

DROP TABLE IF EXISTS `fillier`;
CREATE TABLE IF NOT EXISTS `fillier` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PARCOURS_ID` bigint(20) DEFAULT NULL,
  `RESPONSABLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_FILLIER_PARCOURS_ID` (`PARCOURS_ID`),
  KEY `FK_FILLIER_RESPONSABLE_ID` (`RESPONSABLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fillier`
--

INSERT INTO `fillier` (`ID`, `DESCRIPTION`, `NOM`, `PARCOURS_ID`, `RESPONSABLE_ID`) VALUES
(151, 'Ingénierie des Applications Mobiles', 'Ingénierie des Applications Mobiles', 59, 101),
(152, 'Ingénierie App', 'Ingénierie App', 59, 101),
(153, 'Ingénierie B', 'Ingénierie B', 60, 101),
(154, 'Ingénierie E', 'Ingénierie E', 60, 101);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `ID` bigint(20) NOT NULL,
  `DATEINSCRIPTION` date DEFAULT NULL,
  `ETATINSCRIPTION_ID` bigint(20) DEFAULT NULL,
  `FILLIER_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_INSCRIPTION_USER_ID` (`USER_ID`),
  KEY `FK_INSCRIPTION_FILLIER_ID` (`FILLIER_ID`),
  KEY `FK_INSCRIPTION_ETATINSCRIPTION_ID` (`ETATINSCRIPTION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `FILLIER_ID` bigint(20) DEFAULT NULL,
  `NIVEAUDIFFECULTE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MODULE_FILLIER_ID` (`FILLIER_ID`),
  KEY `FK_MODULE_NIVEAUDIFFECULTE_ID` (`NIVEAUDIFFECULTE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`ID`, `DESCRIPTION`, `NOM`, `FILLIER_ID`, `NIVEAUDIFFECULTE_ID`) VALUES
(201, 'Module 1', 'Module 1', 151, 51),
(202, 'Module 2', 'Module 2', 151, 52),
(203, 'Module 3', 'Module 3', 153, 51);

-- --------------------------------------------------------

--
-- Structure de la table `moduleinscription`
--

DROP TABLE IF EXISTS `moduleinscription`;
CREATE TABLE IF NOT EXISTS `moduleinscription` (
  `ID` bigint(20) NOT NULL,
  `DATEFINALISATION` date DEFAULT NULL,
  `DATEINSCRIPTION` date DEFAULT NULL,
  `NOTE` double DEFAULT NULL,
  `ETATMODULE_ID` bigint(20) DEFAULT NULL,
  `INSCRIPTION_ID` bigint(20) DEFAULT NULL,
  `MODULE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MODULEINSCRIPTION_ETATMODULE_ID` (`ETATMODULE_ID`),
  KEY `FK_MODULEINSCRIPTION_MODULE_ID` (`MODULE_ID`),
  KEY `FK_MODULEINSCRIPTION_INSCRIPTION_ID` (`INSCRIPTION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `niveaudiffeculte`
--

DROP TABLE IF EXISTS `niveaudiffeculte`;
CREATE TABLE IF NOT EXISTS `niveaudiffeculte` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `niveaudiffeculte`
--

INSERT INTO `niveaudiffeculte` (`ID`, `LIBELLE`) VALUES
(51, 'Diffecile'),
(52, 'Facile'),
(53, 'Moyen');

-- --------------------------------------------------------

--
-- Structure de la table `parcours`
--

DROP TABLE IF EXISTS `parcours`;
CREATE TABLE IF NOT EXISTS `parcours` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `parcours`
--

INSERT INTO `parcours` (`ID`, `DESCRIPTION`, `LIBELLE`) VALUES
(59, 'Big data', 'Big data'),
(60, 'code', 'Dev');

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` bigint(20) NOT NULL,
  `ADRESSE` varchar(255) DEFAULT NULL,
  `DATEINSCRIPTION` date DEFAULT NULL,
  `DATENAISSANCE` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `IMAGEPROFILE` varchar(255) DEFAULT NULL,
  `MOTDEPASSE` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`ID`, `ADRESSE`, `DATEINSCRIPTION`, `DATENAISSANCE`, `EMAIL`, `IMAGEPROFILE`, `MOTDEPASSE`, `NOM`, `PRENOM`) VALUES
(101, 'ssd', '2020-06-18', '2020-06-09', 'test@test.com', 'sd', '123456', 'mohamed', 'kamal'),
(102, 'xsqf', '2020-06-02', '2020-06-15', 'test1@test.com', 'sqdsqd', '654321', 'ahmed', 'amine');
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
