package com.example.integradorentregable1.controller;

import com.example.integradorentregable1.dao.AnimalDao;
import com.example.integradorentregable1.model.Animal;
import com.example.integradorentregable1.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

//sera la clase encargada de unir las vistas con el modelo. En este
//caso, tiene un metodo que si hay internet trae el dato desde la web
//y caso contrario, llama al dao que tiene el metodo getAnimales.
public class AnimalController {

    public void getAnimals(ResultListener<List<Animal>> resultListenerDeLaView){
        if(hayInternet()){
            //ir a internet y buscar los animales
            new ArrayList<>();
        }
        else {
            //los busco en el AnimalDao que esta estatico
            resultListenerDeLaView.onFinish(AnimalDao.getAnimales());
        }
    }

    private boolean hayInternet() {
        return false;
    }
}
