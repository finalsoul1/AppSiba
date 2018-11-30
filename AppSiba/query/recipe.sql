-- 레시피 화면 
select id, name, small_image_location, calorie, carbohydrate, protein, fat, natrium from food where id = 387;
select * from food_recipe where food_id = 387 order by ord asc;
select * from food_ingredients where food_id = 387;


