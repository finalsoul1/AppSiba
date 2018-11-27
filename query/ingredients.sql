-- 전체 재료 화면 
select a.id as category_id, a.name as category,b.id as sub_category_id, b.name as sub_category, 
c.id as ingredient_id, c.name as ingredient, c.file_name
from ingredient_category a left outer join ingredient_sub_category b
on a.id = b.ingredient_category_id 
left outer join ingredient_list c
on b.id = c.ingredient_sub_category_id
where a.id= 2 -- 1,2,3,4,5
order by a.id, b.id, c.id asc;


