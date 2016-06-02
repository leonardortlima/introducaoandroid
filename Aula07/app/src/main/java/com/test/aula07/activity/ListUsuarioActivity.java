package com.test.aula07.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.test.aula07.database.UserDbHelper;
import com.test.aula07.preferences.InfoUsuarioPreference;
import com.test.aula07.R;
import com.test.aula07.model.Usuario;
import com.test.aula07.adapter.UsuarioAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListUsuarioActivity extends ActionBarActivity {

    public static final int REQUEST_CODE_CADASTRO = 123;
    public static final int REQUEST_CODE_DETALHES = 234;
    private List<Usuario> usuarios;
    private ListView listUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usuario);

        UserDbHelper userDbHelper = new UserDbHelper(this);
        if(usuarios == null) usuarios = Usuario.listar(userDbHelper.getWritableDatabase());
        userDbHelper.close();

        TextView saudacoes = (TextView) findViewById(R.id.text_view_ola);
        saudacoes.setText("Ola, " + InfoUsuarioPreference.getInstance(this).getEmail());

        Button btConfirmar = (Button) findViewById(R.id.bt_cadastrar);
        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastraUsuario();
            }
        });

        listUsuario = (ListView) findViewById(R.id.usuario_listView);
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
        startActivityForResult(intent, REQUEST_CODE_DETALHES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQUEST_CODE_CADASTRO && resultCode == RESULT_OK) {
            usuarios.add((Usuario) intent.getSerializableExtra("usuario"));
        } else if(requestCode == REQUEST_CODE_DETALHES && resultCode == RESULT_OK) {
            UserDbHelper userDbHelper = new UserDbHelper(this);

            usuarios = Usuario.listar(userDbHelper.getWritableDatabase());
            listUsuario.setAdapter(new UsuarioAdapter(this, usuarios));

            userDbHelper.close();

        }
    }
}

