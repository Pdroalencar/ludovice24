package com.example.ludovice2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ludovice2.model.Vaga;
import com.example.ludovice2.repository.VagaRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class VagaViewModel extends ViewModel {

    private final VagaRepository repository;
    private final MutableLiveData<List<Vaga>> vagas = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();

    public VagaViewModel() {
        repository = new VagaRepository();
    }

    public LiveData<List<Vaga>> getVagas() {
        return vagas;
    }

    public LiveData<String> getError() {
        return error;
    }

    public void refreshVagas() {
        disposables.add(repository.getVagas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        vagasList -> vagas.setValue(vagasList),
                        throwable -> error.setValue("Erro ao carregar vagas: " + throwable.getMessage())
                ));
    }

    @Override
    protected void onCleared() {
        disposables.clear();
        super.onCleared();
    }
}