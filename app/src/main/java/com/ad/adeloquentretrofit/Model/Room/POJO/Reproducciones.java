package com.ad.adeloquentretrofit.Model.Room.POJO;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reproducciones")
public class Reproducciones {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "idMusica")
    private long idMusica;

    @NonNull
    @ColumnInfo(name = "reproducciones")
    private long reproducciones;

    public Reproducciones() {
    }

    public Reproducciones(long idMusica, @NonNull long reproducciones) {
        this.idMusica = idMusica;
        this.reproducciones = reproducciones;
    }

    public Reproducciones(long id, long idMusica, @NonNull long reproducciones) {
        this.id = id;
        this.idMusica = idMusica;
        this.reproducciones = reproducciones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(long idMusica) {
        this.idMusica = idMusica;
    }

    @NonNull
    public long getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(@NonNull long reproducciones) {
        this.reproducciones = reproducciones;
    }

    @Override
    public String toString() {
        return "Reproducciones{" +
                "id=" + id +
                ", idMusica=" + idMusica +
                ", reproducciones='" + reproducciones + '\'' +
                '}';
    }
}
