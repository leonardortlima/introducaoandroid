package com.test.aula04;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DetalhesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        TextView nomeText = (TextView) findViewById(R.id.text_nome);
        nomeText.setText(usuario.getNome());

        TextView emailText = (TextView) findViewById(R.id.text_email);
        emailText.setText(usuario.getEmail());

        TextView celularText = (TextView) findViewById(R.id.text_celular);
        celularText.setText(usuario.getCelular());

        View cor = findViewById(R.id.view_cor);
        cor.setBackgroundColor(Color.parseColor(usuario.getCor()));

    }
}
