package com.cgi.sdm_project.logica.juego;

import java.util.HashMap;

/**
 * Esta clase almacena todas las posibles activities que se pueden lanzar. Se permite acceder a ellas a través de una regla de juego. Cuando se obtiene una regla de juego se asocia con la activity que se debe lanzar para cumplirla.
 *
 * @author Enol García González (UO257775)
 * @version 22-11-2018
 */
public class AlmacenadorActivities {
    /**
     * Instancia para implementar el patrón singleton
     */
    private static AlmacenadorActivities instance = null;
    /**
     * Mapa clave valor que almacena para cada regla, la activity que se debe lanzar
     */
    private HashMap<ReglasJuego, InicioJuego> mapeador;

    private AlmacenadorActivities() {
        mapeador = new HashMap<>();
    }

    /**
     * Método que crea, si es necesario, y devuelve la instancia del elemento almacenador
     *
     * @return Única instancia que puede existir del almacenador
     */
    public static AlmacenadorActivities getInstance() {
        if (instance == null)
            instance = new AlmacenadorActivities();
        return instance;
    }

    /**
     * Método que añade una nueva regla para obtener las activities
     *
     * @param regla    Regla que se quiere asociar con una activity
     * @param activity Activity que se obtendrá cuando se quiera jugar con las reglas
     */
    public void addActivity(ReglasJuego regla, InicioJuego activity) {
        mapeador.put(regla, activity);
    }

    /**
     * Método que permite obtener una activity para unas reglas indicadas.
     *
     * @param reglas Reglas para las que se quiere saber que activity se debe lanzar
     * @return Activity que hay que lanzar pra jugar con las reglas indicadas
     */
    public InicioJuego getActivity(ReglasJuego reglas) {
        if (mapeador.containsKey(reglas))
            throw new IllegalStateException("No hay activity para las reglas de juego obtenidas");
        return mapeador.get(reglas);
    }

    /**
     * Método que obtiene la activity con la que se debe jugar a continuación
     *
     * @return Nueva activity para jugar
     */
    public InicioJuego getSiguienteActivity() {
        return getActivity(Juego.getInstance().getSiguienteJuego());
    }
}
