package com.example.admin.yougohcalculadora;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterListaDeck extends RecyclerView.Adapter<AdapterListaDeck.MyViewHolder> {
    private List<Deck> listaDecks;
    public AdapterListaDeck(List<Deck> listaDecks) {
        this.listaDecks = listaDecks;
    }
    @NonNull
    @Override
    public AdapterListaDeck.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listadeck_layout,parent,false);
        return new MyViewHolder(itemView);
    }
    public void onBindViewHolder(@NonNull AdapterListaDeck.MyViewHolder holder, int position) {
        Deck deck = listaDecks.get(position);
        holder.nome.setText(deck.getNome());
    }
    @Override
    public int getItemCount() {
        return 0;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nome;
        public ImageView imagemDeck;
        public Deck deck;

        public MyViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomeDeck);
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
