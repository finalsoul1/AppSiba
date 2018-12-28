package com.example.co.appsiba.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.co.appsiba.R;
import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.fragment.adapter.RefriRecyclerAdapter;
import com.example.co.appsiba.helper.MyRefriCustomDialog;
import com.example.co.appsiba.helper.MyRefriSearchDialog;
import com.example.co.appsiba.vo.MyRefriVO;

import java.util.ArrayList;

public class MyrefriFragment extends Fragment {

    ArrayList<MyRefriVO> data;

    Cursor cursor;
    SQLiteDatabase db;

    MyRefriCustomDialog myRefriCustomDialog;
    MyRefriSearchDialog myRefriSearchDialog;

    public MyrefriFragment() {
        // Required empty public constructor
    }

    public static MyrefriFragment newInstance(String param1, String param2) {
        MyrefriFragment fragment = new MyrefriFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myrefri, container, false);

        // 검색 버튼
        Button toSearchBtn = view.findViewById(R.id.to_search);
        toSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = SibaDbHelper.getInstance(getActivity()).getReadableDatabase();

                cursor = db.rawQuery("select a.ingredient_list_id, b.name, b.file_name from \n" +
                        "my_refrigerator a left outer join ingredient_list b\n" +
                        "on a.ingredient_list_id = b.id", null);

                if (cursor.getCount() < 3) {
                    cursor.close();
                    myRefriSearchDialog = new MyRefriSearchDialog(getContext());
                    myRefriSearchDialog.call();
                } else {
                    Fragment fragment2 = new ResultFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container, fragment2);
                    fragmentTransaction.commit();
                }
            }
        });
        // 비우기 버튼
        Button myRefriClearBtn = view.findViewById(R.id.myrefri_clear);
        myRefriClearBtn.setOnClickListener(new ClearClickListener(this));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();

        db = SibaDbHelper.getInstance(getActivity()).getReadableDatabase();

        cursor = db.rawQuery("select a.ingredient_list_id, b.name, " +
                "b.file_name from my_refrigerator a " +
                "left outer join ingredient_list b\n" +
                "on a.ingredient_list_id = b.id", null);

        data = new ArrayList<>();
        MyRefriVO myRefriVO;

        while (cursor.moveToNext()) {
            myRefriVO = new MyRefriVO();
            myRefriVO.setIngredientListId(cursor.getInt(0));
            myRefriVO.setName(cursor.getString(1));
            myRefriVO.setFileName(cursor.getString(2));

            data.add(myRefriVO);
        }

        cursor.close();

        RecyclerView recyclerView = getActivity().findViewById(R.id.myrefri_view);
        recyclerView.setNestedScrollingEnabled(false); // 부드러운 스크롤링 설정

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(gridLayoutManager); // 4칸 설정

        RefriRecyclerAdapter refriRecyclerAdapter = new RefriRecyclerAdapter(data, getContext());
        recyclerView.setAdapter(refriRecyclerAdapter);
    }

    public class ClearClickListener implements View.OnClickListener {

        Fragment fragment;

        public ClearClickListener(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View v) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();

            myRefriCustomDialog = new MyRefriCustomDialog(getContext(), ft, fragment);
            myRefriCustomDialog.call();
        }
    }
}

