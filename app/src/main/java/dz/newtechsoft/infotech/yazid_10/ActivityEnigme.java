package dz.newtechsoft.infotech.yazid_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infotech.yazid_10.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ActivityEnigme extends AppCompatActivity {
    private EditText nom,prenom,age,email,tel,ville,willaya,answer1;
    private String enigma_id;
    private TextView enigma;
    private Button b;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("enigma");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enigme);
        enigma=findViewById(R.id.enigma);
        Query myTopPostsQuery = myRef.limitToLast(1);

        myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    enigma.setText(ds.getValue(Enigma.class).getContent());
                    enigma_id=ds.getKey();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        nom=findViewById(R.id.nom1);
        prenom=findViewById(R.id.prenom1);
        age=findViewById(R.id.age1);
        email=findViewById(R.id.email1);
        tel=findViewById(R.id.tel1);
        ville=findViewById(R.id.ville1);
        willaya=findViewById(R.id.willaya1);
        answer1=findViewById(R.id.answer1);
        b=findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference myRef1 = database.getReference("participant_enigma").push();
                participant_enigma pe=new participant_enigma(nom.getText().toString(),prenom.getText().toString(),age.getText().toString(),ville.getText().toString(),willaya.getText().toString(),tel.getText().toString(),answer1.getText().toString(),email.getText().toString(),enigma_id);
                myRef1.setValue(pe);
                Intent i = new Intent(ActivityEnigme .this,Home_scroling.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "شكرا على مشاركتك في اللغز .سوف نتحقق من صحة اجابتك ", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
