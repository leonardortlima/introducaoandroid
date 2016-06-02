package com.test.aula06;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListUsuarioActivity extends ActionBarActivity {

    public static final int REQUEST_CODE_CADASTRO = 123;
    private List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usuario);

        if(usuarios == null) usuarios = new ArrayList<>();

        TextView saudacoes = (TextView) findViewById(R.id.text_view_ola);
        saudacoes.setText("Olá, " + InfoUsuarioPreference.getInstance(this).getEmail());

        Button btConfirmar = (Button) findViewById(R.id.bt_cadastrar);
        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastraUsuario();
            }
        });

        ListView listUsuario = (ListView) findViewById(R.id.usuario_listView);
        listUsuario.setAdapter(new UsuarioAdapter(this, usuarios));
        listUsuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                exibeUsuario(usuarios.get(position));
            }
        });
    }

    private void cadastraUsuario() {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivityForResult(intent, REQUEST_CODE_CADASTRO);
    }

    private void exibeUsuario(Usuario usuario) {
        Intent intent = new Intent(this, DetalhesActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQUEST_CODE_CADASTRO && resultCode == RESULT_OK) {
            usuarios.add((Usuario) intent.getSerializableExtra("usuario"));
        }
    }
}

