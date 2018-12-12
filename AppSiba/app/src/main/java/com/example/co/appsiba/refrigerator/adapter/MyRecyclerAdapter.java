package com.example.co.appsiba.refrigerator.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.helper.ResouceToInt;
import com.example.co.appsiba.vo.RefriIngredientVO;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private final List mData;

    public MyRecyclerAdapter(List mData) {
        this.mData = mData;
    }

    // 뷰홀더 생성
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_toggle, viewGroup, false);

        return new ViewHolder(view);
    }

    // 뷰홀더와 연결
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RefriIngredientVO refri = (RefriIngredientVO) mData.get(i);
        int resId = ResouceToInt.getResId(refri.getFileName(), R.drawable.class);

        viewHolder.foodName.setText(refri.getName());
        viewHolder.foodImage.setImageResource(resId);
        viewHolder.foodImage.setTag(refri.getId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    // 이너클래스로 뷰홀더 구현
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;
        ImageView foodImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            foodName = itemView.findViewById(R.id.food_nameView);
        }
    }
}

