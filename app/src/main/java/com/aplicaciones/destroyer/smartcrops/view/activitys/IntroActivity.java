package com.aplicaciones.destroyer.smartcrops.view.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.model.User;
import com.google.firebase.auth.FirebaseAuth;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
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
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
