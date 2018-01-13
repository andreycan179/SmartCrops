package com.aplicaciones.destroyer.smartcrops.dataBase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Destroyer on 3/01/2018.
 */

public class DataFireBase implements DataBase {

    private DatabaseReference dataBase;
    private FirebaseAuth auth;

    public DataFireBase(){
        dataBase = FirebaseDatabase.getInstance().getReference();
        auth= FirebaseAuth.getInstance();
    }

    @Override
    public void create() {

    }

    @Override
    public List<Station> readStation(String key, String kind) {

        DatabaseReference reference = dataBase.child("Stations");
        Query query;

        if (key!=null){
            query = reference.orderByChild("key").equalTo(key);
        }else {
            query = reference.orderByChild("kind").equalTo(kind);
        }


        List<Station> stations = new ArrayList<>();

        query.addListenerForSingleValueEvent(new ReadStationCompleteListener(stations, kind));

        try {
            synchronized (stations) {
                stations.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return stations;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public boolean login(User user) {

        Task s=auth.signInWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener(new LoginCompleteListener(user));
        try {
            synchronized (user){
            user.wait();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return s.isSuccessful();

    }

    private class LoginCompleteListener implements OnCompleteListener{

        private User user;

        public LoginCompleteListener(User user) {
            this.user = user;
        }

        @Override
        public void onComplete(@NonNull Task task) {
            if (task.isSuccessful()){
                user.userName = auth.getCurrentUser().getDisplayName();
                Log.d("Login", "Successful");

            }else {
                Log.d("Login", "fall");
            }
            synchronized (user){
                user.notify();
            }
        }
    }

    private class ReadStationCompleteListener implements ValueEventListener{

        private List<Station> stations;
        private String kind;

        private ReadStationCompleteListener(List<Station> stations, String kind) {
            this.stations = stations;
            this.kind = kind;
        }

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();

            while (iterator.hasNext()){
                Station station = iterator.next().getValue(Station.class);
                if (station.getKind().equals(kind)){
                    stations.add(station);
                }
            }
            synchronized (stations){
                stations.notify();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    }

}
