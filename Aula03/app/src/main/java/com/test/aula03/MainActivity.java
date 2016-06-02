package com.test.aula03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_MESSAGE_CODE = 1;
    public static final String REQUEST_MESSAGE_KEY = "mensagem_enviada";
    public static final String RESPONSE_MESSAGE_KEY = "resposta_enviada";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nomeUsuario = (TextView) findViewById(R.id.nome_usuario);
        nomeUsuario.setText("Leonardo");

        TextView idadeUsuario = (TextView) findViewById(R.id.idade_usuario);
        idadeUsuario.setText("24");

        TextView sexoUsuario = (TextView) findViewById(R.id.sexo_usuario);
        sexoUsuario.setText("Masculino");

        TextView enderecoUsuario = (TextView) findViewById(R.id.endereco_usuario);
        enderecoUsuario.setText("Avenida Rio Branco, 1");

        final EditText editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.bt_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDados(editText.getText().toString());
            }
        });
    }

    private void enviarDados(String mensagem) {
        Intent intent = new Intent(this,ReceiverActivity.class);
        intent.putExtra(REQUEST_MESSAGE_KEY,mensagem);
        startActivityForResult(intent, REQUEST_MESSAGE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_MESSAGE_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this,data.getStringExtra(RESPONSE_MESSAGE_KEY),Toast.LENGTH_SHORT).show();
        }
    }
}
