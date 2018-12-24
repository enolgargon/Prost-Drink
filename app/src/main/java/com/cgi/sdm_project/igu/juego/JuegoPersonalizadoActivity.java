package com.cgi.sdm_project.igu.juego;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.cgi.sdm_project.BackgroundSoundService;
import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.juego.selectores.FilteredSelector;
import com.cgi.sdm_project.logica.juego.juego.selectores.ProbabilitySelector;
import com.cgi.sdm_project.util.Conf;


public class JuegoPersonalizadoActivity extends AppCompatActivity {

    private CheckBox preguntas, retos, yoNunca, hastaQues, votaciones, fotos, trabalenguas;
    private FilteredSelector filtro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegopersonalizado);

        Juego.getInstance().setSelectorRegla(filtro = new FilteredSelector(new ProbabilitySelector(), null));
        cargarComponentes();
        cargarPreferencias();
    }

    public void lanzarJuego(View vs) {
        guardarPreferencias();
        if (filtro.isValidConfiguration()) {
            Intent mIntent = new Intent(getApplicationContext(), ElegirJugadoresActivity.class);
            startActivity(mIntent);
        } else
            Toast.makeText(this, R.string.error_personalizado, Toast.LENGTH_LONG).show();
    }

    private void cargarComponentes() {
        preguntas = findViewById(R.id.ckPreguntas);
        preguntas.setOnCheckedChangeListener(new CheckedListener("Pregunta", filtro));
        retos = findViewById(R.id.ckRetos);
        retos.setOnCheckedChangeListener(new CheckedListener("Reto", filtro));
        yoNunca = findViewById(R.id.ckYoNunca);
        hastaQues = findViewById(R.id.ckHastaQues);
        hastaQues.setOnCheckedChangeListener(new CheckedListener("Hastaque", filtro));
        votaciones = findViewById(R.id.ckVotaciones);
        votaciones.setOnCheckedChangeListener(new CheckedListener("Votacion", filtro));
        fotos = findViewById(R.id.ckFotos);
        fotos.setOnCheckedChangeListener(new CheckedListener("Camara", filtro));
        trabalenguas = findViewById(R.id.ckTrabalenguas);
        trabalenguas.setOnCheckedChangeListener(new CheckedListener("Trabalenguas", filtro));
    }

    private void cargarPreferencias() {
        Conf conf = Conf.getInstancia();

        preguntas.setChecked(conf.getPreguntas());
        retos.setChecked(conf.getRetos());
        yoNunca.setChecked(conf.getYoNunca());
        hastaQues.setChecked(conf.getHastaQues());
        votaciones.setChecked(conf.getVotaciones());
        fotos.setChecked(conf.getFotos());
        trabalenguas.setChecked(conf.getTrabalenguas());
    }

    private void guardarPreferencias() {
        Conf conf = Conf.getInstancia();
        conf.setPreguntas(preguntas.isChecked());
        conf.setRetos(retos.isChecked());
        conf.setYoNunca(yoNunca.isChecked());
        conf.setHastaQues(hastaQues.isChecked());
        conf.setVotaciones(votaciones.isChecked());
        conf.setFotos(fotos.isChecked());
        conf.setTrabalenguas(trabalenguas.isChecked());
    }

    /**
     * Clase que controla el cambio de los elementos checked.
     * Cuando se cambien esto elementos se tiene que cambiar el selector del juego
     *
     * @author Enol García González
     * @version 16-12-2018
     */
    private class CheckedListener implements CheckBox.OnCheckedChangeListener {
        /**
         * Nombre de la regla que va a cambiar
         */
        private final String nombreRegla;
        private final FilteredSelector filtro;

        CheckedListener(String nombreRegla, FilteredSelector filtro) {
            this.nombreRegla = nombreRegla;
            this.filtro = filtro;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b)
                filtro.active(nombreRegla);
            else
                filtro.desactive(nombreRegla);
        }
    }
}
