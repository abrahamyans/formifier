package com.abrahamyans.formifier.converter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Samvel Abrahamyan
 */
public class ConverterFactory {

    private static final ConverterFactory instance = new ConverterFactory();
    private Map<String, Converter<?, ?>> converterCache = new ConcurrentHashMap<>();

    private ConverterFactory() {
        super();
        initializeDefaultConverters();
    }

    private void initializeDefaultConverters() {

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
