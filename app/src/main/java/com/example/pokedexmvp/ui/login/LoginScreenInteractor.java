package com.example.pokedexmvp.ui.login;

import android.content.Intent;
import android.widget.Toast;

import com.example.pokedexmvp.data.model.User;
import com.example.pokedexmvp.ui.main.PokemonScreenActivity;
import com.example.pokedexmvp.utils.ConsultSharedPreference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

public class LoginScreenInteractor implements LoginScreenContract.Interactor {

    private LoginScreenPresenter presenter;
    private ConsultSharedPreference sharedPreference;

    public LoginScreenInteractor(LoginScreenPresenter presenter) {
        this.presenter = presenter;
        this.sharedPreference = new ConsultSharedPreference(presenter.getAppContext());
    }

    @Override
    public void login(String username, String password) {
        String usersString = null;
        try {
            //Leemos el file y lo pasamos a string
            InputStream i = presenter.getAppContext().getAssets().open("users.json");
            int size = i.available();
            byte[] buffer = new byte[size];
            i.read(buffer);

            usersString = new String(buffer);
            usersString = usersString.replaceAll("\\n","");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        Type userType = new TypeToken<ArrayList<User>>(){}.getType();
        ArrayList<User> users = gson.fromJson(usersString, userType);

        //Si el flujo llego hasta este punto paso los filtos de vacio.
        Iterator<User> iterator = users.iterator();
        User userFind = null;
        while (iterator.hasNext() && userFind == null) {
            User userAux= iterator.next();
            if (userAux.getEmail_user().equalsIgnoreCase(username) && userAux.getPassword().equalsIgnoreCase(password)) {
                //Se encontro la cuenta
                userFind = userAux;
            }
        }

        if (userFind == null) {
            Toast.makeText(presenter.getAppContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
            return;
        }

//        sharedPreference.save(userFind);
        Intent intent = new Intent(presenter.getAppContext(), PokemonScreenActivity.class);
        presenter.getAppContext().startActivity(intent);
    }
}
