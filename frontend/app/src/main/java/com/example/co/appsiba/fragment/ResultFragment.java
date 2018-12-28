package com.example.co.appsiba.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.co.appsiba.R;
import com.example.co.appsiba.helper.MyRefriSearchDialog;
import com.example.co.appsiba.result.TabPagerAdapter;

public class ResultFragment extends Fragment {


    private View view;
    protected ViewPager viewPager;
    protected TabLayout tabLayout;
    private TabPagerAdapter pagerAdapter;
    SQLiteDatabase db;
    Cursor cursor;
    MyRefriSearchDialog myRefriSearchDialog;

    public ResultFragment() {
    }

    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        db = com.example.co.appsiba.db.SibaDbHelper.getInstance(getActivity()).getReadableDatabase();

        cursor = db.rawQuery("select a.ingredient_list_id, b.name, b.file_name from \n" +
                "my_refrigerator a left outer join ingredient_list b\n" +
                "on a.ingredient_list_id = b.id", null);

        if(cursor.getCount() < 3) {

            cursor.close();
            myRefriSearchDialog = new MyRefriSearchDialog(getContext());
            myRefriSearchDialog.call();

            getFragmentManager().popBackStack();

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_results, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.resultViewPager);
        pagerAdapter = new TabPagerAdapter(getChildFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}