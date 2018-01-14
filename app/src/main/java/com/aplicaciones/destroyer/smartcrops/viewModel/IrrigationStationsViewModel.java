package com.aplicaciones.destroyer.smartcrops.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.view.activitys.SpecificIrrigationActivity;


/**
 * Created by Destroyer on 14/01/2018.
 */

public class IrrigationStationsViewModel {

    private Station station;

    public IrrigationStationsViewModel(Station station) {
        this.station = station;
    }

    public String getKey(){
        return station.getKey();
    }

    public  void specificActivity(View view){

        Context context = view.getContext();
        Intent intent = new Intent(context, SpecificIrrigationActivity.class);
        intent.putExtra("station",station);
        context.startActivity(intent);

    }

}
