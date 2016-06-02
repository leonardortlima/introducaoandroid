package com.test.aula04;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    public static final int REQUEST_CODE_CADASTRO = 123;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConfirmar = (Button) findViewById(R.id.bt_cadastrar);
        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastraUsuario();
            }
        });

        Button btExibir = (Button) findViewById(R.id.bt_exibir);
        btExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibeUsuario();
            }
        });

    }

    private void cadastraUsuario() {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivityForResult(intent, REQUEST_CODE_CADASTRO);
    }

    private void exibeUsuario() {
        Intent intent = new Intent(this, DetalhesActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQUEST_CODE_CADASTRO && resultCode == RESULT_OK) {
            usuario = (Usuario) intent.getSerializableExtra("usuario");
        }
    }
}

