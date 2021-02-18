package com.ad.adeloquentretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.R;
import com.ad.adeloquentretrofit.ViewModel.ViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
        //Musica musica = new Musica("Mefjus", "Manifest EP", "Pivot", "Ebm", "a");
        //viewModel.storeMusicaRetrofit(musica);
    }
}