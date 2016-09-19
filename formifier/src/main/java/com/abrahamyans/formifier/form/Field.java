package com.abrahamyans.formifier.form;

import android.view.View;

import com.abrahamyans.formifier.converter.Converter;

/**
 * @author Samvel Abrahamyan
 */
public class Field <V extends View, T>{

    private String name;
    private Converter<V, T> converter;
    private V sourceView;

    public Field(String name, Converter<V, T> converter, V sourceView) {
        this.name = name;
        this.converter = converter;
        this.sourceView = sourceView;
    }

    public String name(){
        return name;
    }

    public Object getInput(){
        return converter.convert(sourceView);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        if (name != null ? !name.equals(field.name) : field.name != null) return false;
        if (converter != null ? !converter.equals(field.converter) : field.converter != null)
            return false;
        return sourceView != null ? sourceView.equals(field.sourceView) : field.sourceView == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (converter != null ? converter.hashCode() : 0);
        result = 31 * result + (sourceView != null ? sourceView.hashCode() : 0);
        return result;
    }
}
