package com.example.tpo2_modelomvvm.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tpo2_modelomvvm.Models.Libro;
import com.example.tpo2_modelomvvm.Models.RepositorioLibros;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> mLibro;
    private MutableLiveData<String> mMsg;
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getmLibro() {
        if(mLibro==null){
            mLibro = new MutableLiveData<>();
        }
        return mLibro;
    }

    public MutableLiveData<String> getmMsg() {
        if(mMsg==null){
            mMsg = new MutableLiveData<>();
        }return mMsg;
    }

    public void buscar(RepositorioLibros repositorio, String tituloBuscado){
        Libro libroBuscado = repositorio.buscarLibroPorTitulo(tituloBuscado);
        if(libroBuscado!=null){
            mLibro.setValue(libroBuscado);
        }else{
            mMsg.setValue("No se ha encontrado el título ingresado.");
        }
    }
}
