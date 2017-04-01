package com.example.jair.appmvp.Interface;

/**
 * Created by Brian on 01/04/2017.
 */

public interface LoginView {

    void showProgress();
    void hideProgress();

    void setErrorUser();
    void setErrorPasword();

    void navigateToHome();
}
