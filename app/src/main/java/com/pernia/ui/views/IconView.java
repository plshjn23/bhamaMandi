package com.pernia.ui.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by om on 3/19/2017.
 */


public class IconView extends TextView {
    public IconView(Context context) {
        super(context);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf"));

    }
}
