package dz.newtechsoft.infotech.yazid_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.infotech.yazid_10.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityTimeLine extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("event");
    RecyclerView recyclerView;
    List<ItemTimeLine> mlist;
    AdapterTimeLine adapter;
    ItemTimeLine itemTimeLine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        recyclerView = findViewById(R.id.rv_list);
        mlist = new ArrayList<>();
        itemTimeLine = new ItemTimeLine();
        adapter = new AdapterTimeLine(this,mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // TODO: karim add here data for TimeLine from DB   |       day       | month    |   year  |     time    |       Text description                                        |
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                mlist.removeAll(mlist);
                recyclerView.setAdapter(adapter);
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    itemTimeLine = ds.getValue(ItemTimeLine.class);
                    mlist.add(itemTimeLine);
                }
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        //for (int i=0;i <10 ;i++) mlist.add(new ItemTimeLine(Integer.toString(i),"Jan","2018","21:20","عموا يازيد سيقيم حفل لللأطفال بمناسبة عيد الطفولة"));


    }
}
