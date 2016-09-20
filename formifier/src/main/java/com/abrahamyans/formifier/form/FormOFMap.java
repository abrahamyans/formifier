package com.abrahamyans.formifier.form;

import android.view.View;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Samvel Abrahamyan
 */
public class FormOfMap implements Form<Map<String, Object>> {

    private List<Field<?, ?>> fields = new ArrayList<>();

    public FormOfMap(List<Field<?, ?>> fields){
        this.fields.addAll(fields);
    }

    public FormOfMap(){
        super();
    }

    public void addField(Field<? extends View, ?> field){
        this.fields.add(field);
    }

    public void removeField(Field<? extends View, ?> field) {
        this.fields.remove(field);
    }

    @Override
    public Map<String, Object> getForm() {
        Map<String, Object> values = new LinkedHashMap<>();
        for(Field<?, ?> f: fields)
            values.put(f.name(), f.getInput());
        return values;
    }


}
