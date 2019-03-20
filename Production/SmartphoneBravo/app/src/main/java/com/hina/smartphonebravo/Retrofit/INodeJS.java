package com.hina.smartphonebravo.Retrofit;

import com.hina.smartphonebravo.Model.User;
import com.hina.smartphonebravo.Model.UserResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface INodeJS {
    @POST("register")
    @FormUrlEncoded
    Observable<String> registerUser(@Field("email")String email,
                                    @Field("name")String name,
                                    @Field("password")String password);

    @POST("login")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("email")String email,
                                 @Field("password")String password);

    @POST("status")
    @FormUrlEncoded
    Call<String> status(@Field("currentStatus")String currentStatus);

    @POST("message")
    @FormUrlEncoded
    Call<String> message(@Field("message")String message);

    @POST("office_hours")
    @FormUrlEncoded
    Call<String> setHours(@Field("office_hours")String office_hours
    );

    @GET("users/{email}")
    Call<User> getProfile(@Path("email") String email);

//    @POST("office_hours")
//    Call<User> setHours(@Body User user);

    @FormUrlEncoded
    @POST("createHours")
    Call<User> createHours(
            @Field("email") String email,
            @Field("officeHours") String officeHours
    );

    @FormUrlEncoded
    @POST("getHours")
    Call<UserResponse> getHours(
            @Field("email") String email,
            @Field("officeHours") String officeHours
    );
}
