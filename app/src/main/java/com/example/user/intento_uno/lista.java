package com.example.user.intento_uno;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.intento_uno.Helper.SqliteHelper;
import com.example.user.intento_uno.Helper.entidad;

import java.util.ArrayList;
import java.util.List;

public class lista extends AppCompatActivity {


    RecyclerView lista ;
    private adaptador adaptador;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lista = findViewById(R.id.lista_uno);
        lista.setLayoutManager(new LinearLayoutManager(this));
        adaptador= new adaptador(ObtenerPersona());
        lista.setAdapter(adaptador);
    }

    private List<entidad> ObtenerPersona() {

        List<entidad> lista = new ArrayList<>();
        SqliteHelper base = new SqliteHelper(this,"bdUsuario.db",null,1);
        SQLiteDatabase datos = base.getReadableDatabase();
        entidad entidades = null;
        Cursor cursor = datos.rawQuery("select Nombre,Apellido,Edad from Persona",null);
        while (cursor.moveToNext()){
            entidades= new entidad();
            entidades.setNombre(cursor.getString(0));
            entidades.setApellido(cursor.getString(1));
            entidades.setEdad(cursor.getString(2));
            lista.add(entidades);
        }
        return lista;

    }


}
