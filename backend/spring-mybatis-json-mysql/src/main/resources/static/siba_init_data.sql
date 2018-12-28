
-- insert food_type;
delete from food_type;
ALTER TABLE food_type AUTO_INCREMENT=1;
insert into food_type (name) values ('밥');
insert into food_type (name) values ('국&찌개');
insert into food_type (name) values ('반찬');
insert into food_type (name) values ('일품');
insert into food_type (name) values ('후식');

-- ingredient_category
delete from ingredient_category;
ALTER TABLE ingredient_category AUTO_INCREMENT=1;
insert into ingredient_category (name) values ('채소');
insert into ingredient_category (name) values ('육류');
insert into ingredient_category (name) values ('어류');
insert into ingredient_category (name) values ('과일');
insert into ingredient_category (name) values ('기타');
select * from ingredient_category;

-- ingredient_sub_category insert 
delete from ingredient_sub_category;
ALTER TABLE ingredient_sub_category AUTO_INCREMENT=1;
insert into ingredient_sub_category (ingredient_category_id, name) values (1, '잎채소');
insert into ingredient_sub_category (ingredient_category_id, name) values (1, '열매채소');
insert into ingredient_sub_category (ingredient_category_id, name) values (1, '버섯');

insert into ingredient_sub_category (ingredient_category_id, name) values (2, '알');
insert into ingredient_sub_category (ingredient_category_id, name) values (2, '닭');
insert into ingredient_sub_category (ingredient_category_id, name) values (2, '돼지');
insert into ingredient_sub_category (ingredient_category_id, name) values (2, '소');
insert into ingredient_sub_category (ingredient_category_id, name) values (2, '오리');

insert into ingredient_sub_category (ingredient_category_id, name) values (3, '생선류');
insert into ingredient_sub_category (ingredient_category_id, name) values (3, '조개&갑각');
insert into ingredient_sub_category (ingredient_category_id, name) values (3, '해조류');
insert into ingredient_sub_category (ingredient_category_id, name) values (3, '건어물&알&젓갈');

insert into ingredient_sub_category (ingredient_category_id, name) values (4, '과일');

insert into ingredient_sub_category (ingredient_category_id, name) values (5, '유제품&치즈');
insert into ingredient_sub_category (ingredient_category_id, name) values (5, '양념&소스&향신료');
insert into ingredient_sub_category (ingredient_category_id, name) values (5, '가공식품');
insert into ingredient_sub_category (ingredient_category_id, name) values (5, '곡류&견과루&가루');
insert into ingredient_sub_category (ingredient_category_id, name) values (5, '음료&주류');
select * from ingredient_sub_category;

-- 잎채소 insert
delete from ingredient_sub_sub_category;
ALTER TABLE ingredient_sub_sub_category AUTO_INCREMENT=1;
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'sangchu.jpg','상추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'keil.jpg','케일');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'kkelip.jpg','깻잎');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'ssukgat.jpg','쑥갓');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'nengi.jpg','냉이');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'congnamul.jpg','콩나물');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'sukju.jpg','숙주');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'pasuli.jpg','파슬리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'chinamul.jpg','취나물');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'dale.jpg','달래');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'gondle.png','곤드레나물');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'cheongungche.jpg','청경채');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'sigumchi.jpg','시금치');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'auk.jpg','아욱');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'conchi.jpg','곰취');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'minari.jpg','미나리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'sellerri.jpg','샐러리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'asparagus.jpg','아스파라거스');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'torande.png','토란대');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'gosari.jpg',	'고사리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'jjukpa.jpg',	'쪽파');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'deapa.jpg','대파');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'durmb.jpg','두릅');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'broccoli.jpg','브로콜리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'buchu.jpg','부추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'beachu.jpg',	'배추(배춧잎)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'redyangbechu.jpg','적양배추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'yangbechu.jpg','양배추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'hobakip.jpg','호박잎');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'yangsangchu.jpg','양상추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'sessak.jpg',	'새싹채소');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'musun.png',	'무순');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'rosemari.jpg',	'로즈마리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'mint.jpg',	'민트');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'basil.jpg',	'바질');
insert into ingredient_sub_sub_category (ingredient_sub_category_id,file_name, name) values (1,'walgyesu.jpg',	'월계수잎');

-- 열매채소 insert
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'gochu.jpg','고추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'chengyanggochu.jpg','청양고추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'paprica.jpg','파프리카');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'pimang.jpg','피망');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'oi.jpg','오이');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'gaji.png','가지');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'yangpa.jpg','양파');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'redyangpa.jpg','적양파');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'bit.jpg','비트');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'garlic.png','마늘');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'danggun.jpg','당근');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'goguma.jpg','고구마');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'gamja.jpg','감자');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'ma.jpg','마');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'deoduk.jpg','더덕');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'doraji.jpg','도라지');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'yeongun.jpg','연근');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'wuweong.png','우엉');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'insam.jpg','인삼');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'senggang.jpg','생강');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'gwanghwang.jpg','강황');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'danhobak.jpg','단호박');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (2,'ehobak.png','애호박');


-- 버섯 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (3,'ntari.jpg','느타리버섯');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (3,'sesongi.jpg','새송이(미니새송이)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (3,'yangsongi.jpg','양송이');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (3,'pengi.jpg','팽이버섯');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (3,'pyogo.jpg','표고버섯');



-- 알 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (4,'egg.jpeg','달걀');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (4,'mechuri.jpg','메추리알');



-- 닭 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (5, 'dakgasum.jpg','닭가슴살');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (5, 'dakbbye.jpg',	'닭뼈');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (5, 'dakgogi.jpg',	'닭고기');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (5, 'dak.jpg',	'닭');


select * from ingredient_sub_sub_category;
select * from ingredient_sub_category;

-- 돼지 고기 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (6,'pork deng.jpg','돼지등심');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (6,'pork an.jpg',	'돼지안심');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (6,'baecon.jpg',	'베이컨');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (6,'pork mok.jpg',	'목살');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (6,'samgyub.jpg',	'삼겹살');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (6,'bulgogi.jpg',	'돼지고기(불고기용)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (6,'pork hongdu.jpg',	'홍두깨살');

-- 소고기 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (7,'sogogi.jpg','쇠고기');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (7,'buchesal.jpg','소고기부채살');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (7,'salchisal.jpg','소고기살치살');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (7,'wodunsal.jpg','소고기우둔살');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (7,'chadol.png','차돌박이');

-- 오리 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (8,'duck.png','오리');


-- 생선류 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'godung.jpg',	'고등어');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'gang.png',	'광어');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'ccongchi.png',	'꽁치');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'daegu.jpg',	'대구');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'dongtae.jpg',	'동태');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'buk.png',	'북어');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'jang.jpg',	'장어');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'samchi.jpg',	'삼치');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'yeon.jpg',	'연어');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'mulchi.jpg',	'멸치');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'kodari.jpg',	'코다리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'agu.jpg',	'아귀');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'juggumi.jpg',	'주꾸미');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'mun.jpg',	'문어');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'nak.jpg',	'낙지');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (9, 'ojing.jpg',	'오징어');


-- 조개&갑각 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'shrimp.png'		,'새우');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'sora.jpg'			,'소라');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'mosi.jpg'			,'모시조개');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'gyanja.jpg'		,'관자');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'kkomack.jpg'		,'꼬막');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'gul.jpg'			,'굴');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'bajirak.jpg'		,'바지락');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'honghap.png'		,'홍합');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (10,'junbok.jpg'		,'전복');


-- 해조류 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (11, 'seaweed.jpg',	'해초');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (11, 'miyuk.jpg',	'미역');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (11, 'dasima.jpeg',	'다시마');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (11, 'mesengi.jpg',	'매생이');


-- 건어물&알&젓갈 insert 
insert into ingredient_sub_sub_category ( ingredient_sub_category_id, file_name, name) values (12, 'gunseou.jpg',	'건새우');
insert into ingredient_sub_sub_category ( ingredient_sub_category_id, file_name, name) values (12, 'hwangtea.jpg',	'황태');
insert into ingredient_sub_sub_category ( ingredient_sub_category_id, file_name, name) values (12, 'nalchial.jpg',	'날치알');
insert into ingredient_sub_sub_category ( ingredient_sub_category_id, file_name, name) values (12, 'mungran.png',	'명란');


-- 과일 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'raison.png','건포도');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'tangerine.png','귤');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'daechu.png',	'대추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'strawberry.png',	'딸기');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'raspberry.png',	'라즈베리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'lemon.png',	'레몬');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'maesil.png',	'매실(매실청, 매실액기스)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'muhwagwa.png',	'무화과');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'banana.png',	'바나나');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'bangTomato.png',	'방울토마토');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'pear.png',	'배');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'apple.png',	'사과');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'seoglyu.png',	'석류');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'watermelon.png',	'수박');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'avocado.png',	'아보카도');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'orange.png',	'오렌지');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'yuja.png',	'유자');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'cham-oe.png',	'참외');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'Cranberry.png',	'크랜베리');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'kiwi.png',	'키위');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'tomato.png',	'토마토');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (13, 'pineapple.png',	'파인애플');



-- 유제품&치즈 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'pizzacheeze.png','피자치즈');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'cheeze.png',	'치즈(저염치즈)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'ricotacheeze.png','리코타치즈');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'milk.png',	'우유');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'soymilk.png',	'두유');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'Plain yogurt.jpg','플레인요거트');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'yogurt.jpg','요거트');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'butter.png',	'버터');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (14, 'cream.jpg',	'생크림');




select * from ingredient_sub_sub_category;


-- 양념&소스&향신료 insert
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'chopepperjang.jpg',	'초고추장');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'pepperjang.jpg',	'고추장');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'bibimpepperjang.jpg',	'비빔고추장');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'ssamjang.png',	'쌈장');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'chunggukjang.jpg',	'청국장');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'donjang.jpg',	'된장');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'kkae.jpg',	'참깨');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'pepper.jpg',	'후추');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'gyuja.jpg',	'겨자');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'ketchup.jpg',	'케첩');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'mulyut.jpg',	'물엿');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'salt.jpg',	'소금');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'sugar.jpg',	'설탕');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'oligodang.jpg',	'요리당(올리고당)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'ganjang.jpg',	'간장(저염간장)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'pepperpowder.jpg','고춧가루');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'matsul.jpg',	'맛술');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'vinegar.jpg',	'식초');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'dangmean.jpg',   '당면');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'honey.png', '꿀');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'duloil.jpg',	'들기름');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'oliveoil.jpg',	'올리브오일');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'kanallaoil.jpg', '카놀라유');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'realoil.jpg','참기름');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'cookingoil.jpg',	'식용유');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'Katsuo Bush.png','가쓰오부시(가다랑어포)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'mulchijut.jpg',	'멸치액젓');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'shrimpjut.jpg',	'새우젓');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (15, 'chichenstock.jpg',	'치킨');



-- 가공식품 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'ham.jpg',	'햄');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'chamchi.jpg',	'통조림참치');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'jellatin.jpg', '판젤라틴');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'dduck.jpg','떡');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'ramean.jpg','라면');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'flour.jpg','밀가루');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'breadpowder.jpg',	'빵가루');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'sausage.jpg',	'소시지');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'somean.jpg',	'소면(국수)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'eunhaeng.jpg',	'은행');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'kimchi.jpg',	'김치');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'gonyak.png',	'곤약');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'silgonyak.jpg',	'실곤약');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'nulunggee.jpg',	'누룽지');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'sundubu.png',	'순두부');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'yundubu.png',	'연두부');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'dubu.png',	'두부');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'konggogi.png',	'콩고기');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'Halapiona.jpg',	'할라피뇨');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (16, 'dried mu.jpg',	'무말랭이');


-- 곡류&견과루&가루 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'rice.jpg',	'쌀(백미, 멥쌀)');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'hyunmi.jpg',	'현미쌀');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'corn.png',	'옥수수');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'hekimjs.png',	'흑임자');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'gyepi.jpg',	'계피');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'omija.png',	'오미자');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'jat.jpg',	'잣');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'almond.png',	'아몬드');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'hodu.gif',	'호두');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'cashew nut.png',	'캐슈넛');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'gangnangcong.jpg',	'강낭콩');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'blackcong.jpg',	'검은콩');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'peanut.jpg',	'땅콩');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'rantilcong.png',	'렌틸콩');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'bom.jpg',	'밤');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'memil.jpg',	'메밀');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'currypowder.jpg',	'카레가루');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'congpowder.jpg',	'콩가루');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'chabsalpowder.jpg',	'찹쌀가루');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'dulkkepowder.jpg',	'들깨가루');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (17, 'nukmal.jpg',	'녹말');


-- 음료&주류 insert 
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (18,'jungjong.jpg',	'정종');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (18,'chungju.jpg',	'청주');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (18,'wine.jpg',	'와인');
insert into ingredient_sub_sub_category (ingredient_sub_category_id, file_name, name) values (18,'greentea.jpg',	'녹차');

