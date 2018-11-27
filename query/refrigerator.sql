-- 내 내장고 속 재료 조회
select a.ingredient_list_id, b.name, b.file_name from 
my_refrigerator a left outer join ingredient_list b
on a.ingredient_list_id = b.id

-- 재료 선택 화면에서 선택한 재료명 insert 
insert into my_refrigerator (ingredient_name) values ('상추');

-- 내 냉장고 속 재료 삭제 
delete from my_refrigerator where id = 2;

