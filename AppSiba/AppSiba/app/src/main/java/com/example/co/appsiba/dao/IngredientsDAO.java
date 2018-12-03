package com.example.co.appsiba.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.db.model.Ingredients;

import java.util.List;

public class IngredientsDAO {

    public void insert(List<Ingredients> ingredients, Context context) {

        SQLiteDatabase db = SibaDbHelper.getInstance(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (Ingredients ingredient : ingredients) {
            contentValues.put("food_id", ingredient.getFoodId());
            contentValues.put("name", ingredient.getName());
            db.insert("food_ingredients", null, contentValues);
        }
    }
}