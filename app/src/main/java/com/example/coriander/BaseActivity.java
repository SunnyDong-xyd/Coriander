package com.example.coriander;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class BaseActivity extends AppCompatActivity implements OnViewCreated {

    private View currentView;
    /*/
    private ContactFragment fragmentA;
    private CallDeleteFragment fragmentB;
    /*/
    private static Context mContext;

    public static Context getContext(){
        return mContext;
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        loadBaseElements();
        setContext(this);


        /*/Intent intent = getIntent();
        String Aname = intent.getStringExtra("name");
        Bundle bundle = new Bundle();
        bundle.putString("name","From Activity");
        CallDeleteFragment fragobj = new CallDeleteFragment();
        fragobj.setArguments(bundle);/*/

        /*/
        fragmentA = new ContactFragment();
        fragmentB = new CallDeleteFragment();
        /*/

       // FragmentManager fragmentManager = getSupportFragmentManager();
       // FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       //fragmentTransaction.replace(R.id.fragment,new CallDeleteFragment());
      //fragmentTransaction.commit();

    }

    protected void loadBaseElements(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.bottom_app_bar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(currentView).navigate(R.id.action_global_panicFragment);
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

    public static void SaveFile(String filename, String fileContents){
        File file = new File(getContext().getFilesDir(), filename);
        try {
            file.createNewFile();
            FileOutputStream oFile = new FileOutputStream(file, false);
            oFile.write(fileContents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LogEntry ReadFile(String filename){
        LogEntry logEntry = new LogEntry();
        try {
            FileInputStream fis = getContext().openFileInput(filename);
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                logEntry.setYear(Integer.parseInt(reader.readLine()));
                logEntry.setMonth(Integer.parseInt(reader.readLine()));
                logEntry.setDay(Integer.parseInt(reader.readLine()));
                logEntry.setMood(Integer.parseInt(reader.readLine()));
                logEntry.setPanicAttack(Boolean.valueOf(reader.readLine()));
                logEntry.setUserLog(reader.readLine());
            } catch (IOException e) {
                // Error occurred when opening raw file for reading.
                e.printStackTrace();
            } finally {
                return logEntry;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onViewSelected (View view){
        currentView = view;
    }

}