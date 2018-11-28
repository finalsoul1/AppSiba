package com.example.co.appsiba.memo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;

import java.util.ArrayList;

public class MemoListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Memo> memosArrayList;
    private ListView memoListView;

    private TextView memoINameTextView;
    //private CheckBox memoCheckBox;
    private Button memoRemoveButton;

    public MemoListAdapter(Context context, ArrayList<Memo> memosArrayList) {
        this.context = context;
        this.memosArrayList = memosArrayList;
    }

    @Override
    public int getCount() {
        return this.memosArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.memosArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.memo_item, null);
            memoINameTextView = convertView.findViewById(R.id.memoINameTextView);
            memoRemoveButton = convertView.findViewById(R.id.memoRemoveButton);

            memoINameTextView.setText(memosArrayList.get(position).getIngredientName());

            memoRemoveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memosArrayList.remove(0);
                    Toast.makeText(context,position + "pressed", Toast.LENGTH_LONG).show();
                    notifyDataSetChanged();
                }
            });
        }

        return convertView;
    }
}
