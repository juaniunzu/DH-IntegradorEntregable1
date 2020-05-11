package com.example.integradorentregable1.dao;

import com.example.integradorentregable1.model.Album;
import com.example.integradorentregable1.service.AlbumService;
import com.example.integradorentregable1.util.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//si quiero hacer varios daos para varios pojos pero que todos traigan de la misma url,
//hago una clase dao padre y dps hago hijos (por ej, si de deezer quiero traer albumes,
//artistas, temas, etc, todos van a venir de la misma url base)
public class AlbumDao {

    private static String BASE_URL = "https://api.deezer.com";
    private Retrofit retrofit;
    private AlbumService albumService;

    public AlbumDao() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //esta linea magica es la que hace que Retrofit implemente y sobreescriba los metodos de la interfaz albumService.
        this.albumService = retrofit.create(AlbumService.class);

    }

    //recibe como parametro el id del album que quiero traer y un escuchador, el escuchador es
    //necesario porque este metodo es asincronico (devuelve void si o si) entonces necesito
    //el onFinish para decir qué hacer con el album que recibo al final.
    public void getAlbum(String id, final ResultListener<Album> resultListenerFromController){

        //traigo la llamada del albumService, retrofit ya se encargo de sobreescribir el getAlbum de la interfaz
        Call<Album> albumCall = this.albumService.getAlbum(id);

        //la pongo en cola (cada peticion al servicio web se realiza en orden "de llegada").
        //se le pasa Callback que es "la contestacion" de la llamada. Esta pide sobreescribir
        //qué hacer cuando la respuesta es correcta y cuando la llamada falla.
        albumCall.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {

                //si la response esta correcta sin problemas:
                if(response.isSuccessful()){
                    //a la response se le puede pedir, entre otras cosas, el body. esto es el
                    //objeto que devuelve
                    Album album = response.body();

                    //como no lo puedo devolver porque esto es asincronico, uso el escuchador
                    resultListenerFromController.onFinish(album);
                } else {
                    //tomar decision en caso de error en la response
                }

            }

            //la llamada falla
            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
