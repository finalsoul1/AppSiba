package com.example.co.appsiba.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.RecipeActivity;
import com.example.co.appsiba.favorite.MyListAdapter;
import com.example.co.appsiba.favorite.list_item;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {

    public FavoritesFragment() {
        // Required empty public constructor
    }

    ListView listView;
    MyListAdapter myListAdapter;
    ArrayList<list_item> list_itemArrayList;
    ArrayAdapter<list_item> list_itemArrayAdapter;






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
        list_itemArrayAdapter = new ArrayAdapter<list_item>(getActivity(),list_itemArrayList.size());

        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                ImageView imageView = view.findViewById(R.id.favorite_imageView);

                TextView textView = view.findViewById(R.id.favorite_content_textview);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageView.getId());

                Intent intent = (new Intent(getContext(), RecipeActivity.class));

              
                intent .putExtra("data",textView.getText());
                intent .putExtra("image",bitmap);

                startActivity(intent);
                Toast.makeText(getActivity(), textView.getText(), Toast.LENGTH_SHORT).show();

            }
        });


        Button button2 = (Button)view.findViewById(R.id.favor_allDelete);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               list_itemArrayList.removeAll(list_itemArrayList);
               myListAdapter.notifyDataSetChanged();

            }
        });

        Button button3 = (Button)view.findViewById(R.id.favor_add);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_itemArrayList.add(new list_item(R.drawable.ic_launcher_background, "추가"));
                myListAdapter.notifyDataSetChanged();
            }
        });



        return view;


    }


}

