package com.example.co.appsiba.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.db.model.Recipe;

import java.util.List;

public class RecipeDAO {

    public void insert(List<Recipe> recipes, Context context) {

        SQLiteDatabase db = SibaDbHelper.getInstance(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (Recipe recipe : recipes) {
            contentValues.put("food_id", recipe.getFoodId());
            contentValues.put("recipe_desc", recipe.getRecipeDesc());
            contentValues.put("image_location", recipe.getImageLocation());
            contentValues.put("ord", recipe.getOrd());
            db.insert("food_recipe", null, contentValues);
        }
    }
}