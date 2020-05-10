package com.example.integradorentregable1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.integradorentregable1.R;
import com.example.integradorentregable1.view.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent desdeMain = getIntent();
        Bundle datosDesdeMain = desdeMain.getExtras();

        //creo fragment y le seteo el bundle que viene desde el main ANTES DE PEGARLO
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(datosDesdeMain);

        //recien ahora lo puedo pegar
        pegarFragment(detailFragment);

    }

    private void pegarFragment(Fragment unFragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityDetailFragmentContainer,unFragment);
        fragmentTransaction.commit();
    }
}
