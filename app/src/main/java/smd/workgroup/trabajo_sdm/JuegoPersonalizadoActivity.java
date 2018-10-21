package smd.workgroup.trabajo_sdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JuegoPersonalizadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_juegopersonalizado);
    }

    public void lanzarJuego (View vs){

        Intent mIntent = new Intent(getApplicationContext(), ElegirJugadoresActivity.class);
        startActivity(mIntent);

    }
}
