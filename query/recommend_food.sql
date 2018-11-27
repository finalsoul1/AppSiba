
Collections.shuffle(fileList);

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

