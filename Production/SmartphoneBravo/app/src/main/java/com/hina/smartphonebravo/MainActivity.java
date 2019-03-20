package com.hina.smartphonebravo;

import com.hina.smartphonebravo.Model.User;
import android.content.SharedPreferences;
import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.hina.smartphonebravo.Retrofit.INodeJS;
import com.hina.smartphonebravo.Retrofit.RetrofitClient;
import com.rengwuxian.materialedittext.MaterialEditText;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    INodeJS myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    MaterialEditText edt_email, edt_password;
    MaterialButton btn_login;
    String unique_id = "";
    User user;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onStop(){
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSharedPreferences();
        user = new User();

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(INodeJS.class);

        btn_login = (MaterialButton)findViewById(R.id.loginBtn);

        edt_email = (MaterialEditText)findViewById(R.id.edt_email);
        edt_password = (MaterialEditText)findViewById(R.id.edt_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(edt_email.getText().toString(),edt_password.getText().toString());
                user.setEmail(edt_email.getText().toString());
            }
        });
    }


    private void loginUser(String email, String password){
        compositeDisposable.add(myAPI.loginUser(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if(s.contains("encrypted_password")){
                            Toast.makeText(MainActivity.this, "Login Success" + "encrypted Password: " + s.getBytes(), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this,Menu.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(MainActivity.this, "" + s, Toast.LENGTH_SHORT).show();
                        }
                    }
                })
        );

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(Constants.EMAIL,email);
        editor.apply();

    }

    private void initSharedPreferences() {

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }
}
