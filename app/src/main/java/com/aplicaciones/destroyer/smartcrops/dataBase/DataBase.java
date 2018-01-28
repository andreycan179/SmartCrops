package com.aplicaciones.destroyer.smartcrops.dataBase;

import android.content.Context;

import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.model.User;

import java.util.List;

/**
 * Created by Destroyer on 3/01/2018.
 */

public interface DataBase {
     void create();
     List<Station> readStation( String kind);
     void update();
     void delete();
     boolean login(User usuario);
     boolean resetPassword(String email);

}
