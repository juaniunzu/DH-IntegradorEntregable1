package com.example.integradorentregable1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements AnimalFragment.AnimalFragmentListener {

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
}
