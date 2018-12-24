package com.cgi.sdm_project.igu.juego;

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
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.juego.Jugador;
import com.cgi.sdm_project.util.AppCompatActivityExtended;
import com.cgi.sdm_project.util.Conf;

import java.util.ArrayList;
import java.util.List;


public class ElegirJugadoresActivity extends AppCompatActivityExtended {

    private ListView listaJugadores;
    private TextView txtJugador;
    private List<Jugador> jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegirjugadores);
        jugadores = new ArrayList<>();
        setComponents();
        configurarAdapter();

    }

    /**
     * Método privado que inicializa los componentes del layout asociado
     */
    private void setComponents() {
        listaJugadores = findViewById(R.id.listJugadores);
        txtJugador = findViewById(R.id.txtAñadirJugador);
    }

    /**
     * Metodo privado que añade listeners a los elementos necesarios
     */
    private void configurarAdapter() {

        listaJugadores.setAdapter(new ArrayAdapter<Jugador>(getApplicationContext(), android.R.layout.simple_list_item_1, jugadores) {
            /* Redefinición de getView para aplicar estilo al listitem */
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);

                text.setTextColor(Color.WHITE);

                return view;
            }
        });
        listaJugadores.setOnItemLongClickListener(new ListView.OnItemLongClickListener() {
            /*
             * Al mantener pulsado un elemento se elimina ese nombre del sorteo
             *
             * @see OnItemLongClickListener
             */
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                jugadores.remove(i);
                ((ArrayAdapter) listaJugadores.getAdapter()).notifyDataSetChanged();
                return true;
            }
        });
    }

    /**
     * Al hacer click sobre el botón de añadir con un nombre válido, se añade al modelo y a la vista que muestra los jugadores correspondientes
     */
    public void addJugador(View view) {
        if (txtJugador.getText() != null && !txtJugador.getText().toString().trim().isEmpty()) {
            jugadores.add(new Jugador(txtJugador.getText().toString()));
            txtJugador.setText("");
            ((ArrayAdapter) listaJugadores.getAdapter()).notifyDataSetChanged();
        } else
            Toast.makeText(getApplicationContext(), "Debe introducir un nombre de jugador", Toast.LENGTH_SHORT).show();
    }

    /**
     * Lanza el juego con los jugadores introducidos, leyendon la signatura basta pero si te hace
     * ilusión leer los comentarios del javadoc te cuento mi vida aquí
     *
     * @param view
     */
    public void lanzarJuego(View view) {

        if (jugadores.isEmpty())
            Toast.makeText(getApplicationContext(), "Debe introducir mínimo un jugador para jugar", Toast.LENGTH_SHORT).show();
        else {
            Juego.getInstance().setJugadores(jugadores);
            Intent mIntent = new Intent(getApplicationContext(), Juego.getInstance().getSiguienteJuego());
            startActivity(mIntent);
        }
    }

    /**
     * Método que carga la lista de jugadores almacenadas en el preferences en el RecyclerView
     *
     * @param view
     */
    public void cargarJugadores(View view) {
        for (String jugador : Conf.getInstancia().loadArray(Conf.JUGADORES)) {
            jugadores.add(new Jugador(jugador));
        }
        ((ArrayAdapter) listaJugadores.getAdapter()).notifyDataSetChanged();
    }

}
