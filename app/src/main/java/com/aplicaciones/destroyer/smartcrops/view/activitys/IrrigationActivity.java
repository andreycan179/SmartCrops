package com.aplicaciones.destroyer.smartcrops.view.activitys;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.adapters.AdapterIrrigation;
import com.aplicaciones.destroyer.smartcrops.dataBase.DataFireBase;
import com.aplicaciones.destroyer.smartcrops.databinding.ActivityIrrigationBinding;

public class IrrigationActivity extends AppCompatActivity {

    private  ActivityIrrigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_irrigation);
        initRecycler();
    }

    private  void  initRecycler(){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerIrrigation.setLayoutManager(layoutManager);
        loadStations();
    }

    private  void  loadStations(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterIrrigation adapterIrrigation = new AdapterIrrigation(new DataFireBase().readStation("irrigation"));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.recyclerIrrigation.setAdapter(adapterIrrigation);
                    }
                });
            }
        });
        thread.start();
    }
}
