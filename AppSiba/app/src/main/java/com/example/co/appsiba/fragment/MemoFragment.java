package com.example.co.appsiba.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.co.appsiba.R;

public class MemoFragment extends Fragment {

    public MemoFragment() {
        // Required empty public constructor
    }

    public static MemoFragment newInstance(String param1, String param2) {
        MemoFragment fragment = new MemoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = (Button)findViewById(R.id.button4);
        final EditText editText = (EditText)findViewById(R.id.editText);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MemoFragment.this, ResultFragment.this);
                intent.putExtra("sendText", String.valueOf(editText.getText()));
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memo, container, false);
    }

}
