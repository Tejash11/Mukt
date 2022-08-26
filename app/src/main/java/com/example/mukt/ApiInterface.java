package com.example.mukt;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/Mukti")
    Call<BotMessage> getStringScalar(@Body UserMessage body);

}
