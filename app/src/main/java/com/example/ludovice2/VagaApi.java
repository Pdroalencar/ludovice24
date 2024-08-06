package com.example.ludovice2.api;

import com.example.ludovice2.model.Vaga;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface VagaApi {

    @GET("vagas")
    Single<List<Vaga>> getVagas();

    static VagaApi create() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(VagaApi.class);
    }

    Call<List<Vaga>> getAllVagas();
}