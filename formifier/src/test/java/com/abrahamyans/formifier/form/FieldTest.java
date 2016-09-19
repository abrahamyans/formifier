package com.abrahamyans.formifier.form;

import android.widget.TextView;

import com.abrahamyans.formifier.converter.Converter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Samvel Abrahamyan
 */
@RunWith(MockitoJUnitRunner.class)
public class FieldTest {

    @Mock
    private Converter<TextView, String> converter;

    @Mock
    private TextView sourceView;

    private Field<TextView, String> field;

    @Before
    public void init(){
        field = new Field<>("name", converter, sourceView);
    }

    @Test
    public void testInputRetrieval(){
        when(converter.convert(sourceView)).thenReturn("Value");
        String value = field.getInput();
        assertEquals(value, "Value");
    }

}
