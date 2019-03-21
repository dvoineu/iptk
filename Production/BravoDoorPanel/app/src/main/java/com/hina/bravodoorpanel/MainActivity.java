package com.hina.bravodoorpanel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    String officeNumber = "";
    TextView tv_officeNumber;
    TextView tv_name;
    TextView tv_status;
    TextView tv_position;
    TextView tv_message;
    Button btn_showOfficeHours;
    Button btn_makeAppointment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_officeNumber = findViewById(R.id.tv_officeNumber);
        tv_name = findViewById(R.id.tv_name);
        tv_status = findViewById(R.id.tv_status);
        tv_position = findViewById(R.id.tv_position);
        tv_message = findViewById(R.id.tv_message);
        btn_showOfficeHours = findViewById(R.id.btn_showOfficeHours);
        btn_makeAppointment = findViewById(R.id.btn_makeAppointment);

        prefs = getSharedPreferences(Constants.PREF_USER, MODE_PRIVATE);
        officeNumber = prefs.getString(Constants.ROOM, "A113");

        tv_name.setText(prefs.getString(Constants.NAME, "Name"));
        tv_position.setText(prefs.getString(Constants.POSITION, "Position"));
        tv_status.setText(prefs.getString(Constants.STATUS, "Status"));
        tv_message.setText(prefs.getString(Constants.MESSAGE, "Message"));


        tv_officeNumber.setText(officeNumber);
        Log.i("Room number", officeNumber);

        btn_showOfficeHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();


//                Toast.makeText(getApplicationContext(), prefs.getString(Constants.OFFICE_HOURS, "???"), Toast.LENGTH_LONG).show();
            }
        });

        btn_makeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Appointment.class);
                startActivity(intent);
            }
        });

    }

    private void openDialog() {
        OfficeHoursDialog officeHoursDialog = new OfficeHoursDialog();
        officeHoursDialog.show(getSupportFragmentManager(), "office hours dialog");
    }
}
