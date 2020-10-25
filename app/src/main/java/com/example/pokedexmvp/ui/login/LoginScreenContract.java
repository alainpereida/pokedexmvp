package com.example.pokedexmvp.ui.login;

import android.content.Context;
import android.widget.EditText;

public interface LoginScreenContract {

    interface View {
        Context getAppContext();
        Boolean verifyData(EditText editText);
    }

    interface Presenter {
        void login(String username, String password);
        Context getAppContext();
    }

    interface Interactor {
        void login(String username, String password);
    }
}
