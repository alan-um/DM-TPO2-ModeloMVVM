package com.example.tpo2_modelomvvm.UI;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.tpo2_modelomvvm.Models.Libro;

public class DetalleLibroViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> mLibro;
    public DetalleLibroViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Libro> getmLibro() {
        if(mLibro==null){
            mLibro = new MutableLiveData<>();
        }
        return mLibro;
    }

    public void cargarLibro(Intent i){
        Libro l = i.getSerializableExtra("libro", Libro.class);
        if(l!=null){
            mLibro.setValue(l);
        }
    }
}
