Formifier
==============
An Android library for self contained XML declared forms


Usage
-----

Declare your forms by using **FieldView** and **FormView**

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <com.abrahamyans.formifier.view.FormView
        android:id="@+id/form"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">


        <com.abrahamyans.formifier.view.FieldView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:name="str"
            app:converter="TextViewStringConverter">
            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Some String"/>
        </com.abrahamyans.formifier.view.FieldView>

        <com.abrahamyans.formifier.view.FieldView
            android:layout_width="match_parent"
            android:orientation="vertical"
            android:layout_height="wrap_content"
            app:name="isChecked"
            app:converter="CheckBoxBooleanConverter">
            <CheckBox
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
        </com.abrahamyans.formifier.view.FieldView>

        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Submit"
            android:onClick="onSubmit"/>
    </com.abrahamyans.formifier.view.FormView>
</RelativeLayout>

Bind the **FormView** in your activity 

    formView = (FormView) findViewById(R.id.form);
    
Declare a POJO to match the name attribute of FieldViews

    public class SomePojo{
      public String str;
      public Boolean isChecked;
    }

Get the values of the the filled form as an Object

    SomePojo form = formView.getFormClass(SomePojo.class);

Get the values as Map<String, Object> 

    Map<String, Object> form = formView.getFormMap();
