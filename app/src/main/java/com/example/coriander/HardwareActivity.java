package com.example.coriander;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HardwareActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);
        super.loadBaseElements();
    }
}