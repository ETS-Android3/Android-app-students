package com.example.welcome1.btp1;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public int[] lst_images={R.drawable.apple,R.drawable.ball,R.drawable.cat,R.drawable.dog,R.drawable.elep,R.drawable.fish,R.drawable.girafee,R.drawable.hen,R.drawable.ice,R.drawable.jelly,R.drawable.kite,R.drawable.llion,R.drawable.monkey,R.drawable.nest,R.drawable.owl,R.drawable.parrot,R.drawable.queen,R.drawable.rabbit,R.drawable.snail,R.drawable.tortise,R.drawable.umbrella,R.drawable.van,R.drawable.watch,R.drawable.xman,R.drawable.yacht,R.drawable.zebra};
    public String[] lst_title={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public String[] lst_description={
            "apple","ball","cat","dog","elephant","fish","girafee","hen","ice","jelly","kite","lion","monkey","nest","orange","parrot","queen","rabbit","snail","tortise","umbrella","vav","watch","xmas","yacht","zebra"
    };
    public int[] lst_background={Color.rgb(55,15,60),Color.rgb(65,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(65,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(65,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(65,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(65,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(65,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(55,15,60),Color.rgb(65,15,60)};
    public SlideAdapter(Context context)
    {this.context=context;}
    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE );
        View view=inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslider=view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide=(ImageView)view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView)view.findViewById(R. id.txttitle);
        TextView description= (TextView)view.findViewById(R.id.txtDescription);
        layoutslider.setBackgroundColor(lst_background[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
