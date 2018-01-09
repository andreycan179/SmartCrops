package com.aplicaciones.destroyer.smartcrops.view.activitys;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.ActivityIntroBinding;
import com.aplicaciones.destroyer.smartcrops.model.User;
import com.aplicaciones.destroyer.smartcrops.viewModel.IntroViewModel;
import com.google.android.gms.maps.SupportMapFragment;


public class IntroActivity extends AppCompatActivity {

    private ActivityIntroBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        binding= DataBindingUtil.setContentView(this, R.layout.activity_intro);
        IntroViewModel intro = new IntroViewModel(this, user);
        binding.setIntroViewModel(intro);
        SupportMapFragment s= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        s.getMapAsync(intro);

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
        binding.getIntroViewModel().logOut();
    }

}
