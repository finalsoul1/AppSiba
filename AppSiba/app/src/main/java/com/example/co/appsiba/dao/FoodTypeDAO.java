package com.example.co.appsiba.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.db.model.FoodType;

import java.util.List;

public class FoodTypeDAO {

    public void insert(List<FoodType> foodTypes, Context context) {

        SQLiteDatabase db = SibaDbHelper.getInstance(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (FoodType foodType : foodTypes) {
            contentValues.put("id", foodType.getId());
            contentValues.put("name", foodType.getName());
            db.insert("food_type", null, contentValues);
        }
    }
}