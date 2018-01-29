package com.aplicaciones.destroyer.smartcrops.view.activitys;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.adapters.AdapterStations;
import com.aplicaciones.destroyer.smartcrops.dataBase.DataFireBase;
import com.aplicaciones.destroyer.smartcrops.databinding.ActivityStationsBinding;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.view.fragments.LoadDialogFragment;

import java.util.List;

public class StationsActivity extends AppCompatActivity {

    private  ActivityStationsBinding binding;
    private String function;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        function = intent.getStringExtra("function");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_stations);
        initRecycler();
    }

    private  void  initRecycler(){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerStations.setLayoutManager(layoutManager);
        new LoadStationsAsyncTask().execute();

    }


    private  class LoadStationsAsyncTask extends AsyncTask<Void, Void, List<Station>>{

        private LoadDialogFragment dialog;

        @Override
        protected void onPreExecute() {
            dialog = new LoadDialogFragment();
            dialog.show(getSupportFragmentManager(),"LoadDialogFragment");
            super.onPreExecute();
        }

        @Override
        protected List<Station> doInBackground(Void... voids) {
            return new DataFireBase().readStation(function);
        }

        @Override
        protected void onPostExecute(List<Station> stations) {
            super.onPostExecute(stations);
            AdapterStations adapterStations = new AdapterStations(stations, function);
            binding.recyclerStations.setAdapter(adapterStations);
            dialog.dismiss();
        }
    }

}
