package com.pernia.ui.views.customtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by BoldKiln on 1/19/2017.
 */

public class RegularTextView extends TextView {

    public RegularTextView(Context context) {
        super(context);


    }

    public RegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-Regular.ttf"));
    }
}
