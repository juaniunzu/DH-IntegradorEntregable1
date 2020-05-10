package com.example.integradorentregable1.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.integradorentregable1.model.Animal;
import com.example.integradorentregable1.R;

import java.util.List;

// entre boquitas se pone lo que retornara el onCreateViewHolder.
// tambien hace que el holder del onBindViewHolder sea de tipo AnimalViewHolder,
// entonces nos evitamos un casteo
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    //se pone listener como atributo para que lo pida el constructor, de esa manera
    //cuando creamos el adapter nos aseguramos que conozca quién lo escucha
    private List<Animal> listaAnimales;
    private AnimalAdapterListener animalAdapterListener;

    public AnimalAdapter(List<Animal> listaAnimales, AnimalAdapterListener animalAdapterListener) {
        this.listaAnimales = listaAnimales;
        this.animalAdapterListener = animalAdapterListener;
    }

    @NonNull
    @Override
    //metodo que crea la celda
    //devuelve AnimalViewHolder en vez de ViewHolder porque se especifico en el extends de la clase
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflador para pasar a View la celda xml
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //celda inflada a xml
        View view = layoutInflater.inflate(R.layout.celda_animal, parent, false);

        return (new AnimalViewHolder(view));
    }

    @Override
    //Le da los datos a la celda creada.
    //holder es tipo AnimalViewHolder en vez de ViewHolder porque se especifico en el
    //extends de la clase. Nos evitamos castearlo para que conozca el onBind
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {

        //tomo un animal determinado segun la posicion y lo guardo en variable local
        Animal animal = this.listaAnimales.get(position);
        //el onBind esta detallado abajo, es un metodo de la clase AnimalViewHolder ("modulacion").
        //uso como parametro el animal guardado arriba
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

            //se setea onClickListener a la celda
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //tomo el animal sobre el que se hizo click y lo guardo en variable local
                    Animal animal = listaAnimales.get(getAdapterPosition());
                    //uso el listener atributo del adapter y llamo el metodo onClickAnimal,
                    //le paso el animal guardado arriba como parametro. Este animal irá
                    //encadenado en cada listener hasta el main que lo guardara en un bundle.
                    animalAdapterListener.onClickAnimal(animal);

                }
            });

        }

        //este metodo se llama arriba en el onBindViewHolder, metodo que le da los datos del objeto a la celda.
        //se hace aca abajo para modular el codigo
        public void onBind(Animal unAnimal){

            celdaAnimalImageView.setImageResource(unAnimal.getImagen());
            celdaAnimalTextView.setText(unAnimal.getNombre());

        }
    }

    //creo interfaz escuchadora que debera ser implementada por el fragment que se desee sea escuchador de este adapter.
    //cada fragment debera sobreescribir este metodo para que se comporte como el quiera
    public interface AnimalAdapterListener{
        void onClickAnimal(Animal unAnimal);
    }


}
