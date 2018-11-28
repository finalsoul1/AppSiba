package com.example.co.appsiba.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.refrigerator.adapter.MyRefriAdapter;
import com.example.co.appsiba.vo.MyRefriVO;

import java.util.ArrayList;

public class MyrefriFragment extends Fragment {

    ArrayList<MyRefriVO> data;

    Cursor cursor;
    SQLiteDatabase db;

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


        Button toSearchBtn = (Button) view.findViewById(R.id.to_search);
        toSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ResultFragment.class);
                startActivity(intent);
            }
        });

        Button myRefriClearBtn = view.findViewById(R.id.myrefri_clear);
        myRefriClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = SibaDbHelper.getInstance(getActivity()).getReadableDatabase();
                db.delete("my_refrigerator", null, null);
                onResume();
            }
        });

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

        cursor = db.rawQuery("select a.ingredient_list_id, b.name, b.file_name from \n" +
                "my_refrigerator a left outer join ingredient_list b\n" +
                "on a.ingredient_list_id = b.id", null);

        data = new ArrayList<>();
        MyRefriVO myRefriVO;

        while (cursor.moveToNext()){
            myRefriVO = new MyRefriVO();
            myRefriVO.setIngredientListId(cursor.getInt(0));
            myRefriVO.setName(cursor.getString(1));
            myRefriVO.setFileName(cursor.getString(2));

            data.add(myRefriVO);
        }

        cursor.close();

        Log.d("kwon", data.toString());

        GridView gridView = getActivity().findViewById(R.id.myrefri_view);

        MyRefriAdapter myRefriAdapter = new MyRefriAdapter(data);

        Log.d("kwon", myRefriAdapter.toString());

        myRefriAdapter.notifyDataSetChanged();

        gridView.setAdapter(myRefriAdapter);

    }

}