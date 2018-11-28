package com.example.co.appsiba.favorite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.appsiba.R;
import com.example.co.appsiba.helper.ResouceToInt;
import com.example.co.appsiba.vo.FavoritesVO;

import java.util.List;


public class MyListAdapter extends BaseAdapter  {

private  final List mdata;
    Context  context;
  //  ArrayList<list_item> list_itemArrayList;
    ArrayAdapter<list_item> list_itemArrayAdapter;


    TextView content_textView;
    ImageView imageView;


    public MyListAdapter(Context context, List<FavoritesVO> mdata) {
        this.context = context;
       // this.list_itemArrayList = list_itemArrayList;
        this.mdata = mdata;

    }

    @Override
//    리스트뷰가 몇개의 아이템을 갖고있는지 카운트(arraylist.size만큼)
    public int getCount() {
        return this.mdata.size();
    }

    @Override
//    현재 어떤 아이템인지 알려주는 부분 (arraylist 의 객체 중 position에 해당하는것을 가져옴.
    public Object getItem(int position) {
        return mdata.get(position);
    }

    @Override
//    현재 포지션 알려주는 부분
    public long getItemId(int position) {
        return position;
    }

    @Override
//     여기서 리스트뷰의 아이템과 xml을 연결해 화면에 표시함.
//    favorite_item.xml을 context생성자로 불러와 반복문처럼 한칸씩 화면구성해줌.
    public View getView(final int position, View convertView, final ViewGroup parent) {

        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.favorite_item, null);

            FavoritesVO favor = (FavoritesVO)mdata.get(position) ;
            int resId = ResouceToInt.getResId(favor.getRecipefileImage(), R.drawable.class);

            content_textView = (TextView) convertView.findViewById(R.id.favorite_content_textview);
            imageView = (ImageView) convertView.findViewById(R.id.favorite_imageView);

            content_textView.setText(favor.getRecipeName());
            imageView.setImageResource(favor.getRecipeId());

            final Button button1 = (Button) convertView.findViewById(R.id.favor_deletebtn);


            button1.setOnClickListener(new Button.OnClickListener() {

                @Override
                public void onClick(View convertView) {
                    mdata.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context, "삭제"+position+"!!!!", Toast.LENGTH_SHORT).show();

                }
            });


        }
        return convertView;

    }


}
