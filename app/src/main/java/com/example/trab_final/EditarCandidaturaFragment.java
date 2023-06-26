package com.example.trab_final;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trab_final.database.AppDatabase;
import com.example.trab_final.databinding.FragmentEditarCandidaturaBinding;
import com.example.trab_final.entities.Candidatura;
import com.example.trab_final.dao.CandidaturaDao;

public class EditarCandidaturaFragment extends Fragment {
    private Candidatura candidatura;
    private AppDatabase db;
    FragmentEditarCandidaturaBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditarCandidaturaBinding.inflate(inflater, container, false);

        db = AppDatabase.getDatabase(getContext().getApplicationContext());

        if (getArguments() != null) {
            final Long candidaturaId = Long.valueOf(getArguments().getString("id"));
            Log.d("aaaa", "" + candidaturaId);
            candidatura = db.getCandidaturaDao().getCandidaturaById(candidaturaId);
            fillFields();
        }

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (candidatura != null) {
                    editarCandidatura();
                }
                NavHostFragment.findNavController(EditarCandidaturaFragment.this)
                        .navigate(R.id.action_editarCandidaturaFragment_to_minhasCandidaturasFragment);
            }
        });

    }

    public void editarCandidatura() {
        candidatura.setNome(binding.editTextNomeVaga.getText().toString());
        candidatura.setDescricao(binding.editTextDescricao.getText().toString());
        candidatura.setSalario(Double.parseDouble(binding.editTextSalario.getText().toString()));
        candidatura.setEmail(binding.editTextEmail.getText().toString());
        candidatura.setTelefone(binding.editTextTelefone.getText().toString());
        db.getCandidaturaDao().update(candidatura);
    }

    public void fillFields() {
        binding.editTextNomeVaga.setText(candidatura.getNome());
        binding.editTextDescricao.setText(candidatura.getDescricao());
        binding.editTextSalario.setText(String.valueOf(candidatura.getSalario()));
        binding.editTextEmail.setText(candidatura.getEmail());
        binding.editTextTelefone.setText(candidatura.getTelefone());
    }
}
