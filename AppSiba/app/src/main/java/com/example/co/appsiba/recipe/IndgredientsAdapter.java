package com.example.co.appsiba.recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.vo.RecipeVO;

import java.util.ArrayList;


public class IndgredientsAdapter extends BaseAdapter {

    Context context;
    ArrayList<RecipeVO> indgredients_itemArrayList;
    TextView indgredients_textView;



    public IndgredientsAdapter(Context context, ArrayList<RecipeVO> indgredients_itemArrayList) {
        this.context = context;
        this.indgredients_itemArrayList = indgredients_itemArrayList;
    }

    @Override
    public int getCount() {
        return this.indgredients_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return  this.indgredients_itemArrayList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.ingredients_item, null);

            indgredients_textView = (TextView)convertView.findViewById(R.id.ingredients_content_textview);
            indgredients_textView.setText(indgredients_itemArrayList.get(position).getName());
    }



    return convertView;
 }
}
