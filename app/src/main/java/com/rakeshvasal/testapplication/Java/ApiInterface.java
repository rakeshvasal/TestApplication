package com.rakeshvasal.testapplication.Java;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("nzin01312019187360.json")
    Call<Data> getData();

    @GET("json/questions.json")
    Call<List<String>> getQuestions();

}
