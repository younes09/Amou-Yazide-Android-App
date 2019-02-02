package dz.newtechsoft.infotech.yazid_10;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infotech.yazid_10.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Home_scroling extends AppCompatActivity {

    CardView cv, cv1, cv2, cv3, cv4, cv5, cv6, cv7;
    ImageView fb, youtube, twet, insta;
    TextView privacy;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("video");
    private Item_video item_video;
    Intent intent;
    String vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_scroling);

        cv = (CardView) findViewById(R.id.bankcardId1);
        cv1 = (CardView) findViewById(R.id.bankcardId2);
        cv2 = (CardView) findViewById(R.id.bankcardId3);
        cv3 = (CardView) findViewById(R.id.bankcardId4);
        cv4 = (CardView) findViewById(R.id.bankcardId5);
        cv5 = (CardView) findViewById(R.id.bankcardId6);
        cv6 = (CardView) findViewById(R.id.bankcardId7);
        cv7 = (CardView) findViewById(R.id.bankcardId8);

        fb = (ImageView) findViewById(R.id.fbid);
        youtube = (ImageView) findViewById(R.id.youtubeid);
        twet = (ImageView) findViewById(R.id.twitid);
        insta = (ImageView) findViewById(R.id.instaid);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //category = أغاني
                intent = new Intent(Home_scroling.this, ActivityVideoWatch.class);
                // TODO: In the extra we put the first vidio to load in the vidio watcher


                intent.putExtra("Categorie", "أغاني");
                String myUserId = "أغاني";
                Query myTopPostsQuery = myRef.orderByChild("category").equalTo(myUserId).limitToFirst(1);

                myTopPostsQuery.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            item_video = ds.getValue(Item_video.class);
                            vid=item_video.getUrl();
                            intent.putExtra("VIDEO_ID", vid);
                        }
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });

            }
        });
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //category = حصص
                intent = new Intent(Home_scroling.this, ActivityVideoWatch.class);
                // TODO: In the extra we put the first vidio to load in the vidio watcher
                intent.putExtra("Categorie", "حصص");
                String myUserId = "حصص";
                Query myTopPostsQuery = myRef.orderByChild("category").equalTo(myUserId).limitToFirst(1);

                myTopPostsQuery.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            item_video = ds.getValue(Item_video.class);
                            vid=item_video.getUrl();
                            intent.putExtra("VIDEO_ID", vid);
                        }
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //category = حفلات
                intent = new Intent(Home_scroling.this, ActivityVideoWatch.class);
                // TODO: In the extra we put the first vidio to load in the vidio watcher
                intent.putExtra("Categorie", "حفلات");
                String myUserId = "حفلات";
                Query myTopPostsQuery = myRef.orderByChild("category").equalTo(myUserId).limitToFirst(1);

                myTopPostsQuery.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            item_video = ds.getValue(Item_video.class);
                            vid=item_video.getUrl();
                            intent.putExtra("VIDEO_ID", vid);
                        }
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //category = لقاءات صحغية
                intent = new Intent(Home_scroling.this, ActivityVideoWatch.class);
                // TODO: In the extra we put the first vidio to load in the vidio watcher
                intent.putExtra("Categorie", "لقاءات صحغية");
                String myUserId = "لقاءات صحغية";
                Query myTopPostsQuery = myRef.orderByChild("category").equalTo(myUserId).limitToFirst(1);

                myTopPostsQuery.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            item_video = ds.getValue(Item_video.class);
                            vid=item_video.getUrl();
                            intent.putExtra("VIDEO_ID", vid);
                        }
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });
            }
        });
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** أحداث قادمة **/
                Intent intent = new Intent(Home_scroling.this, ActivityTimeLine.class);
                startActivity(intent);
            }
        });
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** شارك في حصتنا**/
                Intent intent = new Intent(Home_scroling.this, Activity_Participate.class);
                startActivity(intent);
            }
        });
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** الإجابة على اللغز **/
                Intent intent = new Intent(Home_scroling.this, ActivityEnigme.class);
                startActivity(intent);
            }
        });
        cv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** من هو عموا يازيد**/
                Intent intent = new Intent(Home_scroling.this, AboutYaid.class);
                startActivity(intent);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                try {
                    getApplicationContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/481496292013962"));
                } catch (Exception e) {
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/481496292013962"));
                }
                startActivity(i);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "https://www.youtube.com/channel/UCty_gajGSupAFOL84rJxtyA";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(s));
                startActivity(intent);
            }
        });

        twet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                try {
                    // get the Twitter app if possible
                    getApplicationContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=131114180"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/amou_yazid"));
                }
                startActivity(intent);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/amou_yazid_officiel_");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://instagram.com/amou_yazid_officiel_")));
                }
            }
        });

        privacy = (TextView) findViewById(R.id.Privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://amou-yazid.000webhostapp.com/privacy_policy.html"));
                startActivity(browserIntent);
            }
        });
    }
}
