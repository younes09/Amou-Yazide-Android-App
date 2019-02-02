package dz.newtechsoft.infotech.yazid_10;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.infotech.yazid_10.R;

public class AboutYaid extends AppCompatActivity {

    private boolean isOpen = false ;

    private ConstraintSet layout1,layout2;

    private ConstraintLayout constraintLayout ;

    private ImageView imageViewPhoto;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_yaid);



        // changing the status bar color to transparent
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}