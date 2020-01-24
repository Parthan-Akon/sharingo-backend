CREATE DEFINER=`root`@`localhost` PROCEDURE `getFoodCallRecords`()
BEGIN

SELECT 
foodcallrecord.ID,
DonorID as DonorID,
donor.Name,
FoodCount,
FoodItems,
ServiceCharge,
foodcallrecord.OperatorID,
Volunteer.Name as OperatorName,
ifnull(Completed,0) AS Completed

FROM 
foodcallrecord 
INNER JOIN donor ON foodcallrecord.DonorID = Donor.ID
INNER JOIN volunteer ON volunteer.ID = foodcallrecord.OperatorID
LEFT JOIN collection ON foodcallrecord.DonorID = collection.FoodDonorID  
WHERE
foodcallrecord.Inactive = 0 AND donor.Inactive = 0 order by foodcallrecord.DonorID DESC;

END