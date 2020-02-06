CREATE DEFINER=`root`@`localhost` PROCEDURE `addSensory`( 

p_FoodCallRecordID int(11),
p_recipeName varchar(30),
p_appearance int(11),
p_aroma int(11),
p_taste int(11),
p_temperature int(11),
p_fitStatus varchar(25),
p_acceptability varchar(25)

)
BEGIN

INSERT INTO sensory (

FoodCallRecordID,
RecipeName,
Appearance,
Aroma,
Taste,
Temperature,
FitStatus,
Acceptability
)

VALUES (
p_FoodCallRecordID ,
p_recipeName,
p_appearance,
p_aroma,
p_taste,
p_temperature,
p_fitStatus,
p_acceptability
);

END