-- 즐겨찾기 메뉴 목록  
select a.food_id, b.name, b.small_image_location
from my_favorates a left outer join food b
on a.food_id = b.id;


