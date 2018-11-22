package com.example.co.appsiba.HTTP;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpAsyncTask extends AsyncTask<String, Void, String> {

    // OkHttp 클라이언트
    OkHttpClient client = new OkHttpClient();

    private String TAG;

    public HttpAsyncTask(String TAG) {
        this.TAG = TAG;
    }

    @Override
    protected String doInBackground(String... params) {
        String result = null;
        String strUrl = params[0];
        try {
            // 요청
            Request request = new Request.Builder()
                    .url(strUrl)
                    .build();
            // 응답
            Response response = client.newCall(request).execute();

            Log.d(TAG, "onCreate: " + response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s != null) {
            Log.d("HttpAsyncTask", s);
        }
    }
}
