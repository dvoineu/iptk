package com.hina.bravodoorpanel;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.preference.PreferenceManager;

//public class Setup extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_setup);
//
//
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hina.bravodoorpanel.Model.User;
import com.hina.bravodoorpanel.Model.UserResponse;
import com.hina.bravodoorpanel.Retrofit.INodeJS;
import com.hina.bravodoorpanel.Retrofit.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Setup extends AppCompatActivity {

    EditText et_office_number;
    Button btn_init;
    private SharedPreferences mSharedPreferences;
    String mRoomNumber;
    SharedPreferences.Editor editor;
    INodeJS myAPI;
    String userStatus;
    String userEmail;
    String userPosition;
    String userName;
    String userMessage;
    String userOfficeHours;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        et_office_number = findViewById(R.id.edt_office);
        btn_init = findViewById(R.id.send_button);
        sharedpreferences = getSharedPreferences(Constants.PREF_USER,
                Context.MODE_PRIVATE);

        //////////Retrofit 2 Client//////////////////
        Retrofit retrofit = RetrofitApi.getInstance();
        myAPI = retrofit.create(INodeJS.class);
        /////////END Retrofit ////////////////////

        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRoomNumber = et_office_number.getText().toString();
                checkRoomNumber(mRoomNumber);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Constants.ROOM,mRoomNumber);
                editor.apply();
                Log.i("Room", sharedpreferences.getString(Constants.ROOM, "Failure"));
            }
        });
    }

    private void checkRoomNumber(String roomNumber) {

        Call<User> call  = myAPI.getRoom(roomNumber);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User userResponse = response.body();

                userStatus = userResponse.getStatus();
                userName = userResponse.getName() + " " + userResponse.getSurname();
                userPosition = userResponse.getPositionTitle();
                userOfficeHours = userResponse.getOfficeHours();
                userMessage = userResponse.getMessage();
                userEmail = userResponse.getEmail();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Constants.NAME, userName);
                editor.putString(Constants.POSITION, userPosition);
                editor.putString(Constants.MESSAGE, userMessage);
                editor.putString(Constants.OFFICE_HOURS, userOfficeHours);
                editor.putString(Constants.EMAIL, userEmail);
                editor.putString(Constants.STATUS, userStatus);
                editor.apply();

//                Toast.makeText(getApplicationContext(), sharedpreferences.getString(Constants.NAME, "Failure"), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Setup.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Enter correct Room Number", Toast.LENGTH_LONG).show();
            }
        });
    }
}
