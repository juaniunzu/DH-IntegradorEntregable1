package com.example.integradorentregable1.view;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.integradorentregable1.R;
import com.example.integradorentregable1.controller.AlbumController;
import com.example.integradorentregable1.model.Album;
import com.example.integradorentregable1.util.ResultListener;


public class AlbumFragment extends Fragment {

    private ImageView fragmentAlbumImageView;
    private TextView fragmentAlbumTextViewNombre;
    private TextView fragmentAlbumTextViewDuracion;

    public AlbumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album, container, false);

        fragmentAlbumImageView = view.findViewById(R.id.fragmentAlbumImageView);
        fragmentAlbumTextViewNombre = view.findViewById(R.id.fragmentAlbumTextViewNombre);
        fragmentAlbumTextViewDuracion = view.findViewById(R.id.fragmentAlbumTextViewDuracion);

        //creo controlador
        AlbumController albumController = new AlbumController();
        albumController.getAlbum("302127", new ResultListener<Album>() {
            @Override
            public void onFinish(Album result) {
                fragmentAlbumTextViewNombre.setText(result.getTitulo());
                fragmentAlbumTextViewDuracion.setText(result.getDuration().toString());
                Glide.with(AlbumFragment.this)
                        .load(result.getCover_big())
                        .centerCrop()
                        .into(fragmentAlbumImageView);
            }
        });


        return view;
    }
}
