package com.example.co.appsiba.helper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ScrollHelper {

    public static void setListViewHeightBasedOnChildren(ListView listView) {



        ListAdapter listAdapter = listView.getAdapter();
        if(listAdapter == null){ return;}

        int totalHeight = 0;
        //   int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),View.MeasureSpec.AT_MOST);

        for(int i=0; i<listAdapter.getCount(); i++){
            View listItem = listAdapter.getView(i, null, listView);
            //        listItem.measure(desiredWidth,View.MeasureSpec.UNSPECIFIED);
            listItem.measure(0,0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount()-1));
        listView.setLayoutParams(params);
        listView.requestLayout();



    }
}
