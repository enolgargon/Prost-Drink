package smd.workgroup.trabajo_sdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sdm.workgroup.trabajo_sdm.MainActivity;

public class JuegoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciojuego);
    }

    public void lanzarJuegoNormal(View vs){
        Intent mIntent = new Intent(getApplicationContext(), ElegirJugadoresActivity.class);
        startActivity(mIntent);
    }

    public void lanzarJuegoPersonalizado(View vs){
        Intent mIntent = new Intent(getApplicationContext(), JuegoPersonalizadoActivity.class);
        startActivity(mIntent);
    }
}
