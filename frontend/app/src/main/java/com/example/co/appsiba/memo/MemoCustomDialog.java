package com.example.co.appsiba.memo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.fragment.MemoFragment;
import com.example.co.appsiba.vo.MemoVO;

import java.util.ArrayList;

public class MemoCustomDialog implements DialogInterface {

    private Context context;
    private MemoFragment memofragment;
    private FragmentTransaction fragmentTransaction;
    private ArrayList<MemoVO> memosArrayList;
    SQLiteDatabase db;

    public MemoCustomDialog(Context context, MemoFragment memoFragment, FragmentTransaction fragmentTransaction, ArrayList<MemoVO> memosArrayList) {
        this.context = context;
        this.memofragment = memoFragment;
        this.fragmentTransaction = fragmentTransaction;
        this.memosArrayList = memosArrayList;
    }

    public void call() {
        final Dialog customDialog = new Dialog(context);

        if(memosArrayList.isEmpty()) {
            customDialog.setContentView(R.layout.memo_custom_dialog_when_empty);
            customDialog.show();

            final Button memoButtonConfirm = customDialog.findViewById(R.id.memoButtonConfirm);

            memoButtonConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customDialog.dismiss();
                }
            });
        } else {
            customDialog.setContentView(R.layout.memo_custom_dialog);
            customDialog.show();

            final Button memoButtonYes = customDialog.findViewById(R.id.memoButtonYes);
            final Button memoButtonNo = customDialog.findViewById(R.id.memoButtonNo);

            memoButtonYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getWritableDatabase();
                    db.delete("my_notepad", null, null);
                    Toast.makeText(context, "메모를 모두 삭제했습니다.", Toast.LENGTH_SHORT).show();
                    db.close();

                    customDialog.dismiss();

                    fragmentTransaction.detach(memofragment).attach(memofragment).commit();
                }
            });

            memoButtonNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customDialog.dismiss();
                }
            });
        }
    }

    @Override
    public void cancel() {

    }

    @Override
    public void dismiss() {

    }
}