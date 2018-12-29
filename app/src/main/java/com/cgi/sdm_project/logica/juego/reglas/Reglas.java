package com.cgi.sdm_project.logica.juego.reglas;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.BrujulaActivity;
import com.cgi.sdm_project.igu.juego.loop.CamaraActivity;
import com.cgi.sdm_project.igu.juego.loop.CartasActivity;
import com.cgi.sdm_project.igu.juego.loop.HastaQueActivity;
import com.cgi.sdm_project.igu.juego.loop.PreguntaActivity;
import com.cgi.sdm_project.igu.juego.loop.RetoActivity;
import com.cgi.sdm_project.igu.juego.loop.TrabalenguasActivity;
import com.cgi.sdm_project.igu.juego.loop.VotacionActivity;
import com.cgi.sdm_project.igu.juego.loop.YoNuncaActivity;
import com.cgi.sdm_project.igu.juego.loop.cazatopos.CazatoposInicioActivity;
import com.cgi.sdm_project.igu.juego.loop.equilibrio.EquilibrioInicioActivity;
import com.cgi.sdm_project.igu.juego.loop.memoria.MemoriaInicioActivity;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.util.loaders.BrujulaLoader;
import com.cgi.sdm_project.util.loaders.CamaraLoader;
import com.cgi.sdm_project.util.loaders.CartasLoader;
import com.cgi.sdm_project.util.loaders.CazatoposLoader;
import com.cgi.sdm_project.util.loaders.EquilibrioLoader;
import com.cgi.sdm_project.util.loaders.HastaQuesLoader;
import com.cgi.sdm_project.util.loaders.Loader;
import com.cgi.sdm_project.util.loaders.MemoriaLoader;
import com.cgi.sdm_project.util.loaders.PreguntasLoader;
import com.cgi.sdm_project.util.loaders.RetosLoader;
import com.cgi.sdm_project.util.loaders.TrabalenguasLoader;
import com.cgi.sdm_project.util.loaders.VotacionesLoader;
import com.cgi.sdm_project.util.loaders.YoNuncaLoader;
import com.cgi.sdm_project.util.singletons.AppSingleton;

/**
 * Enumeración de las reglas que se van a usar en este juego. Este es el único fichero que se debería modificar.
 * Cada regla tiene un nombre, una probabilidad de aparición y dos clases asociadas. Un cargador de los datos y una activity para mostrarlos.
 *
 * @author Enol García González
 * @version 26-12-2018
 */
public enum Reglas {
    /*
        ##### Nota del HERR KOORDINATOR #####

        Relación de porcentajes:

        TEXTO (80%)             JUEGO (20%)
            - Pregunta 25%           - Brujula 1.5%
            - Reto 25%               - Camara 1.5%
            - Votación 10%           - Cartas 3.5%
            - Yo nunca 15%           - Cazatopos 3.5%
            - Hasta que 5%           - Equilibrio 4%
                                     - Trabalenguas 3%
                                     - Memoria 3%
     */

    BRUJULA(R.string.Brujula, 1.5f, BrujulaLoader.class, BrujulaActivity.class),
    CAMARA(R.string.Fotos, 1.5f, CamaraLoader.class, CamaraActivity.class),
    CARTAS(R.string.Cartas, 3.5f, CartasLoader.class, CartasActivity.class),
    CAZATOPOS(R.string.Cazatopos, 3.5f, CazatoposLoader.class, CazatoposInicioActivity.class),
    EQUILIBRIO(R.string.Equilibrio, 4, EquilibrioLoader.class, EquilibrioInicioActivity.class),
    HASTAQUE(R.string.HastaQue, 5, HastaQuesLoader.class, HastaQueActivity.class),
    PREGUNTA(R.string.Preguntas, 20, PreguntasLoader.class, PreguntaActivity.class),
    RETO(R.string.Retos, 20, RetosLoader.class, RetoActivity.class),
    TRABALENGUAS(R.string.Trabalenguas, 3, TrabalenguasLoader.class, TrabalenguasActivity.class),
    VOTACION(R.string.Votaciones, 10, VotacionesLoader.class, VotacionActivity.class),
    MEMORIA(R.string.Memoria, 3, MemoriaLoader.class, MemoriaInicioActivity.class),
    YONUNCA(R.string.YoNunca, 25, YoNuncaLoader.class, YoNuncaActivity.class);

    private int nombre;
    private float probabilidad;

    private Class<? extends Loader> loader;
    private Class<? extends InicioJuego> activity;

    Reglas(int nombre, float probabilidad, Class<? extends Loader> loader, Class<? extends InicioJuego> activity) {
        this.nombre = nombre;
        this.probabilidad = probabilidad;

        this.loader = loader;
        this.activity = activity;
    }

    public String nombre() {
        return AppSingleton.getInstance().getContext().getString(nombre);
    }

    public float probabilidad() {
        return probabilidad;
    }

    public Class<? extends Loader> loader() {
        return loader;
    }

    public Class<? extends InicioJuego> activity() {
        return activity;
    }
}
