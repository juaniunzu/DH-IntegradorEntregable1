package com.example.integradorentregable1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// entre boquitas se pone lo que retornara el onCreateViewHolder.
// tambien hace que el holder del onBindViewHolder sea de tipo AnimalViewHolder,
// entonces nos evitamos un casteo
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private List<Animal> listaAnimales;
    private AnimalAdapterListener animalAdapterListener;

    public AnimalAdapter(List<Animal> listaAnimales, AnimalAdapterListener animalAdapterListener) {
        this.listaAnimales = listaAnimales;
        this.animalAdapterListener = animalAdapterListener;
    }

    @NonNull
    @Override
    //devuelve AnimalViewHolder porque se especifico en el extends de la clase
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celda_animal, parent, false);

        return (new AnimalViewHolder(view));
    }

    @Override
    //holder es tipo AnimalViewHolder porque se especifico en el extends de la clase
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {

        Animal animal = this.listaAnimales.get(position);
        //el onBind esta detallado abajo, es un metodo de la clase AnimalViewHolder ("modulacion")
        holder.onBind(animal);
    }

    @Override
    public int getItemCount() {
        return this.listaAnimales.size();
    }

    //representacion java de la celda
    protected class AnimalViewHolder extends RecyclerView.ViewHolder{

        private ImageView celdaAnimalImageView;
        private TextView celdaAnimalTextView;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            celdaAnimalImageView = itemView.findViewById(R.id.celdaAnimalImageView);
            celdaAnimalTextView = itemView.findViewById(R.id.celdaAnimalTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animal animal = listaAnimales.get(getAdapterPosition());
                    animalAdapterListener.onClickAnimal(animal);

                }
            });

        }

        //este metodo se llama arriba en el onBindViewHolder, metodo que le da los datos del objeto a la celda
        public void onBind(Animal unAnimal){

            celdaAnimalImageView.setImageResource(unAnimal.getImagen());
            celdaAnimalTextView.setText(unAnimal.getNombre());

        }
    }

    //creo interfaz escuchadora que debera ser implementada por el fragment que se desee sea escuchador de este adapter
    public interface AnimalAdapterListener{
        void onClickAnimal(Animal unAnimal);
    }


}
