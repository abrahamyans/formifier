package com.abrahamyans.formifiersample;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author Samvel Abrahamyan
 */

public class SomeView extends View {
    public SomeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.SomeView,
                0, 0
        );

        Log.d("SOmeView", String.valueOf(typedArray.getString(R.styleable.SomeView_some)));

        typedArray.recycle();
    }
}
