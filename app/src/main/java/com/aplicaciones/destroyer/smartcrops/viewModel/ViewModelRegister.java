package com.aplicaciones.destroyer.smartcrops.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.model.User;
import com.aplicaciones.destroyer.smartcrops.view.activitys.IntroActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

/**
 * Created by Destroyer on 5/01/2018.
 */

public class ViewModelRegister {

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    public ObservableField<String> password2 = new ObservableField<>();

    private  FirebaseAuth mAuth;

    public ViewModelRegister() {
        mAuth= FirebaseAuth.getInstance();
    }

    public boolean verifyEmail(){

        String email = this.email.get();

        if (email!= null){
            for (int i=0; i<email.length(); i++){

                if (email.charAt(i)=='@')
                    return  true;

            }
        }
         return  false;
    }

    public  boolean verifyPassword(){

        String pass1 = password.get();
        String pass2 = password2.get();

        if (pass1.equals(pass2))
            return true;
        else
            return false;
    }

    public void createAccount(View view){

        Context context = view.getContext();

        if(!verifyEmail()){
            showMessage(context, context.getString(R.string.verify_email));
            return;
        }
        if(!verifyPassword()){
            showMessage(context, context.getString(R.string.password_match));
            return;
        }

        mAuth.createUserWithEmailAndPassword(email.get(), password.get()).addOnCompleteListener(new RegisterListener(context));


    }

    public void introActivity(Context context, User user){
        Intent intent = new Intent(context, IntroActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    public  void showMessage( Context context, String msn){

        Toast toast = Toast.makeText(context, msn, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

    }

    private class RegisterListener implements  OnCompleteListener{

        Context context;

        public RegisterListener(Context context) {
            this.context = context;
        }

        @Override
        public void onComplete(@NonNull Task task) {
            if (task.isSuccessful()){
                FirebaseUser user = mAuth.getCurrentUser();
                UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder().setDisplayName(username.get()).build();
                user.updateProfile(profile);
                showMessage(context, context.getString(R.string.new_user));

                introActivity(context, new User(user.getDisplayName()));



            }else {
                showMessage(context, context.getString(R.string.fall_create_user));
            }
        }
    }
}
