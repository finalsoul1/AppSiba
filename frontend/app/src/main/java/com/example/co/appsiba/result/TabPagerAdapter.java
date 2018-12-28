package com.example.co.appsiba.result;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {


    public TabPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        final Fragment result;
        switch (position) {
            case 0:
                result = new ResultTabFragment1();
                break;
            case 1:
                result = new ResultTabFragment2();
                break;
            case 2:
                result = new ResultTabFragment3();
                break;
            case 3:
                result = new ResultTabFragment4();
                break;
            case 4:
                result = new ResultTabFragment5();
                break;
            default:
                result = null;
                break;
        }
        return result;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "밥";
            case 1:
                return "찌개";
            case 2:
                return "후식";
            case 3:
                return "반찬";
            case 4:
                return "일품";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }


}

