package com.example.co.appsiba.fragment.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.helper.ResouceToInt;
import com.example.co.appsiba.vo.MyRefriVO;
import com.example.co.appsiba.vo.RefriIngredientVO;

import java.util.List;

public class RefriRecyclerAdapter extends RecyclerView.Adapter<RefriRecyclerAdapter.ViewHolder> {

    private final List mData;
    private SQLiteDatabase db;
    private Context context;

    public RefriRecyclerAdapter(List mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_toggle_my, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        MyRefriVO refri = (MyRefriVO) mData.get(i);
        int resId = ResouceToInt.getResId(refri.getFileName(), R.drawable.class);
        final int id = refri.getIngredientListId();

        viewHolder.foodName.setText(refri.getName());
        viewHolder.foodImage.setImageResource(resId);
        viewHolder.foodImage.setTag(id);

        // 냉장고 속 재료 지우는 이벤트리스너
        viewHolder.foodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = SibaDbHelper.getInstance(context).getWritableDatabase();
                db.delete("my_refrigerator", "ingredient_list_id = ?",
                        new String[]{String.valueOf(id)});

                mData.remove(i);
                notifyItemRemoved(i); // 리사이클러 뷰 실시간 적용
                notifyItemRangeChanged(i, mData.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;
        ImageView foodImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.myfood_image);
            foodName = itemView.findViewById(R.id.myfood_nameView);
        }
    }
}

