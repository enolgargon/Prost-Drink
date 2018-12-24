package com.cgi.sdm_project.util.stemmers;

import org.tartarus.snowball.ext.spanishStemmer;

/**
 * Adapter para usar el stemmer español de la librería
 *
 * @author Samuel
 */
public class StemmerES extends Stemmer {

    public StemmerES() {
        this.stemmer = new spanishStemmer();
    }

}
