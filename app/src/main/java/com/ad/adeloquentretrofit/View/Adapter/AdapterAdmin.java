package com.ad.adeloquentretrofit.View.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.R;
import com.ad.adeloquentretrofit.ViewModel.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterAdmin extends RecyclerView.Adapter<AdapterAdmin.Holder> {

    private Context context;
    private List<Musica> musicaList = new ArrayList<>();
    private NavController navController;
    private Activity activity;
    private ViewModel viewModel;

    public AdapterAdmin(List<Musica> musicaList, NavController navController, Activity activity, Context context) {
        this.musicaList = musicaList;
        this.navController = navController;
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_musica,
                                                                        parent, false);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) activity).get(ViewModel.class);
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Musica currentMusica = musicaList.get(position);
        holder.tvIdItem.setText(String.valueOf(currentMusica.getId()));
        holder.tvArtistaItem.setText(currentMusica.getArtista());
        holder.tvAlbumItem.setText(currentMusica.getAlbum());
        holder.tvTituloItem.setText(currentMusica.getTitulo());
        holder.tvTonalidadItem.setText(currentMusica.getTonalidad());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Musica musica = musicaList.get(position);
                viewModel.setMusica(musica);
                navController.navigate(R.id.action_fragmentVerMusica_to_verItemAdminFragment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return musicaList.size();
    }

    public void setMusicaList(List<Musica> musicaList) {
        this.musicaList = musicaList;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView tvIdItem, tvArtistaItem, tvAlbumItem, tvTituloItem, tvTonalidadItem;
        ConstraintLayout parentLayout;

        public Holder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.itemParentLayout);

            tvIdItem = itemView.findViewById(R.id.tvIdItem);
            tvArtistaItem = itemView.findViewById(R.id.tvArtistaItem);
            tvAlbumItem = itemView.findViewById(R.id.tvAlbumItem);
            tvTituloItem = itemView.findViewById(R.id.tvTituloItem);
            tvTonalidadItem = itemView.findViewById(R.id.tvTonalidadItem);
        }
    }
}
