package com.test.aula07.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.test.aula07.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public static abstract class UsuarioEntries implements BaseColumns {

        private static final String TABLE_NAME = "usuario";
        private static final String COLUMN_NAME_NOME = "nome";
        private static final String COLUMN_NAME_EMAIL = "email";
        private static final String COLUMN_NAME_CELULAR = "celular";
        private static final String COLUMN_NAME_COR = "cor";

        private static final String TEXT_TYPE = " TEXT";
        private static final String INT_TYPE = " INTEGER";
        private static final String COMMA_SEP = ",";

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        UsuarioEntries._ID + INT_TYPE + " PRIMARY KEY," +
                        UsuarioEntries.COLUMN_NAME_NOME + TEXT_TYPE + COMMA_SEP +
                        UsuarioEntries.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                        UsuarioEntries.COLUMN_NAME_CELULAR + TEXT_TYPE + COMMA_SEP +
                        UsuarioEntries.COLUMN_NAME_COR + TEXT_TYPE +
                        " )";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + UsuarioEntries.TABLE_NAME;
    }

    public Usuario salvar(SQLiteDatabase db, Usuario usuario) {

        ContentValues values = new ContentValues();
        if(usuario.getId() != 0) {
            values.put(UsuarioEntries._ID, usuario.getId());
        }
        values.put(UsuarioEntries.COLUMN_NAME_NOME, usuario.getNome());
        values.put(UsuarioEntries.COLUMN_NAME_EMAIL, usuario.getEmail());
        values.put(UsuarioEntries.COLUMN_NAME_CELULAR, usuario.getCelular());
        values.put(UsuarioEntries.COLUMN_NAME_COR, usuario.getCor());

        // insere a nova lina, retornando a primary key como valor
        long newRowId = db.insert(
            UsuarioEntries.TABLE_NAME, // nome da tabela
            null, // coluna que pode ser nula
            values // valores a serem inseridos
        );

        // se salvou corretamente, seta o id
        if(newRowId != -1) {
            usuario.setId(newRowId);
        }

        return usuario;
    }

    public boolean alterar(SQLiteDatabase db, Usuario usuario) {
        // novos valores para as colunas
        ContentValues values = new ContentValues();
        values.put(UsuarioEntries.COLUMN_NAME_NOME, usuario.getNome());
        values.put(UsuarioEntries.COLUMN_NAME_EMAIL, usuario.getEmail());
        values.put(UsuarioEntries.COLUMN_NAME_CELULAR, usuario.getCelular());
        values.put(UsuarioEntries.COLUMN_NAME_COR, usuario.getCor());

        // selecionar valor da coluna id
        String selecao = UsuarioEntries._ID + " LIKE ?";
        // parametros para o valor da coluna id
        String[] parametrosSelecao = { String.valueOf(usuario.getId()) };

        int count = db.update(
                UsuarioEntries.TABLE_NAME,
                values,
                selecao,
                parametrosSelecao);

        return count > 0;
    }

    public boolean apagar(SQLiteDatabase db, Usuario usuario) {
        // define o where
        String selecao = UsuarioEntries._ID + " LIKE ?";
        // define os parametros, em ordem
        String[] parametrosSelecao = {String.valueOf(usuario.getId())};
        // executa o sql
        int count = db.delete(UsuarioEntries.TABLE_NAME, selecao, parametrosSelecao);

        return count > 0;
    }

    public List<Usuario> listar(SQLiteDatabase db) {
        // define quais colunas serao projetadas
        String[] projecao = {
                UsuarioEntries._ID,
                UsuarioEntries.COLUMN_NAME_NOME,
                UsuarioEntries.COLUMN_NAME_EMAIL,
                UsuarioEntries.COLUMN_NAME_CELULAR,
                UsuarioEntries.COLUMN_NAME_COR
        };

        // ordenacao
        String ordenacao = UsuarioEntries._ID + " ASC";

        Cursor cursor = db.query(
                UsuarioEntries.TABLE_NAME,  // nome da tabela
                projecao,                   // colunas a serem retornadas
                null,                       // colunas da clausula where
                null,                       // valores da clausula where
                null,                       // nao agrupa os resultados
                null,                       // nao filtra por grupos
                ordenacao
        );

        List<Usuario> usuarios = new ArrayList<>();
        while(cursor.moveToNext()) {
            Usuario usuario = new Usuario();

            usuario.setId(
                    cursor.getLong(cursor.getColumnIndex(UsuarioEntries._ID)));

            usuario.setNome(
                    cursor.getString(cursor.getColumnIndex(UsuarioEntries.COLUMN_NAME_NOME)));

            usuario.setEmail(
                    cursor.getString(cursor.getColumnIndex(UsuarioEntries.COLUMN_NAME_EMAIL)));

            usuario.setCelular(
                    cursor.getString(cursor.getColumnIndex(UsuarioEntries.COLUMN_NAME_CELULAR)));

            usuario.setCor(
                    cursor.getString(cursor.getColumnIndex(UsuarioEntries.COLUMN_NAME_COR)));

            usuarios.add(usuario);
        }

        return usuarios;
    }
}
