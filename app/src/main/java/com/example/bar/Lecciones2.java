package com.example.bar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class Lecciones2 extends AppCompatActivity {
    private ListView lv1;
    private final String[] nombres ={"Tendencias modernas en mix","El uso de frutas y especias en","Cómo crear tu propio cóctel","Diferencias entre cócteles ","Servicio y protocolo en la ",
            "Errores comunes y comó evitarlos"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lecciones2);
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
        lv1=findViewById(R.id.list2);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_item_valores,nombres
        );
        lv1.setAdapter(adapter);

    }
    public void  lecciones1(View view){
        Intent intent = new Intent(this, Lecciones1.class);
        startActivity(intent);
    }
    public void  lecciones2(View view){
        Intent intent = new Intent(this, Lecciones2.class);
        startActivity(intent);
    }
}