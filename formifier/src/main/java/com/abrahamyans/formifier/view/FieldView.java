package com.abrahamyans.formifier.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.abrahamyans.formifier.R;
import com.abrahamyans.formifier.converter.Converter;
import com.abrahamyans.formifier.converter.ConverterFactory;
import com.abrahamyans.formifier.form.Field;


/**
 * @author Samvel Abrahamyan
 */

public class FieldView extends LinearLayout {

    private final String name;
    private final Converter converter;
    private Field<? extends View, ?> field;

    public FieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FieldView,
                0, 0
        );
        String converterClassName = typedArray.getString(R.styleable.FieldView_converter);
        this.converter = ConverterFactory.getInstance().getConverter(converterClassName);
        this.name = typedArray.getString(R.styleable.FieldView_name);
        typedArray.recycle();
    }


    public Field<? extends View, ?> getField() {
        if (field == null)
            throw new IllegalStateException("No child view added in FieldVIew");
        return field;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        if (this.getChildCount() > 1)
            throw new IllegalStateException("FieldView can have only one child");
        if (converter.getSourceType() != child.getClass())
            throw new IllegalStateException("Supplied converter for " + converter.getSourceType().getSimpleName() + " but found child of type " + child.getClass().getSimpleName());
        this.field = new Field<>(
                this.name,
                converter,
                child
        );
    }
}
