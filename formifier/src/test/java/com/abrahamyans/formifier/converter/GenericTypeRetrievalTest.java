package com.abrahamyans.formifier.converter;

import android.widget.TextView;

import com.abrahamyans.formifier.converter.impl.TextViewStringConverter;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author Samvel Abrahamyan
 */
public class GenericTypeRetrievalTest {

    private Converter<TextView, String> converter = new TextViewStringConverter();

    @Test
    public void testSourceTypeRetrieval() {
        Assert.assertEquals(TextView.class, converter.getSourceType());
    }

    @Test
    public void testTargetTypeRetrieval() {
        Assert.assertEquals(String.class, converter.getTargetType());
    }

}
