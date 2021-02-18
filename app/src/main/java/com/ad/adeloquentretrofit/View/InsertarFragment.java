package com.ad.adeloquentretrofit.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.Model.Room.POJO.Reproducciones;
import com.ad.adeloquentretrofit.R;
import com.ad.adeloquentretrofit.ViewModel.ViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class InsertarFragment extends Fragment {

    ViewModel viewModel;
    TextInputEditText tietInsertarArtista, tietInsertarAlbum, tietInsertarTitulo, tietInsertarTonalidad, tietInsertarCaratula;
    Button btnCancelarInsertar, btnInsertarMusica;

    public InsertarFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_insertar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        final NavController navC = Navigation.findNavController(view);

        tietInsertarArtista = view.findViewById(R.id.tietInsertarArtista);
        tietInsertarAlbum = view.findViewById(R.id.tietInsertarAlbum);
        tietInsertarTitulo = view.findViewById(R.id.tietInsertarTitulo);
        tietInsertarTonalidad = view.findViewById(R.id.tietInsertarTonalidad);
        tietInsertarCaratula = view.findViewById(R.id.tietInsertarCaratula);

        btnCancelarInsertar = view.findViewById(R.id.btnCancelarInsertar);
        btnInsertarMusica = view.findViewById(R.id.btnInsertarMusica);

        btnCancelarInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_fragmentInsertar_to_fragmentAdmin);
            }
        });

        btnInsertarMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Musica musica = new Musica();
                musica.setArtista(tietInsertarArtista.getText().toString());
                musica.setAlbum(tietInsertarAlbum.getText().toString());
                musica.setTitulo(tietInsertarTitulo.getText().toString());
                musica.setTonalidad(tietInsertarTonalidad.getText().toString());
                musica.setUrlCaratula(tietInsertarCaratula.getText().toString());
                viewModel.storeMusicaRetrofit(musica).observe(getActivity(), new Observer<Musica>() {
                    @Override
                    public void onChanged(Musica musica) {
                        Log.v("xyz", "nextId: " + musica.getId());
                        Reproducciones reproducciones = new Reproducciones();
                        reproducciones.setIdMusica(musica.getId());
                        reproducciones.setReproducciones(0);
                        viewModel.storeReproduccionesRetrofit(reproducciones);
                        navC.navigate(R.id.action_fragmentInsertar_to_fragmentAdmin);
                    }
                });

            }
        });
    }
}