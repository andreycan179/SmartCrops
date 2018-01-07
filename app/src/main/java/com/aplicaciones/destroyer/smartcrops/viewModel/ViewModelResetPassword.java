package com.aplicaciones.destroyer.smartcrops.viewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.aplicaciones.destroyer.smartcrops.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Destroyer on 6/01/2018.
 */

public class ViewModelResetPassword {

    public ObservableField<String> email;
    private FirebaseAuth auth ;

    public ViewModelResetPassword(){
        email=new ObservableField<>();
        auth= FirebaseAuth.getInstance();
    }

    public void resetPassword(View view){
        final Context context = view.getContext();
        if (verifyEmail()){
            auth.sendPasswordResetEmail(email.get())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                showMessage(context, context.getString(R.string.email_send_successful));
                            }else {
                                showMessage(context, context.getString(R.string.email_send_unsuccessful));
                            }
                        }
                    });
            email.set(null);
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
}
