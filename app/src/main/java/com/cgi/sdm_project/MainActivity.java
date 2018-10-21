package com.cgi.sdm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarJuego (View vs){
        Intent mIntent = new Intent(this, JuegoActivity.class);
        startActivity(mIntent);
    }

    public void lanzarConfiguracion (View vs){
        Intent mIntent = new Intent(this, ConfiguracionActivity.class);
        startActivity(mIntent);
    }

    public void lanzarSortear (View vs){
        Intent mIntent = new Intent(this, SortearActivity.class);
        startActivity(mIntent);
    }
}
