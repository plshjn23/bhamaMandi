package com.pernia.ui.views.customtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by BoldKiln on 1/19/2017.
 */

public class MediumTextView extends TextView {
    public MediumTextView(Context context) {
        super(context);

    }

    public MediumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-SemiBold.ttf"));
    }
}
