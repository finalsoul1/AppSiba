package com.example.co.appsiba.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.favorite.MyListAdapter;
import com.example.co.appsiba.favorite.list_item;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment implements View.OnClickListener {

    public FavoritesFragment() {
        // Required empty public constructor
    }

    ListView listView;
    MyListAdapter myListAdapter;
    ArrayList<list_item> list_itemArrayList;

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

        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        listView = (ListView) view.findViewById(R.id.my_listView);

        list_itemArrayList = new ArrayList<list_item>();

        list_itemArrayList.add(new list_item(R.drawable.baecon, "food1baecon"));
        list_itemArrayList.add(new list_item(R.drawable.agu, "food2agu"));
        list_itemArrayList.add(new list_item(R.drawable.buchesal, "food3buchesal"));
        list_itemArrayList.add(new list_item(R.drawable.dangmean, "food4dangmean"));


        myListAdapter = new MyListAdapter(getActivity(), list_itemArrayList);

        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), list_itemArrayList.get(position).getContent(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }


    @Override
    public void onClick(View v) {

    }
}
