package com.example.retrofit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2,text3,text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        text4=findViewById(R.id.text4);


       RetrofitClint.getRetrofit()
               .create(GetRequest.class)
               .getData()
               .enqueue(new Callback<JsonObject>() {
                   @Override
                   public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
           Log.d("gjhruig", "onResponse: "+response.body().getAsJsonArray("data").get(0).getAsJsonObject().get("id"));
           Log.d("gjhruig", "onResponse: "+response.body().getAsJsonArray("data").get(1).getAsJsonObject().get("vehicle_type"));


           text1.setText(response.body().getAsJsonArray("data").get(0).getAsJsonObject().get("vehicle_type").toString());
           text2.setText(response.body().getAsJsonArray("data").get(0).getAsJsonObject().get("time").toString());
           text3.setText(response.body().getAsJsonArray("data").get(1).getAsJsonObject().get("vehicle_type").toString());
           text4.setText(response.body().getAsJsonArray("data").get(1).getAsJsonObject().get("time").toString());

                   }

                   @Override
                   public void onFailure(Call<JsonObject> call, Throwable t) {

                       Log.d("ufgiufghu", "onFailure: "+t.getMessage());

                   }
               });
    }
}