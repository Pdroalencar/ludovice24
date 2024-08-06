package com.example.ludovice2.api;

import com.example.ludovice2.model.Vaga;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface JobApi {
    @GET("vagas") // Ajuste o endpoint conforme sua API
    Single<List<Vaga>> getVagas();
}