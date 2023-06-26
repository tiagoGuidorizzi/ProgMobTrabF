package com.example.trab_final;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.trab_final.databinding.FragmentCandidatarBinding;
import com.example.trab_final.databinding.FragmentMenuBinding;
import com.example.trab_final.entities.Candidatura;
import com.example.trab_final.entities.Usuario;
import com.example.trab_final.dao.CandidaturaDao;
public class CandidatarFragment extends Fragment {

    FragmentCandidatarBinding binding;

    private Candidatura candidatura;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCandidatarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("erro candidatura", "onClick: SOCORRROOOOOOOOOOOO ");

        // Botão "Cadastrar"
        binding.btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("erro candidatura", "onClick: SOCORRROOOOOOOOOOOO ");
                SharedPreferences sharedPref = getContext().getSharedPreferences("com.example.trab_final.PREFS", Context.MODE_PRIVATE);
                String nomeVaga = binding.editTextNomeVaga.getText().toString();
                String descricao = binding.editTextDescricao.getText().toString();
                String salarioString = binding.editTextSalario.getText().toString();
                double salario = Double.parseDouble(salarioString);
                String email = binding.editTextEmail.getText().toString();
                String telefone = binding.editTextTelefone.getText().toString();
                Long idUsuario = sharedPref.getLong("id_usuario", 0);
                Log.d("erro candidatura", "onClick: SOCORRROOOOOOOOOOOO ");
                candidatura = new Candidatura(idUsuario, nomeVaga, descricao, salario, email, telefone);
                AppDatabase.getDatabase(v.getContext()).getCandidaturaDao().insert(candidatura);
                NavHostFragment.findNavController(CandidatarFragment.this).navigate(R.id.action_candidatarFragment_to_menuFragment);
            }
        });
    }
}


