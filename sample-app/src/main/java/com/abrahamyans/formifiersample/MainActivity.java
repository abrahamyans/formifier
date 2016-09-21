package com.abrahamyans.formifiersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.abrahamyans.formifier.view.FormView;

public class MainActivity extends AppCompatActivity {

    private FormView formView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        formView = (FormView) findViewById(R.id.form);
    }


    public void onSubmit(View view) {
        Credentials input = formView.getFormClass(Credentials.class);
        Log.d("ConverterForm", input.toString());
    }


    public static class Credentials {
        private String username;
        private String password;
        private Integer age;
        private Boolean rememberMe;
        public Credentials(){

        }

        public Credentials(String username,String password){
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "Credentials{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", age=" + age +
                    ", rememberMe=" + rememberMe +
                    '}';
        }
    }
}
