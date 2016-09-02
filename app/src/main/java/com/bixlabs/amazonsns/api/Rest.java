package com.bixlabs.amazonsns.api;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Rest {

    @POST("Consumers/registerDevice")
    Call<ResponseBody> registerDevice(@Body RegisterRequest request);
}
