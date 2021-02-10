package com.ad.adeloquentretrofit.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
import com.ad.adeloquentretrofit.Model.Room.POJO.Reproducciones;
import com.ad.adeloquentretrofit.R;
import com.ad.adeloquentretrofit.ViewModel.ViewModel;
import com.bumptech.glide.Glide;

public class VerItemAdminFragment extends Fragment {

    ViewModel viewModel;
    TextView tvVerAdminArtista, tvVerAdminTitulo, tvReproducciones;
    Button btnVerItemAdminEditar, btnVerItemAdminBorrar, btnVerItemAdminCancelar, btnReproducir;
    ImageView ivVerItemAdminCaratula;
    Musica musicaSeleccionada;
    Reproducciones reproducciones = new Reproducciones();

    public VerItemAdminFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ver_item_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navC = Navigation.findNavController(view);
        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        musicaSeleccionada = viewModel.getMusica();

        // View references
        tvVerAdminArtista = view.findViewById(R.id.tvVerAdminArtista);
        tvVerAdminTitulo = view.findViewById(R.id.tvVerAdminTitulo);
        ivVerItemAdminCaratula = view.findViewById(R.id.ivVerItemAdminCaratula);
        btnVerItemAdminBorrar = view.findViewById(R.id.btnVerItemAdminBorrar);
        btnVerItemAdminEditar = view.findViewById(R.id.btnVerItemAdminEditar);
        btnVerItemAdminCancelar = view.findViewById(R.id.btnVerItemAdminCancelar);
        btnReproducir = view.findViewById(R.id.btnReproducir);
        tvReproducciones = view.findViewById(R.id.tvReproducciones);

        tvVerAdminArtista.setText(musicaSeleccionada.getArtista());
        tvVerAdminTitulo.setText(musicaSeleccionada.getTitulo());

        viewModel.getReproduccionesRetrofit(musicaSeleccionada.getId()).observe(getActivity(), new Observer<Reproducciones>() {
            @Override
            public void onChanged(Reproducciones reproducciones) {
                tvReproducciones.setText(String.valueOf(reproducciones.getReproducciones()));
            }
        });

        // Image load
        String urlCaratulaActual = musicaSeleccionada.getUrlCaratula();
        Glide.with(this).load(urlCaratulaActual).into(ivVerItemAdminCaratula);

        // Button actions
        btnVerItemAdminCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_verItemAdminFragment_to_fragmentVerMusica);
            }
        });

        btnVerItemAdminBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteMusicaRetrofit(musicaSeleccionada.getId());
                //viewModel.deleteReproduccionesRetrofit(musicaSeleccionada.getId());
                navC.navigate(R.id.action_verItemAdminFragment_to_fragmentVerMusica);
            }
        });

        btnVerItemAdminEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_verItemAdminFragment_to_editarMusicaFragment);
            }
        });

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getReproduccionesRetrofit(musicaSeleccionada.getId()).observe(getActivity(), new Observer<Reproducciones>() {
                    @Override
                    public void onChanged(Reproducciones reproducciones) {
                        Reproducciones reproduccionesActuales = reproducciones;
                        reproduccionesActuales.setReproducciones(reproduccionesActuales.getReproducciones()+1);
                        viewModel.updateReproduccionesRetrofit(reproduccionesActuales.getId(), reproduccionesActuales);
                        navC.navigate(R.id.action_verItemAdminFragment_self);
                    }
                });
            }
        });
    }

}