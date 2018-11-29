package com.example.co.appsiba.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.memo.MemoCustomDialog;
import com.example.co.appsiba.memo.MemoListAdapter;
import com.example.co.appsiba.vo.MemoVO;

import java.util.ArrayList;

public class MemoFragment extends Fragment {

    // fragment에 있는 위젯
    ListView memoListView;
    Button memoClearButton;
    Button memoAddButton;

    // Adapter에 의해 memoListView에 넣어질 위젯
    TextView memoINameTextView;
    CheckBox memoCheckBox;
    ImageButton memoWriteButton;
    ImageButton memoRemoveButton;

    // MemoVO 클래스를 자료형으로 하는 배열
    ArrayList<MemoVO> memosArrayList;

    // 리스트뷰에 배열을 넣어줄 Adapter
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
        memoINameTextView = view.findViewById(R.id.memoINameTextView);
        memoClearButton = view.findViewById(R.id.memoClearButton);
        memoAddButton = view.findViewById(R.id.memoAddButton);
        memoRemoveButton = view.findViewById(R.id.memoRemoveButton);

        memosArrayList = new ArrayList<>();
        memosArrayList.add(new MemoVO("돼지고기", "Y"));
        memosArrayList.add(new MemoVO("김치", "N" ));
        memosArrayList.add(new MemoVO("물", "Y"));

        memoListAdapter = new MemoListAdapter(getActivity(), memosArrayList);

        memoClearButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemoCustomDialog memoCustomDialog = new MemoCustomDialog(getContext());
                memoCustomDialog.call(memosArrayList, memoListAdapter);
            }
        });

        memoAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoAdd();
            }
        });

        memoListView.setClickable(true);
        memoListView.setOnItemClickListener(memoWriteButtonListener);

        if (memosArrayList.isEmpty()) {
            memoListView.setAdapter(memoListAdapter);
        } else {
            memoListView.setAdapter(memoListAdapter);
        }

        return view;
    }

    private AdapterView.OnItemClickListener memoWriteButtonListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            ImageButton writeButton = (ImageButton) parent.getAdapter().getItem(position);
//            ImageButton writeButtonView = view.findViewById(R.id.memoWriteButton);
            writeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memosArrayList.get(position).setIngredientName("새 메모");
                    String text = memosArrayList.get(position).getIngredientName();
                    Toast.makeText(getContext(), "선택한 텍스트가 " + text + "로 변경됨.", Toast.LENGTH_LONG).show();
                }
            });
        }
    };

    void memoAdd() {
        memosArrayList.add(new MemoVO("새 메모", "N"));
        memoListView.setAdapter(memoListAdapter);
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
