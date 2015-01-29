package com.example.smartclass.lecture3;

import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    Button launchButton;
    TextView display;

    static final int ACTIVITY_B_REQUEST_CODE = 1111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("My New Title");

        launchButton = (Button) findViewById(R.id.launchButton);
        display = (TextView) findViewById(R.id.display);

        View.OnClickListener ocl = new View.OnClickListener(){
            public void onClick(View v) {
                Intent activityBIntent = new Intent(MainActivity.this, ActivityB.class);

                activityBIntent.putExtra("title", "Enter a value");

                startActivityForResult(activityBIntent, ACTIVITY_B_REQUEST_CODE);
            }
        };

        launchButton.setOnClickListener(ocl);


        Log.d("Status", "onCreate fired");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Status", "onStart fired");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Status", "onResume fired");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Status", "onPause fired");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("Status", "onStop fired");
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        if ((requestCode == ACTIVITY_B_REQUEST_CODE)
                && (resultCode == RESULT_OK)){
            String userInput = data.getStringExtra("userInputKey");

            display.setText(userInput);
        }

    }



}
