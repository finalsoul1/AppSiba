package com.example.co.appsiba.thread;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.co.appsiba.dao.FoodDAO;
import com.example.co.appsiba.db.model.Food;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpAsyncTask5 extends AsyncTask<String, Void, List> {

    // OkHttp 클라이언트
    OkHttpClient client = new OkHttpClient();

    private String TAG;
    Context context;

    public HttpAsyncTask5(String TAG, Context context) {
        this.TAG = TAG;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // 프로그레스바 띄우기
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
            Type listType = new TypeToken<ArrayList<Food>>() {}.getType();
            dbList = gson.fromJson(str, listType);

//            Log.d(TAG, "dbList: " + dbList);

            new FoodDAO().insert(dbList, context);

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
        // 최종결과 처리
        if (dbList != null) {
            Log.d("HttpAsyncTask", dbList.toString());
        }
    }
}
