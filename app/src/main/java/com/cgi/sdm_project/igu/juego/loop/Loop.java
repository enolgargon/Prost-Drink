package com.cgi.sdm_project.igu.juego.loop;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.util.AppCompatActivityExtended;

public abstract class Loop extends AppCompatActivityExtended {
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme_Dialog));
        alertDialogBuilder.setTitle(getString(R.string.titulo_back));

        alertDialogBuilder
                .setMessage(getString(R.string.texto_back))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        salirJuego();
                    }
                })
                .setNegativeButton(getString(R.string.Cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }

    private void salirJuego() {
        super.onBackPressed();
    }
}
