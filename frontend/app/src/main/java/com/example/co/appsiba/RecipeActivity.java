package com.example.co.appsiba;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.helper.ScrollHelper;
import com.example.co.appsiba.recipe.IndgredientsAdapter;
import com.example.co.appsiba.recipe.ProcessAdapter;
import com.example.co.appsiba.vo.RecipeVO;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class RecipeActivity extends AppCompatActivity {


    ListView listView;
    ListView listView2;
    ImageButton Add_favor_btn;
    int id;

    IndgredientsAdapter myindgredientsAdapter;
    ProcessAdapter processAdapter;

    ArrayList<RecipeVO> data;
    ArrayList<RecipeVO> recipe_itemArrayList1;
    ArrayList<RecipeVO> recipe_itemArrayList2;

    Cursor cursor;
    Cursor cursor1;
    Cursor cursor2;

    SQLiteDatabase db;

    RecipeVO recipeVO;
    RecipeVO recipeVO1;
    RecipeVO recipeVO2;


    private String getDateTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_recipe);

        Intent intentFromResult = getIntent();
        Intent intentFromFavor = getIntent();

        int toSearchId = intentFromResult.getIntExtra("id", id);
        toSearchId = intentFromFavor.getIntExtra("id", id);

        String stringid = String.valueOf(toSearchId);

        //String stringid1 = String.valueOf(toSearchId1);
        listView = (ListView) findViewById(R.id.recipe_indgredients);

        db = com.example.co.appsiba.db.SibaDbHelper.getInstance(this).getReadableDatabase();
        cursor = db.rawQuery("select distinct  id, name, small_image_location from food where id = ?", new String[]{stringid});

        recipeVO = new RecipeVO();

        cursor.moveToNext();
        recipeVO.setId(cursor.getInt(0));
        recipeVO.setName(cursor.getString(1));
        recipeVO.setSmall_image_location(cursor.getString(2));

        cursor.close();

        final ImageView imageView = (ImageView) findViewById(R.id.main_recipe_image);
        TextView textView = (TextView) findViewById(R.id.main_recipe_image_textView);

        textView.setText(recipeVO.getName());
        Picasso.with(RecipeActivity.this)
                .load(recipeVO.getSmall_image_location())
                .into(imageView);

////////////////////////////////////////////////////////////////////////

        cursor1 = db.rawQuery("select distinct * from food_recipe where food_id =? order by ord asc", new String[]{stringid});
        Log.d("sh11111", String.valueOf(cursor1.getCount()));
        recipe_itemArrayList1 = new ArrayList<>();

        while (cursor1.moveToNext()) {
            recipeVO1 = new RecipeVO();
            recipeVO1.setId(cursor1.getInt(1));
            recipeVO1.setName(cursor1.getString(2));
            recipeVO1.setSmall_image_location(cursor1.getString(3));

            recipe_itemArrayList1.add(recipeVO1);
        }

        cursor1.close();

        listView2 = (ListView) findViewById(R.id.recipe_process);

        processAdapter = new ProcessAdapter(RecipeActivity.this, recipe_itemArrayList1);
        listView2.setAdapter(processAdapter);

////////////////////////////////////////////////////////////////////////////////////


        cursor2 = db.rawQuery("select distinct * from food_ingredients where food_id = ?", new String[]{stringid});

        recipe_itemArrayList2 = new ArrayList<>();

        while (cursor2.moveToNext()) {
            recipeVO2 = new RecipeVO();
            recipeVO2.setId(cursor2.getInt(1));
            recipeVO2.setName(cursor2.getString(2));

            recipe_itemArrayList2.add(recipeVO2);
        }

        cursor2.close();

        listView = (ListView) findViewById(R.id.recipe_indgredients);

        myindgredientsAdapter = new IndgredientsAdapter(RecipeActivity.this, recipe_itemArrayList2);
        listView.setAdapter(myindgredientsAdapter);

        ScrollHelper.setListViewHeightBasedOnChildren(listView);
        ScrollHelper.setListViewHeightBasedOnChildren(listView2);

/////////////////////////////////////////////////////////////////////////////////////

        Add_favor_btn = (ImageButton) findViewById(R.id.Add_favor_btn);
        Add_favor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(RecipeActivity.this, "즐겨찾기에 추가했습니다.", Toast.LENGTH_SHORT).show();

                SQLiteDatabase db = com.example.co.appsiba.db.SibaDbHelper.getInstance(RecipeActivity.this).getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                int foodid = recipeVO.getId();

                contentValues.put("food_id", foodid);
                db.insert("my_favorates", null, contentValues);

            }


        });
    }
}
