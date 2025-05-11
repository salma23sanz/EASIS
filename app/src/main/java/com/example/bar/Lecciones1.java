package com.example.bar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.bar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lecciones1 extends AppCompatActivity {
    private ListView lv1;
    private final String[] nombres ={"Introducción a la coctelería","Tipos de licores y destilados","Herramientas esenciales","Técnicas de preparación","Cómo medir y dosificar ingredientes",
            "El arte de shake y el stir","Decoración y presentación",
            "Comó ombinar sabores","Cócteles clásicos y su historia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lecciones1);
        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3FB356"));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (itemId == R.id.nav_lessons) {
                startActivity(new Intent(this, Lecciones1.class));
                return true;
            } //else if (itemId == R.id.nav_recipes) {
            //  startActivity(new Intent(this, lecciones.class));
            // return true;
            //} else if (itemId == R.id.nav_bar) {
            //  startActivity(new Intent(this, lecciones.class));
            // return true;
            //  }

            return false;
        });
        lv1=findViewById(R.id.list);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_item_valores,nombres
        );
        lv1.setAdapter(adapter);

    }
}