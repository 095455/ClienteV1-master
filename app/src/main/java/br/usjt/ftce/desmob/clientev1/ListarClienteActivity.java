package br.usjt.ftce.desmob.clientev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarClienteActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> lista;
    public static final String NOME = "br.usjt.ftce.demob.clientev1.nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cliente);
        listView = (ListView)findViewById(R.id.lista_de_cliente);
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = buscarCliente(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(ListarClienteActivity.this, DetalheClienteActivity.class);
                intent1.putExtra(NOME, lista.get(i));
                startActivity(intent1);
            }
        });
    }

    private ArrayList<String> listaDeCliente(){
        ArrayList<String> clientes =  new ArrayList<>();
        clientes.add("Carlos Drummond de Andrade");
        clientes.add("Manuel Bandeira");
        clientes.add("Olavo Bilac");
        clientes.add("Vinícius de Moraes");
        clientes.add("Cecília Meireles");
        clientes.add("Castro Alves");
        clientes.add("Gonçalves Dias");
        clientes.add("Ferreira Gullar");
        clientes.add("Machado de Assis");
        clientes.add("Mário de Andrade");
        clientes.add("Cora Coralina");
        clientes.add("Manoel de Barros");
        clientes.add("João Cabral de Melo Neto");
        clientes.add("Casimiro de Abreu");
        clientes.add("Paulo Leminski");
        clientes.add("Álvares de Azevedo");
        clientes.add("Guilherme de Almeida");
        clientes.add("Alphonsus de Guimarães");
        clientes.add("Mário Quintana");
        clientes.add("Gregório de Matos");
        clientes.add("Augusto dos Anjos");


        return clientes;
    }

    private ArrayList<String> buscarCliente(String chave){
        ArrayList<String> clientes = listaDeCliente();
        ArrayList<String> resultado =  new ArrayList<>();

        if(chave == null || chave.length() == 0){
            return clientes;
        }
        for(String nome:clientes){
            if(nome.toUpperCase().contains(chave.toUpperCase())){
                resultado.add(nome);
            }
        }
        return resultado;
    }
}
