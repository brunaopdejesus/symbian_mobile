package com.example.symbianmobile.remote;

import com.example.symbianmobile.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RouterInterface {

    @POST("/user/register")
    Call<User> addUser(@Body User user);

}
