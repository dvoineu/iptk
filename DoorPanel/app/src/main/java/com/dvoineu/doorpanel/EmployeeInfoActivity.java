package com.dvoineu.doorpanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmployeeInfoActivity extends AppCompatActivity {

    public void backToMainMenu (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toCalendarActivity (View view){
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_info);
    }
}
