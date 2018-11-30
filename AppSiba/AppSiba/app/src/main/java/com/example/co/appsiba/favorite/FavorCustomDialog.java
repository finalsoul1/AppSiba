package com.example.co.appsiba.favorite;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;

import com.example.co.appsiba.R;
import com.example.co.appsiba.vo.FavoritesVO;

import java.util.ArrayList;

public class FavorCustomDialog implements DialogInterface {

    private Context context;
    SQLiteDatabase db;
    public FavorCustomDialog(Context context) {
        this.context = context;
    }

    public void call(final ArrayList<FavoritesVO> list_itemArrayList, final MyListAdapter myListAdapter) {
        final Dialog customDialog = new Dialog(context);

        customDialog.setContentView(R.layout.memo_custom_dialog);
        customDialog.show();

        final Button memoButtonYes = customDialog.findViewById(R.id.memoButtonYes);
        final Button memoButtonNo = customDialog.findViewById(R.id.memoButtonNo);

        memoButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_itemArrayList.clear();
                myListAdapter.notifyDataSetChanged();
                customDialog.dismiss();
                db = com.example.co.appsiba.db.SibaDbHelper.getInstance(context).getReadableDatabase();
                db.delete("my_favorates", null, null);
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