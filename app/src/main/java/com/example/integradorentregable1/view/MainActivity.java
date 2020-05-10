package com.example.integradorentregable1.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.integradorentregable1.model.Animal;
import com.example.integradorentregable1.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements AnimalFragment.AnimalFragmentListener, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout activityMainDrawerLayout;
    private NavigationView activityMainNavigationView;
    private CardView navHeaderCardView;
    private View headerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainDrawerLayout = findViewById(R.id.activityMainDrawerLayout);
        activityMainNavigationView = findViewById(R.id.activityMainNavigationView);
        navHeaderCardView = findViewById(R.id.navHeaderCardView);
        headerView = activityMainNavigationView.getHeaderView(0);

        //se le pone listener al navigation view, se pasa esta actividad que previamente
        //implemento la interfaz escuchadora. Abajo se sobreescribe metodo onNavigationItemSelected
        activityMainNavigationView.setNavigationItemSelectedListener(this);


        //pegar el fragment
        AnimalFragment animalFragment = new AnimalFragment();
        pegarFragment(animalFragment);

    }

    @Override
    //sobreescribo este metodo de la interfaz que implementa esta activity.
    //el parametro toma el animal que viene desde el fragment, que a su vez
    //viene desde el adapter
    public void onClickAnimalDesdeFragment(Animal unAnimal) {

        //intent hacia la activity de detalle, con su respectivo bundle
        Intent mainADetail = new Intent(MainActivity.this, DetailActivity.class);
        Bundle datosADetail = new Bundle();

        //previo a este paso necesito implementar "Serializable" al objeto a guardar en el bundle
        datosADetail.putSerializable("animal", unAnimal);
        mainADetail.putExtras(datosADetail);
        startActivity(mainADetail);

    }

    private void pegarFragment(Fragment unFragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityMainFragmentContainer,unFragment);
        fragmentTransaction.commit();
    }

    @Override
    //listener del click en cada item del menu del navigationView
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //se hace un switch con todos los items del menu,
        //segun cual se clickee se hara una accion distinta
        switch (item.getItemId()){
            case R.id.navigationMenuInicio:
                Toast.makeText(this, "Apretaron en Inicio", Toast.LENGTH_SHORT).show();
                activityMainDrawerLayout.closeDrawers();
                break;
            case R.id.navigationMenuFavoritos:
                Toast.makeText(this, "Apretaron en Favoritos", Toast.LENGTH_SHORT).show();
                activityMainDrawerLayout.closeDrawers();
                break;
            default:
                Toast.makeText(this, "En construccion", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
