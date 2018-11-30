package com.example.co.appsiba.refrigerator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.helper.ExpandableHeightGridView;
import com.example.co.appsiba.refrigerator.adapter.MyAdapter;
import com.example.co.appsiba.vo.RefriIngredientVO;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VegiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VegiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VegiFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<RefriIngredientVO> data;
    ArrayList<RefriIngredientVO> data1;
    ArrayList<RefriIngredientVO> data2;
    ArrayList<RefriIngredientVO> data3;

    Cursor cursor;
    SQLiteDatabase db;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public VegiFragment() {
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
    public static VegiFragment newInstance(String param1, String param2) {
        VegiFragment fragment = new VegiFragment();
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
        View view = inflater.inflate(R.layout.grid_vegi, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // db
        db = SibaDbHelper.getInstance(getContext()).getReadableDatabase();

        cursor = db.rawQuery("select a.id as category_id, a.name as category, b.id as sub_category_id, b.name as sub_category, \n" +
                "c.id as ingredient_id, c.name, c.file_name \n" +
                "from ingredient_category as a left outer join ingredient_sub_category as b \n" +
                "on a.id = b.ingredient_category_id \n " +
                "left outer join ingredient_list c \n" +
                "on b.id = c.ingredient_sub_category_id \n" +
                "where a.id= 1 \n" +
                "order by a.id, b.id, c.id asc", null);

        Log.d("kwon", cursor.getColumnName(6));

        data = new ArrayList<>();
        RefriIngredientVO refriVO;

        while(cursor.moveToNext()){
            refriVO = new RefriIngredientVO();
            refriVO.setCateId(cursor.getInt(2));
            refriVO.setId(cursor.getInt(4));
            refriVO.setName(cursor.getString(5));
            refriVO.setFileName(cursor.getString(6));

            data.add(refriVO);
        }

        cursor.close();

        // 뷰
        GridView gridView1 = (ExpandableHeightGridView) getActivity().findViewById(R.id.vegi_reaf_grid);
        GridView gridView2 = (ExpandableHeightGridView) getActivity().findViewById(R.id.vegi_fruitVegi_grid);
        GridView gridView3 = (ExpandableHeightGridView) getActivity().findViewById(R.id.vegi_mushroom_grid);

        data1 = new ArrayList<>();
        data2 = new ArrayList<>();
        data3 = new ArrayList<>();

        for (RefriIngredientVO ingre : data) {
            switch (ingre.getCateId()) {
                case 1:
                    data1.add(ingre);
                    break;
                case 2:
                    data2.add(ingre);
                    break;
                case 3:
                    data3.add(ingre);
                    break;
            }
        }

        MyAdapter adapter = new MyAdapter(data1);
        gridView1.setAdapter(adapter);

        adapter = new MyAdapter(data2);
        gridView2.setAdapter(adapter);

        adapter = new MyAdapter(data3);
        gridView3.setAdapter(adapter);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
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
