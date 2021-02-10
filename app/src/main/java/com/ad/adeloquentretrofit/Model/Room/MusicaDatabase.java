package com.ad.adeloquentretrofit.Model.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ad.adeloquentretrofit.Model.Room.DAO.MusicaDao;
import com.ad.adeloquentretrofit.Model.Room.DAO.ReproduccionesDao;
import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.Model.Room.POJO.Reproducciones;

@Database(entities = {Musica.class, Reproducciones.class}, version = 2, exportSchema = false)
public abstract class MusicaDatabase extends RoomDatabase {

    private static volatile MusicaDatabase instance;

    public abstract MusicaDao musicaDao();
    public abstract ReproduccionesDao reproduccionesDao();

    public static synchronized MusicaDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MusicaDatabase.class, "musicDatabase.sqlite")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
