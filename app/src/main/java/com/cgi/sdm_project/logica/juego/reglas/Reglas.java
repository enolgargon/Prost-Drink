package com.cgi.sdm_project.logica.juego.reglas;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.BrujulaActivity;
import com.cgi.sdm_project.igu.juego.loop.CamaraActivity;
import com.cgi.sdm_project.igu.juego.loop.HastaQueActivity;
import com.cgi.sdm_project.igu.juego.loop.PreguntaActivity;
import com.cgi.sdm_project.igu.juego.loop.RetoActivity;
import com.cgi.sdm_project.igu.juego.loop.TrabalenguasActivity;
import com.cgi.sdm_project.igu.juego.loop.VotacionActivity;
import com.cgi.sdm_project.igu.juego.loop.cazatopos.CazatoposInicioActivity;
import com.cgi.sdm_project.igu.juego.loop.equilibrio.EquilibrioInicioActivity;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
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
import com.cgi.sdm_project.util.singletons.AppSingleton;

/**
 * Enumeración de las reglas que se van a usar en este juego. Este es el único fichero que se debería modificar.
 * Cada regla tiene un nombre, una probabilidad de aparición y dos clases asociadas. Un cargador de los datos y una activity para mostrarlos.
 *
 * @author Enol García González
 * @version 26-12-2018
 */
public enum Reglas {
    BRUJULA(R.string.Brujula, 3, BrujulaLoader.class, BrujulaActivity.class),
    CAMARA(R.string.Fotos, 5, CamaraLoader.class, CamaraActivity.class),
    CAZATOPOS(R.string.Cazatopos, 15, CazatoposLoader.class, CazatoposInicioActivity.class),
    EQUILIBRIO(R.string.Equilibrio, 12, EquilibrioLoader.class, EquilibrioInicioActivity.class),
    HASTAQUE(R.string.HastaQue, 5, HastaQuesLoader.class, HastaQueActivity.class),
    PREGUNTA(R.string.Preguntas, 15, PreguntasLoader.class, PreguntaActivity.class),
    RETO(R.string.Retos, 20, RetosLoader.class, RetoActivity.class),
    TRABALENGUAS(R.string.Trabalenguas, 5, TrabalenguasLoader.class, TrabalenguasActivity.class),
    VOTACION(R.string.Votaciones, 20, VotacionesLoader.class, VotacionActivity.class);

    private int nombre;
    private int probabilidad;

    private Class<? extends Loader> loader;
    private Class<? extends InicioJuego> activity;

    Reglas(int nombre, int probabilidad, Class<? extends Loader> loader, Class<? extends InicioJuego> activity) {
        this.nombre = nombre;
        this.probabilidad = probabilidad;

        this.loader = loader;
        this.activity = activity;
    }

    public String nombre() {
        return AppSingleton.getInstance().getContext().getString(nombre);
    }

    public int probabilidad() {
        return probabilidad;
    }

    public Class<? extends Loader> loader() {
        return loader;
    }

    public Class<? extends InicioJuego> activity() {
        return activity;
    }
}
