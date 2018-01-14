package com.aplicaciones.destroyer.smartcrops.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.CardViewIrrigationBinding;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.viewModel.IrrigationStationsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Destroyer on 13/01/2018.
 */

public class AdapterIrrigation extends RecyclerView.Adapter<AdapterIrrigation.BindingViewHolder>{

    private List<IrrigationStationsViewModel> stations;

    public AdapterIrrigation(List<Station> stations) {
        this.stations = new ArrayList<>();
        for (Station station: stations) {
            this.stations.add(new IrrigationStationsViewModel(station));
        }
    }

    @Override
    public AdapterIrrigation.BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardViewIrrigationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.card_view_irrigation,parent,false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(AdapterIrrigation.BindingViewHolder holder, int position) {
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
        }
    }

}
