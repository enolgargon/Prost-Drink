package com.cgi.sdm_project.logica.juego.reglas;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Brujula;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Camara;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cazatopos;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Equilibrio;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.HastaQue;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Pregunta;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Reto;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Trabalenguas;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Votacion;
import com.cgi.sdm_project.util.loaders.BrujulaLoader;
import com.cgi.sdm_project.util.loaders.CamaraLoader;
import com.cgi.sdm_project.util.loaders.CazatoposLoader;
import com.cgi.sdm_project.util.loaders.EquilibrioLoader;
import com.cgi.sdm_project.util.loaders.HastaQuesLoader;
import com.cgi.sdm_project.util.loaders.Loader;
import com.cgi.sdm_project.util.loaders.PreguntasLoader;
import com.cgi.sdm_project.util.loaders.RetosLoader;
import com.cgi.sdm_project.util.loaders.TrabalenguasLoader;
import com.cgi.sdm_project.util.loaders.VotacionesLoader;

public enum Reglas {
    BRUJULA("No pierdas el norte", 3, Brujula.class, BrujulaLoader.class),
    CAMARA("Fotos", 5, Camara.class, CamaraLoader.class),
    CAZATOPOS("Cazatopos", 15, Cazatopos.class, CazatoposLoader.class),
    EQUILIBRIO("Equilibrio", 12, Equilibrio.class, EquilibrioLoader.class),
    HASTAQUE("Hasta que", 5, HastaQue.class, HastaQuesLoader.class),
    PREGUNTA("Pregunta", 15, Pregunta.class, PreguntasLoader.class),
    RETO("Reto", 20, Reto.class, RetosLoader.class),
    TRABALENGUAS("Trabalenguas", 5, Trabalenguas.class, TrabalenguasLoader.class),
    VOTACION("Votación", 20, Votacion.class, VotacionesLoader.class);


    public Class<? extends Regla> clase;
    private String nombre;
    private int probabilidad;
    private Class<? extends Loader> loader;

    Reglas(String nombre, int probabilidad, Class<? extends Regla> clase, Class<? extends Loader> loader) {
        this.nombre = nombre;
        this.probabilidad = probabilidad;
        this.clase = clase;
        this.loader = loader;
    }

    public String nombre() {
        return nombre;
    }

    public int probabilidad() {
        return probabilidad;
    }

    public Class<? extends Regla> clase() {
        return clase;
    }

    public Class<? extends Loader> loader() {
        return loader;
    }
}
