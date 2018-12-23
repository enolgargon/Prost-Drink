package com.cgi.sdm_project.logica.juego.reglas;

public class Trabalenguas extends ReglaTragable {

    private final String texto;
    private boolean respuesta;
    private int intentos; //Número de intentos que tendrán para acertar el trabalenguas

    public Trabalenguas(String texto, int tragos) {
        super(tragos);
        this.texto = texto;
        this.intentos = 3;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void atreverse() {
        respuesta = true;
    }

    public void pasar() {
        respuesta = false;
    }

    public String getTexto() {
        return texto;
    }

    public int getIntentos() {
        return intentos;
    }

    public void resetIntentos() {
        this.intentos = 3;
    }

    public boolean reducirIntentos() {
        intentos--;
        if (intentos <= 0)
            return true;
        return false;
    }

    @Override
    protected String nombreRespuesta() {
        //TODO Cambiar los strings para que se ajusten a un trabalenguas
        if (isRespuesta())
            return "pregunta_contestada" + ((int) (Math.random() * 3) + 1);
        return "pregunta_nocontestada" + ((int) (Math.random() * 3) + 1);
    }
}
