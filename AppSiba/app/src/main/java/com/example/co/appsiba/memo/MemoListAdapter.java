package com.example.co.appsiba.memo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.fragment.MemoFragment;
import com.example.co.appsiba.vo.MemoVO;

import java.util.ArrayList;

public class MemoListAdapter extends BaseAdapter {

    SQLiteDatabase db;
    private Context context;
    private ArrayList<MemoVO> memosArrayList;

    private TextView memoINameTextView;
    private CheckBox memoCheckBox;
    private ImageButton memoWriteButton;
    private ImageButton memoRemoveButton;

    private MemoFragment memofragment;
    MemoCustomDialogEditMemo memoCustomDialogEditMemo;

    public MemoListAdapter(Context context, ArrayList<MemoVO> memosArrayList, MemoFragment memoFragment) {
        this.context = context;
        this.memosArrayList = memosArrayList;
        this.memofragment = memoFragment;
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.memo_item, null);

            memoINameTextView = convertView.findViewById(R.id.memoINameTextView);
            memoCheckBox = convertView.findViewById(R.id.memoCheckBox);
            memoWriteButton = convertView.findViewById(R.id.memoRewriteButton);
            memoRemoveButton = convertView.findViewById(R.id.memoRemoveButton);

            memoINameTextView.setText(memosArrayList.get(position).getIngredientName());

            if(memosArrayList.get(position).getChecked().equals("Y")){
                memoCheckBox.setChecked(true);
            } else {
                memoCheckBox.setChecked(false);
            }

            memoCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getWritableDatabase();

                    int id = memosArrayList.get(position).getMemoId();
                    String memoIdString = String.valueOf(id);

                    ContentValues contentValues = new ContentValues();

                    if(memosArrayList.get(position).getChecked().equals("Y")) {
                        contentValues.put("checked", "N");
                        db.update("my_notepad", contentValues, "id=?", new String[]{memoIdString});

                    } else {
                        contentValues.put("checked", "Y");
                        db.update("my_notepad", contentValues, "id=?", new String[]{memoIdString});
                    }
                }
            });

            memoWriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getWritableDatabase();

                    memoCustomDialogEditMemo = new MemoCustomDialogEditMemo(context, memofragment, memosArrayList, position);
                    memoCustomDialogEditMemo.call();
                }
            });

            memoRemoveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getWritableDatabase();

                    String ingredientName = memosArrayList.get(position).getIngredientName();
                    int id = memosArrayList.get(position).getMemoId();
                    String memoIdString = String.valueOf(id);

                    db.delete("my_notepad", "id=?", new String[]{memoIdString});
                    Toast.makeText(context, ingredientName + "이(가) 삭제되었습니다.", Toast.LENGTH_LONG).show();

                    FragmentTransaction ft = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    ft.detach(memofragment).attach(memofragment).commit();
                }
            });
        }
        return convertView;
    }
}