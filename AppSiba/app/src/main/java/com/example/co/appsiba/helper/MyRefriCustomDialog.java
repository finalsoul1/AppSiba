package com.example.co.appsiba.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.co.appsiba.R;

public class MyRefriCustomDialog implements DialogInterface {

    private Context context;
    SQLiteDatabase db;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;

    public MyRefriCustomDialog(Context context, FragmentTransaction fragmentTransaction, Fragment fragment) {
        this.context = context;
        this.fragmentTransaction = fragmentTransaction;
        this.fragment = fragment;
    }

    public void call() {
        final Dialog customDialog = new Dialog(context);

        customDialog.setContentView(R.layout.memo_custom_dialog);
        customDialog.show();

        final Button memoButtonYes = customDialog.findViewById(R.id.memoButtonYes);
        final Button memoButtonNo = customDialog.findViewById(R.id.memoButtonNo);

        memoButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getReadableDatabase();
                db.delete("my_refrigerator", null, null);
                db.close();

                fragmentTransaction.detach(fragment).attach(fragment).commit();

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