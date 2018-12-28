package com.cgi.sdm_project.util;

/**
 * Almacen para enumerados que no pinten nada en otros sitios
 */
public class Enumerates {

    /**
     * Enumerado para representar idiomas
     */
    public enum Idioma {
        SPANISH(0), ENGLISH(1);

        public final int value;

        Idioma(int i) {
            this.value = i;
        }
        /**
         * Returns the enumerate associated with a lang code, by default English
         *
         * @param code
         * @return
         */
        public static Idioma getIdiomaFromCode(String code) {
            switch (code) {
                case "es":
                    return Idioma.SPANISH;
                case "en":
                    return Idioma.ENGLISH;
                default:
                    return Idioma.ENGLISH;
            }
        }
    }


}
