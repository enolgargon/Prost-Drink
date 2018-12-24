package com.cgi.sdm_project.util.stemmers;

import org.tartarus.snowball.SnowballStemmer;

/**
 * Estrategia para stemmizar
 *
 * @author Samuel
 */
public abstract class Stemmer {
    SnowballStemmer stemmer;

    /**
     * Stemmiza el texto recibido como parámetro y lo devuelve
     *
     * @param texto
     * @return
     */
    public String stem(String texto) {
        stemmer.setCurrent(texto);
        stemmer.stem();
        return stemmer.getCurrent();
    }
}
