package com.example.trab_final;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trab_final.database.AppDatabase;
import com.example.trab_final.databinding.ActivityLoginBinding;
import com.example.trab_final.dao.UsuarioDao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = binding.editTextUser.getText().toString();
                String senha = binding.editTextPassword.getText().toString();

                if(AppDatabase.getDatabase(v.getContext()).getUsuarioDao().getUserByLogin(user, senha) != null) {
                    SharedPreferences sharedPref = getSharedPreferences("com.example.trab_final.PREFS", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putLong("id_usuario", 1); // Você pode substituir "1" pelo ID do usuário real
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
