-- 메모장에 체크박스는 존재, checked에서 Y는 체크된거 
select * from my_notepad order by reg_date desc;

-- 메모장에 있는 재료 삭제 
delete from my_notepad where id = 3;

-- 메모장에 있는 재료 추가 
insert into my_notepad (ingredient_name, checked, reg_date) values ('올리브당', 'N', now());
