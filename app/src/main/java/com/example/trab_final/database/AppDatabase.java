package com.example.trab_final.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.trab_final.dao.CandidaturaDao;
import com.example.trab_final.dao.UsuarioDao;
import com.example.trab_final.entities.Candidatura;
import com.example.trab_final.entities.Usuario;

@Database(entities = {Usuario.class, Candidatura.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract UsuarioDao getUsuarioDao();
    public abstract CandidaturaDao getCandidaturaDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "UsuarioCandidaturaControladoria").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
