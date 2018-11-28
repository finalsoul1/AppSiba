package com.example.co.appsiba.result;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.co.appsiba.R;
import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.vo.MyRefriToResultVO;
import com.example.co.appsiba.vo.SearchResultVO;

import java.util.ArrayList;
import java.util.Collections;

public class ResultTabFragment1 extends Fragment {

    View view;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    SQLiteDatabase db;
    Cursor cursor;

    ArrayList<MyRefriToResultVO> data;
    ArrayList<SearchResultVO> searchData;

    String[] selectionArgs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.result_food_photo, container, false);


        viewPager = (ViewPager) view.findViewById(R.id.viewPager1);
        sliderDotspanel = (LinearLayout) view.findViewById(R.id.SliderDots);

        /////


        db = SibaDbHelper.getInstance(getActivity()).getReadableDatabase();
        cursor = db.rawQuery("select b.name from my_refrigerator a left outer join ingredient_list b\n" +
                "on a.ingredient_list_id = b.id", null);

        MyRefriToResultVO myRefriToResultVO;
        data = new ArrayList<>();

        while(cursor.moveToNext()){
            myRefriToResultVO = new MyRefriToResultVO();
            myRefriToResultVO.setName(cursor.getString(0));
            data.add(myRefriToResultVO);
        }

        cursor.close();

        Collections.shuffle(data);

        Log.d("kwon selec", data.size() + "");

        selectionArgs = new String[]{
                data.get(0).getName(),
                data.get(1).getName(),
                data.get(2).getName()
        };

        Log.d("kwon selec", selectionArgs[0]);

        Cursor cursor1;

        cursor1 = db.rawQuery("select id, name,  small_image_location from (\n" +
                "select id, name, small_image_location, big_image_location\n" +
                "from food \n" +
                "where food_type_id = 1\n" +
                "and id in (select food_id from food_ingredients where name like '%아욱%')\n" +
                "union\n" +
                "select id, name, small_image_location, big_image_location\n" +
                "from food \n" +
                "where food_type_id = 1\n" +
                "and id in (select food_id from food_ingredients where name like '%닭%')\n" +
                "union\n" +
                "select id, name, small_image_location, big_image_location\n" +
                "from food \n" +
                "where food_type_id = 1\n" +
                "and id in (select food_id from food_ingredients where name like '%고등어%')\n" +
                ") food limit 3;" , null);

        SearchResultVO searchResultVO;
        searchData = new ArrayList<>();


        while(cursor1.moveToNext()){
            searchResultVO = new SearchResultVO();
            searchResultVO.setId(cursor1.getInt(0));
            searchResultVO.setName(cursor1.getString(1));
            searchResultVO.setSmallImageLocation(cursor1.getString(2));

            searchData.add(searchResultVO);
        }

        Log.d("kwon", searchData.size() + "");



        /////


        viewPagerAdapter = new ViewPagerAdapter(getActivity(), 1);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i]);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
