package com.cgi.sdm_project.logica.juego.reglas;

import java.util.List;

public class Reto extends ReglaTragable {
    private String texto;
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

    public String getTexto() {
        return valores == null ? texto : String.format(texto, valores.get((int) (Math.random() * valores.size())));
    }

    public boolean isAtrevido() {
        return atrevido;
    }
}
