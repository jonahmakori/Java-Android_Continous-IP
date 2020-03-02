package com.moringa.lyrical_musicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    @BindView(R.id.findMusicCategoryButton)
//    Button mFindMusicCategoryButton;
//    @BindView(R.id.musicGenresEditText)
//    EditText mMusicGenresEditText;
//    @BindView(R.id.appNameTextView)
//    TextView mAppNameTextView;
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

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0){
                    startHipHop();
                }else if(i == 0){
                    startSoftRock();
                }
                String musicGenres = ((TextView) view).getText().toString();
                Log.v(TAG,"In the onItemClickListener!");
                Toast.makeText(MainActivity.this, musicGenres, Toast.LENGTH_LONG).show();
            }
        });
        BottomNavigationView navView = findViewById(R.id.nav_view);
//         Passing each menu ID as a set of Ids because each
//         menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void startSoftRock() {
        Intent intent = new Intent(MainActivity.this, SoftRock.class);
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
