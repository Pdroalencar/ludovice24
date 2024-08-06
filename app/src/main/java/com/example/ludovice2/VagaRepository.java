package com.example.ludovice2.repository;

import com.example.ludovice2.api.JobApi;
import com.example.ludovice2.api.RetrofitClient;
import com.example.ludovice2.model.Vaga;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class VagaRepository {
    private final JobApi JobApi;

    public VagaRepository() {
        JobApi = RetrofitClient.getClient().create(JobApi.class);
    }

    public Single<List<Vaga>> getVagas() {
        return JobApi.getVagas()
                .onErrorResumeNext(throwable -> getLocalVagas());
    }

    // Método de fallback caso a API falhe
    private Single<List<Vaga>> getLocalVagas() {
        List<Vaga> vagas = Arrays.asList(
                new Vaga(1, "Desenvolvedor Android", "TechCorp", "Buscamos um desenvolvedor Android experiente..."),
                new Vaga(2, "Designer UX/UI", "DesignStudio", "Procuramos um designer criativo para nossa equipe..."),
                new Vaga(3, "Gerente de Projeto", "ProjectMasters", "Oportunidade para liderar projetos de tecnologia..."),
                new Vaga(4, "Engenheiro de Dados", "DataTech", "Procuramos um engenheiro de dados para trabalhar com big data..."),
                new Vaga(5, "Desenvolvedor Full Stack", "WebSolutions", "Oportunidade para desenvolvedor versátil em tecnologias web...")
        );
        return Single.just(vagas);
    }
}