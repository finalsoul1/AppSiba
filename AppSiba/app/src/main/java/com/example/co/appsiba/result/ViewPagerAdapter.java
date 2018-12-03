package com.example.co.appsiba.result;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.RecipeActivity;
import com.example.co.appsiba.vo.SearchResultVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<SearchResultVO> data;

    public ViewPagerAdapter(Context context, ArrayList data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);


        ImageView imageView = view.findViewById(R.id.pagerImageView);
        TextView textView = view.findViewById(R.id.pagerTextView);

        textView.setText(data.get(position).getName());

        if (data.get(position).getSmallImageLocation().isEmpty()) {
            imageView.setImageResource(R.drawable.siba_mark_noimage);
        } else {
            Picasso.with(context)
                    .load(data.get(position).getSmallImageLocation())
                    .into(imageView);
        }

        final int id = data.get(position).getId();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), RecipeActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}