package com.cgi.sdm_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.cgi.sdm_project.logica.sorteo.util.Conf;

/**
 * Se encarga de guardar las preferencias del usuario en el SharedPreferences
 *
 * @author Samuel
 */
public class ConfiguracionActivity extends AppCompatActivity {

    Switch swSonido;
    SeekBar sbVolumen;
    Spinner spIdioma;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        getComponents();
        cargarPreferencias();
        setListeners();

    }

    /**
     * Simplemente se encarga de inicializar las variables que contienen los componentes relevantes
     * del layout
     */
    private void getComponents() {
        swSonido = findViewById(R.id.swSonido);
        sbVolumen = findViewById(R.id.sbVolumen);
        sbVolumen.setMax(100);
        spIdioma = findViewById(R.id.spIdioma);
        btnGuardar = findViewById(R.id.btnGuardar);
    }

    /**
     * Añade listeners a los componentes para que cooperen de forma adecuada
     */
    private void setListeners() {

        //Si el switch se desactiva la barra se debe poner a 0
        swSonido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sbVolumen.setProgress(50);
                }
                if(!isChecked){
                    sbVolumen.setProgress(0);
                }
            }
        });

        //Si la barra se pone a 0 el switch se debe desactivar, para cualquier otro valor, se deberá
        //activar
        sbVolumen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.getProgress() == 0){
                    swSonido.setChecked(false);
                }
                else{
                    swSonido.setChecked(true);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * Carga los valores almacenados en las preferencias
     */
    private void cargarPreferencias() {
        Conf conf = Conf.getInstancia();
        swSonido.setChecked(conf.getSonido());
        sbVolumen.setProgress(conf.getVolumen());
        spIdioma.setSelection(conf.getIdioma());
    }

    /**
     * Guarda los cambios en las preferences
     * @param view
     */
    public void guardar(View view){
        Conf conf = Conf.getInstancia();
        conf.setSonido(swSonido.isChecked());
        conf.setVolumen(sbVolumen.getProgress());
        conf.setIdioma(spIdioma.getSelectedItemPosition());
        Toast.makeText(getApplicationContext(), getString(R.string.CambiosGuardados),
                Toast.LENGTH_SHORT).show();

    }
}
