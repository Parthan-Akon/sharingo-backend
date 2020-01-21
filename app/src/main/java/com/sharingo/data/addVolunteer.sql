CREATE DEFINER=`root`@`localhost` PROCEDURE `addVolunteer`(

IN p_name VARCHAR(25),
IN p_contact VARCHAR(25)
)
BEGIN
INSERT INTO volunteer (
 Name, 
 Contact 
 )
 VALUES ( 
 p_name,
 p_contact
);

END