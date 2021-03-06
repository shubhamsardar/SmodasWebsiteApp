package in.co.tripin.smodaswebsiteapp;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;
import com.keiferstone.nonet.NoNet;

import java.util.Arrays;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "Smodas Splash";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        NoNet.monitor(this)
                .poll()
                .snackbar();

        FirebaseApp.initializeApp(this);

        FirebaseMessaging.getInstance().subscribeToTopic("generalNotifications");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if(FirebaseAuth.getInstance().getCurrentUser()!=null){
                    startActivity(new Intent(SplashActivity.this,MainNavActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SplashActivity.this,AuthLandingActivity.class));
                    finish();
                }
            }
        }, 3000);


    }


}
