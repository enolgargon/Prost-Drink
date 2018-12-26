package com.cgi.sdm_project.util.factories;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.HastaQue;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Pregunta;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Reto;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Trabalenguas;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Votacion;
import com.cgi.sdm_project.util.parsers.HastaQueParser;
import com.cgi.sdm_project.util.parsers.Parser;
import com.cgi.sdm_project.util.parsers.PreguntaParser;
import com.cgi.sdm_project.util.parsers.RetoParser;
import com.cgi.sdm_project.util.parsers.TrabalenguasParser;
import com.cgi.sdm_project.util.parsers.VotacionParser;

import java.util.List;

public class FactoryParser {

    private FactoryParser() {
    }

    public static Parser<List<Votacion>> getVotacionParser() {
        return new VotacionParser();
    }

    public static Parser<List<HastaQue>> getHastaQueParser() {
        return new HastaQueParser();
    }

    public static Parser<List<Pregunta>> getPreguntaParser() {
        return new PreguntaParser();
    }

    public static Parser<List<Reto>> getRetoParser() {
        return new RetoParser();
    }

    public static Parser<List<Trabalenguas>> getTrabalenguasParser() {
        return new TrabalenguasParser();
    }
}
