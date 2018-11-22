package com.example.co.appsiba;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.co.appsiba.helper.ScrollHelper;
import com.example.co.appsiba.recipe.IndgredientsAdapter;
import com.example.co.appsiba.recipe.ProcessAdapter;
import com.example.co.appsiba.recipe.indgredients_item;
import com.example.co.appsiba.recipe.recipe_item;

import java.util.ArrayList;

 public class RecipeActivity extends AppCompatActivity {


     ListView listView;
     ListView listView2;
     Button Add_favor_btn;


     IndgredientsAdapter myindgredientsAdapter;
     ProcessAdapter processAdapter;

     ArrayList<indgredients_item> indgredients_itemArrayList;
     ArrayList<recipe_item> recipe_itemArrayList;


     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.fragment_recipe);

         listView = (ListView) findViewById(R.id.recipe_indgredients);

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

         Add_favor_btn = (Button) findViewById(R.id.Add_favor_btn);
         Add_favor_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });
     }
 }


