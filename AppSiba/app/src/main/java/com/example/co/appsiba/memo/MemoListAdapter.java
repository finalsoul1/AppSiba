package com.example.co.appsiba.memo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.co.appsiba.R;

import java.util.ArrayList;

public class MemoListAdapter extends BaseAdapter {
    Context context;
    ArrayList<memos> memosArrayList;
    TextView textView;

    // 생성자
    public MemoListAdapter(Context context, ArrayList<memos> memosArrayList) {
        this.context = context;
        this.memosArrayList = memosArrayList;
    }

    // memosArrayList에 몇개 들어있나 세기
    @Override
    public int getCount() {
        return this.memosArrayList.size();
    }

    // memosArrayList의 n번째 요소 가져오기
    @Override
    public Object getItem(int position) {
        return this.memosArrayList.get(position);
    }

    // memosArrayList의 마지막 요소 id를 가져오기
    @Override
    public long getItemId(int position) {
        return position;
    }

    // memosArrayList의 요소와 memo_item.xml을 연결해서 표시하기.
    //
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convertView가 구성되지 않았을 경우 값을 채워넣음
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.memo_item, null);

            textView = (TextView) convertView.findViewById(R.id.memoTextView);
            textView.setText(memosArrayList.get(position).getIngredientName());
        }

        return convertView;
    }
}
