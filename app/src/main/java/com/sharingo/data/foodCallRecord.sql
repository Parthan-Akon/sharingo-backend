CREATE TABLE `sharingo`.`foodcallrecord` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DonorID` VARCHAR(45) NOT NULL,
  `FoodCount` INT NULL,
  `FoodItems` VARCHAR(125) NULL,
  `ServiceCharge` VARCHAR(45) NULL,
  `OperatorName` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));