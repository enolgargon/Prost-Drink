package com.cgi.sdm_project.util;

import java.util.Random;

/**
 * Métodos estáticos de utilidad para su uso
 *
 * @author Samuel
 */
public class SamUtil {

    /**
     * Reordena aleatoriamente un array
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T> T[] shuffleArray(T[] array) {
        //Oremos a RNGesus
        Random rngesus = new Random();

        for (int i = 0; i < array.length; i++) {
            int newPos = rngesus.nextInt(array.length);
            T temp = array[i];
            array[i] = array[newPos];
            array[newPos] = temp;
        }

        return array;
    }

}
