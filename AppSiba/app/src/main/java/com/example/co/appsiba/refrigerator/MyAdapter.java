package com.example.co.appsiba.refrigerator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.refrigerator.model.FoodIngredients;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {

    private final List mData;

    private Map<String, Integer> mFoodImageMap;

    public MyAdapter(List<FoodIngredients> mData) {
        this.mData = mData;
        mFoodImageMap = new HashMap<>();
        mFoodImageMap.put("베이컨", R.drawable.baecon);
        mFoodImageMap.put("부채살", R.drawable.buchesal);
        mFoodImageMap.put("차돌박이", R.drawable.chadol);
        mFoodImageMap.put("불고기", R.drawable.bulgogi);
        mFoodImageMap.put("아구", R.drawable.agu);
        mFoodImageMap.put("당면", R.drawable.dangmean);
        mFoodImageMap.put("호두", R.drawable.hodu);
    }

    @Override
    public int getCount() { // 아이템 개수
        return mData.size();
    }

    @Override
    public Object getItem(int position) { // position 번째 아이템
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) { // position 번째 아이디
        return position;
    }

    @Override // position 번째 아이템의 View를 구성하는 부분
    public View getView(int position, View convertView, ViewGroup parent) {
        // 뷰홀더패턴
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_toggle, parent, false);

            // 재료이름, 이미지 View
            ImageView foodImage = (ImageView) convertView.findViewById(R.id.food_image);
            TextView foodName = (TextView) convertView.findViewById(R.id.food_nameView);

            holder.foodImage = foodImage;
            holder.foodName = foodName;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 현재 position 의 데이터
        FoodIngredients foodIngredients = (FoodIngredients) mData.get(position);

        // 데이터 설정
        holder.foodName.setText(foodIngredients.getFoodName());
        holder.foodImage.setImageResource(mFoodImageMap.get(foodIngredients.getFoodName()));

        return convertView;
    }
    static class ViewHolder{
        ImageView foodImage;
        TextView foodName;
    }
}
