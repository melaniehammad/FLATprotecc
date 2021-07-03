CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `salt` char(24) NOT NULL,
  `hashValue` char(24) NOT NULL,
  `mail` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail` (`mail`)
);

CREATE TABLE IF NOT EXISTS `entry` (
  `id` int NOT NULL AUTO_INCREMENT,
  `acc_id` int NOT NULL,
  `title` varchar(100) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `pwd` varchar(200) NOT NULL,
  `com` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `entry` (`acc_id`),
  CONSTRAINT `entry_ibfk_1` FOREIGN KEY (`acc_id`) REFERENCES `accounts` (`id`)
);