CREATE DEFINER=`root`@`localhost` PROCEDURE `addFoodCalls`(
IN p_donorID INT(20),
IN p_foodCount INT(11),
IN p_foodItems VARCHAR(125),
IN p_serviceCharge VARCHAR(25),
IN p_operatorID INT(25)
)
BEGIN
INSERT INTO foodcallrecord (
 DonorID, 
 FoodCount,
 FoodItems, 
 ServiceCharge,
 OperatorID)
 VALUES ( 
 p_donorID,
 p_foodCount,
 p_foodItems,
 p_serviceCharge,
 p_operatorID
);

END