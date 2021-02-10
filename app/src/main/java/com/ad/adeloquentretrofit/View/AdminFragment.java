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

import com.ad.adeloquentretrofit.R;
import com.ad.adeloquentretrofit.ViewModel.ViewModel;

public class AdminFragment extends Fragment {

    Button btnVerMusicaFragment, btnInsertarFragment, btnAdminVolver;

    public AdminFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        final NavController navC = Navigation.findNavController(view);
        btnVerMusicaFragment = view.findViewById(R.id.btnVerMusicaFragment);
        btnVerMusicaFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_fragmentAdmin_to_fragmentVerMusica);
            }
        });

        btnInsertarFragment = view.findViewById(R.id.btnInsertarFragment);
        btnInsertarFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_fragmentAdmin_to_fragmentInsertar);
            }
        });

        btnAdminVolver = view.findViewById(R.id.btnAdminVolver);
        btnAdminVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_fragmentAdmin_to_firstFragment);
            }
        });
    }
}