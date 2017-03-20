package com.pernia.ui.views.custombutton;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Button;

/**
 * Created by BoldKiln on 1/20/2017.
 */

public class RegularButton extends Button {
    public RegularButton(Context context) {
        super(context);
    }

    public RegularButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-Regular.ttf"));
    }
}
