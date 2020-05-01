package com.example.integradorentregable1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent desdeMain = getIntent();
        Bundle datosDesdeMain = desdeMain.getExtras();

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(datosDesdeMain);

        pegarFragment(detailFragment);

    }

    private void pegarFragment(Fragment unFragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityDetailFragmentContainer,unFragment);
        fragmentTransaction.commit();
    }
}
