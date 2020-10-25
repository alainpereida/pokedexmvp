package com.example.pokedexmvp.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pokedexmvp.R;

public class LoginScreenActivity extends AppCompatActivity implements LoginScreenContract.View{

    private EditText username;
    private EditText password;
    private Button login;
    private LoginScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginScreenPresenter(this);

        username = findViewById(R.id.getEmailAddress);
        password = findViewById(R.id.getPassword);
        login = findViewById(R.id.button_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verifyData(username) && verifyData(password)) {
                    presenter.login(username.getText().toString(), password.getText().toString());
                }
            }
        });
    }

    @Override
    public Context getAppContext() {
        return this;
    }

    @Override
    public Boolean verifyData(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("Error, no puede estar vacio.");
            return false;
        } else {
            return  true;
        }
    }
}