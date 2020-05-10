package com.example.integradorentregable1.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.integradorentregable1.model.Animal;
import com.example.integradorentregable1.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //inflo el xml del fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        //guardo en variable local el bundle que viene de la activity
        Bundle desdedetailActivity = getArguments();
        //le saco el animal al bundle, necesito castearlo ya que el getSerializable devuelve un Serializable
        Animal animal = (Animal) desdedetailActivity.getSerializable("animal");

        //enlazo los elementos de la vista con el xml (se pueden poner como atributos en vez de variables locales)
        ImageView fragmentDetailImageView = view.findViewById(R.id.fragmentDetailImageView);
        TextView fragmentDetailTextViewNombre = view.findViewById(R.id.fragmentDetailTextViewNombre);
        TextView fragmentDetailTextViewDetalle = view.findViewById(R.id.fragmentDetailTextViewDetalle);

        //seteo imagenes y textos
        fragmentDetailImageView.setImageResource(animal.getImagen());
        fragmentDetailTextViewNombre.setText(animal.getNombre());
        fragmentDetailTextViewDetalle.setText(animal.getDescripcion());

        return view;
    }
}
