package com.pernia.ui.views.customedittext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by BoldKiln on 1/20/2017.
 */

public class MediumEditText extends EditText {
    public MediumEditText(Context context) {
        super(context);
    }

    public MediumEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-SemiBold.ttf"));
    }
}
