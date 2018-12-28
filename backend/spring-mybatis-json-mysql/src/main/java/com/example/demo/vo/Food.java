package com.example.demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class Food {
	int id; // key 값
	String name; //음식 이름
	int foodTypeId; // 
	float calorie; // 칼로리
	float carbohydrate; // 탄수화물
	float protein; // 단백질
	float fat; // 지방
	float natrium; 
	String hashTag; // 해쉬태그
	String smallImageLocation; // 이미지(소)
	String bigImageLocation; // 이미지(중)
	String ingredients; // 재료
	int likeIt; // 좋아요
	
	List<Ingredient> ingredientList; // 재료 낱개 
	List<Recipe> recipes; // 음식 만드는 과정 
	
}
