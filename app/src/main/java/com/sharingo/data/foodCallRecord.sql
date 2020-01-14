CREATE TABLE `foodcallrecord` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DonorID` int(20) NOT NULL,
  `FoodCount` int(11) DEFAULT NULL,
  `FoodItems` varchar(125) DEFAULT NULL,
  `ServiceCharge` varchar(45) DEFAULT NULL,
  `OperatorName` varchar(45) DEFAULT NULL,
  `Inactive` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci