CREATE DEFINER=`root`@`localhost` PROCEDURE `getFoodCallRecordsCount`()
BEGIN
Select t1.FoodCallRecord, t2.TotalPlates, t3.Completed 
From
(Select Count(ID) AS FoodCallRecord from foodcallrecord)t1,
(Select SUM(FoodCount) as TotalPlates from foodcallrecord)t2,
(Select Count(*) AS Completed from collection Inner Join foodcallrecord ON foodcallrecord.ID = collection.FoodRecordID 
Where collection.Completed = 1)t3;

END