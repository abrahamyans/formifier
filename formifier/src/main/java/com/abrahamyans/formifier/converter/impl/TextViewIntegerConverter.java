package com.abrahamyans.formifier.converter.impl;

import android.widget.TextView;

import com.abrahamyans.formifier.converter.Converter;

/**
 * @author Samvel Abrahamyan
 */

public class TextViewIntegerConverter extends Converter<TextView, Integer> {

    private TextViewStringConverter stringConverter = new TextViewStringConverter();

    @Override
    public Integer convert(TextView textView) {
        String input = stringConverter.convert(textView);
        return Integer.parseInt(input);
    }
}
