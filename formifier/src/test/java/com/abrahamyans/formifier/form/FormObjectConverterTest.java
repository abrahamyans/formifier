package com.abrahamyans.formifier.form;

import junit.framework.Assert;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * @author Samvel Abrahamyan
 */
@RunWith(MockitoJUnitRunner.class)
public class FormObjectConverterTest {

    private static final Map<String, Object> sourceOutput = new LinkedHashMap<>();

    static{
        sourceOutput.put("age", 22);
        sourceOutput.put("isMarried", false);
        sourceOutput.put("name", "Joe Bloggs");
    }


    @Mock
    private Form<Map<String, Object>> source;

    private FormObjectConversion<Person> toPojoConverter;

    @Before
    public void init(){
        toPojoConverter = new FormObjectConversion<>(Person.class, source);
    }

    @Test
    public void testPojoValue() throws IllegalAccessException {
        when(source.getForm()).thenReturn(sourceOutput);

        Person person = toPojoConverter.getForm();

        for(Map.Entry<String, Object> entry: sourceOutput.entrySet()){
            Assert.assertEquals(FieldUtils.readField(person, entry.getKey(), true), entry.getValue());
        }
    }


    public static class Person{
        String name;
        Boolean isMarried;
        Integer age;
    }
}
