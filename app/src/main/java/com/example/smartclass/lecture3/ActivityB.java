package com.example.smartclass.lecture3;

import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ActivityB extends ActionBarActivity {


    EditText userInput;
    Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);


        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("My New Title");



        userInput = (EditText) findViewById(R.id.userInput);
        doneButton = (Button) findViewById(R.id.doneButton);


        ((TextView) findViewById(R.id.activityBTitle))
                .setText(getIntent().getStringExtra("title"));


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = userInput.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("userInputKey", userText);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });


    }





}
