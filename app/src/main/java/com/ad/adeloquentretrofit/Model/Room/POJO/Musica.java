package com.ad.adeloquentretrofit.Model.Room.POJO;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "musica")
public class Musica {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "artista")
    private String artista;

    @NonNull
    @ColumnInfo(name = "album")
    private String album;

    @NonNull
    @ColumnInfo(name = "titulo")
    private String titulo;

    @NonNull
    @ColumnInfo(name = "tonalidad")
    private String tonalidad;

    @NonNull
    @ColumnInfo(name = "urlCaratula")
    private String urlCaratula;

    public Musica() {
    }

    public Musica(@NonNull String artista, @NonNull String album, @NonNull String titulo, @NonNull String tonalidad, @NonNull String urlCaratula) {
        this.artista = artista;
        this.album = album;
        this.titulo = titulo;
        this.tonalidad = tonalidad;
        this.urlCaratula = urlCaratula;
    }

    public Musica(long id, @NonNull String artista, @NonNull String album, @NonNull String titulo, @NonNull String tonalidad, @NonNull String urlCaratula) {
        this.id = id;
        this.artista = artista;
        this.album = album;
        this.titulo = titulo;
        this.tonalidad = tonalidad;
        this.urlCaratula = urlCaratula;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getArtista() {
        return artista;
    }

    public void setArtista(@NonNull String artista) {
        this.artista = artista;
    }

    @NonNull
    public String getAlbum() {
        return album;
    }

    public void setAlbum(@NonNull String album) {
        this.album = album;
    }

    @NonNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    @NonNull
    public String getTonalidad() {
        return tonalidad;
    }

    public void setTonalidad(@NonNull String tonalidad) {
        this.tonalidad = tonalidad;
    }

    @NonNull
    public String getUrlCaratula() {
        return urlCaratula;
    }

    public void setUrlCaratula(@NonNull String urlCaratula) {
        this.urlCaratula = urlCaratula;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", artista='" + artista + '\'' +
                ", album='" + album + '\'' +
                ", titulo='" + titulo + '\'' +
                ", tonalidad='" + tonalidad + '\'' +
                ", urlCaratula='" + urlCaratula + '\'' +
                '}';
    }
}
