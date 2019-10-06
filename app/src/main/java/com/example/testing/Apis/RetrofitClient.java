package com.example.testing.Apis;


import android.content.Context;

import com.example.testing.Util;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    private static RetrofitClient mInstance;
    private Retrofit retrofit;
    private Api api;

    private RetrofitClient(Context context) throws IOException {
            String baseUrl = Util.getProperty("urlName", context);
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    }

    public static synchronized RetrofitClient getInstance(Context context)  throws IOException{
        if (mInstance == null) {
            mInstance = new RetrofitClient(context);
        }
        return mInstance;
    }


    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
