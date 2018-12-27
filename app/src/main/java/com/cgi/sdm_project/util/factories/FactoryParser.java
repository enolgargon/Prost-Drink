package com.cgi.sdm_project.util.factories;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Camara;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.HastaQue;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Pregunta;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Reto;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Trabalenguas;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Votacion;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.YoNunca;
import com.cgi.sdm_project.util.parsers.CamaraParser;
import com.cgi.sdm_project.util.parsers.HastaQueParser;
import com.cgi.sdm_project.util.parsers.Parser;
import com.cgi.sdm_project.util.parsers.PreguntaParser;
import com.cgi.sdm_project.util.parsers.RetoParser;
import com.cgi.sdm_project.util.parsers.TrabalenguasParser;
import com.cgi.sdm_project.util.parsers.VotacionParser;
import com.cgi.sdm_project.util.parsers.YoNuncaParser;

public class FactoryParser {

    private FactoryParser() {
    }

    public static Parser<Votacion> getVotacionParser() {
        return new VotacionParser();
    }

    public static Parser<HastaQue> getHastaQueParser() {
        return new HastaQueParser();
    }

    public static Parser<Pregunta> getPreguntaParser() {
        return new PreguntaParser();
    }

    public static Parser<Reto> getRetoParser() {
        return new RetoParser();
    }

    public static Parser<Trabalenguas> getTrabalenguasParser() {
        return new TrabalenguasParser();
    }

    public static Parser<Camara> getCamaraParser() {
        return new CamaraParser();
    }

    public static Parser<YoNunca> getYoNuncaParser() {
        return new YoNuncaParser();
    }
}
