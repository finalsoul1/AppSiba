package com.example.co.appsiba.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;

import com.example.co.appsiba.R;

public class MyRefriSearchDialog implements DialogInterface {

    private Context context;
    SQLiteDatabase db;

    public MyRefriSearchDialog(Context context) {
        this.context = context;
    }

    public void call() {
        final Dialog customDialog = new Dialog(context);

        customDialog.setContentView(R.layout.myrefri_ingre_dialog);
        customDialog.show();

        final Button memoButton = customDialog.findViewById(R.id.myrefri_dialog);

        memoButton.setOnClickListener(new View.OnClickListener() {
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