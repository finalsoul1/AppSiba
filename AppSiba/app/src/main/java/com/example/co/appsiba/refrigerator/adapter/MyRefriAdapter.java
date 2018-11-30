package com.example.co.appsiba.refrigerator.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.helper.ResouceToInt;
import com.example.co.appsiba.vo.MyRefriVO;

import java.util.List;

public class MyRefriAdapter extends BaseAdapter {

    private final List mData;

    public MyRefriAdapter(List<MyRefriVO> mData) {
        this.mData = mData;
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

    int count = 0;

    @Override // position 번째 아이템의 View를 구성하는 부분
    public View getView(int position, View convertView, ViewGroup parent) {
        // 뷰홀더패턴
        ViewHolder holder;


        if(convertView == null){
            Log.d("convertView", "convertView = " + (++count));
            holder = new ViewHolder();

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_toggle_my, parent, false);

            // 재료이름, 이미지 View
            ImageView foodImage = convertView.findViewById(R.id.myfood_image);
            TextView foodName = convertView.findViewById(R.id.myfood_nameView);

            holder.foodImage = foodImage;
            holder.foodName = foodName;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 현재 position 의 데이터
        MyRefriVO refri = (MyRefriVO) mData.get(position);
        int resId = ResouceToInt.getResId(refri.getFileName(), R.drawable.class);
        Log.d("확인", refri.getName());

        // 데이터 설정
        holder.foodName.setText(refri.getName());
        holder.foodImage.setImageResource(resId);
        holder.foodImage.setTag(refri.getIngredientListId());

        return convertView;
    }

    static class ViewHolder{
        ImageView foodImage;
        TextView foodName;
    }

}
