package com.dvoineu.phoneapp;

import com.dvoineu.phoneapp.models.ServerRequest;
import com.dvoineu.phoneapp.models.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("index.php")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
