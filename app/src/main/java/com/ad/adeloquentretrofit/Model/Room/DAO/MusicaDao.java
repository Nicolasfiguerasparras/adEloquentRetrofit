package com.ad.adeloquentretrofit.Model.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;

import java.util.List;

@Dao
public interface MusicaDao {

    @Insert
    void insert(Musica musica);

    @Insert
    void update(Musica musica);

    @Insert
    void delete(Musica musica);

    @Query("SELECT * FROM musica ORDER BY id DESC")
    LiveData<List<Musica>> getAllMusic();
}
