package com.example.co.appsiba.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.db.model.Food;

import java.util.List;

public class FoodDAO {

    public void insert(List<Food> foods, Context context) {

        SQLiteDatabase db = SibaDbHelper.getInstance(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (Food food : foods) {
            contentValues.put("id", food.getId());
            contentValues.put("name", food.getName());
            contentValues.put("food_type_id", food.getFoodTypeId());
            contentValues.put("calorie", food.getCalorie());
            contentValues.put("carbohydrate", food.getCarbohydrate());
            contentValues.put("protein", food.getProtein());
            contentValues.put("fat", food.getFat());
            contentValues.put("natrium", food.getNatrium());
            contentValues.put("small_image_location", food.getSmallImageLocation());
            contentValues.put("big_image_location", food.getBigImageLocation());
            contentValues.put("ingredients", food.getIngredients());
            db.insert("food", null, contentValues);
        }
    }
}
