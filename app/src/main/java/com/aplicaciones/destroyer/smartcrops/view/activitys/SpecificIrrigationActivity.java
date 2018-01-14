package com.aplicaciones.destroyer.smartcrops.view.activitys;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.adapters.SectionsPagerAdapter;
import com.aplicaciones.destroyer.smartcrops.databinding.ActivitySpecificIrrigationBinding;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.view.fragments.InfoIrrigationFragment;

import java.util.ArrayList;
import java.util.List;

public class SpecificIrrigationActivity extends AppCompatActivity {

    private ActivitySpecificIrrigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Intent intent = getIntent();
       Station station = (Station) intent.getSerializableExtra("station");



       binding = DataBindingUtil.setContentView(this, R.layout.activity_specific_irrigation);
       Toolbar toolbar = binding.toolbar;
       setSupportActionBar(toolbar);

       setUpViewPager(binding.container, station);

       TabLayout layout = binding.tabLayout;
       layout.setupWithViewPager(binding.container);

    }

    public  void  setUpViewPager(ViewPager viewPager, Station station){

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(setUpFragment(station));
        sectionsPagerAdapter.addFragment(setUpFragment(station));
        sectionsPagerAdapter.addFragment(setUpFragment(station));
        viewPager.setAdapter(sectionsPagerAdapter);
    }

    public Fragment setUpFragment(Station station){
        Fragment fragment = new InfoIrrigationFragment();
        Bundle args = new Bundle();
        args.putSerializable("station",station);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case (R.id.app_bar_logout):
                goLoginActivity();
                return true;
            case (R.id.app_bar_info):
                Log.d("Info","menu");
                return true;
            case (R.id.app_bar_search):
                Log.d("Search","menu");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public  void  goLoginActivity(){

    }
}
