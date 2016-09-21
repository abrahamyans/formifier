package com.abrahamyans.formifier.converter;

import com.abrahamyans.formifier.converter.impl.CheckBoxBooleanConverter;
import com.abrahamyans.formifier.converter.impl.TextViewIntegerConverter;
import com.abrahamyans.formifier.converter.impl.TextViewStringConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Samvel Abrahamyan
 */
public class ConverterFactory {

    private static final ConverterFactory instance = new ConverterFactory();
    private Map<String, Converter<?, ?>> converterCache = new HashMap<>();

    private ConverterFactory() {
        super();
        initializeDefaultConverters();
    }

    private void initializeDefaultConverters() {
        converterCache.put(TextViewStringConverter.class.getSimpleName(), new TextViewStringConverter());
        converterCache.put(CheckBoxBooleanConverter.class.getSimpleName(), new CheckBoxBooleanConverter());
        converterCache.put(TextViewIntegerConverter.class.getSimpleName(), new TextViewIntegerConverter());
    }

    public static ConverterFactory getInstance(){
        return instance;
    }

    public Converter<?, ?> getConverter(String className) {
        if (converterCache.containsKey(className))
            return converterCache.get(className);
        else {
            Converter<?, ?> converter = createFromClassName(className);
            converterCache.put(className, converter);
            return converter;
        }
    }

    private Converter<?,?> createFromClassName(String className) {
        Class klass;
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Class  " + className + " is not found", e);
        }
        if (!(Converter.class.isAssignableFrom(klass))) {
            throw new IllegalStateException("The class " + className + " should extend com.abrahamyans.formifier.converter.Converter");
        }
        @SuppressWarnings("unchecked")
        Class<Converter<?, ?>> converterClass = (Class<Converter<?, ?>>) klass;
        Converter<?, ?> converter;
        try {
            converter = converterClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Could not instantiate class " + className + ", it should have an empty public constructor", e);
        }
        return converter;
    }


}
