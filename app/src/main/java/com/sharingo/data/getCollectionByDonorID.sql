CREATE DEFINER=`root`@`localhost` PROCEDURE `getCollectionByDonorID`(IN p_donorID INT(16))
BEGIN

Select 
FoodRecordID,
FoodDonorID,
donor.Name AS DonarName,
donor.Address AS DonorAddress,
donor.Contact AS DonorContact,
donor.DOR AS DonatedDate,
foodcallrecord.FoodCount AS FoodCount,
foodcallrecord.FoodItems AS FoodItems,
foodcallrecord.ServiceCharge AS ServiceCharge,
DeliveredTime,
PickupTime,
ServingTemp,
StorageTemp,
volunteer.name AS OperatorName,
CollectionDate

FROM
collection
LEFT JOIN foodcallrecord ON collection.FoodDonorID = foodcallrecord.DonorID
INNER JOIN volunteer ON volunteer.ID = collection.operatorID
LEFT JOIN donor ON collection.FoodDonorID = donor.ID

WHERE collection.FoodDonorID = p_donorID AND foodcallrecord.Inactive=0 AND Collection.Inactive=0;

END