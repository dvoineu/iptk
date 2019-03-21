package com.hina.bravodoorpanel.Retrofit;

import com.hina.bravodoorpanel.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static Retrofit instance;

    public static Retrofit getInstance(){


        if(instance==null){
            instance = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
//
//
////                    .baseUrl("https://teambravo-nodejs-server.herokuapp.com/")
////                    .baseUrl("http://10.0.2.2:3000/")
        }
//
        return instance;
    }
}
