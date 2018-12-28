package com.example.co.appsiba.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.co.appsiba.R;
import com.example.co.appsiba.favorite.FavorCustomDialog;
import com.example.co.appsiba.favorite.MyListAdapter;
import com.example.co.appsiba.favorite.list_item;
import com.example.co.appsiba.vo.FavoritesVO;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {

    Cursor cursor;
    SQLiteDatabase db;
    FavoritesVO favoritesVO;
    View view;

    MyListAdapter myListAdapter;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;


    ArrayAdapter<list_item> list_itemArrayAdapter;

    ArrayList<FavoritesVO> list_itemArrayList;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    public static FavoritesFragment newInstance(String param1, String param2) {
        FavoritesFragment fragment = new FavoritesFragment();
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

        view = inflater.inflate(R.layout.fragment_favorites, container, false);

        db = com.example.co.appsiba.db.SibaDbHelper.getInstance(getContext()).getReadableDatabase();

        cursor = db.rawQuery(" select  distinct a.food_id, b.name, b.small_image_location\n" +
                "from my_favorates a left outer join food b\n" +
                "on a.food_id = b.id\n" + "order by a.id desc", null);


        list_itemArrayList = new ArrayList<>();

        while (cursor.moveToNext()) {
            favoritesVO = new FavoritesVO();
            favoritesVO.setRecipeId(cursor.getInt(0));
            favoritesVO.setRecipeName(cursor.getString(1));
            favoritesVO.setRecipefileImage(cursor.getString(2));
            list_itemArrayList.add(favoritesVO);
        }
        cursor.close();

        mRecyclerView  = view.findViewById(R.id.my_listView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        myListAdapter  = new MyListAdapter(getActivity(), list_itemArrayList, this);

        list_itemArrayAdapter = new ArrayAdapter<list_item>(getActivity(), list_itemArrayList.size());

        mRecyclerView.setAdapter(myListAdapter);


        mRecyclerView.setNestedScrollingEnabled(false);


        Button button2 = (Button) view.findViewById(R.id.favor_allDelete);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavorCustomDialog favorCustomDialog = new FavorCustomDialog(getContext());
                favorCustomDialog.call(list_itemArrayList, myListAdapter);


                myListAdapter.notifyDataSetChanged();


            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}

