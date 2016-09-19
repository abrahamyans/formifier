package com.abrahamyans.formifier.converter;

import android.view.View;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Samvel Abrahamyan
 */
public abstract class Converter<V extends View, T> {

    public abstract T convert(V v);

    @SuppressWarnings("unchecked")
    public final Class<V> getSourceType(){
        Type superType = this.getClass().getGenericSuperclass();
        return (Class<V>) ((ParameterizedType) superType).getActualTypeArguments()[0];
    }
    @SuppressWarnings("unchecked")
    public final Class<T> getTargetType(){
        Type superType = this.getClass().getGenericSuperclass();
        return (Class<T>) ((ParameterizedType) superType).getActualTypeArguments()[1];
    }
}