package com.example.integradorentregable1.util;

//listener de tipo T, cuando se implementa en una vista,
//ésta al sobreescribir el método tendrá que realizar una
//accion con el resultado que será tipo T
public interface ResultListener<T> {

    void onFinish(T result);

}
