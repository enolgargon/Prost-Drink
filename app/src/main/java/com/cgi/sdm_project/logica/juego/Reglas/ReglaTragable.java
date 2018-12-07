package com.cgi.sdm_project.logica.juego.Reglas;

class Regla implements IRegla {
    protected int tragos;

    Regla(int tragos) {
        this.tragos = tragos;
    }

    public int getTragos() {
        return tragos;
    }
}
