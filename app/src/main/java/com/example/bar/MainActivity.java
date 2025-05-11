package com.example.bar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;
import com.example.bar.R;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ListView lv1;
    private final String[] nombres ={"Introducción a la coctelería","Tipos de licores y destilados","Herramientas esenciales","Técnicas de preparación","Cómo medir y dosificar ingredientes",
            "El arte de shake y el stir","Decoración y presentación",
            "Comó ombinar sabores","Cócteles clásicos y su historia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3FB356"));  // Aquí puedes definir el color que deseas
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

    }
    public void  lecciones(View view){
        Intent intent = new Intent(this, Lecciones1.class);
        startActivity(intent);
    }
}