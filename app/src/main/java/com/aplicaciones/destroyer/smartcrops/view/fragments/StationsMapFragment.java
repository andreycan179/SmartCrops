package com.aplicaciones.destroyer.smartcrops.view.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.FragmentStationsMapBinding;
import com.aplicaciones.destroyer.smartcrops.viewModel.StationsMapFragmentViewModel;


public class StationsMapFragment extends Fragment {


    private View mView;

    public StationsMapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentStationsMapBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_stations_map, container,false);
        StationsMapFragmentViewModel stationsMapFragment = new StationsMapFragmentViewModel(binding.mapView);
        binding.setStationsFragmentMap(stationsMapFragment);
        mView = binding.getRoot();
        return mView;
    }


}
