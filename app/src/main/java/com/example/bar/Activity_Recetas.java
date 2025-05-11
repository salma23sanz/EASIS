package com.example.bar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity_Recetas extends AppCompatActivity {

    private List<String> recetasBase = Arrays.asList(
            "🍹 Margarita", "🌿 Mojito", "🍸 Gintonic", "🍋 Caipirinha",
            "🍍 Piña Colada", "🍓 Daiquiri", "🍒 Cosmopolitan",
            "🍸 Martini", "🏛 Manhattan"
    );
    private List<String> recetasMostradas = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecetasAdapter adapter;
    private EditText searchBar;
    private Button verMasButton;
    private int limiteRecetas = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        // Cambiar color de la barra de estado
        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3FB356"));

        // Toolbar
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_settings) {
                Toast.makeText(Activity_Recetas.this, "Configuración", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        // RecyclerView y búsqueda
        recyclerView = findViewById(R.id.recetasRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recetasMostradas.addAll(recetasBase.subList(0, Math.min(limiteRecetas, recetasBase.size())));
        adapter = new RecetasAdapter(recetasMostradas);
        recyclerView.setAdapter(adapter);

        // Barra de búsqueda
        searchBar = findViewById(R.id.searchBar);
        searchBar.addTextChangedListener(new android.text.TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrarRecetas(s.toString());
            }
            @Override public void afterTextChanged(android.text.Editable s) {}
        });

        // Botón Ver más
        verMasButton = findViewById(R.id.verMasButton);
        verMasButton.setOnClickListener(v -> {
            if (limiteRecetas < recetasBase.size()) {
                limiteRecetas += 3;
                recetasMostradas.clear();
                recetasMostradas.addAll(recetasBase.subList(0, Math.min(limiteRecetas, recetasBase.size())));
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "No hay más recetas", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filtrarRecetas(String texto) {
        List<String> filtradas = new ArrayList<>();
        for (String receta : recetasBase) {
            if (receta.toLowerCase().contains(texto.toLowerCase())) {
                filtradas.add(receta);
            }
        }
        recetasMostradas.clear();
        recetasMostradas.addAll(filtradas);
        adapter.notifyDataSetChanged();
    }
}
