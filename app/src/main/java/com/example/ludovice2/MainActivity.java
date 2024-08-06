package com.example.ludovice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ludovice2.adapter.VagaAdapter;
import com.example.ludovice2.viewmodel.VagaViewModel;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private VagaViewModel vagaViewModel;
    private RecyclerView recyclerView;
    private VagaAdapter vagaAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
        setupViewModel();
        observeViewModel();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        vagaAdapter = new VagaAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(vagaAdapter);

        vagaAdapter.setOnItemClickListener(vaga -> {
            Intent intent = new Intent(MainActivity.this, VagaDetalhesActivity.class);
            intent.putExtra("VAGA_ID", vaga.getId());
            startActivity(intent);
        });
    }

    private void setupViewModel() {
        vagaViewModel = new ViewModelProvider(this).get(VagaViewModel.class);
    }

    private void observeViewModel() {
        vagaViewModel.getVagas().observe(this, vagas -> {
            vagaAdapter.submitList(vagas);
            progressBar.setVisibility(View.GONE);
        });

        vagaViewModel.getError().observe(this, errorMessage -> {
            if (errorMessage != null) {
                Snackbar.make(recyclerView, errorMessage, Snackbar.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });

        progressBar.setVisibility(View.VISIBLE);
        vagaViewModel.refreshVagas();
    }
}
