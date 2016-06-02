package com.test.aula04;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CadastroActivity extends ActionBarActivity {

    private EditText textNome;
    private EditText textCor;
    private EditText textCelular;
    private EditText textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        textNome = (EditText) findViewById(R.id.edit_nome);
        textEmail = (EditText) findViewById(R.id.edit_email);
        textCelular = (EditText) findViewById(R.id.edit_celular);
        textCor = (EditText) findViewById(R.id.edit_cor);

        Button btAceitar = (Button) findViewById(R.id.bt_aceitar);
        btAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaResposta();
            }
        });

    }

    private void enviaResposta() {
        Usuario usuario = new Usuario();
        usuario.setNome(textNome.getText().toString());
        usuario.setEmail(textEmail.getText().toString());
        usuario.setCelular(textCelular.getText().toString());
        usuario.setCor(textCor.getText().toString());

        Intent intent = new Intent();
        intent.putExtra("usuario",usuario);

        setResult(RESULT_OK,intent);
        finish();
    }
}
