package com.aplicaciones.destroyer.smartcrops.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.CardViewIrrigationBinding;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.viewModel.StationsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Destroyer on 13/01/2018.
 */

public class AdapterStations extends RecyclerView.Adapter<AdapterStations.BindingViewHolder>{

    private List<StationsViewModel> stations;
    private String function;

    public AdapterStations(List<Station> stations, String function) {
        this.stations = new ArrayList<>();
        this.function = function;
        for (Station station: stations) {
            this.stations.add(new StationsViewModel(station));
        }
    }

    @Override
    public AdapterStations.BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardViewIrrigationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.card_view_irrigation,parent,false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(AdapterStations.BindingViewHolder holder, int position) {
        CardViewIrrigationBinding binding = holder.binding;
        binding.setStationViewModel(stations.get(position));
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder{

        private CardViewIrrigationBinding binding;

        public BindingViewHolder(CardViewIrrigationBinding binding) {
            super(binding.cardViewIrrigation);
            this.binding=binding;
            if(function.equals("IRRIG_STATION")){
                this.binding.imageView.setImageResource(R.drawable.irrigation_stations);
            }else {
                this.binding.imageView.setImageResource(R.drawable.measure_stations);
            }

        }
    }

}
