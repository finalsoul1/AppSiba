-- 즐겨찾기 메뉴 목록  
select a.food_id, b.name, b.small_image_location
from my_favorates a left outer join food b
on a.food_id = b.id
order by a.reg_date desc;


-- 즐겨찾기 추가 쿼리 
insert into my_favorates (food_id, reg_date) values (250, now());

-- sqlite 날짜 
cv.put(db.PROCESS_DATE, new Date().getTime());

-- 즐겨찾기 삭제
delete from my_favorates where food_id = 250;


