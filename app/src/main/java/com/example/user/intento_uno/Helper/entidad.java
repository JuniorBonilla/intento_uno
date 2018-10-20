package com.example.user.intento_uno.Helper;

import java.io.Serializable;
import java.io.SerializablePermission;

public class entidad implements Serializable {

    private String Documento;
    private String Nombre;
    private String Edad;
    private String Apellido;

    public entidad(String documento, String nombre, String edad, String apellido) {
        Documento = documento;
        Nombre = nombre;
        Edad = edad;
        Apellido = apellido;
    }

    public entidad() {
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
}
