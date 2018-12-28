create database siba;

show create table comments;

alter table food drop cooking_type_id;
desc food;


select * from food_type;
insert into food_type (name) values ('밥');
insert into food_type (name) values ('국&찌개');
insert into food_type (name) values ('반찬');
insert into food_type (name) values ('일품');
insert into food_type (name) values ('후식');

use my_cookbook;
-- ingredient_category table insert
insert into ingredient_category (name) values ('채소');
insert into ingredient_category (name) values ('육류');
insert into ingredient_category (name) values ('어류');
insert into ingredient_category (name) values ('과일');
insert into ingredient_category (name) values ('기타');


-- ingredient_sub_category
insert into ingredient_sub_category (ingredients_category_id, name) values (1,'잎채소');
insert into ingredient_sub_category (ingredients_category_id, name) values (1,'열매채소');
insert into ingredient_sub_category (ingredients_category_id, name) values (1,'느타리버섯');

insert into ingredient_sub_category (ingredients_category_id, name) values (2,'알');
insert into ingredient_sub_category (ingredients_category_id, name) values (2,'닭');
insert into ingredient_sub_category (ingredients_category_id, name) values (2,'돼지');
insert into ingredient_sub_category (ingredients_category_id, name) values (2,'소');
insert into ingredient_sub_category (ingredients_category_id, name) values (2,'오리');

insert into ingredient_sub_category (ingredients_category_id, name) values (3,'생선류');
insert into ingredient_sub_category (ingredients_category_id, name) values (3,'조개&갑각');
insert into ingredient_sub_category (ingredients_category_id, name) values (3,'해조류');
insert into ingredient_sub_category (ingredients_category_id, name) values (3,'건어물&알&젓갈');

insert into ingredient_sub_category (ingredients_category_id, name) values (4,'건포도');

insert into ingredient_sub_category (ingredients_category_id, name) values (5,'유제품&치즈');
insert into ingredient_sub_category (ingredients_category_id, name) values (5,'양념&소스&향신료');
insert into ingredient_sub_category (ingredients_category_id, name) values (5,'곡류&견과류&가루');
insert into ingredient_sub_category (ingredients_category_id, name) values (5,'음료&주류');


-- ingredient_sub_category
select * from ingredient_sub_sub_category;

desc ingredient_sub_sub_category;

-- 알
insert into ingredient_sub_sub_category (name) values ('달걀');
insert into ingredient_sub_sub_category (name) values ('메추리알');

-- 닭
insert into ingredient_sub_sub_category (name) values ('닭가슴살');
insert into ingredient_sub_sub_category (name) values ('닭뼈');
insert into ingredient_sub_sub_category (name) values ('닭고기');
insert into ingredient_sub_sub_category (name) values ('닭');

-- 돼지 
insert into ingredient_sub_sub_category (name) values ('돼지등심');
insert into ingredient_sub_sub_category (name) values ('돼지안심');
insert into ingredient_sub_sub_category (name) values ('베이컨');
insert into ingredient_sub_sub_category (name) values ('목살');
insert into ingredient_sub_sub_category (name) values ('삼겹살');
insert into ingredient_sub_sub_category (name) values ('돼지고기(불고기용)');
insert into ingredient_sub_sub_category (name) values ('홍두깨살');

-- 소 
insert into ingredient_sub_sub_category (name) values ('쇠고기');
insert into ingredient_sub_sub_category (name) values ('소고기부채살');
insert into ingredient_sub_sub_category (name) values ('소고기살치살');
insert into ingredient_sub_sub_category (name) values ('소고기우둔살');
insert into ingredient_sub_sub_category (name) values ('차돌박이');

-- 오리 
insert into ingredient_sub_sub_category (name) values ('오리');

-- 생선류 
insert into ingredient_sub_sub_category (name) values ('고등어');
insert into ingredient_sub_sub_category (name) values ('광어');
insert into ingredient_sub_sub_category (name) values ('꽁치');
insert into ingredient_sub_sub_category (name) values ('대구');
insert into ingredient_sub_sub_category (name) values ('동태');
insert into ingredient_sub_sub_category (name) values ('북어');
insert into ingredient_sub_sub_category (name) values ('장어');
insert into ingredient_sub_sub_category (name) values ('삼치');
insert into ingredient_sub_sub_category (name) values ('연어');
insert into ingredient_sub_sub_category (name) values ('멸치');
insert into ingredient_sub_sub_category (name) values ('코다리');
insert into ingredient_sub_sub_category (name) values ('아귀');
insert into ingredient_sub_sub_category (name) values ('쭈꾸미');

insert into ingredient_sub_sub_category (name) values ('문어');
insert into ingredient_sub_sub_category (name) values ('낙지');
insert into ingredient_sub_sub_category (name) values ('오징어');

-- 조개 & 갑각
insert into ingredient_sub_sub_category (name) values ('새우');
insert into ingredient_sub_sub_category (name) values ('소라');
insert into ingredient_sub_sub_category (name) values ('모시조개');
insert into ingredient_sub_sub_category (name) values ('관자');
insert into ingredient_sub_sub_category (name) values ('꼬막');
insert into ingredient_sub_sub_category (name) values ('굴');
insert into ingredient_sub_sub_category (name) values ('바지락');
insert into ingredient_sub_sub_category (name) values ('홍합');
insert into ingredient_sub_sub_category (name) values ('전복');

-- 해조류
insert into ingredient_sub_sub_category (name) values ('해초');
insert into ingredient_sub_sub_category (name) values ('미역');
insert into ingredient_sub_sub_category (name) values ('다시마');
insert into ingredient_sub_sub_category (name) values ('매생이');

-- 건어물&알&젓갈
insert into ingredient_sub_sub_category (name) values ('건새우');
insert into ingredient_sub_sub_category (name) values ('황태');
insert into ingredient_sub_sub_category (name) values ('날치알');
insert into ingredient_sub_sub_category (name) values ('명란');
insert into ingredient_sub_sub_category (name) values ('멸치액젓');

insert into ingredient_sub_sub_category (name) values ('새우젓');
insert into ingredient_sub_sub_category (name) values ('건포도');

-- 과일 
insert into ingredient_sub_sub_category (name) values ('귤');
insert into ingredient_sub_sub_category (name) values ('대추');
insert into ingredient_sub_sub_category (name) values ('딸기');

insert into ingredient_sub_sub_category (name) values ('라즈베리');
insert into ingredient_sub_sub_category (name) values ('레몬');
insert into ingredient_sub_sub_category (name) values ('매실(매실청,매실액기스)');
insert into ingredient_sub_sub_category (name) values ('무화과');
insert into ingredient_sub_sub_category (name) values ('바나나');



insert into ingredient_sub_sub_category (name) values ('방울토마토');
insert into ingredient_sub_sub_category (name) values ('배');
insert into ingredient_sub_sub_category (name) values ('사과');
insert into ingredient_sub_sub_category (name) values ('석류');
insert into ingredient_sub_sub_category (name) values ('수박');

insert into ingredient_sub_sub_category (name) values ('아보카도');
insert into ingredient_sub_sub_category (name) values ('오렌지');
insert into ingredient_sub_sub_category (name) values ('유자');
insert into ingredient_sub_sub_category (name) values ('참외');
insert into ingredient_sub_sub_category (name) values ('크랜베리');

insert into ingredient_sub_sub_category (name) values ('키위');
insert into ingredient_sub_sub_category (name) values ('토마토');
insert into ingredient_sub_sub_category (name) values ('파인애플');

-- 유제품 & 치즈
insert into ingredient_sub_sub_category (name) values ('피자치즈');
insert into ingredient_sub_sub_category (name) values ('치즈(저염치즈)');
insert into ingredient_sub_sub_category (name) values ('리코타치즈');
insert into ingredient_sub_sub_category (name) values ('우유');
insert into ingredient_sub_sub_category (name) values ('두유');
insert into ingredient_sub_sub_category (name) values ('플레인요거트');
insert into ingredient_sub_sub_category (name) values ('요거트');
insert into ingredient_sub_sub_category (name) values ('버터');
insert into ingredient_sub_sub_category (name) values ('생크림');

-- 양념 & 소스 & 향신료 
insert into ingredient_sub_sub_category (name) values ('초고추장');
insert into ingredient_sub_sub_category (name) values ('고추장');
insert into ingredient_sub_sub_category (name) values ('비빔고추장');
insert into ingredient_sub_sub_category (name) values ('쌈장');
insert into ingredient_sub_sub_category (name) values ('청국장');
insert into ingredient_sub_sub_category (name) values ('된장');
insert into ingredient_sub_sub_category (name) values ('참깨');
insert into ingredient_sub_sub_category (name) values ('후추');
insert into ingredient_sub_sub_category (name) values ('겨자');
insert into ingredient_sub_sub_category (name) values ('케첩');
insert into ingredient_sub_sub_category (name) values ('물엿');
insert into ingredient_sub_sub_category (name) values ('소금');
insert into ingredient_sub_sub_category (name) values ('설탕');
insert into ingredient_sub_sub_category (name) values ('요리당(올리고당)');
insert into ingredient_sub_sub_category (name) values ('간장(저염간장)');
insert into ingredient_sub_sub_category (name) values ('고춧가루');
insert into ingredient_sub_sub_category (name) values ('맛술');
insert into ingredient_sub_sub_category (name) values ('식초');
insert into ingredient_sub_sub_category (name) values ('당면');
insert into ingredient_sub_sub_category (name) values ('꿀');
insert into ingredient_sub_sub_category (name) values ('들기름');
insert into ingredient_sub_sub_category (name) values ('올리브오일');
insert into ingredient_sub_sub_category (name) values ('카놀라유');
insert into ingredient_sub_sub_category (name) values ('참기름');
insert into ingredient_sub_sub_category (name) values ('식용유');
insert into ingredient_sub_sub_category (name) values ('가쓰오부시(가다랑어포)');

-- 가공식품 
insert into ingredient_sub_sub_category (name) values ('치킨');
insert into ingredient_sub_sub_category (name) values ('햄');
insert into ingredient_sub_sub_category (name) values ('통조림참치');
insert into ingredient_sub_sub_category (name) values ('판젤라틴');
insert into ingredient_sub_sub_category (name) values ('떡');
insert into ingredient_sub_sub_category (name) values ('라면');

insert into ingredient_sub_sub_category (name) values ('밀가루');
insert into ingredient_sub_sub_category (name) values ('빵가루');
insert into ingredient_sub_sub_category (name) values ('소시지');
insert into ingredient_sub_sub_category (name) values ('소면(국수)');
insert into ingredient_sub_sub_category (name) values ('은행');
insert into ingredient_sub_sub_category (name) values ('김치');

insert into ingredient_sub_sub_category (name) values ('곤약');
insert into ingredient_sub_sub_category (name) values ('실곤약');
insert into ingredient_sub_sub_category (name) values ('누룽지');
insert into ingredient_sub_sub_category (name) values ('순두부');
insert into ingredient_sub_sub_category (name) values ('연두부');
insert into ingredient_sub_sub_category (name) values ('두부');

insert into ingredient_sub_sub_category (name) values ('콩고기');
insert into ingredient_sub_sub_category (name) values ('할라피뇨');
insert into ingredient_sub_sub_category (name) values ('무말랭이');

-- 곡류&견과류&가루 음료& 주류
insert into ingredient_sub_sub_category (name) values ('쌀(백미,멥쌀)');
insert into ingredient_sub_sub_category (name) values ('현미쌀');
insert into ingredient_sub_sub_category (name) values ('옥수수');

insert into ingredient_sub_sub_category (name) values ('흑임자');
insert into ingredient_sub_sub_category (name) values ('계피');
insert into ingredient_sub_sub_category (name) values ('오미자');
insert into ingredient_sub_sub_category (name) values ('잣');
insert into ingredient_sub_sub_category (name) values ('아몬드');
insert into ingredient_sub_sub_category (name) values ('호두');
insert into ingredient_sub_sub_category (name) values ('캐슈넛');
insert into ingredient_sub_sub_category (name) values ('강낭콩');
insert into ingredient_sub_sub_category (name) values ('검은콩');

insert into ingredient_sub_sub_category (name) values ('땅콩');
insert into ingredient_sub_sub_category (name) values ('렌틸콩');
insert into ingredient_sub_sub_category (name) values ('밤');
insert into ingredient_sub_sub_category (name) values ('메밀');
insert into ingredient_sub_sub_category (name) values ('카레가루');
insert into ingredient_sub_sub_category (name) values ('콩가루');
insert into ingredient_sub_sub_category (name) values ('찹쌀가루');
insert into ingredient_sub_sub_category (name) values ('들깨가루');
insert into ingredient_sub_sub_category (name) values ('녹말');

-- 음료& 주류 
insert into ingredient_sub_sub_category (name) values ('정종');
insert into ingredient_sub_sub_category (name) values ('청주');
insert into ingredient_sub_sub_category (name) values ('와인');
insert into ingredient_sub_sub_category (name) values ('녹차');


