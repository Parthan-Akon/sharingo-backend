CREATE DEFINER=`root`@`localhost` PROCEDURE `getFoodCallRecords`()
BEGIN

SELECT 
DonorID as ID,
Name,
FoodCount,
FoodItems,
ServiceCharge,
OperatorName

FROM 
foodcallrecord INNER JOIN donor ON foodcallrecord.DonorID = Donor.ID
WHERE
foodcallrecord.Inactive = 0 AND donor.Inactive = 0 order by foodcallrecord.DonorID DESC;

END