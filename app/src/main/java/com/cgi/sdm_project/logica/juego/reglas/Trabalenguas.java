package com.cgi.sdm_project.logica.juego.reglas;

public class Trabalenguas extends ReglaTragable{

    private final String texto;
    private boolean respuesta;

    public Trabalenguas(String texto, int tragos){
        super(tragos);
        this.texto = texto;
    }

    public boolean isRespuesta(){ return respuesta; }

    public void atreverse() {
        respuesta = true;
    }

    public void pasar() {
        respuesta = false;
    }

    public String getTexto(){ return texto; }

    @Override
    protected String nombreRespuesta() {
        //TODO Cambiar los strings para que se ajusten a un trabalenguas
        if (isRespuesta())
            return "pregunta_contestada" + ((int) (Math.random() * 3) + 1);
        return "pregunta_nocontestada" + ((int) (Math.random() * 3) + 1);
    }
}
