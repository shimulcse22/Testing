package com.example.testing.Apis;

import com.example.testing.ModelClasses.CountryModel;
import com.example.testing.ModelClasses.JobModel;

import com.example.testing.ModelClasses.SubmitModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("country")
    Call<List<CountryModel>> getingCountry();

    @GET("job")
    Call<List<JobModel>> gettingJob();

    @POST("candidate")
    Call<SubmitModel> userRegistration(@Body SubmitModel model);

}
