package com.example.retrofit1;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClint {

private static Retrofit retrofit;

  static Context context;

 public static Retrofit getRetrofit(){


     if (retrofit==null){

         return retrofit=new Retrofit.Builder()
                 .baseUrl("http://139.59.0.182/demo/travier2/public/api/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
     }
else {

    return retrofit;
     }
}
}
