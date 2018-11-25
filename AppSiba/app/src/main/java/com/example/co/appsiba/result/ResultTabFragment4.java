package com.example.co.appsiba.result;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.appsiba.R;

public class ResultTabFragment4 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_food_photo, container,false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TextView textview = (TextView) getView().findViewById(R.id.resulttextview1111);
//        textview.setText("44444444444");
        ImageView imageView = (ImageView) getView().findViewById(R.id.result_food_photo);
        imageView.setImageResource(R.drawable.agu);
    }
}
