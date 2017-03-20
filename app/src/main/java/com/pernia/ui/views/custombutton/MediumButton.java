package com.pernia.ui.views.custombutton;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by BoldKiln on 1/20/2017.
 */

public class MediumButton extends Button {
    public MediumButton(Context context) {
        super(context);
    }

    public MediumButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-SemiBold.ttf"));
    }
}
