package com.example.co.appsiba;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;

import com.example.co.appsiba.fragment.FavoritesFragment;
import com.example.co.appsiba.fragment.MemoFragment;
import com.example.co.appsiba.fragment.MyrefriFragment;
import com.example.co.appsiba.fragment.ResultFragment;
import com.example.co.appsiba.helper.BottomNavigationBehavior;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        // load the store fragment by default
        loadFragment(new MyrefriFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_myRefri:
                    fragment = new MyrefriFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_menuRecommand:
                    fragment = new ResultFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_memo:
                    fragment = new MemoFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_favorites:
                    fragment = new FavoritesFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void clickToRefri(View view) {

        Intent intent = new Intent(this, RefriActivity.class);

        try {
            startActivity(intent);
        } catch (OutOfMemoryError e) {

        }

    }

    public void onClickSearch(View view) {
        ViewPager viewPager = findViewById(R.id.refri_pager);
        ScrollView scrollView = findViewById(R.id.scroll);

        viewPager.addView(scrollView);
    }
}

