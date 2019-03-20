package com.hina.smartphonebravo;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import com.hina.smartphonebravo.Retrofit.INodeJS;
import com.hina.smartphonebravo.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StatusActivity extends AppCompatActivity {

    Button btn_out_of_the_office, btn_in_the_office, btn_busy;
    TextView tv_current_status;
    INodeJS myAPI;
    private SharedPreferences mSharedPreferences;
    String mCurrentStatus;
    String mShareStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        btn_busy = findViewById(R.id.btn_busy);
        btn_out_of_the_office = findViewById(R.id.btn_out_of_the_office);
        btn_in_the_office = findViewById(R.id.btn_in_the_office);
        tv_current_status = findViewById(R.id.tv_current_status);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mShareStatus = mSharedPreferences.getString(Constants.STATUS,"");
        tv_current_status.setText(mShareStatus);

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(INodeJS.class);

//        String mCurrentStatus;
        tv_current_status.setText(mShareStatus);

        btn_busy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_current_status.setText("BUSY");
                mCurrentStatus = tv_current_status.getText().toString();
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString(Constants.STATUS, mCurrentStatus);
                editor.apply();
                Call<String> call = myAPI.status(mCurrentStatus);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful() && response.body() != null){
                            Toast.makeText(StatusActivity.this,
                                    "Success", Toast.LENGTH_LONG);

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });

        btn_out_of_the_office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_current_status.setText("OUT OF THE OFFICE");

                mCurrentStatus = tv_current_status.getText().toString();
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString(Constants.STATUS, mCurrentStatus);
                editor.apply();
                Call<String> call = myAPI.status(mCurrentStatus);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful() && response.body() != null){
                            Toast.makeText(StatusActivity.this,
                                    "Success", Toast.LENGTH_LONG);

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });

            }
        });

        btn_in_the_office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_current_status.setText("IN THE OFFICE");
                mCurrentStatus = tv_current_status.getText().toString();
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString(Constants.STATUS, mCurrentStatus);
                editor.apply();
                Call<String> call = myAPI.status(mCurrentStatus);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful() && response.body() != null){
                            Toast.makeText(StatusActivity.this,
                                    "Success", Toast.LENGTH_LONG);

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });


    }
}
