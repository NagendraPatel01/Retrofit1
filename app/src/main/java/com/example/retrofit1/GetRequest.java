package com.example.retrofit1;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequest {

    @GET("vehicle-types")
    Call<JsonObject> getData();
}
