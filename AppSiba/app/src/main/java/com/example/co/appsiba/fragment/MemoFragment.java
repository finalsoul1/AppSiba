package com.example.co.appsiba.fragment;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.memo.MemoCustomDialog;
import com.example.co.appsiba.memo.MemoListAdapter;
import com.example.co.appsiba.vo.MemoVO;

import java.util.ArrayList;

public class MemoFragment extends Fragment {

    ArrayList<MemoVO> memosArrayList;
    View view;
    Cursor cursor;
    SQLiteDatabase db;
    MemoVO memoVO;

    Button memoClearButton;
    Button memoAddButton;

    MemoListAdapter memoListAdapter;
    ListView memoListView;

    MemoCustomDialog memoCustomDialog;

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
        view = inflater.inflate(R.layout.fragment_memo, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        db = com.example.co.appsiba.db.SibaDbHelper.getInstance(getActivity()).getReadableDatabase();
        cursor = db.rawQuery("select * from my_notepad;", null);

        memosArrayList = new ArrayList<>();

        while (cursor.moveToNext()) {
            memoVO = new MemoVO();
            memoVO.setMemoId(cursor.getInt(0));
            memoVO.setIngredientName(cursor.getString(1));
            memoVO.setChecked(cursor.getString(2));

            memosArrayList.add(memoVO);
        }

        cursor.close();

        memoListAdapter = new MemoListAdapter(getContext(), memosArrayList, this);

        memoClearButton = view.findViewById(R.id.memoClearButton);
        memoClearButton.setOnClickListener(new memoClearButtonClickListener(this));

        memoAddButton = view.findViewById(R.id.memoAddButton);
        memoAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = com.example.co.appsiba.db.SibaDbHelper.getInstance(getContext()).getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                contentValues.put("ingredient_name", "새 메모");
                contentValues.put("checked", "N");
                db.insert("my_notepad", null, contentValues);

                onResume();

            }
        });

        memoListView = view.findViewById(R.id.memoListView);
        memoListView.setAdapter(memoListAdapter);
    }

    public class memoClearButtonClickListener implements View.OnClickListener {

        MemoFragment memofragment;

        public memoClearButtonClickListener(MemoFragment memoFragment) {
            this.memofragment = memoFragment;
        }

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            memoCustomDialog = new MemoCustomDialog(getContext(), memofragment, fragmentTransaction);
            memoCustomDialog.call();
        }
    }
}
