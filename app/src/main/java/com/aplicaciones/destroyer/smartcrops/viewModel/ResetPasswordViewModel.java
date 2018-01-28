package com.aplicaciones.destroyer.smartcrops.viewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.aplicaciones.destroyer.smartcrops.R;
import com.aplicaciones.destroyer.smartcrops.dataBase.DataFireBase;
import com.aplicaciones.destroyer.smartcrops.view.fragments.LoadFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Destroyer on 6/01/2018.
 */

public class ResetPasswordViewModel {

    public ObservableField<String> email;
    private FirebaseAuth auth ;

    public ResetPasswordViewModel(){
        email=new ObservableField<>();
        auth= FirebaseAuth.getInstance();
    }

    public void resetPassword(View view){
        Context context = view.getContext();
        if (verifyEmail()){
            ResetPasswordAsyncTask reset = new ResetPasswordAsyncTask(context);
            reset.execute();
        }
        else {
            showMessage(context, context.getString(R.string.verify_email));
        }
    }

    private   void showMessage( Context context, String msn){

        Toast toast = Toast.makeText(context, msn, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

    }

    private boolean verifyEmail(){

        String email = this.email.get();

        if (email!= null){
            for (int i=0; i<email.length(); i++){

                if (email.charAt(i)=='@')
                    return  true;

            }
        }
        return  false;
    }

    private  class ResetPasswordAsyncTask extends AsyncTask<Void, Void, Boolean>{

        private Context context;
        private LoadFragment dialog;

        ResetPasswordAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new LoadFragment();
            dialog.show(((AppCompatActivity)context).getSupportFragmentManager(),"loadFragment");
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            DataFireBase base = new DataFireBase();
            return base.resetPassword(email.get());
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            dialog.dismiss();
            if (aBoolean){
                showMessage(context, context.getString(R.string.email_send_successful));
                email.set(null);
            }else {
                showMessage(context, context.getString(R.string.email_send_unsuccessful));
            }
        }
    }

}
