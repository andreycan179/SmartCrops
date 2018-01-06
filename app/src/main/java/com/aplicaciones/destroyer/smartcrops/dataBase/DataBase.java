package com.aplicaciones.destroyer.smartcrops.dataBase;

import android.content.Context;

import com.aplicaciones.destroyer.smartcrops.model.User;

/**
 * Created by Destroyer on 3/01/2018.
 */

public interface DataBase {
    public void createUser();
    public void readUser();
    public void update();
    public void delete();
    public boolean login(User usuario);

}
