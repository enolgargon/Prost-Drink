package com.cgi.sdm_project.igu.sorteo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.sorteo.Sorteo;
import com.cgi.sdm_project.util.AppCompatActivityExtended;
import com.cgi.sdm_project.util.Conf;

/**
 * Clase que se encarga de preparar un sorteo. Para eso interacciona con la parte gráfica y gestiona los datos que introduce el usuario.
 * Hace de clase mediadora entre el usuario y la clase Sorteo que hará toda la mágia.
 *
 * @author Enol García González
 * @version 28-10-2018
 * @see Sorteo
 */
public class SortearActivity extends AppCompatActivityExtended {
    /**
     * Clave que se usa para pasar el sorteo por el intent
     */
    public static final String SORTEO = "sorteo";

    /*
     * Elementos de lógica
     */
    /**
     * Clase con toda la información en la lógica
     */
    private Sorteo sorteo;

    /*
     * Elementos de gráfica
     */
    /**
     * Lista en la que se mostrarán los nombres de los jugadores en el sorteo
     */
    private ListView lista;
    /**
     * TextView en el que el usuario introducirá el nombre
     */
    private TextView nombre;
    /**
     * TextView en el que el usuario introducirá el número de equipos
     */
    private TextView equipos;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparacionsorteo);

        // Inicialización del sorteo
        sorteo = new Sorteo();

        // Recuperación de los componentes graficos
        lista = findViewById(R.id.lsJugadores);
        nombre = findViewById(R.id.txtAñadirJugador);
        equipos = findViewById(R.id.txtNumGrupos);

        // Configuración de los componentes gráficos
        lista.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, sorteo.getJugadores()) {
            /* Redefinición de getView para aplicar estilo al listitem */
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);

                text.setTextColor(Color.WHITE);

                return view;
            }
        });
        lista.setOnItemLongClickListener(new ListView.OnItemLongClickListener() {
            /*
             * Al mantener pulsado un elemento se elimina ese nombre del sorteo
             *
             * @see OnItemLongClickListener
             */
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                sorteo.removeJugador(i);
                ((ArrayAdapter) lista.getAdapter()).notifyDataSetChanged();
                return true;
            }
        });
    }

    /**
     * Método que añade un jugador a la lista de jugadores para el sorteo
     *
     * @param view Vista que lanza el evento de añadir el jugador
     */
    public void addJugador(View view) {
        String nombre = this.nombre.getText().toString();
        if (nombre.trim().length() == 0) {
            Toast.makeText(getApplicationContext(), R.string.error_nombre_sorteo, Toast.LENGTH_SHORT).show();
            return;
        }
        sorteo.addJugador(nombre);
        ((ArrayAdapter) lista.getAdapter()).notifyDataSetChanged();
        this.nombre.setText("");
    }

    /**
     * Método que carga la lista de jugadores almacenadas en el preferences en el RecyclerView
     *
     * @param view
     */
    public void cargarJugadores(View view) {
        for (String jugador : Conf.getInstancia().loadArray(Conf.JUGADORES)) {
            sorteo.addJugador(jugador);
        }
        ((ArrayAdapter) lista.getAdapter()).notifyDataSetChanged();
    }

    /**
     * Método que prepara todos los datos para realizar el sorteo y llama a la actividad encargada de mostrarle los datos del sorteo al usuario.
     * En caso de que los datos para iniciar el sorteo sean incorrectos no hace el cambio, y avisa al usuario.
     *
     * @param view Vista que hace que se lance este comportamiento.
     * @see ResultadoSorteoActivity
     */
    public void lanzarResultadoSorteo(View view) {
        if (equipos.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), R.string.error_equipos_inexistente, Toast.LENGTH_SHORT).show();
        else {
            int numEquipos = Integer.parseInt(equipos.getText().toString());
            if (numEquipos <= 0)
                Toast.makeText(getApplicationContext(), R.string.error_equipos_menor, Toast.LENGTH_SHORT).show();
            else if (numEquipos > sorteo.getNumJugadores())
                Toast.makeText(getApplicationContext(), R.string.error_equipos_mayor, Toast.LENGTH_SHORT).show();
            else {
                sorteo.setNumEquipos(numEquipos);
                Intent mIntent = new Intent(getApplicationContext(), ResultadoSorteoActivity.class);
                mIntent.putExtra(SORTEO, sorteo);
                startActivity(mIntent);
            }
        }
    }
}
