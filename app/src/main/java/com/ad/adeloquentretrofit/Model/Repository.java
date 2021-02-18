package com.ad.adeloquentretrofit.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ad.adeloquentretrofit.Model.Client.MusicaClient;
import com.ad.adeloquentretrofit.Model.Client.ReproduccionesClient;
import com.ad.adeloquentretrofit.Model.Room.DAO.MusicaDao;
import com.ad.adeloquentretrofit.Model.Room.DAO.ReproduccionesDao;
import com.ad.adeloquentretrofit.Model.Room.MusicaDatabase;
import com.ad.adeloquentretrofit.Model.Room.POJO.Musica;
import com.ad.adeloquentretrofit.Model.Room.POJO.Reproducciones;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private MusicaDao musicaDao;
    private LiveData<List<Musica>> allMusica;
    private ReproduccionesDao reproduccionesDao;
    private LiveData<List<Reproducciones>> allReproducciones;
    private Retrofit retrofit;
    private Context context;
    private MusicaClient musicaClient;
    private ReproduccionesClient reproduccionesClient;

    private long lastInsertedIdMusica;

    public Repository(Context context) {
        MusicaDatabase database = MusicaDatabase.getInstance(context);
        musicaDao = database.musicaDao();
        allMusica = musicaDao.getAllMusic();

        reproduccionesDao = database.reproduccionesDao();
        allReproducciones = reproduccionesDao.getAllReproducciones();

        // Retrofit
        String url = "https://www.nicolasfiguerasparras.com/Retrofit/public/api/";
        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        this.context = context;
    }

    /* MUSICA RETROFIT */

        public MutableLiveData<List<Musica>> getListaMusicaRetrofit() {
            musicaClient = retrofit.create(MusicaClient.class);
            MutableLiveData<List<Musica>> liveDataMusica = new MutableLiveData<>();
            Call<List<Musica>> requestMusica = musicaClient.getAllMusica();
            requestMusica.enqueue(new Callback<List<Musica>>() {
                @Override
                public void onResponse(Call<List<Musica>> call, Response<List<Musica>> response) {
                    liveDataMusica.setValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Musica>> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al recuperar los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzGetMusica", t.getLocalizedMessage());
                }
            });

            return liveDataMusica;
        }

        public MutableLiveData<Musica> getMusicaRetrofit(long id) {
            musicaClient = retrofit.create(MusicaClient.class);
            MutableLiveData<Musica> liveDataMusica = new MutableLiveData<>();
            Call<Musica> requestMusica = musicaClient.getMusica(id);
            requestMusica.enqueue(new Callback<Musica>() {
                @Override
                public void onResponse(Call<Musica> call, Response<Musica> response) {
                    liveDataMusica.setValue(response.body());
                    Log.v("xyzGetMus", response.body().toString());
                }

                @Override
                public void onFailure(Call<Musica> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al obtener los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzGetSong", t.getLocalizedMessage());
                }
            });

            return liveDataMusica;
        }

        public void deleteMusicaRetrofit(long id) {
            musicaClient = retrofit.create(MusicaClient.class);
            Call<Void> requestMusica = musicaClient.deleteMusica(id);
            requestMusica.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(context, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al eliminar los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzDeleteMusica", t.getLocalizedMessage());
                }
            });
        }

        public MutableLiveData<Musica> storeMusicaRetrofit(Musica musica) {
            musicaClient = retrofit.create(MusicaClient.class);
            Call<Musica> requestMusica = musicaClient.storeMusic(musica);
            MutableLiveData<Musica> liveDataMusica = new MutableLiveData<>();
            requestMusica.enqueue(new Callback<Musica>() {
                @Override
                public void onResponse(Call<Musica> call, Response<Musica> response) {
                    liveDataMusica.setValue(response.body());
                    Toast.makeText(context, "Almacenado correctamente", Toast.LENGTH_SHORT).show();
                    Log.v("xyzStoreMusica", response.body().toString());
                }

                @Override
                public void onFailure(Call<Musica> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al insertar los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzStoreMusica", t.getLocalizedMessage());
                }
            });

            return liveDataMusica;
        }

        public void updateMusicaRetrofit(long id, Musica musica) {
            musicaClient = retrofit.create(MusicaClient.class);
            Call<Void> requestMusica = musicaClient.updateMusic(id, musica);
            requestMusica.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(context, "Datos actualizados", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al actualizar los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzUpdateMusica", t.getLocalizedMessage());
                }
            });
        }

        public long getLastInsertedIdMusica() {
            return lastInsertedIdMusica;
        }

        public void setLastInsertedIdMusica(long lastInsertedIdMusica) {
            this.lastInsertedIdMusica = lastInsertedIdMusica;
        }

    /* /musica retrofit */

    /* REPRODUCCIONES RETROFIT */

        public MutableLiveData<List<Reproducciones>> getListaReproduccionesRetrofit() {
            reproduccionesClient = retrofit.create(ReproduccionesClient.class);
            MutableLiveData<List<Reproducciones>> liveDataReproducciones = new MutableLiveData<>();
            Call<List<Reproducciones>> requestReproducciones = reproduccionesClient.getAllReproducciones();
            requestReproducciones.enqueue(new Callback<List<Reproducciones>>() {
                @Override
                public void onResponse(Call<List<Reproducciones>> call, Response<List<Reproducciones>> response) {
                    liveDataReproducciones.setValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Reproducciones>> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al recuperar los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzGetReproducciones", t.getLocalizedMessage());
                }
            });

            return liveDataReproducciones;
        }

        public void deleteReproduccionesRetrofit(long id) {
            reproduccionesClient = retrofit.create(ReproduccionesClient.class);
            Call<Void> requestReproducciones = reproduccionesClient.deleteReproducciones(id);
            requestReproducciones.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(context, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al eliminar los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzDeleteReproducciones", t.getLocalizedMessage());
                }
            });
        }

        public void storeMusicaRetrofit(Reproducciones reproducciones) {
            reproduccionesClient = retrofit.create(ReproduccionesClient.class);
            Call<Long> requestReproducciones = reproduccionesClient.storeReproducciones(reproducciones);
            requestReproducciones.enqueue(new Callback<Long>() {
                @Override
                public void onResponse(Call<Long> call, Response<Long> response) {
                    Toast.makeText(context, "Almacenado correctamente", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Long> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al insertar los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzStoreReproducciones", t.getLocalizedMessage());
                }
            });
        }

        public void updateReproduccionesRetrofit(long id, Reproducciones reproducciones) {
            reproduccionesClient = retrofit.create(ReproduccionesClient.class);
            Call<Void> requestReproducciones = reproduccionesClient.updateReproducciones(id, reproducciones);
            requestReproducciones.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(context, "Datos actualizados", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al actualizar los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzUpdateReproducciones", t.getLocalizedMessage());
                }
            });
        }

        public MutableLiveData<Reproducciones> getReproduccionesRetrofit(long id) {
            reproduccionesClient = retrofit.create(ReproduccionesClient.class);
            MutableLiveData<Reproducciones> liveDataReproducciones = new MutableLiveData<>();
            Call<Reproducciones> requestReproducciones = reproduccionesClient.getReproducciones(id);
            requestReproducciones.enqueue(new Callback<Reproducciones>() {
                @Override
                public void onResponse(Call<Reproducciones> call, Response<Reproducciones> response) {
                    liveDataReproducciones.setValue(response.body());
                    Log.v("xyzGetRep", response.body().toString());
                }

                @Override
                public void onFailure(Call<Reproducciones> call, Throwable t) {
                    Toast.makeText(context, "Ha habido un fallo al obtener los datos :(", Toast.LENGTH_SHORT).show();
                    Log.v("xyzGetSong", t.getLocalizedMessage());
                }
            });

            return liveDataReproducciones;
        }

    /* /reproducciones retrofit */


    /* ROOM no necesario

        public void insert(Musica musica) {
            new insertMusicaAsyncTask(musicaDao).execute(musica);
        }

        public void update(Musica musica) {
            new updateMusicaAsyncTask(musicaDao).execute(musica);
        }

        public void delete(Musica musica) {
            new deleteMusicaAsyncTask(musicaDao).execute(musica);
        }

        public LiveData<List<Musica>> getAllMusic() {
            return allMusica;
        }

        private static class insertMusicaAsyncTask extends AsyncTask<Musica, Void, Void> {

            private MusicaDao musicaDao;

            private insertMusicaAsyncTask(MusicaDao musicaDao) {
                this.musicaDao = musicaDao;
            }
            @Override
            protected Void doInBackground(Musica... musicas) {
                musicaDao.insert(musicas[0]);
                return null;
            }
        }

        private static class updateMusicaAsyncTask extends AsyncTask<Musica, Void, Void> {

            private MusicaDao musicaDao;

            private updateMusicaAsyncTask(MusicaDao musicaDao) {
                this.musicaDao = musicaDao;
            }
            @Override
            protected Void doInBackground(Musica... musicas) {
                musicaDao.update(musicas[0]);
                return null;
            }
        }

        private static class deleteMusicaAsyncTask extends AsyncTask<Musica, Void, Void> {

            private MusicaDao musicaDao;

            private deleteMusicaAsyncTask(MusicaDao musicaDao) {
                this.musicaDao = musicaDao;
            }
            @Override
            protected Void doInBackground(Musica... musicas) {
                musicaDao.delete(musicas[0]);
                return null;
            }
        }

     */
}
