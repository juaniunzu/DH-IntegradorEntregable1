package com.example.integradorentregable1.dao;

import com.example.integradorentregable1.R;
import com.example.integradorentregable1.model.Animal;

import java.util.ArrayList;
import java.util.List;

//se crea esta clase solo para que tenga el metodo de devolver lista de animales. Se pone abstracta porque su funcion
//solo es tener este metodo, y no nos interesa que se pueda instanciar. Es buena practica porque mantengo la actividad
//mas ordenada, con menos codigo, y ademas, el momento en el que la lista pueda ser traida de otra fuente,
//directamente se toca este modulo.
public abstract class AnimalDao {

    //static para que pueda llamarse sin ser instanciada la clase
    public static List<Animal> getAnimales(){
        List<Animal> listaADevolver = new ArrayList<>();
        listaADevolver.add(new Animal("Perro 1", R.drawable.perro1, "Este perro se ve muy piola, ademas es recontra guardian y se porta muy bien, le gusta salir a pasear a la plaza." ));
        listaADevolver.add(new Animal("Perro 2", R.drawable.perro2, "Este perro se porta muy mal, se lleva mal con los chicos y es peligroso para la comunidad. No le gusta socializar."));
        listaADevolver.add(new Animal("Perro 3", R.drawable.perro3, "Este perro es un verdadero peligro para la humanidad, solo le gusta atacar humanos, especialmente si son bebes."));
        listaADevolver.add(new Animal("Perro 4", R.drawable.perro4, "A este perro solo le gusta comer y dormir, no hace otra cosa en todo el dia, es mimoso y tranquilo. Se lleva bien con otras mascotas"));
        listaADevolver.add(new Animal("Perro 5", R.drawable.perro5, "Este perro es el mas amigable de todos, ama los gatos y los niños, es obediente e inteligente, aprende rapido y es muy limpio."));
        listaADevolver.add(new Animal("Perro 1", R.drawable.perro1, "Este perro se ve muy piola, ademas es recontra guardian y se porta muy bien, le gusta salir a pasear a la plaza." ));
        listaADevolver.add(new Animal("Perro 2", R.drawable.perro2, "Este perro se porta muy mal, se lleva mal con los chicos y es peligroso para la comunidad. No le gusta socializar."));
        listaADevolver.add(new Animal("Perro 3", R.drawable.perro3, "Este perro es un verdadero peligro para la humanidad, solo le gusta atacar humanos, especialmente si son bebes."));
        listaADevolver.add(new Animal("Perro 4", R.drawable.perro4, "A este perro solo le gusta comer y dormir, no hace otra cosa en todo el dia, es mimoso y tranquilo. Se lleva bien con otras mascotas"));
        listaADevolver.add(new Animal("Perro 5", R.drawable.perro5, "Este perro es el mas amigable de todos, ama los gatos y los niños, es obediente e inteligente, aprende rapido y es muy limpio."));
        listaADevolver.add(new Animal("Perro 1", R.drawable.perro1, "Este perro se ve muy piola, ademas es recontra guardian y se porta muy bien, le gusta salir a pasear a la plaza." ));
        listaADevolver.add(new Animal("Perro 2", R.drawable.perro2, "Este perro se porta muy mal, se lleva mal con los chicos y es peligroso para la comunidad. No le gusta socializar."));
        listaADevolver.add(new Animal("Perro 3", R.drawable.perro3, "Este perro es un verdadero peligro para la humanidad, solo le gusta atacar humanos, especialmente si son bebes."));
        listaADevolver.add(new Animal("Perro 4", R.drawable.perro4, "A este perro solo le gusta comer y dormir, no hace otra cosa en todo el dia, es mimoso y tranquilo. Se lleva bien con otras mascotas"));
        listaADevolver.add(new Animal("Perro 5", R.drawable.perro5, "Este perro es el mas amigable de todos, ama los gatos y los niños, es obediente e inteligente, aprende rapido y es muy limpio."));

        return listaADevolver;

    }


}
