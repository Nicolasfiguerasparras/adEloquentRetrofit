package com.ad.adeloquentretrofit.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.R;
import com.ad.adeloquentretrofit.ViewModel.ViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class EditarMusicaFragment extends Fragment {

    ViewModel viewModel;
    Musica musicaSeleccionada;
    TextInputEditText tietEditarArtista, tietEditarAlbum, tietEditarTitulo, tietEditarTonalidad, tietEditarCaratula;
    Button btnEditarCancelar, btnEditarConfirmar;


    public EditarMusicaFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_editar_musica, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navC = Navigation.findNavController(view);
        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        musicaSeleccionada = viewModel.getMusica();

        // Init views
        btnEditarCancelar = view.findViewById(R.id.btnEditarCancelar);
        btnEditarConfirmar = view.findViewById(R.id.btnEditarConfirmar);
        tietEditarArtista = view.findViewById(R.id.tietEditarArtista);
        tietEditarAlbum = view.findViewById(R.id.tietEditarAlbum);
        tietEditarTitulo = view.findViewById(R.id.tietEditarTitulo);
        tietEditarTonalidad = view.findViewById(R.id.tietEditarTonalidad);
        tietEditarCaratula = view.findViewById(R.id.tietEditarCaratula);

        // Load data on TIET
        tietEditarArtista.setText(musicaSeleccionada.getArtista());
        tietEditarAlbum.setText(musicaSeleccionada.getAlbum());
        tietEditarTitulo.setText(musicaSeleccionada.getTitulo());
        tietEditarTonalidad.setText(musicaSeleccionada.getTonalidad());
        tietEditarCaratula.setText(musicaSeleccionada.getUrlCaratula());


        // Buttons
        btnEditarConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Musica updatedMusica = new Musica();
                updatedMusica.setId(musicaSeleccionada.getId());
                updatedMusica.setArtista(tietEditarArtista.getText().toString());
                updatedMusica.setAlbum(tietEditarAlbum.getText().toString());
                updatedMusica.setTitulo(tietEditarTitulo.getText().toString());
                updatedMusica.setTonalidad(tietEditarTonalidad.getText().toString());
                updatedMusica.setUrlCaratula(tietEditarCaratula.getText().toString());

                viewModel.updateMusicaRetrofit(musicaSeleccionada.getId(), updatedMusica);
                navC.navigate(R.id.action_editarMusicaFragment_to_verItemAdminFragment);
            }
        });

        btnEditarCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_editarMusicaFragment_to_verItemAdminFragment);
            }
        });

    }
}