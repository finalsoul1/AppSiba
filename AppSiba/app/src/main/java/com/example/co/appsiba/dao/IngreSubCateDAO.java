package com.example.co.appsiba.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.db.model.IngreSubCate;

import java.util.List;

public class IngreSubCateDAO {

    public void insert(List<IngreSubCate> ingreSubCate, Context context) {

        SQLiteDatabase db = SibaDbHelper.getInstance(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (IngreSubCate ingresubcate : ingreSubCate) {
            contentValues.put("id", ingresubcate.getId());
            contentValues.put("ingredient_category_id", ingresubcate.getIngredientCategoryId());
            contentValues.put("name", ingresubcate.getName());
            db.insert("ingredient_sub_category", null, contentValues);
        }
    }
}