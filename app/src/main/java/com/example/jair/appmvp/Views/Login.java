package com.example.jair.appmvp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.jair.appmvp.Interface.LoginPresenter;
import com.example.jair.appmvp.Interface.LoginView;
import com.example.jair.appmvp.Presenters.LoginPresenterImpl;
import com.example.jair.appmvp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity implements LoginView{

    @Bind(R.id.username)
    EditText user;
    @Bind(R.id.password)
    EditText contraseña;
    @Bind(R.id.button)
    Button ingresar;
    @Bind(R.id.progress)
    ProgressBar progressBar;

    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        user.setError("Usuario Obligatorio");
    }

    @Override
    public void setErrorPasword() {
        contraseña.setError("Password Obligatorio");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(Login.this,PrincipalActivity.class));

    }
    @OnClick(R.id.button)
    public void validation(){
        loginPresenter.validarUsuario(user.getText().toString(),contraseña.getText().toString());
    }
}
