package com.example.admin.yougohcalculadora.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class BancoDAO extends SQLiteOpenHelper {
    private static final String NOMEBANCO = "Duelista";
    private static final int VERSAOBANCO = 1;
    private static final String TABLEDUELISTA = "CREATE TABLE Duelista (id INTEGER PRIMARY KEY,"+
            "nome TEXT,deck INTEGER, vitorias INTEGER, derrotas INTEGER, deck INTEGER);";
    public BancoDAO(Context context) {
        super(context, NOMEBANCO, null, VERSAOBANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLEDUELISTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS Duelista;");
    }
}
