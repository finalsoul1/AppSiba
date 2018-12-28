package com.example.co.appsiba.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.db.model.IngreList;

import java.util.List;

public class IngreListDAO {

    public void insert(List<IngreList> ingreLists, Context context) {

        SQLiteDatabase db = SibaDbHelper.getInstance(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        for (IngreList gre:ingreLists) {
//            String str = gre.getName().replaceAll("^()$", "");
//            gre.setName(str);
//        }

        for (IngreList ingrelist : ingreLists) {
            contentValues.put("id", ingrelist.getId());
            contentValues.put("ingredient_sub_category_id", ingrelist.getIngredientSubCategoryId());
            contentValues.put("name", ingrelist.getName());
            contentValues.put("file_name", ingrelist.getFileName());
            db.insert("ingredient_list", null, contentValues);
        }
    }
}