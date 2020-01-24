CREATE DEFINER=`root`@`localhost` PROCEDURE `addCollection`(

IN p_donorID INT(11),
IN p_foodRecordID INT(11),
IN p_deliveredTime TIME,
IN p_pickupTime TIME,
IN p_servingTemp INT(100),
IN p_storageTemp INT(100),
IN p_operatorID INT(20),
IN p_completed tinyint(1),
OUT p_id INT(11)
)
BEGIN
INSERT INTO collection (

 FoodDonorID, 
 FoodRecordID,
 DeliveredTime,
 PickupTime, 
 ServingTemp,
 StorageTemp,
 OperatorID,
 Completed,
 CollectionDate )
 VALUES ( 
 p_donorID,
 p_foodRecordID,
 p_deliveredTime,
 p_pickupTime,
 p_servingTemp,
 p_storageTemp,
 p_operatorID,
 p_completed,
 now()
);

SELECT LAST_INSERT_ID() INTO p_id ;
END