package com.example.integradorentregable1.util;

//listener de tipo T, cuando se implementa en una vista,
//ésta al sobreescribir el método tendrá que realizar una
//accion con el resultado que será tipo T. Se usa en metodos
//asincronicos, ya que los mismos solo pueden devolver void.
//de esta manera logramos que se haga algo con lo que recibe el escuchador.
public interface ResultListener<T> {

    void onFinish(T result);

}
