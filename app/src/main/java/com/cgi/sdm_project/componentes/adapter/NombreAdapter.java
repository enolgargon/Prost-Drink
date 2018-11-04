package com.cgi.sdm_project.componentes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cgi.sdm_project.R;

import java.util.List;

/**
 * Clase que define un adaptador para mostrar una llista de nombres personalizada
 *
 * @author Enol García González
 * @version 04-11-2018
 */
public class NombreAdapter extends BaseAdapter {
    /**
     * Lista de nombres que se deben mostrar
     */
    private List<String> nombres;
    /**
     * Contexto en el que se ejecuta la aplicación
     */
    private Context context;

    /**
     * Constructor que recibe el contexto en el que se ejecuta la aplicacion y la lista de nombres que debe mostrar el adaptador.
     *
     * @param context Contexto de la aplicacion
     * @param nombres Lista de nombres para mostrar
     */
    public NombreAdapter(Context context, List<String> nombres) {
        this.context = context;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return nombres.size();
    }

    @Override
    public Object getItem(int i) {
        return nombres.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_nombre, null);
        ((TextView) view.findViewById(R.id.txtNombre)).setText(nombres.get(i));

        return view;
    }
}
