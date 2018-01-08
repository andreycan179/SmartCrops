package com.aplicaciones.destroyer.smartcrops.dataBase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.aplicaciones.destroyer.smartcrops.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    public void read() {

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

}
