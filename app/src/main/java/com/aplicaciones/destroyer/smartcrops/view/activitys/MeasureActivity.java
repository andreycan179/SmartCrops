package com.aplicaciones.destroyer.smartcrops.view.activitys;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.adapters.SectionsPagerAdapter;
import com.aplicaciones.destroyer.smartcrops.databinding.ActivityMeasureBinding;
import com.aplicaciones.destroyer.smartcrops.model.Station;
import com.aplicaciones.destroyer.smartcrops.view.fragments.InfoMeasureFragment;

public class MeasureActivity extends AppCompatActivity {

    private ActivityMeasureBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Station station = (Station) intent.getSerializableExtra("station");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_measure);

        Toolbar toolbar = binding.toolbar2;
        setSupportActionBar(toolbar);

        SectionsPagerAdapter adapter = new SectionsPagerAdapter( getSupportFragmentManager());
        Fragment fragment = new InfoMeasureFragment();
        Bundle args = new Bundle();
        args.putSerializable("station", station);
        Fragment fragment1= new InfoMeasureFragment();
        fragment.setArguments(args);
        fragment1.setArguments(args);
        adapter.addFragment(fragment);
        adapter.addFragment(fragment1);

        ViewPager pager = binding.container;
        pager.setAdapter(adapter);
        binding.tabLayoutM.setupWithViewPager(pager);
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
