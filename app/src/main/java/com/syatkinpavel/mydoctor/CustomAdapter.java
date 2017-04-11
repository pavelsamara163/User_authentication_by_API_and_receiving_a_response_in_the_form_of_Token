package com.syatkinpavel.mydoctor;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Павел on 04.01.2017.
 */

public class CustomAdapter extends PagerAdapter {
    private int[] imgs = {R.drawable.mainfonimage,R.drawable.mainfonlaytwo,R.drawable.mainfonlaythree};
    private LayoutInflater inflater;
    private Context ctx;

    public CustomAdapter(Context ctx){
        this.ctx = ctx;
    }
    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =  inflater.inflate(R.layout.swip,container,false);
        ImageView img = (ImageView)v.findViewById(R.id.swipImg);
        img.setImageResource(imgs[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
