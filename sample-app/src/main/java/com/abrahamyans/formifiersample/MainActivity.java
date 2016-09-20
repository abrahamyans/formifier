package com.abrahamyans.formifiersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.abrahamyans.formifier.view.FormView;

public class MainActivity extends AppCompatActivity {

    private FormView formView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
