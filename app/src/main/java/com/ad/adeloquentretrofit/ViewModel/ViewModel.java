package com.ad.adeloquentretrofit.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ad.adeloquentretrofit.Model.Repository;
import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.Model.Room.POJO.Reproducciones;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Musica>> allMusica;
    private LiveData<List<Reproducciones>> allReproducciones;

    private Musica musica;
    private Reproducciones reproducciones;
    private long lastInsertedId;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    /*
        public void insert(Musica musica) {
            repository.insert(musica);
        }

        public void update(Musica musica) {
            repository.update(musica);
        }

        public void delete(Musica musica) {
            repository.delete(musica);
        }

        public LiveData<List<Musica>> getAllMusic() {
            return repository.getAllMusic();
        }
     */

    /* MUSICA */

        public MutableLiveData<List<Musica>> getListaMusicaRetrofit() {
            return repository.getListaMusicaRetrofit();
        }

        public void deleteMusicaRetrofit(long id) {
            repository.deleteMusicaRetrofit(id);
            repository.deleteReproduccionesRetrofit(id);
        }

        public MutableLiveData<Musica> getMusicaRetrofit(long id) {
            return repository.getMusicaRetrofit(id);
        }

        public MutableLiveData<Musica> storeMusicaRetrofit(Musica musica) {
            return repository.storeMusicaRetrofit(musica);
        }

        public void updateMusicaRetrofit(long id, Musica musica) {
            repository.updateMusicaRetrofit(id, musica);
        }

        public void setMusica(Musica musica) {
            this.musica = musica;
        }

        public Musica getMusica() {
            return musica;
        }

        public long getLastInsertedId() {
            return lastInsertedId;
        }

        public void setLastInsertedId(long lastInsertedId) {
            this.lastInsertedId = lastInsertedId;
        }

    /* /musica */

    /* REPRODUCCIONES */

        public MutableLiveData<List<Reproducciones>> getListaReproduccionesRetrofit() {
            return repository.getListaReproduccionesRetrofit();
        }

        public MutableLiveData<Reproducciones> getReproduccionesRetrofit(long id) {
            return repository.getReproduccionesRetrofit(id);
        }

        public void deleteReproduccionesRetrofit(long id) {
            repository.deleteReproduccionesRetrofit(id);
        }

        public void storeReproduccionesRetrofit(Reproducciones reproducciones) {
            repository.storeMusicaRetrofit(reproducciones);
        }

        public void updateReproduccionesRetrofit(long id, Reproducciones reproducciones) {
            repository.updateReproduccionesRetrofit(id, reproducciones);
        }

    /* /reproducciones */
}
