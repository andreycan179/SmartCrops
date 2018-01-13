package com.aplicaciones.destroyer.smartcrops.dataBase;

import android.content.Context;

import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.model.User;

import java.util.List;

/**
 * Created by Destroyer on 3/01/2018.
 */

public interface DataBase {
    public void create();
    public List<Station> readStation(String key, String kind);
    public void update();
    public void delete();
    public boolean login(User usuario);

}
