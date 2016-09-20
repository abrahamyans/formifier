package com.abrahamyans.formifier.form;

import android.widget.CheckBox;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Samvel Abrahamyan
 */
@RunWith(MockitoJUnitRunner.class)
public class FormMapConverterTest {

    @Mock
    private Field<TextView, String> nameField;

    @Mock
    private Field<CheckBox, Boolean> isMarriedField;

    @Mock
    private Field<TextView, Number> ageField;

    private FormOfMap formMapConversion;

    @Before
    public void init(){
        formMapConversion = new FormOfMap(Arrays.<Field<?, ?>>asList(
                nameField,
                isMarriedField,
                ageField
        ));
    }

    @Test
    public void testFormToMapConversion(){
        when(nameField.name()).thenReturn("name");
        when(isMarriedField.name()).thenReturn("isMarried");
        when(ageField.name()).thenReturn("age");

        when(nameField.getInput()).thenReturn("Joe Bloggs");
        when(isMarriedField.getInput()).thenReturn(false);
        when(ageField.getInput()).thenReturn(22);

        Map<String, Object> formValues = formMapConversion.getForm();

        assertEquals(formValues.get("name"), "Joe Bloggs");
        assertEquals(formValues.get("isMarried"), false);
        assertEquals(formValues.get("age"), 22);

    }

}

