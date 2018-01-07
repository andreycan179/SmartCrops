package com.aplicaciones.destroyer.smartcrops.view.activitys;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.databinding.ActivityResetPasswordBinding;
import com.aplicaciones.destroyer.smartcrops.viewModel.ResetPasswordViewModel;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityResetPasswordBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password);
        ResetPasswordViewModel password = new ResetPasswordViewModel();
        binding.setResetViewModel(password);
    }
}
