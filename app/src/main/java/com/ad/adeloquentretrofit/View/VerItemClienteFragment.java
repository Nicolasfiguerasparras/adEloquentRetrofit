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
import android.widget.ImageView;
import android.widget.TextView;

import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.R;
import com.ad.adeloquentretrofit.ViewModel.ViewModel;
import com.bumptech.glide.Glide;

public class VerItemClienteFragment extends Fragment {

    ViewModel viewModel;
    TextView tvVerClienteArtista, tvVerClienteTitulo;
    Button btnVerItemClienteCancelar;
    ImageView ivVerItemClienteCaratula;
    Musica musicaSeleccionada;


    public VerItemClienteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ver_item_cliente, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navC = Navigation.findNavController(view);
        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        musicaSeleccionada = viewModel.getMusica();

        // View references
        tvVerClienteArtista = view.findViewById(R.id.tvVerClienteArtista);
        tvVerClienteTitulo = view.findViewById(R.id.tvVerClienteTitulo);
        ivVerItemClienteCaratula = view.findViewById(R.id.ivVerItemClienteCaratula);
        btnVerItemClienteCancelar = view.findViewById(R.id.btnVerItemClienteCancelar);

        tvVerClienteArtista.setText(musicaSeleccionada.getArtista());
        tvVerClienteTitulo.setText(musicaSeleccionada.getTitulo());

        // Image load
        String urlCaratulaActual = musicaSeleccionada.getUrlCaratula();
        Glide.with(this).load(urlCaratulaActual).into(ivVerItemClienteCaratula);

        // Button actions
        btnVerItemClienteCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_verMusicaClienteFragment_to_clienteFragment);
            }
        });
    }
}