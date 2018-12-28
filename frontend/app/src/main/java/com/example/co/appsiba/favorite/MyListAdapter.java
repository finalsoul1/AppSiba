package com.example.co.appsiba.favorite;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.RecipeActivity;
import com.example.co.appsiba.fragment.FavoritesFragment;
import com.example.co.appsiba.vo.FavoritesVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class MyViewholder extends RecyclerView.ViewHolder {
        TextView content_textView;
        ImageView imageView;
        Button button1;

        MyViewholder(@NonNull View view) {
            super(view);

            content_textView = (TextView) view.findViewById(R.id.favorite_content_textview);
            imageView = (ImageView) view.findViewById(R.id.favorite_imageView);
            button1 = (Button) view.findViewById(R.id.favor_deletebtn);

        }

    }

    Context context;
    ArrayList<FavoritesVO> list_itemArrayList;
    Fragment fragment;
    SQLiteDatabase db;
    MyViewholder myViewholder;

    public MyListAdapter(Context context, ArrayList<FavoritesVO> list_itemArrayList, FavoritesFragment favoritesFragment) {
        this.context = context;
        this.fragment = favoritesFragment;
        this.list_itemArrayList = list_itemArrayList;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.favorite_item, viewGroup, false);
        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int position) {

        myViewholder = (MyViewholder) viewHolder;

        myViewholder.content_textView.setText(list_itemArrayList.get(position).getRecipeName());

        Picasso.with(context)
                .load(list_itemArrayList.get(position).getRecipefileImage())
                .into(myViewholder.imageView);

        myViewholder.content_textView.setTag(list_itemArrayList.get(position).getRecipeId());

        myViewholder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = (new Intent(context, RecipeActivity.class));
                intent.putExtra("id", (Integer) list_itemArrayList.get(position).getRecipeId());
                context.startActivity(intent);

            }
        });
        myViewholder.content_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = (new Intent(context, RecipeActivity.class));
                intent.putExtra("id", (Integer) list_itemArrayList.get(position).getRecipeId());
                context.startActivity(intent);

            }
        });


        myViewholder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = list_itemArrayList.get(position).getRecipeId();
                String str = String.valueOf(id);
                db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getWritableDatabase();
                db.delete("my_favorates " ,"food_id=?",new String[]{str});
                Toast.makeText(context, "삭제했습니다.", Toast.LENGTH_SHORT).show();

                FragmentTransaction ft = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                ft.detach(fragment).attach(fragment).commit();

                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list_itemArrayList.size();
    }

}
