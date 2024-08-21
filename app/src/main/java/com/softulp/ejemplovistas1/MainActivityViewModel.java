package com.softulp.ejemplovistas1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<String> mMensaje;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<String> getMmensaje(){

        if(mMensaje==null){
            mMensaje=new MutableLiveData<>();
        }
        return mMensaje;
    }

    public void verificarIngreso(String usuario,String password){

        //Validar contra un usuario ficticio
        if(usuario.equals("carlos@mail.com")&& password.equals("123")){
            //vamor a suponer que desde el modelo obtuvimos un usario
            Usuario nUsuario=new Usuario(23492089,"Lopez","Carlos","carlos@mail.com","123");
            Intent intent=new Intent(getApplication(),PerfilActivity.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("usuario",nUsuario);

            intent.putExtra("usuario",bundle);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        }else {

            mMensaje.setValue("Usario y/o Contraseña Incorrecto");
        }
    }

}
