package com.example.co.appsiba.refrigerator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.co.appsiba.R;
import com.example.co.appsiba.db.SibaDbHelper;
import com.example.co.appsiba.refrigerator.adapter.MyRecyclerAdapter;
import com.example.co.appsiba.vo.RefriIngredientVO;

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

    ArrayList<RefriIngredientVO> data;
    ArrayList<RefriIngredientVO> data1;
    ArrayList<RefriIngredientVO> data2;
    ArrayList<RefriIngredientVO> data3;
    ArrayList<RefriIngredientVO> data4;
    ArrayList<RefriIngredientVO> data5;

    GridLayoutManager gridLayoutManager1;
    GridLayoutManager gridLayoutManager2;
    GridLayoutManager gridLayoutManager3;
    GridLayoutManager gridLayoutManager4;
    GridLayoutManager gridLayoutManager5;

    Cursor cursor;
    SQLiteDatabase db;

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
        View view = inflater.inflate(R.layout.recycler_meat, container, false);

        // db
        db = SibaDbHelper.getInstance(getContext()).getReadableDatabase();

        cursor = db.rawQuery("select a.id as category_id, a.name as category, b.id as sub_category_id, b.name as sub_category, \n" +
                "c.id as ingredient_id, c.name, c.file_name \n" +
                "from ingredient_category as a left outer join ingredient_sub_category as b \n" +
                "on a.id = b.ingredient_category_id \n " +
                "left outer join ingredient_list c \n" +
                "on b.id = c.ingredient_sub_category_id \n" +
                "where a.id= 2 \n" +
                "order by a.id, b.id, c.id asc", null);

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

        data1 = new ArrayList<>();
        data2 = new ArrayList<>();
        data3 = new ArrayList<>();
        data4 = new ArrayList<>();
        data5 = new ArrayList<>();

        for (RefriIngredientVO ingre : data) {
            switch (ingre.getCateId()) {
                case 4:
                    data1.add(ingre);
                    break;
                case 5:
                    data2.add(ingre);
                    break;
                case 6:
                    data3.add(ingre);
                    break;
                case 7:
                    data4.add(ingre);
                    break;
                case 8:
                    data5.add(ingre);
                    break;
            }
        }

        RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id.meat_egg_re);
        recyclerView1.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.meat_dak_re);
        recyclerView2.setNestedScrollingEnabled(false);
        RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.meat_pig_re);
        recyclerView3.setNestedScrollingEnabled(false);
        RecyclerView recyclerView4 = (RecyclerView) view.findViewById(R.id.meat_cow_re);
        recyclerView4.setNestedScrollingEnabled(false);
        RecyclerView recyclerView5 = (RecyclerView) view.findViewById(R.id.meat_duck_re);
        recyclerView5.setNestedScrollingEnabled(false);

        gridLayoutManager1 = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager2 = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager3 = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager4 = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager5 = new GridLayoutManager(getActivity(), 4);
        recyclerView1.setLayoutManager(gridLayoutManager1);
        recyclerView2.setLayoutManager(gridLayoutManager2);
        recyclerView3.setLayoutManager(gridLayoutManager3);
        recyclerView4.setLayoutManager(gridLayoutManager4);
        recyclerView5.setLayoutManager(gridLayoutManager5);

        MyRecyclerAdapter mrAdapter = new MyRecyclerAdapter(data1);
        recyclerView1.setAdapter(mrAdapter);
        mrAdapter = new MyRecyclerAdapter(data2);
        recyclerView2.setAdapter(mrAdapter);
        mrAdapter = new MyRecyclerAdapter(data3);
        recyclerView3.setAdapter(mrAdapter);
        mrAdapter = new MyRecyclerAdapter(data4);
        recyclerView4.setAdapter(mrAdapter);
        mrAdapter = new MyRecyclerAdapter(data5);
        recyclerView5.setAdapter(mrAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



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
