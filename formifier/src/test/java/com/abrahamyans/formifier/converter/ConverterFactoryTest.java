package com.abrahamyans.formifier.converter;

import android.widget.ImageView;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author Samvel Abrahamyan
 */
public class ConverterFactoryTest {
    private ConverterFactory factory = ConverterFactory.getInstance();


    @Test
    public void testConverterCreation(){
        Converter<?, ?> converter = factory.getConverter(ValidConverter.class.getName());
        Assert.assertNotNull(converter);
        Assert.assertEquals(converter.getClass(), ValidConverter.class);
        Assert.assertEquals(factory.getConverter(ValidConverter.class.getName()), converter);
    }

    @Test(expected = IllegalStateException.class)
    public void testNotFoundClassFailure(){
        factory.getConverter("com.hello.world.Java");
    }

    @Test(expected = IllegalStateException.class)
    public void testNotSubclassOfConverterFailure(){
        factory.getConverter(InvalidClass2.class.getName());
    }

    @Test(expected = IllegalStateException.class)
    public void testInstantiationFailure(){
        factory.getConverter(InvalidClass1.class.getName());
    }


    public static class ValidConverter extends Converter<ImageView, Number>{

        @Override
        public Number convert(ImageView v) {
            return null;
        }
    }

    public static class InvalidClass1 extends Converter<TextView, String>{

        public InvalidClass1(String someArg){}

        private InvalidClass1(){}

        @Override
        public String convert(TextView v) {
            return null;
        }
    }

    public static class InvalidClass2 extends Number{

        @Override
        public int intValue() {
            return 0;
        }

        @Override
        public long longValue() {
            return 0;
        }

        @Override
        public float floatValue() {
            return 0;
        }

        @Override
        public double doubleValue() {
            return 0;
        }
    }

}
