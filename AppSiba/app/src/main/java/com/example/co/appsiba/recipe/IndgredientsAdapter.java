package com.example.co.appsiba.recipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.ingredients_item, null);

            indgredients_textView = (TextView)convertView.findViewById(R.id.ingredients_content_textview);
            indgredients_textView.setText(indgredients_itemArrayList.get(position).getName());

            //region Region ysMemo
            Button memoAddButton = convertView.findViewById(R.id.memo_add_btn);
            memoAddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ingredientName = indgredients_itemArrayList.get(position).getName();

                    SQLiteDatabase db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getWritableDatabase();
                    ContentValues contentValues = new ContentValues();

                    contentValues.put("ingredient_name", ingredientName);
                    contentValues.put("checked", "N");
                    db.insert("my_notepad", null, contentValues);

                    Toast.makeText(context, ingredientName + "이 메모장에 추가되었습니다.", Toast.LENGTH_LONG).show();
                }
            });
            //endregion ysMemo
    }



    return convertView;
 }
}
