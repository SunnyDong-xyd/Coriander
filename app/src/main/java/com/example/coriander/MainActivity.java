package com.example.coriander;

import android.os.Bundle;

public class MainActivity extends BaseActivity {
    //REMINDER: Change all hardcoded strings in xml files to @string resource
    //Note: May want to change activity transition animations
    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.loadBaseElements();
    }

}