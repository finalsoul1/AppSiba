package com.example.co.appsiba;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.refrigerator.EtcFragment;
import com.example.co.appsiba.refrigerator.FishFragment;
import com.example.co.appsiba.refrigerator.FruitFragment;
import com.example.co.appsiba.refrigerator.MeatFragment;
import com.example.co.appsiba.refrigerator.RefriAdapter;
import com.example.co.appsiba.refrigerator.VegiFragment;

public class RefriActivity extends AppCompatActivity
        implements MeatFragment.OnFragmentInteractionListener,
        EtcFragment.OnFragmentInteractionListener,
        FishFragment.OnFragmentInteractionListener,
        FruitFragment.OnFragmentInteractionListener,
        VegiFragment.OnFragmentInteractionListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refri);

        ViewPager viewPager = findViewById(R.id.refri_pager);
        RefriAdapter adapter = new RefriAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

//        Button button = (Button) findViewById(R.id.food_image)

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        TextView textView = view.findViewById(R.id.food_nameView);
        ImageView imageView = view.findViewById(R.id.food_image);

        if(imageView.getImageAlpha() == 255){
            Toast.makeText(this, textView.getText() + "을/를 누르셨습니다.", Toast.LENGTH_LONG).show();
            imageView.setImageAlpha(20);
        } else {
            Toast.makeText(this, textView.getText() + "을/를 이미 추가하셨습니다.", Toast.LENGTH_LONG).show();
        }
        
    }
}
