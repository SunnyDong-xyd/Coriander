package com.example.coriander;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BaseActivity extends AppCompatActivity implements OnViewCreated {

    private View currentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        loadBaseElements();
    }

    protected void loadBaseElements(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.bottom_app_bar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(), PanicActivity.class));
            }
        });
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
            case R.id.app_bar_main:
                Navigation.findNavController(currentView).navigate(R.id.action_global_mainFragment);
                return true;
            case R.id.app_bar_hardware:
                Navigation.findNavController(currentView).navigate(R.id.action_global_hardwareFragment);
                return true;
            case R.id.app_bar_settings:
                //Settings (fragment?);
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
                return true;
            case android.R.id.home:
                MainDrawerFragment mainNavDrawerFragment = new MainDrawerFragment();
                mainNavDrawerFragment.show(getSupportFragmentManager(), mainNavDrawerFragment.getTag());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onViewSelected (View view){
        currentView = view;
    }

}