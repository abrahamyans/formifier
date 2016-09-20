package com.abrahamyans.formifier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.abrahamyans.formifier.form.FormOfMap;
import com.abrahamyans.formifier.form.FormOfObject;

import java.util.Map;

/**
 * @author Samvel Abrahamyan
 */

public class FormView extends LinearLayout implements ViewGroup.OnHierarchyChangeListener{

    private FormOfMap formOfMap = new FormOfMap();

    public FormView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public <T> T getFormClass (Class<T> klass){
        FormOfObject<T> formOfObject = new FormOfObject<>(klass, formOfMap);
        return formOfObject.getForm();
    }

    public Map<String, Object> getFormMap(){
        return formOfMap.getForm();
    }

    @Override
    public void onChildViewAdded(View parent, View child) {
        if (!(child instanceof FieldView))
            return;
        FieldView fieldView = (FieldView) child;
        formOfMap.addField(fieldView.getField());
    }

    @Override
    public void onChildViewRemoved(View parent, View child) {
        if(child instanceof FieldView)
            formOfMap.removeField(((FieldView) child).getField());
    }
}
