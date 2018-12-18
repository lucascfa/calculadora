package com.example.admin.yougohcalculadora;

import android.graphics.drawable.Drawable;

public class Deck {
    private int id;
    private String nome;
    private int imagemDeck;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagemDeck() {
        return imagemDeck;
    }

    public void setImagemDeck(int imagemDeck) {
        this.imagemDeck = imagemDeck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
