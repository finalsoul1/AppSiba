package com.example.co.appsiba.memo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

import com.example.co.appsiba.R;
import com.example.co.appsiba.vo.MemoVO;

import java.util.ArrayList;

public class MemoCustomDialog implements DialogInterface {

    private Context context;

    public MemoCustomDialog(Context context) {
        this.context = context;
    }

    public void call(final ArrayList<MemoVO> memosArrayList, final MemoListAdapter memoListAdapter) {
        final Dialog customDialog = new Dialog(context);

        customDialog.setContentView(R.layout.memo_custom_dialog);
        customDialog.show();

        final Button memoButtonYes = customDialog.findViewById(R.id.memoButtonYes);
        final Button memoButtonNo = customDialog.findViewById(R.id.memoButtonNo);

        memoButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memosArrayList.clear();
                memoListAdapter.notifyDataSetChanged();
                customDialog.dismiss();
            }
        });

        memoButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();
            }
        });
    }

    @Override
    public void cancel() {

    }

    @Override
    public void dismiss() {

    }
}