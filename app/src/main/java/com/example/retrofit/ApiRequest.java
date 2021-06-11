package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("KhoaPhamTraining/json/tien/demo1.json")
    Call<Demo1> fetchDemo1();
}
