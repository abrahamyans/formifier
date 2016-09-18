package com.abrahamyans.formifier.converter.impl;

import android.widget.TextView;

import com.abrahamyans.formifier.converter.Converter;

/**
 * @author Samvel Abrahamyan
 */
public class TextViewStringConverter extends Converter<TextView,String> {

    @Override
    public String convert(TextView v) {
        return v.getText().toString();
    }

}
