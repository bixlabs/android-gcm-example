package com.bixlabs.amazonsns.api;

import android.util.Log;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static Rest create() {
        Retrofit fit = new Retrofit.Builder()
                .baseUrl("http://0.0.0.0:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return fit.create(Rest.class);
    }

    public static void registerDevice(String token) {
        RegisterRequest request = new RegisterRequest();
        request.setToken(token);
        request.setType("android");

        Log.d(Api.class.getCanonicalName(), "registering " + token);
        try {
            Api.create().registerDevice(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
