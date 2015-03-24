-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 14, 2014 at 10:44 PM
-- Server version: 5.5.37-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ToDoApp`
--

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `idevent` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `titre` varchar(50) DEFAULT NULL,
  `disc` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `uid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idevent`),
  KEY `Fkkk_1` (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`idevent`, `type`, `titre`, `disc`, `date`, `uid`) VALUES
(1, 'note', 'note1', 'blablablaaa', '2014-12-16', '54830fd47dfcc4.25764665'),
(2, 'Project', 'projet GL', '-cahier de charge\n-conception\n-developpement', '2014-12-15', '54830fd47dfcc4.25764665');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `unique_id` varchar(23) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `encrypted_password` varchar(80) NOT NULL,
  `salt` varchar(10) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `unique_id` (`unique_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `unique_id`, `firstname`, `lastname`, `username`, `email`, `encrypted_password`, `salt`, `created_at`) VALUES
(1, '54830fd47dfcc4.25764665', 'ghada', 'bahloul', 'girl1n2', 'ghada.bahloul@gmail.com', '8ozLNrbdEKz9Sbm3Rs0cyo9CMwo4YzlhZmYwYmVl', '8c9aff0bee', '2014-12-06 15:16:52'),
(2, '5485c0f437b2e9.15595616', 'siraj', 'ghedira', 'dfgvb', 'siraj.ghedira@j.m', 'h1sNg6P0GpsKYgX/aS0fZ9kUTn8zMGIyN2ZiMThj', '30b27fb18c', '2014-12-08 16:17:08');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `Fkkk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`unique_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
