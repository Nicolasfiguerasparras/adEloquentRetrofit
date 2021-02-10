package com.ad.adeloquentretrofit.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.ad.adeloquentretrofit.ViewModel.ViewModel;

public class MainActivity extends AppCompatActivity {

    Button btnAdminActivity, btnClientesActivity;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        btnAdminActivity = findViewById(R.id.btnAdminActivity);
        btnClientesActivity = findViewById(R.id.btnClientesActivity);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        btnAdminActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(MainActivity.this, AdminActivity.class);
                adminIntent.setData(viewModel);
                startActivity(adminIntent);
            }
        });

        btnClientesActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clientesIntent = new Intent(MainActivity.this, ClientesActivity.class);
                startActivity(clientesIntent);
            }
        });

 */
    }
}