package com.aplicaciones.destroyer.smartcrops.viewModel;


import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.dataBase.DataBase;
import com.aplicaciones.destroyer.smartcrops.dataBase.DataFireBase;
import com.aplicaciones.destroyer.smartcrops.model.User;
import com.aplicaciones.destroyer.smartcrops.view.activitys.IntroActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.LoginActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.RegisterActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.ResetPasswordActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Destroyer on 3/01/2018.
 */

public class ViewModelLogin extends BaseObservable {

    private User user;
    private DataBase baseData;

    public ViewModelLogin(){
        user=new User();
        baseData= new DataFireBase();
    }

    @Bindable
    public String getEmail() {
        return user.email;
    }

    public void setEmail(String email) {
        user.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return user.password;
    }

    public void setPassword(String password) {
        user.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void login(View view){

        final Context context = view.getContext();

        if (user.email==null || user.password==null){
            Toast toast = Toast.makeText(context, context.getString(R.string.empty_login),Toast.LENGTH_SHORT );
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }else {
            Thread t = new Thread( new LoginThread(context));

            t.start();
        }


    }

    public void introActivity(Context context, User user){
        Intent intent = new Intent(context, IntroActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    public void registerActivity(View view){
        Intent intent = new Intent(view.getContext(), RegisterActivity.class);
        view.getContext().startActivity(intent);
    }

    public void resetActivity(View view){
        Intent intent = new Intent(view.getContext(), ResetPasswordActivity.class);
        view.getContext().startActivity(intent);
    }

    public class  LoginThread implements Runnable{

        private Context context;

        private   LoginThread(Context context){
            this.context=context;
        }

        @Override
        public void run() {
            if(baseData.login(user)){
                user.userName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                introActivity(context, user);
                setEmail(null);
                setPassword(null);
                Log.d("Call","IntroActivity");
            }else {
                Looper.prepare();
                Toast toast = Toast.makeText(context, context.getString(R.string.error_login),Toast.LENGTH_SHORT );
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                Looper.loop();
            }
        }
    }
}
