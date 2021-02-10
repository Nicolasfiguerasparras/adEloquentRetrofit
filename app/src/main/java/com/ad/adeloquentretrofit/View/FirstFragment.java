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

public class FirstFragment extends Fragment {

    Button btnAdminFragment, btnClientFragment;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModel viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        final NavController navC = Navigation.findNavController(view);
        btnAdminFragment = view.findViewById(R.id.btnAdminFragment);
        btnClientFragment = view.findViewById(R.id.btnClientFragment);

        btnAdminFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_firstFragment_to_fragmentAdmin);
            }
        });

        btnClientFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navC.navigate(R.id.action_firstFragment_to_clienteFragment);
            }
        });
    }
}