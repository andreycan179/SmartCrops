package com.aplicaciones.destroyer.smartcrops.viewModel;

import com.aplicaciones.destroyer.smartcrops.model.Station;

/**
 * Created by destroyer on 1/02/18.
 */

public class InfoMeasureViewModel {

    private Station station;

    public InfoMeasureViewModel(Station station) {
        this.station = station;
    }

    public String getFunction(){
        return station.getFunction();
    }

}
