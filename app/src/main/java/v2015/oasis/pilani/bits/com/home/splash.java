package v2015.oasis.pilani.bits.com.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ImageView image=(ImageView) findViewById(R.id.image);

        Animation anim1 =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.loading);

        anim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Thread sync=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SyncDB.refreshEvent(getApplicationContext());
                        SyncDB.refreshResult(getApplicationContext());
                    }

                });
                sync.setPriority(Thread.MAX_PRIORITY);
                sync.start();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(anim1);

        final Intent i = new Intent(this, MainHome.class);

        //Setting up a delay
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                startActivity(i);
            }
        }, 8000);

    }


}

