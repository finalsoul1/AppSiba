package com.example.co.appsiba.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.RecipeActivity;
import com.example.co.appsiba.favorite.MyListAdapter;
import com.example.co.appsiba.favorite.list_item;
import com.example.co.appsiba.vo.FavoritesVO;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {





    Cursor cursor;
    SQLiteDatabase db;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    ListView listView;
    MyListAdapter myListAdapter;

    ArrayAdapter<list_item> list_itemArrayAdapter;

    ArrayList<FavoritesVO> list_itemArrayList;
    ArrayList<FavoritesVO> list_itemArrayList1;




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

        db = com.example.co.appsiba.db.SibaDbHelper.getInstance(getContext()).getReadableDatabase();



        cursor = db.rawQuery("select a.food_id, b.name, b.small_image_location\n" +
                "from my_favorates a left outer join food b\n" +
                "on a.food_id = b.id\n", null);

        Log.d("sh123", cursor.toString());

        list_itemArrayList = new ArrayList<>();
        FavoritesVO favoritesVO;

        while(cursor.moveToNext()){
            favoritesVO = new FavoritesVO();
            favoritesVO.setRecipeId(cursor.getInt(0));
            favoritesVO.setRecipeName(cursor.getString(1));
            favoritesVO.setRecipefileImage(cursor.getString(2));

            list_itemArrayList.add(favoritesVO);
        }

        cursor.close();

        list_itemArrayList1 = new ArrayList<>();
        for(FavoritesVO favor : list_itemArrayList){
            list_itemArrayList1.add(favor);
        }

        listView = (ListView) view.findViewById(R.id.my_listView);



//        list_itemArrayList.add(new list_item(R.drawable.baecon, "food1baecon"));
//        list_itemArrayList.add(new list_item(R.drawable.agu, "food2agu"));
//        list_itemArrayList.add(new list_item(R.drawable.buchesal, "food3buchesal"));
//        list_itemArrayList.add(new list_item(R.drawable.dangmean, "food4dangmean"));


        myListAdapter = new MyListAdapter( getActivity(),list_itemArrayList1);
        list_itemArrayAdapter = new ArrayAdapter<list_item>(getActivity(),list_itemArrayList.size());

        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView imageView = view.findViewById(R.id.favorite_imageView);

                TextView textView = view.findViewById(R.id.favorite_content_textview);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageView.getId());

                Intent intent = (new Intent(getActivity(), RecipeActivity.class));

              
              //  intent .putExtra("data",textView.getText());
              //  intent .putExtra("image",bitmap);

                startActivity(intent);
              //  Toast.makeText(getActivity(), textView.getText(), Toast.LENGTH_SHORT).show();

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



        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       // db = com.example.co.appsiba.db.SibaDbHelper.getInstance(getContext()).getReadableDatabase();
        //cursot = db.


    }
}

