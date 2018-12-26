package com.cgi.sdm_project.logica.juego.almacenes;

import com.cgi.sdm_project.igu.juego.loop.BrujulaActivity;
import com.cgi.sdm_project.igu.juego.loop.CamaraActivity;
import com.cgi.sdm_project.igu.juego.loop.HastaQueActivity;
import com.cgi.sdm_project.igu.juego.loop.PreguntaActivity;
import com.cgi.sdm_project.igu.juego.loop.RetoActivity;
import com.cgi.sdm_project.igu.juego.loop.TrabalenguasActivity;
import com.cgi.sdm_project.igu.juego.loop.VotacionActivity;
import com.cgi.sdm_project.igu.juego.loop.cazatopos.CazatoposInicioActivity;
import com.cgi.sdm_project.igu.juego.loop.equilibrio.EquilibrioInicioActivity;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.Regla;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Brujula;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Camara;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cazatopos;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Equilibrio;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.HastaQue;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Pregunta;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Reto;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Trabalenguas;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Votacion;

/**
 * @author Enol García González (UO257775)
 * @version 22-11-2018
 */
public class AlmacenadorActivities {
    private static AlmacenadorActivities instance;

    private AlmacenadorActivities() {

    }

    public static AlmacenadorActivities getInstance() {
        if (instance == null)
            instance = new AlmacenadorActivities();
        return instance;
    }

    public Class<? extends InicioJuego> getActivityFor(Regla regla) {
        if (regla instanceof Pregunta)
            return PreguntaActivity.class;
        else if (regla instanceof HastaQue)
            return HastaQueActivity.class;
        else if (regla instanceof Reto)
            return RetoActivity.class;
        else if (regla instanceof Votacion)
            return VotacionActivity.class;
        else if (regla instanceof Juego)
            return null;
        else if (regla instanceof Camara)
            return CamaraActivity.class;
        else if (regla instanceof Trabalenguas)
            return TrabalenguasActivity.class;
        else if (regla instanceof Equilibrio)
            return EquilibrioInicioActivity.class;
        else if (regla instanceof Cazatopos)
            return CazatoposInicioActivity.class;
        else if (regla instanceof Brujula)
            return BrujulaActivity.class;

        throw new UnsupportedOperationException();
    }
}