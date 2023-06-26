package com.example.trab_final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.trab_final.adapters.MinhasCandidaturasAdapter;
import com.example.trab_final.adapters.VagasAdapter;
import com.example.trab_final.database.AppDatabase;
import com.example.trab_final.databinding.FragmentCandidaturasBinding;
import com.example.trab_final.entities.Candidatura;

import java.util.ArrayList;
import java.util.List;

public class MinhasCandidaturasFragment extends Fragment {
    FragmentCandidaturasBinding binding;
    private MinhasCandidaturasAdapter candidaturaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCandidaturasBinding.inflate(inflater, container, false);

        List<Candidatura> candidaturas = new ArrayList<>();
        candidaturas = AppDatabase.getDatabase(this.getContext()).getCandidaturaDao().getAllCandidaturas();

        candidaturaAdapter = new MinhasCandidaturasAdapter(this, candidaturas);

        binding.listViewCandidaturas.setAdapter(candidaturaAdapter);

        return binding.getRoot();
    }
}
