package com.cgi.sdm_project.util.stemmers;

import org.tartarus.snowball.ext.englishStemmer;

/**
 * Adapter para la versión inglesa del stemmer
 *
 * @author Samuel
 */
public class StemmerEN extends Stemmer {

    public StemmerEN() {
        this.stemmer = new englishStemmer();
    }
}
