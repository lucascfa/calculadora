package com.example.admin.yougohcalculadora.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.admin.yougohcalculadora.Duelista;

import java.util.ArrayList;
import java.util.List;

public class DuelistaDAO {
    Context context;
    BancoDAO dao;
    private static final String BANCONOME = "Duelista";

    public DuelistaDAO(Context context) {
        this.context = context;
    }

    public long insere(Duelista duelista) {
        dao = new BancoDAO(context);
        SQLiteDatabase db = dao.getWritableDatabase();
        ContentValues dados = pegaDadosDoDuelista(duelista);
        long inserir = db.insert(BANCONOME, null, dados);
        db.close();
        Log.i(BANCONOME, inserir + "");
        return inserir;
    }

    private ContentValues pegaDadosDoDuelista(Duelista duelista) {
        ContentValues dados = new ContentValues();
        dados.put("nome", duelista.getNome());
        dados.put("vitorias", duelista.getVitorias());
        dados.put("derrotas", duelista.getDerrotas());
        dados.put("deck", duelista.getDeck());
        return dados;
    }

    public List<Duelista> buscaDuelista() {
        String sql = "SELECT * FROM " + BANCONOME;
        dao = new BancoDAO(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Duelista> duelistas = new ArrayList<Duelista>();
        while (c.moveToNext()) {
            Duelista duelista = new Duelista();
            duelista.setId(c.getInt(c.getColumnIndex("id")));
            duelista.setNome(c.getString(c.getColumnIndex("nome")));
            duelista.setDerrotas(c.getInt(c.getColumnIndex("derrotas")));
            duelista.setDeck(c.getInt(c.getColumnIndex("deck")));
            duelistas.add(duelista);
        }
        db.close();
        return duelistas;
    }
}
