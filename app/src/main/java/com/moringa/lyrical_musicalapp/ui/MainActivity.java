package com.moringa.lyrical_musicalapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moringa.lyrical_musicalapp.MusicGenresArrayAdapter;
import com.moringa.lyrical_musicalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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


//        mFindMusicCategoryButton.setOnClickListener(this);
        MusicGenresArrayAdapter adapter = new MusicGenresArrayAdapter(this, android.R.layout.simple_list_item_1, musicGenres);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListner);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0){
                    startHipHop();
                }else if(i == 1){
                    startSoftRock();
                }
                String musicGenres = ((TextView) view).getText().toString();
                Log.v(TAG,"In the onItemClickListener!");
                Toast.makeText(MainActivity.this, musicGenres, Toast.LENGTH_LONG).show();
            }
        });
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigation_dashboard:
                    startActivity(new Intent(MainActivity.this, SearchTrackActivity.class));
                    return true;
                case R.id.navigation_home:
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
            return false;
        }
    };

    private void startSoftRock() {
        Intent intent = new Intent(MainActivity.this, SoftRockActivity.class);
        intent.putExtra("musicGenres", musicGenres);
        startActivity(intent);
    }


    public void startHipHop(){
        Intent intent = new Intent(MainActivity.this, HipHopActivity.class);
        intent.putExtra("musicGenres", musicGenres);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {


    }

    @Override
    public void onClick(View view) {

    }
}
