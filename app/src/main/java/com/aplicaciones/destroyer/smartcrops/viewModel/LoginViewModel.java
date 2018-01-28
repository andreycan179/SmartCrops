package com.aplicaciones.destroyer.smartcrops.viewModel;



import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
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
import com.aplicaciones.destroyer.smartcrops.view.activitys.RegisterActivity;
import com.aplicaciones.destroyer.smartcrops.view.activitys.ResetPasswordActivity;
import com.aplicaciones.destroyer.smartcrops.view.fragments.LoadFragment;


/**
 * Created by Destroyer on 3/01/2018.
 */

public class LoginViewModel extends BaseObservable {

    private User user;
    private DataBase baseData;

    public LoginViewModel(){
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

        Context context = view.getContext();

        if (user.email==null || user.password==null){
            Toast toast = Toast.makeText(context, context.getString(R.string.empty_login),Toast.LENGTH_SHORT );
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }else {
            LoginAsyncTask loginAsyncTask = new LoginAsyncTask(context);
            loginAsyncTask.execute();

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

    private class LoginAsyncTask extends AsyncTask<Void,Void,Boolean>{

        private Context context;
        private LoadFragment dialog;

        public  LoginAsyncTask(Context context){
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new LoadFragment();
            dialog.show(((AppCompatActivity)context).getSupportFragmentManager(),"loadFragment");
        }

        @Override
        protected Boolean doInBackground(Void... args) {
            return baseData.login(user);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            dialog.dismiss();

            if(aBoolean){
                //Log.d("Username", user.userName);
                introActivity(context, user);
                setEmail(null);
                setPassword(null);
                Log.d("Call","IntroActivity");
            }else {
                Toast toast = Toast.makeText(context, context.getString(R.string.error_login),Toast.LENGTH_SHORT );
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }


        }
    }


}
