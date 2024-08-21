package com.softulp.ejemplovistas1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.ejemplovistas1.databinding.ActivityPerfilBinding;

public class PerfilActivity extends AppCompatActivity {
private PerfilActivityViewModel mv;
private ActivityPerfilBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(PerfilActivityViewModel.class);
        binding=ActivityPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv.getMUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.etDni.setText(usuario.getDni()+"");
                binding.etApellido.setText(usuario.getApellido());
                binding.etNombre.setText(usuario.getNombre());
                binding.etEmail.setText(usuario.getEmail());
            }
        });
        mv.rescatarDatos(getIntent());

    }
}