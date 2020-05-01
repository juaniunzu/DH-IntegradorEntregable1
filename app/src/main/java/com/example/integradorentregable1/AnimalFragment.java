package com.example.integradorentregable1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
//implementa listener del adapter
public class AnimalFragment extends Fragment implements AnimalAdapter.AnimalAdapterListener {

    //tiene el listener como atributo para poder acceder al metodo onClick sobreescrito.
    //no es necesario pedirlo en el constructor, el constructor del fragment debe estar siempre vacio.
    private AnimalFragmentListener animalFragmentListener;

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


        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        //se usa como variable local, pero podría ponerse como atributo del fragment
        RecyclerView fragmentAnimalRecyclerView = view.findViewById(R.id.fragmentAnimalRecyclerView);

        //creo lista que sera parametro en la construccion del adapter
        List<Animal> listaAnimales = ProveedorDeAnimales.getAnimales();
        //creo adapter, como parametro listener uso esta mismo fragment que es escuchador
        AnimalAdapter animalAdapter = new AnimalAdapter(listaAnimales, this);
        //creo layout manager, falso para que la lista no se muestre de atras para adelante
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false);

        //seteo adapter y layout manager al recyclerView
        fragmentAnimalRecyclerView.setAdapter(animalAdapter);
        fragmentAnimalRecyclerView.setLayoutManager(linearLayoutManager);

        return view;
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
