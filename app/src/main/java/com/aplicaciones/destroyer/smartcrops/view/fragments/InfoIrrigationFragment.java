package com.aplicaciones.destroyer.smartcrops.view.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.FragmentInfoIrrigationBinding;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.viewModel.InfoIrrigationViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoIrrigationFragment extends Fragment {


    public InfoIrrigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentInfoIrrigationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                R.layout.fragment_info_irrigation,container,false);
        Bundle args = getArguments();
        Station station = (Station) args.getSerializable("station");
        binding.setInfoIrrigation(new InfoIrrigationViewModel(station));

        return binding.getRoot();
    }

}
