package com.ad.adeloquentretrofit.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.R;
import com.ad.adeloquentretrofit.View.Adapter.AdapterAdmin;
import com.ad.adeloquentretrofit.ViewModel.ViewModel;

import java.util.ArrayList;
import java.util.List;


public class VerMusicaAdminFragment extends Fragment {

    private ViewModel viewModel;
    private List<Musica> musicaList = new ArrayList<>();
    private Button btnVerMusicaVolver;

    public VerMusicaAdminFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ver_musica_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navC = Navigation.findNavController(view);
        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);

        btnVerMusicaVolver = view.findViewById(R.id.btnVerMusicaVolver);

        RecyclerView rv = view.findViewById(R.id.rvListaMusicaAdmin);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);

        final AdapterAdmin adapterAdmin = new AdapterAdmin(musicaList, navC, getActivity(), getActivity());
        rv.setAdapter(adapterAdmin);
        
        viewModel.getListaMusicaRetrofit().observe(getActivity(), new Observer<List<Musica>>() {
            @Override
            public void onChanged(List<Musica> musicas) {
                adapterAdmin.setMusicaList(musicas);
            }
        });

        btnVerMusicaVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_fragmentVerMusica_to_fragmentAdmin);
            }
        });

    }
}