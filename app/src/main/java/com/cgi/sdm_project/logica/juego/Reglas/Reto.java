package com.cgi.sdm_project.logica.juego.reglas;

import java.util.List;

public class Reto extends ReglaTragable {
    private String texto;
    private boolean atrevido;

    public Reto(String texto, int tragos) {
        super(tragos);
        this.texto = texto;
    }

    public Reto(String texto, int tragos, List<String> values) {
        this(texto, tragos);
        int index = (int) Math.floor(Math.random() * values.size());
        texto.replace("{0}", values.get(index));
    }

    public void atreverse() {
        atrevido = true;
    }

    public void pasar() {
        atrevido = false;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isAtrevido() {
        return atrevido;
    }
}
