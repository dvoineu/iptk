package com.hina.bravodoorpanel;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmployeeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Employee> em;


    public EmployeeAdapter(Context context, ArrayList<Employee> employees){
        this.context = context;
        this.em = employees;
    }


    @Override
    public int getCount() {
        return em.size();
    }

    @Override
    public Object getItem(int position) {
        return em.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.employee_button_template, parent, false);
        }

        // get current item to be displayed
        Employee currentEm = (Employee) getItem(position);

        // get the TextView for item name and item description
        ImageView emPic = (ImageView) convertView.findViewById(R.id.grid_item_image);
        TextView emName = (TextView)convertView.findViewById(R.id.grid_item_label);
        TextView emPosition = (TextView)convertView.findViewById(R.id.employee_position);
        TextView emStatus = (TextView)convertView.findViewById(R.id.employee_status);
        Button bOfficeHours = (Button) convertView.findViewById(R.id.buttonOfficeHours);
        Button bAppointment = (Button) convertView.findViewById(R.id.buttonAppointment);

        //sets the text for item name and item description from the current item object
        //emPic.setImageResource(currentEm.getPic());
        emPic.setImageResource(R.drawable.athene);
        emName.setText(currentEm.getName());
        emPosition.setText(currentEm.getPosition());
        emStatus.setText(currentEm.getStatus());


        //ClickListener for displaying office hours
        bOfficeHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, currentEm.getName() + "OFFICE HOURS", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context.getApplicationContext(),Appointment.class);
                Bundle bundle = new Bundle();
                //bundle.putSerializable("KEY", currentEm);
                i.putExtras(bundle);
                context.startActivity(i);
            }
        });

        //ClickListener for option: make appointment
        bAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, currentEm.getName() + "Appointment", Toast.LENGTH_SHORT).show();
                System.out.println("BUTTON HAS BEEN CLICKED");

                Intent i = new Intent(context.getApplicationContext(),Appointment.class);
                context.startActivity(i);

            }
        });
        // returns the view for the current row
        return convertView;
    }
}
