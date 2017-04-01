package com.example.jair.appmvp.Interactors;


import com.example.jair.appmvp.Interface.LoginInteractor;
import com.example.jair.appmvp.Interface.OnLoginFinishListener;
import android.os.Handler;


/**
 * Created by Brian on 01/04/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void validarUser(final String user,final String pass,final OnLoginFinishListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!user.equals("") && !pass.equals("")){
                        listener.successfully();
                }else {
                    if(user.equals("")){
                        listener.usernameError();
                    }
                    if(pass.equals("")){
                        listener.passwordError();
                    }
                }
            }
        },1000);

    }
}
