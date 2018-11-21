package com.example.co.appsiba.refrigerator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.refrigerator.adapter.MyAdapter;
import com.example.co.appsiba.refrigerator.model.FoodIngredients;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MeatFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MeatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeatFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<FoodIngredients> data;
    ArrayList<FoodIngredients> data1;
    ArrayList<FoodIngredients> data2;
    ArrayList<FoodIngredients> data3;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;



    public MeatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeatFragment newInstance(String param1, String param2) {
        MeatFragment fragment = new MeatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.grid_meat, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 자료
        data = new ArrayList<>();
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));
        data.add(new FoodIngredients("달걀", "알"));
        data.add(new FoodIngredients("닭", "닭"));
        data.add(new FoodIngredients("목살", "돼지"));



        // 어댑터
//        MyAdapter adapter = new MyAdapter(data);

        // 뷰
        GridView gridView1 = (GridView) getActivity().findViewById(R.id.meat_egg_grid);
        GridView gridView2 = (GridView) getActivity().findViewById(R.id.meat_dak_grid);
        GridView gridView3 = (GridView) getActivity().findViewById(R.id.meat_pig_grid);

//        gridView.setAdapter(adapter);

        data1 = new ArrayList<>();
        data2 = new ArrayList<>();
        data3 = new ArrayList<>();

        for (FoodIngredients food : data) {
            switch (food.getFoodType()) {
                case "알":
                    data1.add(food);
                    break;
                case "닭":
                    data2.add(food);
                    break;
                case "돼지":
                    data3.add(food);
                    break;
            }
        }

        MyAdapter adapter1 = new MyAdapter(data1);
        MyAdapter adapter2 = new MyAdapter(data2);
        MyAdapter adapter3 = new MyAdapter(data3);

        gridView1.setAdapter(adapter1);
        gridView2.setAdapter(adapter2);
        gridView3.setAdapter(adapter3);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onClick(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
