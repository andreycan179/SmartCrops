package com.aplicaciones.destroyer.smartcrops.viewModel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aplicaciones.destroyer.smartcrops.model.User;
import com.aplicaciones.destroyer.smartcrops.view.activitys.IrrigationActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.LoginActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.MeasureActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Destroyer on 7/01/2018.
 */

public class IntroViewModel  implements OnMapReadyCallback{

    private Context context;
    private  User user;

    public IntroViewModel(Context context, User user) {
        this.context = context;
        this.user = user;
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

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}
