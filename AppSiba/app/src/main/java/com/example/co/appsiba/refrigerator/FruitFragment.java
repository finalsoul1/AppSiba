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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.co.appsiba.R;
import com.example.co.appsiba.refrigerator.adapter.MyRecyclerAdapter;
import com.example.co.appsiba.vo.RefriIngredientVO;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FruitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FruitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FruitFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<RefriIngredientVO> data;

    Cursor cursor;
    SQLiteDatabase db;

    GridLayoutManager gridLayoutManager1;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FruitFragment() {
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
    public static FruitFragment newInstance(String param1, String param2) {
        FruitFragment fragment = new FruitFragment();
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
        View view = inflater.inflate(R.layout.recycler_fruit, container, false);

        // db 연결
        db = com.example.co.appsiba.db.SibaDbHelper.getInstance(getContext()).getReadableDatabase();

        // 조회query
        cursor = db.rawQuery("select a.id as category_id, a.name as category, b.id as sub_category_id, b.name as sub_category, \n" +
                "c.id as ingredient_id, c.name, c.file_name \n" +
                "from ingredient_category as a left outer join ingredient_sub_category as b \n" +
                "on a.id = b.ingredient_category_id \n " +
                "left outer join ingredient_list c \n" +
                "on b.id = c.ingredient_sub_category_id \n" +
                "where a.id= 4 \n" + // 재료종류
                "order by a.id, b.id, c.id asc", null);

        data = new ArrayList<>();
        RefriIngredientVO refriVO;

        while (cursor.moveToNext()) {
            refriVO = new RefriIngredientVO();
            refriVO.setCateId(cursor.getInt(2));
            refriVO.setId(cursor.getInt(4));
            refriVO.setName(cursor.getString(5));
            refriVO.setFileName(cursor.getString(6));

            data.add(refriVO);
        }

        cursor.close();

        // 리사이클러뷰 설정 밑 적용
        RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id.fruit_re);
        recyclerView1.setNestedScrollingEnabled(false);

        gridLayoutManager1 = new GridLayoutManager(getActivity(), 4);
        recyclerView1.setLayoutManager(gridLayoutManager1);

        MyRecyclerAdapter mrAdapter = new MyRecyclerAdapter(data);
        recyclerView1.setAdapter(mrAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
