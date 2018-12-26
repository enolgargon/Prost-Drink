package com.cgi.sdm_project.igu.juego;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;

public class InstruccionesActivity extends AppCompatActivity {
    private final Handler handler = new Handler();
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme_Dialog));
        builder.setView(getLayoutInflater().inflate(R.layout.dialog_instrucciones, null));
        builder.setCancelable(false).setTitle(R.string.instrucciones_title);
        builder.setPositiveButton(R.string.entendido, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                seguir(null);
            }
        }, 10000);
    }

    public void mostrarAyuda(View view) {
        dialog.show();
    }

    public void seguir(View view) {
        if (dialog.isShowing())
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    seguir(null);
                }
            }, 10000);
        else
            empezarJuego();
    }

    private void empezarJuego() {
        Intent mIntent = new Intent(getApplicationContext(), Juego.getInstance().getSiguienteJuego());
        startActivity(mIntent);
        finish();
    }
}
