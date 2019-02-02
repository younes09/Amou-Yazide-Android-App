package dz.newtechsoft.infotech.yazid_10;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.infotech.yazid_10.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityVideoWatch extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyAGPHl6XFLCmD7M19OdPQE5O1ca_oDKSVE ";
    //public static final String VIDEO_ID = "_RfNGi9-n-8";
    public String VIDEO_ID = "_RfNGi9-n-8";
    public String ctegory = "";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("video");
    private Item_video item_video;
    List<Item_video> mlist;
    Adapter_video adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_watch);

        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);

        /** get video VIDEO_ID from Intent always to watch the video **/
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            VIDEO_ID = bundle.getString("VIDEO_ID");
            ctegory = bundle.getString("Categorie");
            Toast.makeText(getApplicationContext(), ctegory, Toast.LENGTH_SHORT).show();
        }

        /** Recycle view for Video watche
         ** Set up the rycycler view with the adapter
         **/

        recyclerView = findViewById(R.id.rv_list);
        mlist = new ArrayList<>();
        item_video = new Item_video();

        adapter = new Adapter_video(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Query query = myRef.orderByChild("category").equalTo(ctegory);
        // TODO: Karim Here you can put data for vidio from database (img ,title , url)
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                mlist.removeAll(mlist);
                recyclerView.setAdapter(adapter);
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    item_video = ds.getValue(Item_video.class);
                    mlist.add(item_video);
                }
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
/** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
/** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
            Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPlaying() {
            Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSeekTo(int arg0) {
        }

        @Override
        public void onStopped() {
        }
    };
    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(getApplicationContext(), "Fin", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoStarted() {
        }
    };
}
