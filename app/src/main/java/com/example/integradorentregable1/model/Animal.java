package com.example.integradorentregable1.model;

//POJO - objeto a representar en la celda

import java.io.Serializable;

//se le hace implementar serializable para que pueda meterlo entero adentro de un bundle como "serializable"
public class Animal implements Serializable {

    private String nombre;
    private Integer imagen;
    private String descripcion;

    public Animal(String nombre, Integer imagen, String descripcion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
