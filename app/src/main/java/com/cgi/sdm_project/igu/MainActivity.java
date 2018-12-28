package com.cgi.sdm_project.igu;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.InicioJuegoActivity;
import com.cgi.sdm_project.igu.sorteo.SortearActivity;
import com.cgi.sdm_project.util.AppCompatActivityExtended;

public class MainActivity extends AppCompatActivityExtended {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Splash);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("wtf", "llegué");
        setContentView(R.layout.activity_main);
    }

    public void mostrarAcercaDe(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme_Dialog));

        builder.setView(getLayoutInflater().inflate(R.layout.dialog_acercade, null));
        builder.setCancelable(false).setTitle(R.string.AcercaDe);
        builder.setPositiveButton(R.string.cerrar_acercade, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    public void mostrarAyuda(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme_Dialog));

        builder.setView(getLayoutInflater().inflate(R.layout.dialog_instrucciones, null));
        builder.setCancelable(false).setTitle(R.string.instrucciones_title);
        builder.setPositiveButton(R.string.entendido, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    public void lanzarJuego(View vs) {
        Intent mIntent = new Intent(this, InicioJuegoActivity.class);
        startActivity(mIntent);
    }

    public void lanzarConfiguracion(View vs) {
        Intent mIntent = new Intent(this, ConfiguracionActivity.class);
        startActivity(mIntent);
    }

    public void lanzarSortear(View vs) {
        Intent mIntent = new Intent(this, SortearActivity.class);
        startActivity(mIntent);
    }


}
