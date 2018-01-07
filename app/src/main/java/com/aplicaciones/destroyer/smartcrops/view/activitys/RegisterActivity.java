package com.aplicaciones.destroyer.smartcrops.view.activitys;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.ActivityRegisterBinding;
import com.aplicaciones.destroyer.smartcrops.viewModel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        RegisterViewModel register = new RegisterViewModel();
        binding.setRegisterViewModel(register);
    }
}
