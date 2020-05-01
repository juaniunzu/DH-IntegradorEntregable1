package com.example.integradorentregable1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


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
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle desdedetailActivity = getArguments();
        Animal animal = (Animal) desdedetailActivity.getSerializable("animal");

        ImageView fragmentDetailImageView = view.findViewById(R.id.fragmentDetailImageView);
        TextView fragmentDetailTextViewNombre = view.findViewById(R.id.fragmentDetailTextViewNombre);
        TextView fragmentDetailTextViewDetalle = view.findViewById(R.id.fragmentDetailTextViewDetalle);

        fragmentDetailImageView.setImageResource(animal.getImagen());
        fragmentDetailTextViewNombre.setText(animal.getNombre());
        fragmentDetailTextViewDetalle.setText(animal.getDescripcion());

        return view;
    }
}
