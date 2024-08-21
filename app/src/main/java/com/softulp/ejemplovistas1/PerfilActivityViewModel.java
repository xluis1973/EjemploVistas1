package com.softulp.ejemplovistas1;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.FileWriter;

public class PerfilActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Usuario> mUsuario;

    public PerfilActivityViewModel(@NonNull Application application) {
        super(application);
       }

       public LiveData<Usuario> getMUsuario(){
        if(mUsuario==null){
            mUsuario=new MutableLiveData<>();
        }
        return mUsuario;
       }



       public void rescatarDatos(Intent intent){


        Bundle bundle =intent.getBundleExtra("usuario");
        if(bundle!=null){
            Usuario user=bundle.getSerializable("usuario", Usuario.class);
            if(user!=null){
                mUsuario.setValue(user);
            }
        }





    }
}
