package com.aplicaciones.destroyer.smartcrops.view.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.FragmentInfoMeasureBinding;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.viewModel.InfoMeasureViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoMeasureFragment extends Fragment {


    public InfoMeasureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentInfoMeasureBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_info_measure,container,false);
        Bundle args = getArguments();
        binding.setInfoMeasureViewModel(new InfoMeasureViewModel((Station) args.getSerializable("station")));

        return binding.getRoot();
    }

}
