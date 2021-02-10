package com.ad.adeloquentretrofit.Model.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ad.adeloquentretrofit.Model.Room.POJO.Reproducciones;

import java.util.List;

@Dao
public interface ReproduccionesDao {
    @Insert
    void insert(Reproducciones reproducciones);

    @Insert
    void update(Reproducciones reproducciones);

    @Insert
    void delete(Reproducciones reproducciones);

    @Query("SELECT * FROM reproducciones ORDER BY id DESC")
    LiveData<List<Reproducciones>> getAllReproducciones();
}
