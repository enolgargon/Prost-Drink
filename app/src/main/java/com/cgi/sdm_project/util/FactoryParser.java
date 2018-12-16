package com.cgi.sdm_project.util;

import com.cgi.sdm_project.util.parsers.HastaQueParser;
import com.cgi.sdm_project.util.parsers.PreguntaParser;
import com.cgi.sdm_project.util.parsers.RetoParser;
import com.cgi.sdm_project.util.parsers.VotacionParser;

class FactoryParser {

    private FactoryParser() {
    }

    static VotacionParser getVotacionParser() {
        return new VotacionParser();
    }

    static HastaQueParser getHastaQueParser() {
        return new HastaQueParser();
    }

    static PreguntaParser getPreguntaParser() {
        return new PreguntaParser();
    }

    static RetoParser getRetoParser() {
        return new RetoParser();
    }
}
