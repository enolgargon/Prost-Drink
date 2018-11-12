package com.cgi.sdm_project.igu.juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.Jugador;

import java.util.ArrayList;
import java.util.List;


public class ElegirJugadoresActivity extends AppCompatActivity {

    private ListView listaJugadores;
    private TextView txtJugador;
    private Button añadirJugador;
    private Button jugar;
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
    private void setComponents(){
        listaJugadores = findViewById(R.id.listJugadores);
        txtJugador = findViewById(R.id.txtAñadirJugador);
        añadirJugador = findViewById(R.id.btnAñadirParticipante);
        jugar = findViewById(R.id.fabJugar);

    }

    /**
     * Metodo privado que añade listeners a los elementos necesarios
     */
    private void setListeners(){

        listaJugadores.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, jugadores));
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
                jugadores.add(new Jugador(añadirJugador.getText().toString()));
                ((ArrayAdapter) listaJugadores.getAdapter()).notifyDataSetChanged();
            }
        });

        jugar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Juego.getInstance().setJugadores(jugadores);
                Intent mIntent = new Intent(getApplicationContext(), JuegoPreguntaActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
