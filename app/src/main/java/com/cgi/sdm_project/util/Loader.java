package com.cgi.sdm_project.util;

import com.cgi.sdm_project.logica.juego.Reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.Reglas.Juego;
import com.cgi.sdm_project.logica.juego.Reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.Reglas.Reto;
import com.cgi.sdm_project.logica.juego.Reglas.Votacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loader {
    public static List<Pregunta> loadPreguntas() {

        //TODO Introducir el documento a parsear correspondiente en cada comando en base al contexto
        return FactoryParser.getPreguntaParser().execute(null);

        /*
        List<Pregunta> toRet = new ArrayList<>();
        toRet.add(new Pregunta("¿Te has o estás enamorado de un amigo/a?", 5));
        toRet.add(new Pregunta("¿Te liarías con alguien de la mesa?", 3));
        toRet.add(new Pregunta("¿Cuál ha sido el momento más caliente de tu vida?", 2));
        toRet.add(new Pregunta("¿Alguna vez te han atado o has atado a alguien a la cama?", 4));
        toRet.add(new Pregunta("¿Te has masturbado alguna vez delante de alguien? ¿De quién?", 3));
        return toRet;
        */
    }
    public static List<Reto> loadRetos() {

        //TODO Introducir el documento a parsear correspondiente en cada comando en base al contexto
        return FactoryParser.getRetoParser().execute(null);
        /*
        List<Reto> toRet = new ArrayList<>();
        toRet.add(new Reto("Las tres personas que señales con el dedo beben", 3));
        toRet.add(new Reto("Quien tenga una prenda de color {0} bebe", 2,
                Arrays.asList("rojo", "verde", "azul", "negro", "blanco")));
        toRet.add(new Reto("Decir personajes de los Simpson. Quien repita pierde", 2));
        toRet.add(new Reto("Retuércete los pezones hasta que esten bien duritos", 4));
        toRet.add(new Reto("Los que hayan discutido en lo dos últimos días beben", 2));
        toRet.add(new Reto("Intenta poner caliente a la persona que más te guste de la mesa", 3));
        return toRet;
        */
    }
    public static List<Votacion> loadVotaciones() {

        //TODO Introducir el documento a parsear correspondiente en cada comando en base al contexto
        return FactoryParser.getVotacionParser().execute(null);
        /*
        List<Votacion> toRet = new ArrayList<>();

        toRet.add(new Votacion(Arrays.asList("Ser invisible", "Leer la mente"),2));
        toRet.add(new Votacion(Arrays.asList("Morir congelado", "Morir quemado"),3));
        toRet.add(new Votacion(Arrays.asList("Beber un litro de orina cada día", "Una noche de sexo con tu madre"),3));
        toRet.add(new Votacion(Arrays.asList("Supositorio cada día", "Inyección cada día"),4));
        toRet.add(new Votacion(Arrays.asList("Saber que te han puesto los cuernos", "No enterarte nunca"),2));

        return toRet;
        */
    }
    public static List<Juego> loadJuegos() {
        //TODO Introducir el documento a parsear correspondiente en cada comando en base al contexto
        return FactoryParser.getJuegosParser().execute(null);
    }
    public static List<HastaQue> loadHastaQues() {

        //TODO Introducir el documento a parsear correspondiente en cada comando en base al contexto
        return FactoryParser.getHastaQueParser().execute(null);
        /*
        List<HastaQue> toRet = new ArrayList<>();
        toRet.add(new HastaQue("Hasta que te vuelva a tocar tienes que hablar y moverte como un robot", 5));
        toRet.add(new HastaQue("Hasta que te vuelva a tocar te tienen que tratar de usted", 7));
        toRet.add(new HastaQue("Hasta que te vuelva a tocar tienes que estar sin camiseta", 3));
        toRet.add(new HastaQue("Hasta que te vuelva a tocar tienes que estar sentado/a encima de la persona que más te guste de la mesa", 4));
        return toRet;
        */
    }
}
