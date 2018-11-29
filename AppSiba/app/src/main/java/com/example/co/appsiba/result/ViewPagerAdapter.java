package com.example.co.appsiba.result;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.co.appsiba.R;
import com.example.co.appsiba.RecipeActivity;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

public class ViewPagerAdapter extends PagerAdapter {
    private  String url;
    private  int id;
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.dangmean,R.drawable.agu,R.drawable.baecon};

    public ViewPagerAdapter(Context context, String url, int id) {
        this.context = context;
        this.url = url;
        this. id = id;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.pagerImageView);


           // imageView.setImageResource(images[position]);
        Picasso.with(context)
                .load(url)
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(context.getApplicationContext(), RecipeActivity.class);
        intent.putExtra("id",id);
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


        private class LoadImage extends AsyncTask<String, String, Bitmap>{
            ImageView img=null;

            public LoadImage(ImageView img){
                this.img=img;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }
            protected Bitmap doInBackground(String... args) {
                Bitmap bitmap=null;
                try {
                    bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return bitmap;
            }
            protected void onPostExecute(Bitmap image) {
                if(image != null){
                    img.setImageBitmap(image);
                }
            }
        }
}
