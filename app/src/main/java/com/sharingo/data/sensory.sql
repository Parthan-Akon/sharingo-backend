CREATE TABLE `sensory` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `FoodCallRecordID` int(10) DEFAULT NULL,
  `RecipeName` varchar(45) DEFAULT NULL,
  `Appearance` int(25) DEFAULT NULL,
  `Aroma` int(25) DEFAULT NULL,
  `Taste` int(25) DEFAULT NULL,
  `Temperature` int(25) DEFAULT NULL,
  `FitStatus` varchar(45) DEFAULT NULL,
  `Acceptability` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci