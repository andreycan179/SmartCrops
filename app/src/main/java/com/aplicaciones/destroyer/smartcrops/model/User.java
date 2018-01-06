package com.aplicaciones.destroyer.smartcrops.model;


import java.io.Serializable;

/**
 * Created by Destroyer on 3/01/2018.
 */

public class User implements Serializable{

    public String userName;
    public String email;
    public String password;

    public  User(){}

    public User(String userName) {
        this.userName = userName;
    }
}
