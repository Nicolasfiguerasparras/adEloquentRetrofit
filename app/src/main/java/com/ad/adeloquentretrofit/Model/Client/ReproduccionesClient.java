package com.ad.adeloquentretrofit.Model.Client;

import com.ad.adeloquentretrofit.Model.Room.POJO.Reproducciones;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReproduccionesClient {

    @DELETE("Reproducciones/{id}")
    Call<Void> deleteReproducciones(@Path("id") long id);

    @GET("Reproducciones/{id}")
    Call<Reproducciones> getReproducciones(@Path("id") long id);

    @GET("Reproducciones")
    Call<List<Reproducciones>> getAllReproducciones();

    @POST("Reproducciones")
    Call<Long> storeReproducciones(@Body Reproducciones reproducciones);

    @PUT("Reproducciones/{id}")
    Call<Void> updateReproducciones(@Path("id") long id, @Body Reproducciones reproducciones);
}
