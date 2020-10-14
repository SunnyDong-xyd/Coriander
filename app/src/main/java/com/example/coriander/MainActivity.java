package com.example.coriander;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends BaseActivity {
    //REMINDER: Change all hardcoded strings in xml files to @string resource
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(toolbar);
    }

}