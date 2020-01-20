CREATE DEFINER=`root`@`localhost` PROCEDURE `getDonorByID`(IN p_id INT(16))
BEGIN

Select 
ID,
Name,
Address,
Contact,
DOR,
Inactive
FROM
donor
WHERE donor.ID = p_id;

END