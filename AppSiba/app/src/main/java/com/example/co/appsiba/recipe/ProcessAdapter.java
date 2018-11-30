package com.example.co.appsiba.recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.vo.RecipeVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProcessAdapter extends BaseAdapter {
    Context context;
    ArrayList<RecipeVO> recipe_itemArrayList;
    TextView recipe_process_textview;
    ImageView recipe_image;


    public ProcessAdapter(Context context, ArrayList<RecipeVO> recipe_itemArrayList) {
        this.context = context;
        this.recipe_itemArrayList = recipe_itemArrayList;

    }

    @Override
    public int getCount() {
        return recipe_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return recipe_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.recipe_item,null);

            recipe_image=(ImageView)convertView.findViewById(R.id.recipe_imageView);
            recipe_process_textview=(TextView) convertView.findViewById(R.id.recipe_content_textview);

            recipe_process_textview.setText(recipe_itemArrayList.get(position).getName());


                 Picasso.with(context)
                         .load(recipe_itemArrayList.get(position).getSmall_image_location())
                         .into(recipe_image);
             }
        return convertView;
    }
}
