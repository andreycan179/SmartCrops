package com.aplicaciones.destroyer.smartcrops.viewModel;

import com.aplicaciones.destroyer.smartcrops.model.Station;

/**
 * Created by Destroyer on 14/01/2018.
 */

public class InfoIrrigationViewModel {

    private Station station;

    public InfoIrrigationViewModel(Station station) {
        this.station = station;
    }

    public String getKey(){
        return station.getKey();
    }
}
