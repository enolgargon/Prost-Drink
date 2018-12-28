package com.cgi.sdm_project.igu.sorteo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.widget.ListView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.sorteo.Sorteo;
import com.cgi.sdm_project.util.AppCompatActivityExtended;
import com.cgi.sdm_project.util.adapters.NombreAdapter;

import java.util.List;
import java.util.Objects;

/**
 * Clase que define la activity que muestra al usuario el resultado de un sorteo
 *
 * @author Enol García González
 * @version 04-11-2018
 */
public class ResultadoSorteoActivity extends AppCompatActivityExtended {
    /**
     * Grid layout que muestra a los equipos en forma de rejilla
     */
    private GridLayout resultados;
    /**
     * Lista de los equipos que han salido del sorteo. Cada equipo es una lista de nombres
     */
    private List<List<String>> equipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_sorteo);

        Sorteo sorteo = Objects.requireNonNull(getIntent().getExtras(), "No se han recibido los datos del sorteo").getParcelable(SortearActivity.SORTEO);
        assert sorteo != null;
        equipos = sorteo.sortear();

        resultados = findViewById(R.id.gridResultados);
        rellenarResultados();
    }

    /**
     * Método que rellena el grid layout con cada uno de los equipos que se han formado
     */
    private void rellenarResultados() {
        if (equipos.size() == 1)
            resultados.setColumnCount(1);
        else if (equipos.size() % 2 == 0)
            resultados.setColumnCount(2);
        else resultados.setColumnCount(3);
        for (List<String> equipo : equipos)
            resultados.addView(generarListaEquipo(equipo));
    }

    /**
     * Método que crea un list view para mostrar los jugadores que pertenecen a cada equipo. Este método se llama para cada equipo que sale del sorteo.
     *
     * @param equipo Lista de los jugadores que están en el equipo que representa la lista
     * @return Nuevo list view que muestra el equipo
     */
    private ListView generarListaEquipo(List<String> equipo) {
        ListView lista = new ListView(new ContextThemeWrapper(getApplicationContext(), R.style.SorteoBucket));
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        lista.setLayoutParams(new ListView.LayoutParams(metrics.widthPixels / resultados.getColumnCount() - getPixels(30), ListView.LayoutParams.MATCH_PARENT));
        lista.setAdapter(new NombreAdapter(getApplicationContext(), equipo));
        lista.setDivider(null);
        lista.setBackground(getApplicationContext().getDrawable(R.drawable.saco));

        return lista;
    }

    /**
     * Método de utilidad que permite calcular medidas en pixeles a partir de una medida dada en do
     *
     * @param dp Medida en dp
     * @return Medida convertida a pixeles
     */
    private int getPixels(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
