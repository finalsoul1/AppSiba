-- 전체 재료 화면 
select a.id as category_id, a.name as category,b.id as sub_category_id, b.name as sub_category, 
c.id as ingredient_id, c.name as ingredient, c.file_name
from ingredient_category a left outer join ingredient_sub_category b
on a.id = b.ingredient_category_id 
left outer join ingredient_list c
on b.id = c.ingredient_sub_category_id
where a.id= 2 -- 1,2,3,4,5
order by a.id, b.id, c.id asc;

 -- update food_ingredients set name = replace(name, '변경해야 할 대상 재료명', '변경되길 원하는 재료명');
update food_ingredients set name = replace(name, '가다랑어포', '가쓰오부시') where name like '%가다랑어포%';
update food_ingredients set name = replace(name, '아구', '아귀') where name like '%아구%';
update food_ingredients set name = replace(name, '매실청','매실') where name like '%매실청%';
update food_ingredients set name = replace(name, '매실액기스', '매실') where name like '%매실액기스%';
