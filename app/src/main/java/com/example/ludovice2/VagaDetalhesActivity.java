package com.example.ludovice2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class VagaDetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaga_detalhes);

        String vagaId = getIntent().getStringExtra("VAGA_ID");

        // Use the vagaId to fetch more details from your API or database
        TextView vagaIdTextView = findViewById(R.id.vagaIdTextView);
        vagaIdTextView.setText(vagaId);

        // Exemplo de uso de mais informações da vaga
        // Você pode buscar essas informações do seu ViewModel ou API
    }
}
