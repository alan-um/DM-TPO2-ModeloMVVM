package com.example.tpo2_modelomvvm.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpo2_modelomvvm.Models.RepositorioLibros;
import com.example.tpo2_modelomvvm.R;
import com.example.tpo2_modelomvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private RepositorioLibros repositorio = new RepositorioLibros();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Observe
        viewModel.getmMsg().observe(this, msg->{
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });

        viewModel.getmLibro().observe(this,libro -> {
            //Toast.makeText(this, "Libro encontrado -> "+libro.getTitulo()+" - "+libro.getAutor(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,DetalleLibro.class);
            i.putExtra("libro",libro);
            startActivity(i);
        });


        //Listener
        binding.btBuscar.setOnClickListener(v -> {
            viewModel.buscar(repositorio,binding.etTituloBuscar.getText().toString());
        });

        //Other function
        //repositorio.mostrarLibros();
    }
}