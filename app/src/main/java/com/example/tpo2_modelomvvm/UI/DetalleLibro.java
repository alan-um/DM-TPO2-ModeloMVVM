package com.example.tpo2_modelomvvm.UI;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpo2_modelomvvm.R;
import com.example.tpo2_modelomvvm.databinding.ActivityDetalleLibroBinding;

public class DetalleLibro extends AppCompatActivity {

    private ActivityDetalleLibroBinding binding;
    private DetalleLibroViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleLibroBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(DetalleLibroViewModel.class);

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Observe
        viewModel.getmLibro().observe(this,libro -> {
            binding.tvTitutlo.setText(libro.getTitulo());
            binding.tvAutor.setText(libro.getAutor());
            binding.tvIsbn.setText(String.valueOf(libro.getIsbn()));
            binding.tvFecha.setText(String.valueOf(libro.getFechaPublicacion()));
            binding.tvGenero.setText(libro.getGenero());
            binding.tvDescripcion.setText(libro.getDescripcion());
            binding.imageView.setImageResource(libro.getImagen());
        });

        //Listener
        binding.btVolver.setOnClickListener(v -> {
            finish();
        });

        //Other
        viewModel.cargarLibro(getIntent());
    }
}