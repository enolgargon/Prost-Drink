package com.cgi.sdm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.cgi.sdm_project.logica.sorteo.util.Conf;


public class JuegoPersonalizadoActivity extends AppCompatActivity{

    private CheckBox preguntas, retos, yoNunca, juegos, votaciones, bebe, mandaBeber, castigo, reto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegopersonalizado);

        cargarComponentes();
        cargarPreferencias();
    }

    public void lanzarJuego (View vs){

        guardarPreferencias();
        Intent mIntent = new Intent(getApplicationContext(), ElegirJugadoresActivity.class);
        startActivity(mIntent);

    }

    private void cargarComponentes(){

        preguntas = findViewById(R.id.ckPreguntas);
        retos = findViewById(R.id.ckRetos);
        yoNunca = findViewById(R.id.ckYoNunca);
        juegos = findViewById(R.id.ckJuegos);
        votaciones = findViewById(R.id.ckVotaciones);
        bebe = findViewById(R.id.ckBebe);
        mandaBeber = findViewById(R.id.ckMandaBeber);
        castigo = findViewById(R.id.ckCastigo);
        reto = findViewById(R.id.ckReto);
    }

    private void cargarPreferencias() {

        Conf conf = Conf.getInstancia();
        preguntas.setChecked(conf.getPreguntas());
        retos.setChecked(conf.getRetos());
        yoNunca.setChecked(conf.getYoNunca());
        juegos.setChecked(conf.getJuegos());
        votaciones.setChecked(conf.getVotaciones());
        bebe.setChecked(conf.getBebe());
        mandaBeber.setChecked(conf.getMandaBeber());
        castigo.setChecked(conf.getCastigo());
        reto.setChecked(conf.getReto());
    }

    private void guardarPreferencias(){

        Conf conf = Conf.getInstancia();
        conf.setPreguntas(preguntas.isChecked());
        conf.setRetos(retos.isChecked());
        conf.setYoNunca(yoNunca.isChecked());
        conf.setJuegos(juegos.isChecked());
        conf.setVotaciones(votaciones.isChecked());
        conf.setBebe(bebe.isChecked());
        conf.setMandaBeber(mandaBeber.isChecked());
        conf.setCastigo(castigo.isChecked());
        conf.setReto(reto.isChecked());

    }
}
