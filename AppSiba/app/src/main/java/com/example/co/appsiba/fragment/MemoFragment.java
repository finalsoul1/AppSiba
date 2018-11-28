package com.example.co.appsiba.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.memo.Memo;
import com.example.co.appsiba.memo.MemoCustomDialog;
import com.example.co.appsiba.memo.MemoListAdapter;

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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
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


        memoClearButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemoCustomDialog memoCustomDialog = new MemoCustomDialog(getContext());
                memoCustomDialog.call(memosArrayList, memoListAdapter);
            }
        });

        if (memosArrayList.isEmpty()) {
            memoListView.setAdapter(memoListAdapter);
        } else {
            memoListView.setAdapter(memoListAdapter);
        }

        return view;
    }

//    void confirmClear(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("모든 메모를 지웁니다.");
//        builder.setMessage("정말 다 지울거개?");
//        builder.setPositiveButton("응", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                memosArrayList.clear();
//                memoListAdapter.notifyDataSetChanged();
//                //memoEmptyListAdapter = new MemoEmptyListAdapter(getActivity(), memosEmptyList);
//                //memoListView.setAdapter(memoEmptyListAdapter);
//            }
//        });
//        builder.setNegativeButton("아니", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        builder.show();
//
//        MemoCustomDialog memoCustomDialog = new MemoCustomDialog(MemoFragment.this);
//        memoCustomDialog.call();
//    }
}
