package com.example.testing.Apis;

import com.example.testing.CountryModel;
import com.example.testing.JobModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("country")
    Call<List<CountryModel>> getingCountry();

    @GET("job")
    Call<List<JobModel>> gettingJob();

}
