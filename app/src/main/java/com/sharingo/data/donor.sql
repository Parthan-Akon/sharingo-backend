CREATE TABLE `donor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT 'null',
  `Address` varchar(200) DEFAULT 'null',
  `Contact` varchar(50) DEFAULT NULL,
  `DOR` date DEFAULT NULL,
  `Inactive` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci