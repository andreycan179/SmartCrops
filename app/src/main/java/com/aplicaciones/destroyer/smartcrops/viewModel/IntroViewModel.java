package com.aplicaciones.destroyer.smartcrops.viewModel;

import android.content.Context;
import android.content.Intent;

import com.aplicaciones.destroyer.smartcrops.view.activitys.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Destroyer on 7/01/2018.
 */

public class IntroViewModel {

    Context context;

    public IntroViewModel(Context context) {
        this.context = context;
    }

    public  void  logOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

}
