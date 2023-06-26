package com.example.trab_final;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trab_final.database.AppDatabase;
import com.example.trab_final.databinding.ActivityRegisterBinding;
import com.example.trab_final.entities.Usuario;
import com.example.trab_final.dao.UsuarioDao;
public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = binding.editTextFullName.getText().toString();
                String username = binding.editTextUsername.getText().toString();
                String senha = binding.editTextPassword.getText().toString();
                String Csenha = binding.editTextConfirmPassword.getText().toString();
                if (senha.equals(Csenha)) {
                    usuario = new Usuario(nome, username, senha, Csenha);
                    AppDatabase.getDatabase(v.getContext()).getUsuarioDao().insert(usuario);
                    finish();
                }
            }
        });

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

