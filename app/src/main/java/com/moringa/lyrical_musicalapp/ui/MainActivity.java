package com.moringa.lyrical_musicalapp.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringa.lyrical_musicalapp.Constants;
import com.moringa.lyrical_musicalapp.MusicGenresArrayAdapter;
import com.moringa.lyrical_musicalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @BindView(R.id.viewSavedTracksButton)
    Button mViewSavedTrackButton;
    @BindView(R.id.searchTrack)
    EditText searchTrackEditText;
    @BindView(R.id.searchArtistEditText) EditText searchArtistEditText;
    @BindView(R.id.submitTrackDetails)
    Button searchTrackDetailsButton;
    @BindView(R.id.nav_view) BottomNavigationView bottomNavigationView;
    @BindView(R.id.listView)
    ListView mListView;
    public static final String TAG = TypeOfMusicActivity.class.getSimpleName();
    private String[] musicGenres = new String[] {"Hip Hop","Soft Rock", "Hard Rock", "Reggae", "Pop Music",
            "Rhythm and Blues", "Electronic Dance Music(EDM)", "Heavy Metal", "Country Music", "Classical Music",
            "Jazz Music", "Gospel Music", "House Music", "New Wave", "Live Performance", "Dance Music" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //display welcome message
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();


        searchTrackDetailsButton.setOnClickListener(this);
        mViewSavedTrackButton.setOnClickListener(this);

//        mFindMusicCategoryButton.setOnClickListener(this);
        MusicGenresArrayAdapter adapter = new MusicGenresArrayAdapter(this, android.R.layout.simple_list_item_1, musicGenres);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListner);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String musicGenres = ((TextView) view).getText().toString();
                Log.v(TAG,"In the onItemClickListener!");
                Toast.makeText(MainActivity.this, musicGenres, Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);


    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigation_dashboard:
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    return true;
                case R.id.navigation_home:
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
            return false;
        }
    };

//    private void startSoftRock() {
//        Intent intent = new Intent(MainActivity.this, SoftRockActivity.class);
//        intent.putExtra("musicGenres", musicGenres);
//        startActivity(intent);
//    }
//
//
//    public void startHipHop(){
//        Intent intent = new Intent(MainActivity.this, HipHopActivity.class);
//        intent.putExtra("musicGenres", musicGenres);
//        startActivity(intent);
//    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {


    }

    @Override
    public void onClick(View view) {
        if(view == searchTrackDetailsButton){
            String q_track = searchTrackEditText.getText().toString();
            String q_artist = searchArtistEditText.getText().toString();
            if((!(q_artist).equals("")) && (!(q_track).equals(""))) {
                addToSharedPreferences(q_track, q_artist);
            }
            Log.d("Entered Track:", q_track);
            Intent trackIntent = new Intent(MainActivity.this, TrackListActivity.class);
            trackIntent.putExtra("q_track",q_track);
            trackIntent.putExtra("q_artist",q_artist);
            startActivity(trackIntent);
        }
        if(view == mViewSavedTrackButton){
            Intent intent = new Intent(MainActivity.this, SavedTracksActivity.class);
            startActivity(intent);
        }

    }

    private void addToSharedPreferences(String q_track,String q_artist) {
        mEditor.putString(Constants.PREFERENCES_TRACK_KEY, q_track).apply();
        mEditor.putString(Constants.PREFERENCES_ARTISTNAME_KEY, q_artist).apply();

    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
