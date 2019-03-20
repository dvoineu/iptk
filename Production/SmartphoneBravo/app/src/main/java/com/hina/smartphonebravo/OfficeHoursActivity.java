package com.hina.smartphonebravo;

import com.hina.smartphonebravo.Model.User;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.hina.smartphonebravo.Model.UserResponse;
import com.hina.smartphonebravo.Retrofit.INodeJS;
import com.hina.smartphonebravo.Retrofit.RetrofitApi;
import com.hina.smartphonebravo.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OfficeHoursActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    INodeJS myAPI;
    private SharedPreferences mSharedPreferences;
    TextView tv_mon;
    TextView tv_tue;
    TextView tv_wed;
    TextView tv_thu;
    TextView tv_fri;

    EditText et_mon_hours_1;
    EditText et_mon_hours_2;
    EditText et_mon_hours_3;
    EditText et_mon_hours_4;

    EditText et_tue_hours_1;
    EditText et_tue_hours_2;
    EditText et_tue_hours_3;
    EditText et_tue_hours_4;

    EditText et_wed_hours_1;
    EditText et_wed_hours_2;
    EditText et_wed_hours_3;
    EditText et_wed_hours_4;

    EditText et_thu_hours_1;
    EditText et_thu_hours_2;
    EditText et_thu_hours_3;
    EditText et_thu_hours_4;

    EditText et_fri_hours_1;
    EditText et_fri_hours_2;
    EditText et_fri_hours_3;
    EditText et_fri_hours_4;

    Button setOfficeHours;
    String officeHours = "";
    String tv_officeHours;
    String mEmail;
    String mOfficeHours;
    User user;
    String mName;
    String retrofitName;
    TextView currentOfficeHours;

    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_hours);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mOfficeHours = mSharedPreferences.getString(Constants.OFFICE_HOURS,"");
//        currentOfficeHours.setText(mOfficeHours);

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(INodeJS.class);

//        Retrofit retrofit = RetrofitApi.getInstance();
//        myAPI = retrofit.create(INodeJS.class);

        currentOfficeHours = findViewById(R.id.tv_currentOfficeHours);
        setOfficeHours = findViewById(R.id.btn_setOfficeHours);

        tv_mon = findViewById(R.id.tv_mon);
        tv_tue = findViewById(R.id.tv_tue);
        tv_wed = findViewById(R.id.tv_wed);
        tv_thu = findViewById(R.id.tv_thu);
        tv_fri = findViewById(R.id.tv_fri);

        et_mon_hours_1 = findViewById(R.id.et_mon_hours_1);
        et_mon_hours_2 = findViewById(R.id.et_mon_hours_2);
        et_mon_hours_3 = findViewById(R.id.et_mon_hours_3);
        et_mon_hours_4 = findViewById(R.id.et_mon_hours_4);

        et_tue_hours_1 = findViewById(R.id.et_tue_hours_1);
        et_tue_hours_2 = findViewById(R.id.et_tue_hours_2);
        et_tue_hours_3 = findViewById(R.id.et_tue_hours_3);
        et_tue_hours_4 = findViewById(R.id.et_tue_hours_4);

        et_wed_hours_1 = findViewById(R.id.et_wed_hours_1);
        et_wed_hours_2 = findViewById(R.id.et_wed_hours_2);
        et_wed_hours_3 = findViewById(R.id.et_wed_hours_3);
        et_wed_hours_4 = findViewById(R.id.et_wed_hours_4);

        et_thu_hours_1 = findViewById(R.id.et_thu_hours_1);
        et_thu_hours_2 = findViewById(R.id.et_thu_hours_2);
        et_thu_hours_3 = findViewById(R.id.et_thu_hours_3);
        et_thu_hours_4 = findViewById(R.id.et_thu_hours_4);

        et_fri_hours_1 = findViewById(R.id.et_fri_hours_1);
        et_fri_hours_2 = findViewById(R.id.et_fri_hours_2);
        et_fri_hours_3 = findViewById(R.id.et_fri_hours_3);
        et_fri_hours_4 = findViewById(R.id.et_fri_hours_4);


        setOfficeHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                officeHours += tv_mon.getText().toString();
// Mon
                if (et_mon_hours_1.getText().toString().equals("") || et_mon_hours_2.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "   " + et_mon_hours_1.getText().toString() + " - " + et_mon_hours_2.getText().toString();
                }

                if (et_mon_hours_3.getText().toString().equals("") || et_mon_hours_4.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "   " + et_mon_hours_3.getText().toString() + " - " + et_mon_hours_4.getText().toString();
                }

                officeHours +=  "\n";

// Tue
                officeHours += tv_tue.getText().toString();
                if (et_tue_hours_1.getText().toString().equals("") || et_tue_hours_2.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "    " + et_tue_hours_1.getText().toString() + " - " + et_tue_hours_2.getText().toString();
                }

                if (et_tue_hours_3.getText().toString().equals("") || et_tue_hours_4.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "    " + et_tue_hours_3.getText().toString() + " - " + et_tue_hours_4.getText().toString();
                }
                officeHours +=  "\n";
/// Wed
                officeHours += tv_wed.getText().toString();
                if (et_wed_hours_1.getText().toString().equals("") || et_wed_hours_2.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "   " + et_wed_hours_1.getText().toString() + " - " + et_wed_hours_2.getText().toString();
                }

                if (et_wed_hours_3.getText().toString().equals("") || et_wed_hours_4.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "   " + et_wed_hours_3.getText().toString() + " - " + et_wed_hours_4.getText().toString();
                }
                officeHours +=  "\n";
/// Thu
                officeHours += tv_thu.getText().toString();
                if (et_thu_hours_1.getText().toString().equals("") || et_thu_hours_2.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "    " + et_thu_hours_1.getText().toString() + " - " + et_thu_hours_2.getText().toString();
                }

                if (et_thu_hours_3.getText().toString().equals("") || et_thu_hours_4.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "    " + et_thu_hours_3.getText().toString() + " - " + et_thu_hours_4.getText().toString();
                }
                officeHours +=  "\n";

/// Fri
                officeHours += tv_fri.getText().toString();
                if (et_fri_hours_1.getText().toString().equals("") || et_fri_hours_2.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "      " + et_fri_hours_1.getText().toString() + " - " + et_fri_hours_2.getText().toString();
                }

                if (et_fri_hours_3.getText().toString().equals("") || et_fri_hours_4.getText().toString().equals("")) {
                    officeHours += "";
                } else {
                    officeHours += "      " + et_fri_hours_3.getText().toString() + " - " + et_fri_hours_4.getText().toString();
                }

//                currentOfficeHours.setText(mEmail);
                if (officeHours.equals("")) {
                    currentOfficeHours.setText("Your office hours are not set.");
                } else {
                    tv_officeHours = officeHours;
                    currentOfficeHours.setText(tv_officeHours);



//                    currentOfficeHours.setText(tv_officeHours);
                    officeHours = "";

                }
//                SharedPreferences.Editor editor = mSharedPreferences.edit();
//                editor.putString(Constants.STATUS, tv_officeHours);
//                editor.apply();

/////////////// Retrofit without email
                Call<String> call = myAPI.setHours(tv_officeHours);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Toast.makeText(OfficeHoursActivity.this,
                                    "Success", Toast.LENGTH_LONG);

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
/////////////// Retrofit without email

////////////New retrofit with Email
//                Call<User> call  = myAPI.createHours(tv_officeHours, mEmail);
//                call.enqueue(new Callback<User>() {
//                    @Override
//                    public void onResponse(Call<User> call, Response<User> response) {
//                        String s = response.body().toString();
//                        Log.i("name check", s);
//                        Toast.makeText(OfficeHoursActivity.this, s, Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<User> call, Throwable t) {
//
//                    }
//                });
//// /////// Get DATA from Table User

//                Call<UserResponse> call2  = myAPI.getHours(tv_officeHours, mEmail);
//                call2.enqueue(new Callback<UserResponse>() {
//                    @Override
//                    public void onResponse(Call<UserResponse> call2, Response<UserResponse> response) {
//                        UserResponse userResponse = response.body();
//                        retrofitName = userResponse.getOfficeHours();
//                        String s = response.body().toString();
//                        Log.i("name check", retrofitName);
//                        Toast.makeText(OfficeHoursActivity.this, s, Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<UserResponse> call2, Throwable t) {
//
//                    }
//                });

                //////////// END Get Data From User
            }
        });



    }



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String format = "%1$02d";
//        et_mon_hours_1.setText(String.format(format, hourOfDay)+ " : " + String.format(format,minute));

    }


}
