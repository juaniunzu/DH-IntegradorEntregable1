package com.example.integradorentregable1.controller;

import com.example.integradorentregable1.dao.AlbumDao;
import com.example.integradorentregable1.model.Album;
import com.example.integradorentregable1.util.ResultListener;

public class AlbumController {

    private AlbumDao albumDao;

    public AlbumController() {
        this.albumDao = new AlbumDao();
    }

    //listener from view porque el controlador le avisa a la vista, asi como el dao le avisa a este controlador
    public void getAlbum(String id, final ResultListener<Album> resultListenerFromView){

        this.albumDao.getAlbum(id, new ResultListener<Album>() {
            @Override
            public void onFinish(Album result) {
                resultListenerFromView.onFinish(result);
            }
        });


    }
}
