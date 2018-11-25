package com.example.co.appsiba.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.memo.MemoListAdapter;
import com.example.co.appsiba.memo.Memo;

import java.util.ArrayList;

public class MemoFragment extends Fragment {

    ListView memoListView;
    Button memoClearButton;

    ArrayList<Memo> memosArrayList;
    MemoListAdapter memoListAdapter;

    public MemoFragment() {}

    public static MemoFragment newInstance(String param1, String param2) {
        MemoFragment fragment = new MemoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memo, container, false);
        memoListView = view.findViewById(R.id.memoListView);
        memoClearButton = view.findViewById(R.id.memoClearButton);

        memosArrayList = new ArrayList<>();
        memosArrayList.add(new Memo("돼지고기"));
        memosArrayList.add(new Memo("김치"));
        memosArrayList.add(new Memo("물3"));
        memosArrayList.add(new Memo("물4"));
        memosArrayList.add(new Memo("물5"));
        memosArrayList.add(new Memo("물6"));
        memosArrayList.add(new Memo("물7"));
        memosArrayList.add(new Memo("물8"));
        memosArrayList.add(new Memo("물9"));
        memosArrayList.add(new Memo("물10"));
        memosArrayList.add(new Memo("물11"));
        memosArrayList.add(new Memo("물12"));

        memoListAdapter = new MemoListAdapter(getActivity(), memosArrayList);
        memoListView.setAdapter(memoListAdapter);

        memoClearButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                memosArrayList.clear();
                memoListView.setAdapter(memoListAdapter);
            }
        });

        return view;
    }

}
