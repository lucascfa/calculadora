package com.example.admin.yougohcalculadora;

public class Duelista {
    private String nome = "Duelista";
    private String deck;
    private String lifepoint = "8000";
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

}
