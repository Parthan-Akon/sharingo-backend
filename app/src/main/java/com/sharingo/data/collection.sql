CREATE TABLE `collection` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FoodRecordID` int(11) DEFAULT NULL,
  `FoodDonorID` int(11) NOT NULL,
  `DeliveredTime` time DEFAULT NULL,
  `PickupTime` time DEFAULT NULL,
  `ServingTemp` int(100) DEFAULT NULL,
  `StorageTemp` int(100) DEFAULT NULL,
  `OperatorID` int(20) DEFAULT NULL,
  `Completed` tinyint(1) DEFAULT '0',
  `CollectionDate` date DEFAULT NULL,
  `Inactive` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci