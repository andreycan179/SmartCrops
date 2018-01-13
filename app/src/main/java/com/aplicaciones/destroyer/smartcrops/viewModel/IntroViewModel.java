package com.aplicaciones.destroyer.smartcrops.viewModel;



import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.model.User;
import com.aplicaciones.destroyer.smartcrops.view.activitys.IrrigationActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.LoginActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.MeasureActivity;
import com.aplicaciones.destroyer.smartcrops.view.fragments.StationsMapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by Destroyer on 7/01/2018.
 */

public class IntroViewModel  {

    private Context context;
    private  User user;
    private FragmentManager fragmentManager;

    public IntroViewModel(Context context, User user) {
        this.context = context;
        this.user = user;
        addMapFragment();
    }

    private void addMapFragment(){

        StationsMapFragment mapFragment = new StationsMapFragment();
        fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mapLayout,mapFragment).commit();

    }

    public String getUserName(){
        return  user.userName;
    }

    public void irrigationActivity(View view){

        Intent intent = new Intent(context, IrrigationActivity.class);
        context.startActivity(intent);

    }

    public void measureActivity(View view){

        Intent intent = new Intent(context, MeasureActivity.class);
        context.startActivity(intent);

    }

    public  void  logOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

}
