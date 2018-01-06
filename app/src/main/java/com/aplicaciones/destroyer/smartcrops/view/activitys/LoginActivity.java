package com.aplicaciones.destroyer.smartcrops.view.activitys;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.ActivityLoginBinding;
import com.aplicaciones.destroyer.smartcrops.model.User;
import com.aplicaciones.destroyer.smartcrops.viewModel.ViewModelLogin;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private  ViewModelLogin login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        login= new ViewModelLogin();
        binding.setLoginViewModel(login);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser != null){
            Log.d("USER", currentUser.getDisplayName());
            login.introActivity(this, new User(currentUser.getDisplayName()));
        }else
            Log.d("User", "not found!!!!!!!!!!!!!!!");

    }

}
