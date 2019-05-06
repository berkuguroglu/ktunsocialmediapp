package com.app.ktun.ktunhome.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.app.ktun.ktunhome.Model.Slider;
import com.app.ktun.ktunhome.R;
import com.app.ktun.ktunhome.Service.VolleyRequest;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Slider> sliderImg;
    private ImageLoader imageLoader;


    public ViewPagerAdapter(List sliderImg, Context context) {
        this.sliderImg = sliderImg;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderImg.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_viewpager, null);


        Slider utils = sliderImg.get(position);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        //TextView txt_slider_title = (TextView) view.findViewById(R.id.txt_slider_title);
        Button vp_right = view.findViewById(R.id.vp_right);
        Button vp_left = view.findViewById(R.id.vp_left);


        imageLoader = VolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(utils.getSliderImageUrl(), ImageLoader.getImageListener(imageView, R.mipmap.ic_launcher,
                android.R.drawable.ic_dialog_alert));
        //txt_slider_title.setText(utils.getSliderTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0) {
                    Toast.makeText(context, "Slide 1 Clicked", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(context, "Slide 2 Clicked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Slide 3 Clicked", Toast.LENGTH_SHORT).show();
                }

            }
        });

        final ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);


        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}