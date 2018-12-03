package com.example.co.appsiba.refrigerator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class RefriAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mData;

    public RefriAdapter(FragmentManager fm) {
        super(fm);

        mData = new ArrayList<>();
        mData.add(new VegiFragment());
        mData.add(new MeatFragment());
        mData.add(new FishFragment());
        mData.add(new FruitFragment());
        mData.add(new EtcFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String str = "";
        switch (position){
            case 0:
                str = "채소";
                break;
            case 1:
                str = "육류";
                break;
            case 2:
                str = "어류";
                break;
            case 3:
                str = "과일";
                break;
            case 4:
                str = "기타";
                break;
        }
        return str;
    }
}


