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
    Cursor cursor;
    SQLiteDatabase db;

    ArrayList<MyRefriToResultVO> data;
    ArrayList<MyRefriToResultVO> mdata;

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

        viewPager = (ViewPager)view.findViewById(R.id.viewPager1);
        sliderDotspanel = (LinearLayout)view.findViewById(R.id.SliderDots);

        db = com.example.co.appsiba.db.SibaDbHelper.getInstance(getActivity()).getReadableDatabase();
        cursor = db.rawQuery("select b.name from my_refrigerator a left outer join ingredient_list b\n" +
                "on a.ingredient_list_id = b.id", null);

        MyRefriToResultVO myRefriToResultVO;
        data = new ArrayList<>();

        while (cursor.moveToNext()) {
            myRefriToResultVO = new MyRefriToResultVO();
            myRefriToResultVO.setName(cursor.getString(0));
            data.add(myRefriToResultVO);
        }

        Collections.shuffle(data);

        mdata = new ArrayList<>();
        if (data.size() > 3) {
            mdata.addAll(data.subList(0, 3));
        } else {
            mdata.addAll(data);
        }

        selectionArgs = new String[mdata.size()];
        int count = 0;
        for (MyRefriToResultVO mrr : mdata) {
            selectionArgs[count] = "%" + mrr.getName() + "%";
            count++;
        }

        cursor = db.rawQuery("select id, name, small_image_location\n" +
                "from food \n" +
                "where food_type_id =1\n" +
                "and id in (\n" +
                "select food_id from food_ingredients \n" +
                "where name like ? \n" +
                "or name like ?\n" +
                "or name like ?)\n" +
                "limit 3", selectionArgs);

        SearchResultVO searchResultVO;
        searchData = new ArrayList<>();

        Log.d("kwon cursor", cursor.getCount() + "");

        while (cursor.moveToNext()) {
            searchResultVO = new SearchResultVO();
            searchResultVO.setId(cursor.getInt(0));
            searchResultVO.setName(cursor.getString(1));
            searchResultVO.setSmallImageLocation(cursor.getString(2));

            searchData.add(searchResultVO);
        }

        cursor.close();

        Log.d("kwon selec", searchData.size() + "");

        /////

        if (searchData.size() == 0) {
            viewPager.setBackgroundResource(R.drawable.siba_mark_more_searching);
        } else {
            viewPager.setBackgroundResource(R.drawable.siba_mark_searching);
        }

        viewPagerAdapter = new ViewPagerAdapter(getActivity(), searchData);

        viewPager.setAdapter(viewPagerAdapter);

        Log.d("kwon why??", "");

        if (searchData.size() > 0) {

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
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
