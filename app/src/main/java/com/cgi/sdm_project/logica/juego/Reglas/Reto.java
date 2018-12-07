package com.cgi.sdm_project.logica.juego.Reglas;

import java.util.List;
import java.util.regex.Pattern;

public class Reto {
    private String texto;
    private int tragos;
    private List<String> values;

    public Reto(String texto, int tragos){
        this.texto = texto;
        this.tragos = tragos;
        this.values = null;
    }

    public Reto(String texto, int tragos, List<String> values){
        this(texto, tragos);
        int index = (int)Math.floor(Math.random() * values.size());
        texto.replace("{0}", values.get(index));
    }

    public String getTexto() {
        return texto;
    }

    public int getTragos() {
        return tragos;
    }
}
