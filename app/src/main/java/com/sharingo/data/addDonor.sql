CREATE DEFINER=`root`@`localhost` PROCEDURE `addDonor`(

IN p_name VARCHAR(25),
IN p_address VARCHAR(125),
IN p_contact VARCHAR(50),
OUT p_id INT(11)
)
BEGIN
INSERT INTO donor (
 Name, 
 Address,
 Contact, 
 DOR )
 VALUES ( 
 p_name,
 p_address,
 p_contact,
 now()
);

SELECT COUNT(ID) INTO p_id FROM donor;
END