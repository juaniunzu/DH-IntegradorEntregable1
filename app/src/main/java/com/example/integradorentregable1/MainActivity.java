package com.example.integradorentregable1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AnimalFragment.AnimalFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pegar el fragment
        AnimalFragment animalFragment = new AnimalFragment();
        pegarFragment(animalFragment);




    }

    @Override
    public void onClickAnimalDesdeFragment(Animal unAnimal) {

        Intent mainADetail = new Intent(MainActivity.this, DetailActivity.class);
        Bundle datosADetail = new Bundle();
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
