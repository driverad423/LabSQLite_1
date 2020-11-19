package com.androfast.server.appgpssqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaCoordenadas extends AppCompatActivity {
    DatabaseHelper miDB;
    ListView listac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_coordenadas);
        listac = (ListView)findViewById(R.id.listView);
        miDB = new DatabaseHelper(this);

        ArrayList<String>listados = new ArrayList<>();
        Cursor data = miDB.getListaContenidos();
        if (data.getCount() == 0 ){
            Toast.makeText(this," No hay lista que mostrar",Toast.LENGTH_LONG).show();
        }else{
            while (data.moveToNext()){
                listados.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(
                        this,android.R.layout.simple_list_item_1,listados);
                listac.setAdapter(listAdapter);

            }
        }
    }
}
