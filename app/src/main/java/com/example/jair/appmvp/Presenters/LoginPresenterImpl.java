package com.example.jair.appmvp.Presenters;

import com.example.jair.appmvp.Interactors.LoginInteractorImpl;
import com.example.jair.appmvp.Interface.LoginInteractor;
import com.example.jair.appmvp.Interface.LoginPresenter;
import com.example.jair.appmvp.Interface.LoginView;
import com.example.jair.appmvp.Interface.OnLoginFinishListener;

/**
 * Created by Brian on 01/04/2017.
 */

public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView=loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validarUsuario(String user, String pass) {
        if(loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.validarUser(user,pass,this);

    }

    @Override
    public void usernameError() {
        if(loginView != null) {
            loginView.hideProgress();
            loginView.setErrorUser();
        }
    }

    @Override
    public void passwordError() {
        if(loginView != null) {
            loginView.hideProgress();
            loginView.setErrorPasword();
        }
    }

    @Override
    public void successfully() {
        if(loginView != null) {
            loginView.hideProgress();
            loginView.navigateToHome();
        }

    }
}
