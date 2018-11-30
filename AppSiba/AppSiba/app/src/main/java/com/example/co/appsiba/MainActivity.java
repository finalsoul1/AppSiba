package com.example.co.appsiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.co.appsiba.thread.HttpAsyncTask;
import com.example.co.appsiba.thread.HttpAsyncTask2;
import com.example.co.appsiba.thread.HttpAsyncTask3;
import com.example.co.appsiba.thread.HttpAsyncTask4;
import com.example.co.appsiba.thread.HttpAsyncTask5;
import com.example.co.appsiba.thread.HttpAsyncTask6;
import com.example.co.appsiba.thread.HttpAsyncTask7;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void clickToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);

        try {
            startActivity(intent);
        } catch (OutOfMemoryError e){

        }

    }


    public void testHttp(View view) {
        Log.d(TAG, "testHttp() called.");

        HttpAsyncTask httpAsyncTask = new HttpAsyncTask(MainActivity.class.getSimpleName(), this);
        HttpAsyncTask2 httpAsyncTask2 = new HttpAsyncTask2(MainActivity.class.getSimpleName(), this);
        HttpAsyncTask3 httpAsyncTask3 = new HttpAsyncTask3(MainActivity.class.getSimpleName(), this);
        HttpAsyncTask4 httpAsyncTask4 = new HttpAsyncTask4(MainActivity.class.getSimpleName(), this);
        HttpAsyncTask5 httpAsyncTask5 = new HttpAsyncTask5(MainActivity.class.getSimpleName(), this);
        HttpAsyncTask6 httpAsyncTask6 = new HttpAsyncTask6(MainActivity.class.getSimpleName(), this);
        HttpAsyncTask7 httpAsyncTask7 = new HttpAsyncTask7(MainActivity.class.getSimpleName(), this);

        httpAsyncTask.execute("http://192.168.0.201:7777/ingredientCategory/list");
        httpAsyncTask2.execute("http://192.168.0.201:7777/ingredientSubCategory/list");
        httpAsyncTask3.execute("http://192.168.0.201:7777/ingredientList/list");
        httpAsyncTask4.execute("http://192.168.0.201:7777/foodType/list");
        httpAsyncTask5.execute("http://192.168.0.201:7777/food/list");
        httpAsyncTask6.execute("http://192.168.0.201:7777/recipe/list");
        httpAsyncTask7.execute("http://192.168.0.201:7777/ingredients/list");


    }

}