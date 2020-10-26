package com.example.pokedexmvp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {

    private static User user;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String last_name;

    @SerializedName("email")
    private String email_user;

    @SerializedName("password")
    private String password;

    private ArrayList<Pokemon> pokemons;

    private User(String firstName, String last_name, String email_user, String password) {
        this.firstName = firstName;
        this.last_name = last_name;
        this.email_user = email_user;
        this.password = password;
    }

    private User() { }

    public String getFirstName() {
        return firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail_user() {
        return email_user;
    }

    public String getPassword() {
        return password;
    }

    public static void setUser(User user) {
        User.user = user;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User getInstance(){
        if (user == null) {
            user = new User();
        }
        return user;
    }
}
