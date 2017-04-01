package com.example.jair.appmvp.Interface;

/**
 * Created by Brian on 01/04/2017.
 */

public interface LoginInteractor {
    void validarUser(String user,String pass,OnLoginFinishListener listener);


}
