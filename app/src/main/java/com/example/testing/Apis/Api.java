package com.example.testing.Apis;

import com.example.testing.CountryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("bank")
    Call<List<CountryModel>> getingCountry();

}
