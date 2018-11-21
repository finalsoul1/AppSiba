-- 전체 재료 화면 
select a.id as category_id, a.name as category,b.id as sub_category_id, b.name as sub_category, 
c.id as ingredient_id, c.name as ingredient, c.file_name
from ingredient_category a left outer join ingredient_sub_category b
on a.id = b.ingredient_category_id 
left outer join ingredient_sub_sub_category c
on b.id = c.ingredient_sub_category_id
where a.id= 2 -- 1,2,3,4,5
order by a.id, b.id, c.id asc;


-- 내 냉장고에 있는 재료 
select a.ingredient_sub_sub_category_id, b.name, b.file_name
from my_refrigerator a left outer  join ingredient_sub_sub_category b
on a.ingredient_sub_sub_category_id = b.id;
-- 냉장고 속 재료 삭제할 때는 ingredient_sub_sub_category_id의 값만 주면 됨.


-- 추천메뉴 
select id, name, small_image_location, big_image_location
from (
	select id, name, small_image_location, big_image_location
	from food 
	where food_type_id = 1
	and id in (select food_id from food_ingredients where name like '%상추%')
	union
	select id, name, small_image_location, big_image_location
	from food 
	where food_type_id = 1
	and id in (select food_id from food_ingredients where name like '%콩나물%')
	union
	select id, name, small_image_location, big_image_location
	from food 
	where food_type_id = 1
	and id in (select food_id from food_ingredients where name like '%곤드레나물%')
) food limit 4;


-- 레시피 화면 
select id, name, small_image_location, calorie, carbohydrate, protein, fat, natrium from food where id = 387;
select * from food_recipe where food_id = 387;
select * from food_ingredients where food_id = 387;


-- 메모장에 체크박스는 존재 
select * from my_notepad;


-- 즐겨찾기 메뉴 목록  
select a.food_id, b.name, b.small_image_location
from my_favorates a left outer join food b
on a.food_id = b.id;


select ingredient_sub_sub_category_id from my_refrigerator;

