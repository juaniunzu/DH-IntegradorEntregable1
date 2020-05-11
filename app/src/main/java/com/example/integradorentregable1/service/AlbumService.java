package com.example.integradorentregable1.service;

import com.example.integradorentregable1.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//estos son los servicios de Album. Es como un menu de lo que se
//puede pedir a la api en cuanto a albumes.
//los metodos que forman parte de esta interfaz no seran nunca sobreescritos
//ya que esta interfaz no sera nunca implementada. Estos metodos seran
//sobreescritos de manera automatica por Retrofit.

public interface AlbumService {

    //https://api.deezer.com/album/idAlbum - la ruta completa

    //esto devuelve un album
    @GET("album/{id}")
    Call<Album> getAlbum(@Path("id") String id);

    //esto devuelve un listado de albums
    @GET("album")
    Call<List<Album>> getAlbums();


}
