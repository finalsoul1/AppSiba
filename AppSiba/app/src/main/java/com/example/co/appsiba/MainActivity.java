package com.example.co.appsiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.co.appsiba.HTTP.HttpAsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DB테스트 코드
//        ContentValues contentValues = new ContentValues();
//        ContentValues contentValues1 = new ContentValues();
//        ContentValues contentValues2 = new ContentValues();
//
//        contentValues.put("id", 1);
//        contentValues.put("name", "상추");
//        SQLiteDatabase db = SibaDbHelper.getInstance(this).getWritableDatabase();
//        db.insert("ingre_cate", null, contentValues);
//
//        contentValues1.put("id", 2);
//        contentValues1.put("ingredient_category_id", 3);
//        contentValues1.put("name", "잎채소");
//        db.insert("ingre_sub_cate", null, contentValues1);
//
//
//        contentValues2.put("id", 4);
//        contentValues2.put("ingredient_category_id", 363);
//        contentValues2.put("name", "상추");
//        contentValues2.put("file_name", "sangchu.webp");
//        db.insert("ingre_list", null, contentValues2);

        HttpAsyncTask httpAsyncTask = new HttpAsyncTask(MainActivity.class.getSimpleName());

        httpAsyncTask.execute("https://goo.gl/eIXu9l");

//        httpAsyncTask.execute("http://192.168.0.201:7777/ingredientCategory/list");

        // HTTP
//        new HttpAsyncTask().execute("http://192.168.0.201:7777/ingredientCategory/list");
//        new HttpAsyncTask().execute("https://goo.gl/eIXu9l");

    }


    public void clickToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}