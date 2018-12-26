package com.cgi.sdm_project.igu.juego;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.CheckBox;

import com.cgi.sdm_project.logica.juego.reglas.Reglas;
import com.cgi.sdm_project.util.Conf;

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class ReglaChecker extends CheckBox {
    private Reglas regla;

    public ReglaChecker(Context context, Reglas regla) {
        super(context);
        this.regla = regla;

        setText(regla.nombre());
        setChecked(Conf.getInstancia().getTipo(regla));
    }

    @Override
    public void toggle() {
        super.toggle();
        Conf.getInstancia().setTipo(regla, isChecked());
    }
}
