package com.cgi.sdm_project.logica.juego.reglas;

class ReglaTragable implements Tragable {
    protected int tragos;

    ReglaTragable(int tragos) {
        this.tragos = tragos;
    }

    public int getTragos() {
        return tragos;
    }
}
