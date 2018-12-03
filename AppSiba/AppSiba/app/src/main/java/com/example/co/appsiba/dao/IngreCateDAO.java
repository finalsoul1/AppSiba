package com.example.co.appsiba.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.db.model.IngreCate;

import java.util.List;

public class IngreCateDAO {

    public void insert(List<IngreCate> iCate, Context context) {

        SQLiteDatabase db = SibaDbHelper.getInstance(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (IngreCate ingrecate : iCate) {
            contentValues.put("id", ingrecate.getId());
            contentValues.put("name", ingrecate.getName());
            db.insert("ingredient_category", null, contentValues);
        }

    }
}