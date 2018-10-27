package com.example.admin.yougohcalculadora;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterListaDecks extends BaseAdapter {
    private List<Deck> listaDeck;
    private Activity activity;

    public AdapterListaDecks(Activity activity, List<Deck> lista){
        this.activity = activity;
        this.listaDeck =  lista;
    }
    @Override
    public int getCount() {
        return listaDeck.size();
    }

    @Override
    public Object getItem(int i) {
        return listaDeck.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = activity.getLayoutInflater().inflate(R.layout.listadeck_layout,viewGroup,false);
        Deck deck =  listaDeck.get(i);
        TextView nome = view.findViewById(R.id.nome);
        nome.setText(deck.getNome());

        ImageView imagem =  view.findViewById(R.id.imagem);
        imagem.setBackgroundResource(deck.getImagemDeck());

        return v;
    }
}
