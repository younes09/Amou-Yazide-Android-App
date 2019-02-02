package dz.newtechsoft.infotech.yazid_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infotech.yazid_10.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Participate extends AppCompatActivity {
    private EditText nom,prenom,age,email,tel,ville,willaya;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participate);
        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        age=findViewById(R.id.age);
        email=findViewById(R.id.email);
        tel=findViewById(R.id.tel);
        ville=findViewById(R.id.ville);
        willaya=findViewById(R.id.willaya);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = database.getReference("particepant").push();
                particepant pe=new particepant(nom.getText().toString(),prenom.getText().toString(),age.getText().toString(),ville.getText().toString(),willaya.getText().toString(),tel.getText().toString(),email.getText().toString());
                myRef1.setValue(pe);
                Intent i = new Intent(Activity_Participate .this,Home_scroling.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "شكرا على مشاركتك. ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
