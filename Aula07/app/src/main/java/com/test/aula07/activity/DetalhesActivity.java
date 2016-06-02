package com.test.aula07.activity;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.aula07.R;
import com.test.aula07.database.UserDbHelper;
import com.test.aula07.model.Usuario;

public class DetalhesActivity extends ActionBarActivity {

    private EditText textNome;
    private EditText textCor;
    private EditText textCelular;
    private EditText textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        final Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        textNome = (EditText) findViewById(R.id.edit_nome);
        textNome.setText(usuario.getNome());

        textEmail = (EditText) findViewById(R.id.edit_email);
        textEmail.setText(usuario.getEmail());

        textCelular = (EditText) findViewById(R.id.edit_celular);
        textCelular.setText(usuario.getCelular());

        textCor = (EditText) findViewById(R.id.edit_cor);
        textCor.setText(usuario.getCor());

        Button btAtualizar = (Button) findViewById(R.id.bt_atualizar);
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualiza(usuario);
            }
        });

        Button btApagar = (Button) findViewById(R.id.bt_apagar);
        btApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apaga(usuario);
            }
        });

    }

    private void atualiza(Usuario usuario) {
        usuario.setNome(textNome.getText().toString());
        usuario.setEmail(textEmail.getText().toString());
        usuario.setCelular(textCelular.getText().toString());
        usuario.setCor(textCor.getText().toString());

        UserDbHelper userDbHelper = new UserDbHelper(this);
        boolean sucesso = usuario.alterar(userDbHelper.getWritableDatabase());
        userDbHelper.close();

        if(sucesso) {
            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(this, "Falha ao alterar!", Toast.LENGTH_SHORT).show();
        }
    }

    private void apaga(Usuario usuario) {
        UserDbHelper userDbHelper = new UserDbHelper(this);
        boolean sucesso = usuario.apagar(userDbHelper.getWritableDatabase());
        userDbHelper.close();

        if(sucesso) {
            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(this, "Falha ao apagar!", Toast.LENGTH_SHORT).show();
        }
    }
}
