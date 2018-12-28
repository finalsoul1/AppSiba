package com.example.co.appsiba.memo;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.fragment.MemoFragment;
import com.example.co.appsiba.vo.MemoVO;

import java.util.ArrayList;

public class MemoCustomDialogEditMemo {
    private Context context;
    private MemoFragment memoFragment;
    private ArrayList<MemoVO> memosArrayList;
    private int position;
    SQLiteDatabase db;

    public MemoCustomDialogEditMemo(
            Context context,
            MemoFragment memoFragment,
            ArrayList<MemoVO> memosArrayList,
            int position
    ) {
        this.context = context;
        this.memoFragment = memoFragment;
        this.memosArrayList = memosArrayList;
        this.position = position;
    }

    public void call() {
        final Dialog customDialog = new Dialog(context);

        customDialog.setContentView(R.layout.memo_custom_dialog_edit_memo);
        customDialog.show();

        final TextView textBeforeEdit = customDialog.findViewById(R.id.memoRewriteBeforeEdit);
        final EditText textAfterEdit = customDialog.findViewById(R.id.memoRewriteAfterEdit);
        final Button memoButtonConfirm = customDialog.findViewById(R.id.memeRewriteConfirm);
        final Button memoButtonCancel = customDialog.findViewById(R.id.memeRewriteCancel);

        String memoBeforeEdit = memosArrayList.get(position).getIngredientName();
        textBeforeEdit.setText(memoBeforeEdit);

        textAfterEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAfterEdit.setText("");
            }
        });

        memoButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getWritableDatabase();

                int id = memosArrayList.get(position).getMemoId();
                String memoIdString = String.valueOf(id);

                String memoAfterEdit = textAfterEdit.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put("ingredient_name", memoAfterEdit);

                db.update("my_notepad", contentValues, "id=?", new String[]{memoIdString});
                Toast.makeText(context, "메모가 변경되었습니다.", Toast.LENGTH_SHORT).show();

                FragmentTransaction ft = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                ft.detach(memoFragment).attach(memoFragment).commit();

                customDialog.dismiss();
            }
        });

        memoButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();
            }
        });
    }
}
