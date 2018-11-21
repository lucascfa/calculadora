package com.example.admin.yougohcalculadora.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.admin.yougohcalculadora.Duelista;

public class DuelistaDAO {
    Context context;
    BancoDAO dao;
    private static final String BANCONOME = "Duelista";
    public DuelistaDAO(Context context){
        this.context = context;
    }
    public void insere(Duelista duelista){
        dao = new BancoDAO(context);
        SQLiteDatabase db = dao.getWritableDatabase();
        ContentValues dados = pegaDadosDoDuelista(duelista);
        long inserir = db.insert(BANCONOME, null, dados);
        db.close();
        Log.i(BANCONOME, inserir + "");
    }
    private ContentValues pegaDadosDoDuelista(Duelista duelista){
        ContentValues dados = new ContentValues();
        dados.put("nome", duelista.getNome());
        dados.put("vitorias", duelista.getVitorias());
        dados.put("derrotas", duelista.getDerrotas());
        dados.put("deck",duelista.getDeck());
        return dados;
    }
}
