package br.usjt.ftce.desmob.clientev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheClienteActivity extends AppCompatActivity {
    TextView textViewNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);
        textViewNome = (TextView) findViewById(R.id.txt_cliente_nome);
        Intent intent = getIntent();
        String nome = intent.getStringExtra(ListarClienteActivity.NOME);
        textViewNome.setText(nome);


    }
}
