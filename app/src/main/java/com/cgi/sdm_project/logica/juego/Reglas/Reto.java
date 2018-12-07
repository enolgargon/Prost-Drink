package com.cgi.sdm_project.logica.juego.Reglas;

import java.util.List;

public class Reto extends ReglaTragable {
    private String texto;

    public Reto(String texto, int tragos){
        super(tragos);
        this.texto = texto;
    }

    public Reto(String texto, int tragos, List<String> values) {
        this(texto, tragos);
        int index = (int) Math.floor(Math.random() * values.size());
        texto.replace("{0}", values.get(index));
    }

    public String getTexto() {
        return texto;
    }
}
