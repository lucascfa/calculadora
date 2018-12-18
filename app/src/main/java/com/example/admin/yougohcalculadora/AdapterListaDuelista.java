package com.example.admin.yougohcalculadora;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterListaDuelista extends RecyclerView.Adapter<AdapterListaDuelista.MyViewHolder> {
    private List<Duelista> duelistaLista;

    public AdapterListaDuelista(List<Duelista> duelistaLista) {
        this.duelistaLista = duelistaLista;
    }

    @NonNull
    @Override
    public AdapterListaDuelista.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.criar_player, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListaDuelista.MyViewHolder holder, int position) {
    Duelista duelista = duelistaLista.get(position);
    holder.nome.setText(duelista.getNome());
    holder.derrotas.setText(duelista.getDerrotas());
    holder.vitorias.setText(duelista.getVitorias());
    }

    @Override
    public int getItemCount() {
        return duelistaLista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nome, vitorias, derrotas;
        public ImageView imagemDeck;
        public Deck deck;

        public MyViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomeplayer);
            imagemDeck = itemView.findViewById(R.id.imagemDeck);
            if (deck.getImagemDeck() == 1) {
                imagemDeck.setBackgroundResource(R.drawable.felgrand_deck);
            } else if (deck.getImagemDeck() == 2) {
                imagemDeck.setBackgroundResource(R.drawable.shiranui_deck);
            } else if (deck.getImagemDeck() == 3) {
                imagemDeck.setBackgroundResource(R.drawable.darklord_png);
            } else if (deck.getImagemDeck() == 4) {
                imagemDeck.setBackgroundResource(R.drawable.six_samurai_deck);
            }

        }
    }


}



