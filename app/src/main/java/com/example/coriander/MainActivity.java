package com.example.coriander;

import android.os.Bundle;

public class MainActivity extends BaseActivity {
    //REMINDER: Change all hardcoded strings in xml files to @string resource.
    /*
    - Note: May want to change activity transition animations
    - Note: Review behaviour on clicking navigation button on the same activity as the navigation target.
        Suggested behaviour is to return to default activity and close open fragments without transition animation.
    - Note: Also change back button functionality to always reset history on returning to main menu.
        Possibly add popup interface to close app on last back
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.loadBaseElements();
    }

}