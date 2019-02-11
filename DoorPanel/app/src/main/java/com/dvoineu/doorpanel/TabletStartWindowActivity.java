package com.dvoineu.doorpanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class TabletStartWindowActivity extends AppCompatActivity {

    public void onClickUpLeft (View view){
        Button btnUpLeftNameOfEmployee = (Button) view;
        Log.i("clicked", "Button clicked!");
        Intent intent = new Intent(this, EmployeeInfoActivity.class);
        startActivity(intent);

    }

    public void onClickUpRight (View view){
        Button btnUpRightNameOfEmployee = (Button) view;
        Log.i("clicked", "Button clicked upRight!");
    }

    public void onClickBottomRight (View view){
        Button btnBottomRightNameOfEmployee = (Button) view;
        Log.i("clicked", "Button clicked upRight!");
    }

    public void onClickBottomLeft (View view){
        Button btnBottomLeftNameOfEmployee = (Button) view;
        Log.i("clicked", "Button clicked left!");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
