package com.example.admin.yougohcalculadora;

import android.widget.ImageView;

public class Duelista {
    private int id;
    private String nome = "Duelista";
    private int deck;
    private String lifepoint = "8000";
    private int vitorias = 0;
    private int derrotas = 0;

    private boolean ativo = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDeck() {
        return deck;
    }

    public void setDeck(int deck) {
        this.deck = deck;
    }

    public String getLifepoint() {
        return lifepoint;
    }

    public void setLifepoint(String lifepoint) {
        this.lifepoint = lifepoint;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo ) {
        if(ativo){
            this.ativo = ativo;
        }else{
            this.ativo = false;
        }

    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
