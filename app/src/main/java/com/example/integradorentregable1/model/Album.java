package com.example.integradorentregable1.model;

import com.google.gson.annotations.SerializedName;

public class Album {

    //los atributos se tienen que llamar igual a lo que devuelve el http request, si no no los reconoce,
    //salvo que se serialice (remapee) el nombre del atributo con lo que devuelve el get
    public Integer id;
    @SerializedName("title")
    public String titulo;
    public String cover_big;
    public Integer duration;

    public Album() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
