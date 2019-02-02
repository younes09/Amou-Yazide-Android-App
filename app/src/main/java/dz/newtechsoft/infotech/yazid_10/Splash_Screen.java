package dz.newtechsoft.infotech.yazid_10;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.infotech.yazid_10.R;

public class Splash_Screen extends AppCompatActivity {

    ImageView v;
    long x = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);



        // set statu bar backgraound to trancparent
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        v = (ImageView) findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        v.setAnimation(animation);

        Handler /*h = new Handler(),*/h2 = new Handler();

       /* h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //v.animate().translationY(-200);
                //t.setText("مَرْحبا");
            }
        },1000);*/



        h2.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_Screen.this,Home_scroling.class);
                startActivity(i);
               /*if(haveInternetConnection()){

                }
                else{
                    Toast.makeText(null, "Veuillez verifier votre connection internet !", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    finish();
                    System.exit(0);
                }*/

            }
        },x);

    }
    @Override
    protected void onResume() {
        super.onResume();
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_Screen.this,Home_scroling.class);
                startActivity(i);
            }
        },x);
        x = 2000;
    }

    private boolean haveInternetConnection(){
        // Fonction haveInternetConnection : return true si connecté, return false dans le cas contraire
        NetworkInfo network = ((ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (network==null || !network.isConnected())
        {
            // Le périphérique n'est pas connecté à Internet
            return false;
        }
        // Le périphérique est connecté à Internet
        return true;
    }
}