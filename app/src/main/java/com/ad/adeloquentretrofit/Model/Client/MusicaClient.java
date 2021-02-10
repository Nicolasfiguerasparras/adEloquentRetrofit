package com.ad.adeloquentretrofit.Model.Client;


import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MusicaClient {

    @DELETE("Musica/{id}")
    Call<Void> deleteMusica(@Path("id") long id);

    @GET("Musica/{id}")
    Call<Musica> getMusica(@Path("id") long id);

    @GET("Musica")
    Call<List<Musica>> getAllMusica();

    @POST("Musica")
    Call<Musica> storeMusic(@Body Musica musica);

    @PUT("Musica/{id}")
    Call<Void> updateMusic(@Path("id") long id, @Body Musica musica);
}
