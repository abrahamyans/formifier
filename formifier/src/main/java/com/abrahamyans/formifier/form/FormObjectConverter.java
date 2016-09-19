package com.abrahamyans.formifier.form;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.Map;

/**
 * @author Samvel Abrahamyan
 */
public class FormObjectConverter<T> implements Form<T>{

    private Class<T> targetKlass;
    private Form<Map<String, Object>> formMapConverter;

    public FormObjectConverter(Class<T> klass, Form<Map<String, Object>> formMapConverter){
        this.targetKlass = klass;
        this.formMapConverter = formMapConverter;
    }

    @Override
    public T getForm() {
        Map<String, Object> formValues = formMapConverter.getForm();
        T formPojo;
        try {
            formPojo = targetKlass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Could not instantiate class " + targetKlass.getName() + " Make sure it has public empty constructor", e);
        }

        for(Map.Entry<String, Object> entry: formValues.entrySet()){
            try {
                FieldUtils.writeField(formPojo, entry.getKey(), entry.getValue(), true);
            } catch (Exception e) {
                throw new IllegalStateException("The class should have field named " + entry.getKey(), e);
            }
        }

        return formPojo;
    }
}
