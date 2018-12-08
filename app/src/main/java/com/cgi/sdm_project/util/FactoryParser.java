package com.cgi.sdm_project.util;

import com.cgi.sdm_project.util.parsers.HastaQueParser;
import com.cgi.sdm_project.util.parsers.JuegosParser;
import com.cgi.sdm_project.util.parsers.PreguntaParser;
import com.cgi.sdm_project.util.parsers.RetoParser;
import com.cgi.sdm_project.util.parsers.VotacionParser;

public class FactoryParser {

    private FactoryParser(){}

    public static VotacionParser getVotacionParser(){
        return new VotacionParser();
    }

    public static HastaQueParser getHastaQueParser(){
        return new HastaQueParser();
    }

    public static PreguntaParser getPreguntaParser(){
        return new PreguntaParser();
    }

    public static RetoParser getRetoParser(){
        return new RetoParser();
    }

    public static JuegosParser getJuegosParser(){
        return new JuegosParser();
    }
}
