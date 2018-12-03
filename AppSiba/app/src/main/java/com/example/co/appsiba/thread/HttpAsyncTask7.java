package com.example.co.appsiba.thread;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.co.appsiba.R;
import com.example.co.appsiba.dao.IngredientsDAO;
import com.example.co.appsiba.db.model.Ingredients;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpAsyncTask7 extends AsyncTask<String, Void, List> {

    // OkHttp 클라이언트
    OkHttpClient client = new OkHttpClient();

    private String TAG;
    Context context;

    Dialog dialog;
    AlertDialog.Builder builder;



    public HttpAsyncTask7(String TAG, Context context) {
        this.TAG = TAG;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {


            builder = new AlertDialog.Builder(context);
            builder.setView(R.layout.loading_dialog);
            builder.setCancelable(false);
            dialog = builder.create();

            dialog.show();

        super.onPreExecute();
    }

    @Override
    protected List doInBackground(String... params) {
        // 실제 시간이 오래 걸리는 로직을 처리: 다운로드

        List dbList = new ArrayList<>();
        String strUrl = params[0];

        try {
            // 요청
            Request request = new Request.Builder()
                    .url(strUrl)
                    .build();

            // 응답
            Response response = client.newCall(request).execute();

            String str = response.body().string();
//            Log.d(TAG, "str: " + str);

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Ingredients>>() {}.getType();
            dbList = gson.fromJson(str, listType);

            Log.d(TAG, "dbList: " + dbList.size());

            new IngredientsDAO().insert(dbList, context);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dbList;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        // 프로그레스바 진행상황 보고


    }

    @Override
    protected void onPostExecute(List dbList) {

        super.onPostExecute(dbList);

        dialog.dismiss();

        // 최종결과 처리
        if (dbList != null) {
            Log.d("HttpAsyncTask", dbList.toString());
        }
    }
}
