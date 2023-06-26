package com.example.trab_final.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.trab_final.entities.Candidatura;

import java.util.List;

@Dao
public interface CandidaturaDao {
    @Insert
    void insert(Candidatura candidatura);

    @Query("SELECT * FROM candidaturas WHERE id = :candidaturaId")
    Candidatura getCandidaturaById(long candidaturaId);

    @Query("SELECT * FROM candidaturas")
    List<Candidatura> getAllCandidaturas();

    @Update
    void update(Candidatura candidatura);

    @Delete
    void delete(Candidatura candidatura);
}