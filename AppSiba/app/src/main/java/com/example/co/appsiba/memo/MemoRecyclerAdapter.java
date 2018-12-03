package com.example.co.appsiba.memo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.fragment.MemoFragment;
import com.example.co.appsiba.helper.ResouceToInt;
import com.example.co.appsiba.refrigerator.adapter.MyRecyclerAdapter;
import com.example.co.appsiba.vo.MemoVO;
import com.example.co.appsiba.vo.RefriIngredientVO;

import java.util.ArrayList;

public class MemoRecyclerAdapter extends RecyclerView.Adapter<MemoRecyclerAdapter.MemoViewHolder> {

    SQLiteDatabase db;
    private Context context;
    private ArrayList<MemoVO> memosArrayList;
    private MemoFragment memofragment;
    MemoCustomDialogEditMemo memoCustomDialogEditMemo;

    public MemoRecyclerAdapter(Context context, ArrayList<MemoVO> memosArrayList, MemoFragment memoFragment) {
        this.context = context;
        this.memosArrayList = memosArrayList;
        this.memofragment = memoFragment;
    }

    @NonNull
    @Override
    public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.memo_item, viewGroup, false);
        return new MemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoViewHolder memoViewHolder,final int position) {

        memoViewHolder.memoINameTextView.setText(memosArrayList.get(position).getIngredientName());

        if(memosArrayList.get(position).getChecked().equals("Y")){
            memoViewHolder.memoCheckBox.setChecked(true);
        } else {
            memoViewHolder.memoCheckBox.setChecked(false);
        }

        memoViewHolder.memoCheckBox.setOnClickListener(new View.OnClickListener() {
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

        memoViewHolder.memoWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getWritableDatabase();

                memoCustomDialogEditMemo = new MemoCustomDialogEditMemo(context, memofragment, memosArrayList, position);
                memoCustomDialogEditMemo.call();
            }
        });

        memoViewHolder.memoRemoveButton.setOnClickListener(new View.OnClickListener() {
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

    public static class MemoViewHolder extends RecyclerView.ViewHolder {
        TextView memoINameTextView;
        CheckBox memoCheckBox;
        ImageButton memoWriteButton;
        ImageButton memoRemoveButton;

        public MemoViewHolder(@NonNull View itemView) {
            super(itemView);

            memoINameTextView = itemView.findViewById(R.id.memoINameTextView);
            memoCheckBox = itemView.findViewById(R.id.memoCheckBox);
            memoWriteButton = itemView.findViewById(R.id.memoRewriteButton);
            memoRemoveButton = itemView.findViewById(R.id.memoRemoveButton);
        }
    }

    @Override
    public int getItemCount() {
        return memosArrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}