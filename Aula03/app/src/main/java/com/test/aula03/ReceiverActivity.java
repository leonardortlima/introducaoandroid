package com.test.aula03;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ReceiverActivity extends ActionBarActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        String mensagem = getIntent().getStringExtra(MainActivity.REQUEST_MESSAGE_KEY);

        textView = (TextView) findViewById(R.id.texto_modificado);
        textView.setText(mensagem);

        Button button = (Button) findViewById(R.id.bt_resposta);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarResultado();
            }
        });
    }

    private void enviarResultado() {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.RESPONSE_MESSAGE_KEY,"Deu certo!");
        setResult(RESULT_OK,intent);
        finish();
    }
}
