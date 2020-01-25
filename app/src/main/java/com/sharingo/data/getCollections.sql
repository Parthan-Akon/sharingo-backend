CREATE DEFINER=`root`@`localhost` PROCEDURE `getCollections`()
BEGIN

Select 
FoodRecordID,
FoodDonorID,
donor.Name AS DonorName,
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

WHERE foodcallrecord.Inactive=0 AND Collection.Inactive=0;

END