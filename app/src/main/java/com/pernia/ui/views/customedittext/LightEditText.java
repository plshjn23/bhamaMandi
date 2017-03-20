package com.pernia.ui.views.customedittext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Boldkiln on 1/20/2017.
 */

public class LightEditText extends EditText {
    public LightEditText(Context context) {
        super(context);
    }

    public LightEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-Light.ttf"));
    }
}
