package com.cgi.sdm_project.util.factories;

import com.cgi.sdm_project.util.Conf;
import com.cgi.sdm_project.util.Enumerates;
import com.cgi.sdm_project.util.stemmers.Stemmer;
import com.cgi.sdm_project.util.stemmers.StemmerEN;
import com.cgi.sdm_project.util.stemmers.StemmerES;

public class FactoryStemmer {
    /**
     * Devuelve un stemmer en función del idioma de la app
     *
     * @return
     */
    public static Stemmer getStemmer() {
        switch (Enumerates.Idioma.values()[Conf.getInstancia().getIdioma()]) {
            case SPANISH:
                return FactoryStemmer.forES();
            case ENGLISH:
                return FactoryStemmer.forEN();
        }
        return null;
    }

    private static Stemmer forES() {
        return new StemmerES();
    }

    private static Stemmer forEN() {
        return new StemmerEN();
    }
}
