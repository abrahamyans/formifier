package com.abrahamyans.formifier.converter.impl;

import android.widget.CheckBox;

import com.abrahamyans.formifier.converter.Converter;

/**
 * @author Samvel Abrahamyan
 */

public class CheckBoxBooleanConverter extends Converter<CheckBox, Boolean> {
    @Override
    public Boolean convert(CheckBox checkBox) {
        return checkBox.isChecked();
    }
}
