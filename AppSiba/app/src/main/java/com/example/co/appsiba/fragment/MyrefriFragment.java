package com.example.co.appsiba.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.co.appsiba.R;

public class MyrefriFragment extends Fragment {

    public MyrefriFragment() {
        // Required empty public constructor
    }

    public static MyrefriFragment newInstance(String param1, String param2) {
        MyrefriFragment fragment = new MyrefriFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myrefri, container, false);

//        Button button = (Button) view.findViewById(R.id.to_refri);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentActivity activity = getActivity();
//                activity.
//            }
//        });

        return view;
    }


}
