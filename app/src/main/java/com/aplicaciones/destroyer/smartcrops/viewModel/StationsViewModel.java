package com.aplicaciones.destroyer.smartcrops.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.view.activitys.IrrigationActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.MeasureActivity;


/**
 * Created by Destroyer on 14/01/2018.
 */

public class StationsViewModel {

    private Station station;

    public StationsViewModel(Station station) {
        this.station = station;
    }

    public String getName(){
        return station.getName();
    }

    public  void specificActivity(View view){

        Context context = view.getContext();
        Intent intent;
        if(station.getFunction().equals("IRRIG_STATION")){
            intent = new Intent(context, IrrigationActivity.class);
        }else {
            intent = new Intent(context, MeasureActivity.class);
        }
        intent.putExtra("station",station);
        context.startActivity(intent);

    }

}
