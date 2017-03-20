package com.pernia.ui.customlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.pernia.R;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class CustomSliderView extends BaseSliderView {
    public CustomSliderView(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fullscreen_image_display,null);
        ImageViewTouch target = (ImageViewTouch) v.findViewById(R.id.slider_image);
        TextView description = (TextView)v.findViewById(R.id.description);
        description.setText(getDescription());
        bindEventAndShow(v, target);
        return v;
    }
}
