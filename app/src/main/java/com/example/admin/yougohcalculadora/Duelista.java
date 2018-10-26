package com.example.admin.yougohcalculadora;

import android.widget.ImageView;

public class Duelista {
    private String nome = "Duelista";
    private String deck;
    private String lifepoint = "8000";
    private int vitorias = 0;
    private int derrotas = 0;
    private ImageView imagem;

    private boolean ativo = false;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
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
    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }
}
