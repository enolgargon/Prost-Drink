package com.cgi.sdm_project.util.adapters;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.memoria.MemoriaActivity;
import com.cgi.sdm_project.util.singletons.AppSingleton;

import java.util.List;
import java.util.Random;

/**
 * Adaptador para el recyclerView de @MemoriaActivity
 *
 * @author Samuel
 */
public class MemoryCardAdapter extends RecyclerView.Adapter<MemoryCardAdapter.ItemViewHolder> {
    /**
     * Constante que almacena la imagen que se pintará cuando se de la vuelta a las cartas
     */
    private final Drawable OCULTA_IMG = AppSingleton.getInstance().getDrawable(R.drawable.blanco);

    /**
     * Lista de los drawables que se pintarán
     */
    private List<Drawable> mImages;
    //Nuestro señor y salvador RNGesus elegirá la carta
    private Random rngesus;
    /**
     * Índice de la carta elegida
     */
    private int mIndex = -1;

    /**
     * Almacena la activity para mandarle notificaciones
     */
    private MemoriaActivity mActivity;
    /**
     * Representa el estado en que se encuentran las cartas (visibles u ocultas) mediante un booleano
     */
    private boolean[] ocultas;

    /**
     * Representa si se puede pulsar o no las cartas
     */
    private boolean clickable;

    public MemoryCardAdapter(List<Drawable> images, MemoriaActivity activity) {
        this.mImages = images;
        this.rngesus = new Random();
        this.ocultas = new boolean[mImages.size()];
        this.mActivity = activity;
        this.clickable = false;
    }


    @NonNull
    @Override
    public MemoryCardAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.memory_view, viewGroup, false);
        return new ItemViewHolder(view);
    }

    /**
     * Pinta el item como le corresponde a su estado actual
     *
     * @param holder Hueco de la imagen
     * @param i      Posición de la imagen
     */
    @Override
    public void onBindViewHolder(@NonNull MemoryCardAdapter.ItemViewHolder holder, int i) {
        if (ocultas[i]) {
            holder.imagenOculta.setImageDrawable(OCULTA_IMG);
            holder.imagenOculta.setVisibility(View.VISIBLE);
            holder.imagenVisible.setVisibility(View.GONE);
        } else {
            holder.imagenOculta.setVisibility(View.GONE);
            holder.imagenVisible.setImageDrawable(mImages.get(i));
            holder.imagenVisible.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    /**
     * Oculta todas las cartas al comienzo del juego
     */
    public void ocultarCartas() {
        for (int i = 0; i < ocultas.length; i++) {
            ocultas[i] = true;
        }
        clickable = true;
        notifyDataSetChanged();
    }

    public void mostrarCartas() {
        for (int i = 0; i < ocultas.length; i++) {
            ocultas[i] = false;
        }
        clickable = false;
        notifyDataSetChanged();
    }

    /**
     * Elige la carta objetivo y devuelve su drawable para que el activity lo pueda mostrar
     *
     * @return Imagen que se dibujara
     */
    public Drawable getObjetivo() {
        mIndex = rngesus.nextInt(mImages.size());
        return mImages.get(mIndex);
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatImageView imagenVisible;
        AppCompatImageView imagenOculta;

        ItemViewHolder(View itemView) {
            super(itemView);
            imagenVisible = itemView.findViewById(R.id.imagenVisible);
            imagenOculta = itemView.findViewById(R.id.imagenOculta);
            itemView.setOnClickListener(this);
        }

        /**
         * Notifica a la activity qué carta se ha pulsado y le da la vuelta
         *
         * @param v Vista que lanza el evento
         */
        @Override
        public void onClick(View v) {
            if (!clickable)
                return;

            clickable = false;
            if (mIndex == getAdapterPosition()) {

                ocultas[getAdapterPosition()] = false;
                notifyItemChanged(getAdapterPosition());
                //Notifica a la activity de que ha acertado el usuario
                mActivity.notifySuccess();
            } else {
                ocultas[getAdapterPosition()] = false;
                ocultas[mIndex] = false;

                /*
                 * Marca visualmente como incorrecta la carta... incorrecta
                 */
                Drawable[] layers = {mImages.get(getAdapterPosition()), mActivity.getDrawable(R.drawable.cartaincorrecta)};
                LayerDrawable highlightedTarget = new LayerDrawable(layers);

                mImages.set(getAdapterPosition(), highlightedTarget);

                notifyDataSetChanged();
                //Notifica a la activity de que ha fallado
                mActivity.notifyFailure();
            }
        }
    }
}
