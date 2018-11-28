package com.example.co.appsiba;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.fragment.FavoritesFragment;
import com.example.co.appsiba.helper.ScrollHelper;
import com.example.co.appsiba.recipe.IndgredientsAdapter;
import com.example.co.appsiba.recipe.ProcessAdapter;
import com.example.co.appsiba.recipe.indgredients_item;
import com.example.co.appsiba.recipe.recipe_item;
import com.example.co.appsiba.vo.RecipeVO;

import java.util.ArrayList;

 public class RecipeActivity extends AppCompatActivity {


     ListView listView;
     ListView listView2;
     Button Add_favor_btn;

     ArrayList<RecipeVO> data;
     ArrayList<RecipeVO> data1;
     ArrayList<RecipeVO> data2;
     ArrayList<RecipeVO> data3;


     IndgredientsAdapter myindgredientsAdapter;
     ProcessAdapter processAdapter;

     ArrayList<indgredients_item> indgredients_itemArrayList;
     ArrayList<recipe_item> recipe_itemArrayList;

     Cursor cursor;
     SQLiteDatabase db;

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.fragment_recipe);

         Intent intent = getIntent();

         listView = (ListView) findViewById(R.id.recipe_indgredients);

         db = com.example.co.appsiba.db.SibaDbHelper.getInstance(this).getReadableDatabase();
         cursor = db.rawQuery("select id, name, small_image_location from food where id = 54", null);

         RecipeVO recipeVO = new RecipeVO();

         cursor.moveToNext();
         recipeVO.setId(cursor.getInt(0));
         recipeVO.setName(cursor.getString(1));
         recipeVO.setSmall_image_location(cursor.getString(2));

         Log.d("sh1128",recipeVO.toString());

         cursor.close();

         indgredients_itemArrayList = new ArrayList<indgredients_item>();

         indgredients_itemArrayList.add(new indgredients_item("감자 100g"));
         indgredients_itemArrayList.add(new indgredients_item("감자 200g"));
         indgredients_itemArrayList.add(new indgredients_item("감자 300g"));
         indgredients_itemArrayList.add(new indgredients_item("감자 400g"));
         indgredients_itemArrayList.add(new indgredients_item("감자 500g"));
         indgredients_itemArrayList.add(new indgredients_item("감자 600g"));


         listView2 = (ListView) findViewById(R.id.recipe_process);

         recipe_itemArrayList = new ArrayList<recipe_item>();

         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "1분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "2분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "3분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "4분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "5분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "6분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "7분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "8분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "9분동안  데우기"));
         recipe_itemArrayList.add(new recipe_item(R.drawable.avocado, "10분동안  데우기"));


         myindgredientsAdapter = new IndgredientsAdapter(RecipeActivity.this, indgredients_itemArrayList);
         listView.setAdapter(myindgredientsAdapter);

         processAdapter = new ProcessAdapter(RecipeActivity.this, recipe_itemArrayList);
         listView2.setAdapter(processAdapter);


         ScrollHelper.setListViewHeightBasedOnChildren(listView);
         ScrollHelper.setListViewHeightBasedOnChildren(listView2);

        ImageView imageView = (ImageView)findViewById(R.id.main_recipe_image);
        TextView textView = (TextView)findViewById(R.id.main_recipe_image_textView);




         RecipeVO recipe = new RecipeVO();

         textView.setText(recipe.getName());
     



         Add_favor_btn = (Button) findViewById(R.id.Add_favor_btn);
         Add_favor_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 FavoritesFragment favoritesFragment = new FavoritesFragment();
                 Bundle bundle = new Bundle();
                 bundle.putString("userId", "바보");
                 favoritesFragment.setArguments(bundle);
                 Toast.makeText(RecipeActivity.this, "="+bundle.getString("userId"), Toast.LENGTH_SHORT).show();


             }


         });



     }



 }


