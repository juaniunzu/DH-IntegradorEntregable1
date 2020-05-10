package com.example.integradorentregable1.view;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.integradorentregable1.controller.AnimalController;
import com.example.integradorentregable1.model.Animal;
import com.example.integradorentregable1.dao.AnimalDao;
import com.example.integradorentregable1.R;
import com.example.integradorentregable1.util.ResultListener;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
//implementa listener del adapter
public class AnimalFragment extends Fragment implements AnimalAdapter.AnimalAdapterListener {

    //tiene el listener como atributo para poder acceder al metodo onClick sobreescrito.
    //no es necesario pedirlo en el constructor, el constructor del fragment debe estar siempre vacio.
    private AnimalFragmentListener animalFragmentListener;
    private RecyclerView fragmentAnimalRecyclerView;

    public AnimalFragment() {
        // Required empty public constructor
    }

    @Override
    //es cuando el fragment conoce al contexto donde se acaba de pegar
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.animalFragmentListener = (AnimalFragmentListener) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //inflo el xml del fragment
        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        //busco el recycler view del fragment
        fragmentAnimalRecyclerView = view.findViewById(R.id.fragmentAnimalRecyclerView);

        //creo controller que tiene el metodo para traer datos segun haya internet o no
        AnimalController animalController = new AnimalController();

        //le llamo el metodo getAnimals y le paso como parametro la interfaz ResultListener,
        //la misma pide sobreescribir el onFinish, que es lo que se ejecutará cuando corra el
        //getAnimals del controller. en el onFinish se corre método que crea adapter, layout manager
        //y los asocia al recycler view. La lista que toma de parametro será diferente segun qué devuelva
        //el getAnimals (si hay inet, la trae, si no hay, usa el AnimalDao que devuelve una lista fija.
        animalController.getAnimals(new ResultListener<List<Animal>>() {
            @Override
            public void onFinish(List<Animal> result) {
                cargarRecycler(result);
            }
        });

        return view;
    }

    private void cargarRecycler(List<Animal> listaAnimales) {
        AnimalAdapter animalAdapter = new AnimalAdapter(listaAnimales, this);
        //creo layout manager, falso para que la lista no se muestre de atras para adelante
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        //seteo adapter y layout manager al recyclerView
        fragmentAnimalRecyclerView.setAdapter(animalAdapter);
        fragmentAnimalRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    //sobreescribo el onClickAnimal, metodo de la interfaz que implementa este fragment.
    //uso el listener atributo de este fragment para llamar el metodo onClickDesdeFragment y le paso como parametro
    //el animal que viene desde el click del adapter
    public void onClickAnimal(Animal unAnimal) {
        this.animalFragmentListener.onClickAnimalDesdeFragment(unAnimal);
    }

    //creo interfaz escuchadora que debera ser implementada por la activity donde se desee escuchar los eventos del fragment
    public interface AnimalFragmentListener{
        void onClickAnimalDesdeFragment(Animal unAnimal);
    }
}
