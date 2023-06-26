package com.example.trab_final.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.trab_final.entities.Usuario;

@Dao
public interface UsuarioDao {
    @Insert
    void insert(Usuario user);

    @Query("SELECT * FROM usuarios WHERE id = :userId")
    Usuario getUserById(long userId);

    @Query("SELECT * FROM usuarios WHERE usuario = :usuario and senha = :senha")
    Usuario getUserByLogin(String usuario, String senha);
}