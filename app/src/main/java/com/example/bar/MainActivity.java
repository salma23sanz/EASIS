package com.example.bar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.example.bar.R;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

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
        // MediaPlayer mp=MediaPlayer.create(this,R.raw.argentina_sodastereo);
        // mp.start();
        //Toast.makeText(this,"Soda stereo",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Lecciones1.class);
        startActivity(intent);
    }
}