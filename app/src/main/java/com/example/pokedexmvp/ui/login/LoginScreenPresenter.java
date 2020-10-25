package com.example.pokedexmvp.ui.login;

import android.content.Context;

public class LoginScreenPresenter implements LoginScreenContract.Presenter {

    private LoginScreenActivity view;
    private LoginScreenInteractor interactor;

    public LoginScreenPresenter(LoginScreenActivity view) {
        this.view = view;
        this.interactor = new LoginScreenInteractor(this);
    }

    @Override
    public void login(String username, String password) {
        interactor.login(username, password);
    }

    @Override
    public Context getAppContext() {
        return view.getAppContext();
    }
}
