package com.aplicaciones.destroyer.smartcrops.viewModel;

import android.app.Activity;
import android.util.Log;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.dataBase.DataBase;
import com.aplicaciones.destroyer.smartcrops.dataBase.DataFireBase;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Destroyer on 12/01/2018.
 */

public class StationsMapFragmentViewModel implements OnMapReadyCallback{

    private MapView mapView;
    private List<Station> stations;

    public StationsMapFragmentViewModel(MapView mapView) {
        this.mapView = mapView;
        this.stations= new ArrayList<>();
        readLocation();
    }

    private void initMapView(){
        if (mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    private void readLocation(){

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                DataBase dataBase = new DataFireBase();
                stations = dataBase.readStation(null, "irrigation");
                stations.addAll(dataBase.readStation(null,"measure"));
                for (Station station: stations) {
                    Log.d("OutThread", station.getKey()+" "+ station.getKind());
                }

                ((Activity)mapView.getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initMapView();
                    }
                });

            }
        });
        myThread.start();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        for (Station station:stations ) {
            LatLng position = new LatLng( station.getLatitude(), station.getLongitude());
            MarkerOptions markerOptions;

            if (station.getKind().equals("irrigation")){
                 markerOptions = new MarkerOptions().position(position).title(station.getKind().toUpperCase()).
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_irrigation_map));
            }else {
                 markerOptions = new MarkerOptions().position(position).title(station.getKind().toUpperCase()).
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_measure_map));
            }

            Marker marker = googleMap.addMarker(markerOptions);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,17));
        }

    }
}
