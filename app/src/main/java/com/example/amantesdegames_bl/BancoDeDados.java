package com.example.amantesdegames_bl;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BancoDeDados extends SQLiteOpenHelper {

    public BancoDeDados(@Nullable Context context) {
        super(context, "users", null, 1);
    }

    public long insereUser(String name, String email, String password) {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("name", name);
        registro.put("email", email);
        registro.put("password", password);
        long id = banco.insert("users", null, registro);
        banco.close();
        return id;
    }

    public ArrayList<String> consulta() {
        SQLiteDatabase banco = this.getReadableDatabase();
        String sql = "SELECT * FROM users";
        ArrayList<String> resultado = null;

        Cursor c = banco.rawQuery(sql, null);
        if (c.moveToFirst()) {
            resultado = new ArrayList<String>();
            do {
                String registro;
                registro = "\n name : " + c.getString(1);
                registro+= "\n email      : " + c.getString(2);
                registro+= "\n password     : " + c.getString(3);

                resultado.add(registro);
            } while (c.moveToNext());
        }
        banco.close();
        return resultado;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE users( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT, " +
                "email TEXT, " +
                "password TEXT " +
                ")";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
