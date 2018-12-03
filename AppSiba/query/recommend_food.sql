
Collections.shuffle(fileList);

-- 내 내장고 속 재료 가져오기 
select b.name from my_refrigerator a left outer join ingredient_list b
on a.ingredient_list_id = b.id;

-- 추천메뉴 
select id, name, small_image_location
    from food 
    where food_type_id =1
    and id in (
    select food_id from food_ingredients 
    where name like '%콩나물%' 
    or name like '%상추%'
    or name like '%곤드레나물%')
limit 4
