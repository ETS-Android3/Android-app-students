package com.example.welcome1.btp1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomSwipeAdapter extends PagerAdapter{
    private int[] image_resources={R.drawable.apple, R.drawable.ball};
    private Context ctx;
    private LayoutInflater layoutInflater;
    CustomSwipeAdapter(Context ctx)
    {
        this.ctx=ctx;
    }
    public int getCount() {
        return image_resources.length;
    }


    public boolean isViewFromObject(View view, Object object) {
        return ((LinearLayout)object==view);
    }


    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView=(ImageView)item_view.findViewById(R.id.image_view);
        TextView textView=(TextView)item_view.findViewById(R.id.image_count);
        imageView.setImageResource(image_resources[position]);
        textView.setText("image" + position);
        container.addView(item_view);
        return item_view;


    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);

    }
}
