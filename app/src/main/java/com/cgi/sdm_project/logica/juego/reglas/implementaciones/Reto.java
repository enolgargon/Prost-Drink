package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import com.cgi.sdm_project.logica.juego.reglas.ReglaTragable;

import java.util.List;

public class Reto extends ReglaTragable {
    private final String texto;
    private boolean atrevido;
    private List<String> valores;

    public Reto(String texto, int tragos) {
        super(tragos);
        this.texto = texto;
    }

    public Reto(String texto, int tragos, List<String> values) {
        this(texto, tragos);
        this.valores = values;
    }

    public void atreverse() {
        atrevido = true;
    }

    public void pasar() {
        atrevido = false;
    }

    protected String nombreRespuesta() {
        if (isAtrevido())
            return "resultado_atrevido" + ((int) (Math.random() * 3) + 1);
        return "resultado_cobarde" + ((int) (Math.random() * 3) + 1);
    }

    public String getTexto() {
        return valores == null ? texto : String.format(texto, valores.get((int) (Math.random() * valores.size())));
    }

    public boolean isAtrevido() {
        return atrevido;
    }
}
