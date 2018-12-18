package com.cgi.sdm_project.igu.juego;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.Jugador;

import java.util.ArrayList;
import java.util.List;


public class ElegirJugadoresActivity extends AppCompatActivity {

    private ListView listaJugadores;
    private TextView txtJugador;
    private Button añadirJugador;
    private FloatingActionButton jugar;
    private List<Jugador> jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegirjugadores);
        jugadores = new ArrayList<Jugador>();
        setComponents();
        setListeners();

    }

    /**
     * Método privado que inicializa los componentes del layout asociado
     */
    private void setComponents() {
        listaJugadores = findViewById(R.id.listJugadores);
        txtJugador = findViewById(R.id.txtAñadirJugador);
        añadirJugador = findViewById(R.id.btnAñadirParticipante);
        jugar = findViewById(R.id.fabJugar);

    }

    /**
     * Metodo privado que añade listeners a los elementos necesarios
     */
    private void setListeners() {

        listaJugadores.setAdapter(new ArrayAdapter<Jugador>(getApplicationContext(), android.R.layout.simple_list_item_1, jugadores){
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

        /*
         *  Al hacer click sobre el botón de añadir con un nombre válido, se añade al modelo y a la vista que muestra los jugadores correspondientes
         */
        añadirJugador.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtJugador.getText() != null && !txtJugador.getText().toString().trim().isEmpty()) {
                    jugadores.add(new Jugador(txtJugador.getText().toString()));
                    txtJugador.setText("");
                    ((ArrayAdapter) listaJugadores.getAdapter()).notifyDataSetChanged();
                } else
                    Toast.makeText(getApplicationContext(), "Debe introducir un nombre de jugador", Toast.LENGTH_SHORT).show();
            }
        });

        jugar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Juego.getInstance().setJugadores(jugadores);
                Intent mIntent = new Intent(getApplicationContext(), Juego.getInstance().getSiguienteJuego());
                startActivity(mIntent);
            }
        });
    }
}
