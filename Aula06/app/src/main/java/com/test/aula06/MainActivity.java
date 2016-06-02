package com.test.aula06;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(InfoUsuarioPreference.getInstance(this).getAceitou()) {
            redirecionaTelaPrincipal();
        }

        setContentView(R.layout.activity_main);

        final TextView email = (TextView) findViewById(R.id.activity_main_edit_email);

        Button btAceitar = (Button) findViewById(R.id.activity_main_bt_aceito);
        btAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoUsuarioPreference.getInstance(MainActivity.this).setAceitou(true);
                InfoUsuarioPreference.getInstance(MainActivity.this)
                        .setEmail(email.getText().toString());
                redirecionaTelaPrincipal();
            }
        });

        Button btRecusar = (Button) findViewById(R.id.activity_main_bt_nao_aceito);
        btRecusar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finaliza();
            }
        });

    }

    private void redirecionaTelaPrincipal() {
        Intent intent = new Intent(this, ListUsuarioActivity.class);
        startActivity(intent);
    }

    private void finaliza() {
        finish();
    }
}

