package com.cgi.sdm_project.igu.juego.loop.brujula;

import android.os.Bundle;
import android.widget.ImageView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.Loop;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.reglas.Brujula;

import java.util.Observable;
import java.util.Observer;


public class BrujulaActivity extends Loop implements Observer {
    private ImageView imgAguja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brujula);

        imgAguja = findViewById(R.id.imgAguja);
        ((Brujula) Juego.getInstance().getJuegoActual()).addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Float)
            imgAguja.setRotation((float) arg);
        else if (o instanceof Brujula)
            imgAguja.setRotation(((Brujula) o).getAngle());
        else
            throw new RuntimeException();
    }
}
