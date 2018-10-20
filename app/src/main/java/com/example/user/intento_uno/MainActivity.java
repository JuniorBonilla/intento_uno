package com.example.user.intento_uno;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.intento_uno.Helper.SqliteHelper;

public class MainActivity extends AppCompatActivity {
    EditText documento,nombre,edad,apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        documento = findViewById(R.id.txtDocumento);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        edad = findViewById(R.id.txtEdad);

    }

    public void mtdRegistro(View view){
        Intent unos = new Intent(this,lista.class);

        SqliteHelper uno = new SqliteHelper(this,"bdUsuario.db",null,1);
        SQLiteDatabase datos = uno.getWritableDatabase();
        String Nombre = nombre.getText().toString();
        String Apellido = apellido.getText().toString();
        String Edad = edad.getText().toString();
        String Documento = documento.getText().toString();
        if (!Nombre.isEmpty() || !Apellido.isEmpty() || !Edad.isEmpty() || !Documento.isEmpty()){
            ContentValues valores = new ContentValues() ;
            valores.put("Documento",Documento);
            valores.put("Nombre",Nombre);
            valores.put("Apellido",Apellido);
            valores.put("Edad",Edad);
            datos.insert("Persona",null,valores);
            nombre.setText("");
            apellido.setText("");
            edad.setText("");
            documento.setText("");
            Toast.makeText(this, "Registro Realizado con exito", Toast.LENGTH_SHORT).show();
            startActivity(unos);

        }else{
            Toast.makeText(this, "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void mtdBuscar(View view){

        SqliteHelper base = new SqliteHelper(this,"bdUsuario.db",null,1);
        SQLiteDatabase datos = base.getWritableDatabase();
        String Documento =documento.getText().toString();
        if (!Documento.isEmpty()){
            Cursor cursor = datos.rawQuery("Select Nombre,Apellido,Edad from Persona where Documento = "+Documento,null);
            if (cursor.moveToFirst()){
                nombre.setText(cursor.getString(0));
                apellido.setText(cursor.getString(1));
                edad.setText(cursor.getString(2));
                datos.close();
            }else{
                Toast.makeText(this, "No existe un Usuario con este numero de documento", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "ingresar un documento antes de buscar por favor", Toast.LENGTH_SHORT).show();
        }

    }
    public void mtdModificar(View view){

        SqliteHelper base = new SqliteHelper(this,"bdUsuario.db",null,1);
        SQLiteDatabase datos = base.getWritableDatabase();
        String Nombre = nombre.getText().toString();
        String Apellido = apellido.getText().toString();
        String Edad = edad.getText().toString();
        String Documento = documento.getText().toString();
        if (!Nombre.isEmpty() || !Apellido.isEmpty() || !Edad.isEmpty() || !Documento.isEmpty()){
            ContentValues valores= new ContentValues();
            valores.put("Documento",Documento);
            valores.put("Nombre",Nombre);
            valores.put("Apellido",Apellido);
            valores.put("Edad",Edad);
            int cursor = datos.update("Persona",valores,"Documento ="+Documento,null);
            if (cursor>0){
                Toast.makeText(this, "Persona Actualizada con exito", Toast.LENGTH_SHORT).show();
                documento.setText("");
                nombre.setText("");
                apellido.setText("");
                edad.setText("");
                datos.close();
            }else{
                Toast.makeText(this, "No existe una persona con ese documento", Toast.LENGTH_SHORT).show();
                datos.close();
            }

        }else{
            Toast.makeText(this, "Debe llenar todos los campos :v", Toast.LENGTH_SHORT).show();
        }
    }

    public void mtdEliminar(View view){

        SqliteHelper base = new SqliteHelper(this,"bdUsuario.db",null,1);
        SQLiteDatabase datos = base.getWritableDatabase();
        String Documento = documento.getText().toString();
        if (!Documento.isEmpty()){
            int uno = datos.delete("Persona","Documento ="+Documento,null);
            if (uno>0){
                Toast.makeText(this, "Usuario eliminado con exito", Toast.LENGTH_SHORT).show();
                documento.setText("");
                nombre.setText("");
                apellido.setText("");
                edad.setText("");
                datos.close();
            }else{
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                datos.close();
            }
        }else{
            Toast.makeText(this, "Por favor ingresar un documento", Toast.LENGTH_SHORT).show();
        }

    }


}
