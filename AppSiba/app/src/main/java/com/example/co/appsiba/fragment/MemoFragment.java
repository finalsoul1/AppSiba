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
import com.example.co.appsiba.memo.memos;

import java.util.ArrayList;

    //region onCreateView 설명

    /*
    View
        > 클래스
        > android.view
        > This class represents the basic building block for user interface components.
        > UI 요소를 위한 기본 블록이다.

    onCreateView
        ==> View 생성시 실행될 기능을 선언

    LayoutInflater
        > 클래스
        > android.view.LayoutInflater
        > Instantiates a layout XML file into its corresponding {@link android.view.View} objects.
        > 상응하는 android.view.View 객체 안에 layout XML 파일을 인스턴스화 한다.

    ViewGroup
        > 추상클래스
        > android.view.ViewGroup
        > A ViewGroup is a special view that can contain other views (called children.)
        > ViewGroup은 다른 view들(이런 view들을 children이라고 한다)을 보관할 수 있는 특별한 view이다.
        > The view group is the base class for layouts and views containers.
        > view group은 layouts와 views containers를 위한 기본 클래스이다.

    Bundle
        > 클래스
        > android.os.Bundle
        > A mapping from String keys to various {@link Parcelable} values.
        > 문자열 keys를 다양한 Parcelable 값들로 mapping하는 것.

    ListView
        > 클래스
        > android.widget.ListView
        > Displays a vertically-scrollable collection of views, where each view is positioned immediately below the previous view in the list.
        > 수직으로 넘길 수 있는 views들의 collection을 보여준다. (list 내부의 각 view가 이전 view의 바로 아래에 위치했을 때)
    */

    //endregion

// HomeActivity에서 '메모장' 버튼을 클릭하면 상단의 화면을 MemoFragment로 교환

// MemoFragment를 선언하고 Fragment 클래스를 상속
public class MemoFragment extends Fragment {

    ListView listView;
    MemoListAdapter memoListAdapter;
    ArrayList<memos> memosArrayList;
    Button clearAllButton;

    // 생성자 선언
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

        listView = view.findViewById(R.id.ingredientsListView);
        clearAllButton = view.findViewById(R.id.clearAllButton);

        memosArrayList = new ArrayList<memos>();

        memosArrayList.add(new memos("돼지고기"));
        memosArrayList.add(new memos("김치"));
        memosArrayList.add(new memos("물"));

        memoListAdapter = new MemoListAdapter(getActivity(), memosArrayList);

        listView.setAdapter(memoListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), memosArrayList.get(position).getIngredientName(), Toast.LENGTH_SHORT).show();
            }
        });

        clearAllButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                memosArrayList.clear();
                listView.setAdapter(memoListAdapter);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

}
