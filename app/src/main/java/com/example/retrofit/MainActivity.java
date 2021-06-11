package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //1: khởi tạo retrofit
        //2: link gốc : https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                              .readTimeout(30 , TimeUnit.SECONDS)
                              .connectTimeout(30 , TimeUnit.SECONDS)
                              .writeTimeout(30 , TimeUnit.SECONDS)
                              .protocols(Arrays.asList(Protocol.HTTP_1_1))
                              .build();


        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://khoapham.vn")   //địa chỉ link gốc
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))//đọc dữ liệu json và làm sao chuyển đổi, chuyển về dạng gì
                .build();

        //2: định nghĩa phương thức call request : interface ApiRequest

        //3: khởi tạo lớp request
        ApiRequest apiRequest = retrofit.create(ApiRequest.class);


        //4: call method api
        Call<Demo1> callbackdemo1 = apiRequest.fetchDemo1();

        //5: Nhận đáp trả từ api
        //enqueue : dùng để nhận đáp trả
        callbackdemo1.enqueue(new Callback<Demo1>() {
            @Override
            public void onResponse(Call<Demo1> call, Response<Demo1> response) {
                //nhận dữ liệu
                Demo1 demo1 = response.body();
                Toast.makeText(MainActivity.this, demo1.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Demo1> call, Throwable t) {
                Log.d("BBBB" , t.getMessage());
            }
        });

    }
}