package com.example.coriander;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar)findViewById(R.id.bottom_app_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.app_bar_hardware:
                //hardware functionality
                return true;
            case R.id.app_bar_search:
                //search functionality
                return true;
            case R.id.app_bar_settings:
                //settings;
                return true;
            case android.R.id.home:
                MainDrawerFragment mainNavDrawerFragment = new MainDrawerFragment();
                mainNavDrawerFragment.show(getSupportFragmentManager(), mainNavDrawerFragment.getTag());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}