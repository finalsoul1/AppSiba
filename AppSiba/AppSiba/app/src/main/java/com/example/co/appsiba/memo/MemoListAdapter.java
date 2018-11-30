package com.example.co.appsiba.memo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.vo.MemoVO;

import java.util.ArrayList;

public class MemoListAdapter extends BaseAdapter {

    // Adapter가 사용되는 곳의 맥락을 알려줄 Context
    private Context context;

    // 받아서 처리할 MemoVO 자료형의 배열
    private ArrayList<MemoVO> memosArrayList;

    // 받아서 처리한 후 채워넣을 위치인 ListView
    private ListView memoListView;

    // 하나의 MemoVO 객체가 갖고있는 멤버변수 ? // or 하나의 뷰가 갖고있는 멤버변수
    private TextView memoINameTextView;
    private CheckBox memoCheckBox;

    // MemoVO 객체는 갖고있지 않지만, 삭제 등의 기능을 위해 필요한 변수
    private ImageButton memoWriteButton;
    private ImageButton memoRemoveButton;

    // Adapter 생성자. 소환되는 곳의 맥락, MemoVO 자료형 배열을 파라메터로 소환된다.
    public MemoListAdapter(Context context, ArrayList<MemoVO> memosArrayList) {
        this.context = context;
        this.memosArrayList = memosArrayList;
    }

    // memosArrayList에 MemoVO 자료형 객체가 몇 개 있는지 세준다.
    @Override
    public int getCount() {
        return this.memosArrayList.size();
    }

    // memoArrayList의 MemoVO 자료형 객체 중에서 position 번째 객체를 소환 해준다.
    @Override
    public Object getItem(int position) {
        return this.memosArrayList.get(position);
    }

    // memoArrayList의 MemoVO 자료형 객체 중 position 번째 객체의 id를 소환 해준다.
    @Override
    public long getItemId(int position) {
        return position;
    }

    // memoArrayList의 MemoVO 자료형 객체 중 position 번째 객체의 View를 소환 해준다.
    // View convertView는 Adapter에 의해 변환된 View,
    // ViewGroup parent는 Adapter가 소환되는 맥락에서 사용하는 layout 파일 (xml)
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.memo_item, null);

            // 위젯들의 참조를 획득
            memoINameTextView = convertView.findViewById(R.id.memoINameTextView);
            memoCheckBox = convertView.findViewById(R.id.memoCheckBox);

            memoWriteButton = convertView.findViewById(R.id.memoWriteButton);
            memoRemoveButton = convertView.findViewById(R.id.memoRemoveButton);

            // memosArrayList의 position 번째 MemoVO 객체에서 IngredientName을 찾아서 memoINameTextView에 넣음
            memoINameTextView.setText(memosArrayList.get(position).getIngredientName());

            // memoArrayList의 position 번째 MemoVO 객체에서 CheckBoxCheckedStatus를 찾아서 memoCheckBox의 체크 상태를 결정함
            if(memosArrayList.get(position).getCheckBoxCheckedStatus() == "Y"){
                memoCheckBox.setChecked(true);
            } else {
                memoCheckBox.setChecked(false);
            }

            // memoWriteButton에 OnClickListener를 장착.
//            memoWriteButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    memosArrayList.get(position).setIngredientName("새 메모");
//                    String text = memosArrayList.get(position).getIngredientName();
//                    Toast.makeText(context, "선택한 텍스트가 " + text + "로 변경됨.", Toast.LENGTH_LONG).show();
//                }
//            });

            // memoRemoveButton에 OnClickListener를 장착.
//            final int memoIndex = memosArrayList.get(position).getId();
            memoRemoveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memosArrayList.remove(position);
                    Toast.makeText(context, position + " has pressed", Toast.LENGTH_LONG).show();
                    notifyDataSetChanged();
                }
            });
        }
        return convertView;
    }
}
