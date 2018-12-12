package com.example.co.appsiba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.refrigerator.EtcFragment;
import com.example.co.appsiba.refrigerator.FishFragment;
import com.example.co.appsiba.refrigerator.FruitFragment;
import com.example.co.appsiba.refrigerator.MeatFragment;
import com.example.co.appsiba.refrigerator.RefriAdapter;
import com.example.co.appsiba.refrigerator.VegiFragment;
import com.example.co.appsiba.vo.MyRefriVO;

import java.util.ArrayList;

public class RefriActivity extends AppCompatActivity
        implements MeatFragment.OnFragmentInteractionListener,
        EtcFragment.OnFragmentInteractionListener,
        FishFragment.OnFragmentInteractionListener,
        FruitFragment.OnFragmentInteractionListener,
        VegiFragment.OnFragmentInteractionListener {

    Cursor cursor;
    SQLiteDatabase db;
    ArrayList<MyRefriVO> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refri);

        ViewPager viewPager = findViewById(R.id.refri_pager);
        RefriAdapter adapter = new RefriAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    // 재료추가 부분
    public void onClick(View view) {
        TextView textView = view.findViewById(R.id.food_nameView);
        ImageView imageView = view.findViewById(R.id.food_image);

        db = SibaDbHelper.getInstance(this).getWritableDatabase();

        int id = (int) imageView.getTag();

        cursor = db.rawQuery("select ingredient_list_id from my_refrigerator " +
                "where ingredient_list_id = ?", new String[]{String.valueOf(id)});

        if(cursor.getCount() == 0){
            ContentValues contentValues = new ContentValues();

            contentValues.put("ingredient_list_id", id);
            db.insert("my_refrigerator", null, contentValues);

            Toast.makeText(this, textView.getText() + "을/를 추가하셨습니다.", Toast.LENGTH_LONG).show();
            imageView.setImageAlpha(20);

        } else {
            imageView.setImageAlpha(20);
            Toast.makeText(this, textView.getText() + "을/를 이미 추가하셨습니다.", Toast.LENGTH_LONG).show();
        }

        /////////////////////////////////////////

//        cursor = db.rawQuery("select a.ingredient_list_id, b.name, b.file_name from \n" +
//                "my_refrigerator a left outer join ingredient_list b\n" +
//                "on a.ingredient_list_id = b.id", null);
//
//        data = new ArrayList<>();
//        MyRefriVO myRefriVO;
//
//        while (cursor.moveToNext()) {
//            myRefriVO = new MyRefriVO();
//            myRefriVO.setIngredientListId(cursor.getInt(0));
//            myRefriVO.setName(cursor.getString(1));
//            myRefriVO.setFileName(cursor.getString(2));
//
//            data.add(myRefriVO);
//        }
//
//        int idTag = (Integer) imageView.getTag();
//        Boolean inRefri = false;
//
//        for (MyRefriVO myRefri : data) {
//            if (myRefri.getIngredientListId() == idTag) {
//                inRefri = true;
//                break;
//            }
//        }
//
//        if (!inRefri) {
//            ContentValues contentValues = new ContentValues();
//
//            contentValues.put("ingredient_list_id", idTag);
//            db.insert("my_refrigerator", null, contentValues);
//
//            Toast.makeText(this, textView.getText() + "을/를 추가하셨습니다.", Toast.LENGTH_LONG).show();
//            imageView.setImageAlpha(20);
//
//        } else {
//            imageView.setImageAlpha(20);
//            Toast.makeText(this, textView.getText() + "을/를 이미 추가하셨습니다.", Toast.LENGTH_LONG).show();
//        }
    }
}
