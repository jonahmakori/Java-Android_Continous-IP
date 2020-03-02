package com.moringa.lyrical_musicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TypeOfMusicActivity extends AppCompatActivity {
    @BindView(R.id.musicGenresTextView)
    TextView mMusicGenresTextView;
    @BindView(R.id.listView)
    ListView mListView;
    public static final String TAG = TypeOfMusicActivity.class.getSimpleName();
    private String[] musicGenres = new String[] {"Hip Hop","Soft Rock", "Hard Rock", "Reggae", "Pop Music",
            "Rhythm and Blues", "Electronic Dance Music(EDM)", "Heavy Metal", "Country Music", "Classical Music",
            "Jazz Music", "Gospel Music", "House Music", "New Wave", "Live Performance", "Dance Music" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicgenres);
        ButterKnife.bind(this);
//        MusicGenresArrayAdapter adapter = new MusicGenresArrayAdapter(TypeOfMusicActivity.this, android.R.layout.simple_list_item_1, musicGenres);

//        mListView.setAdapter(adapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String musicGenres = ((TextView) view).getText().toString();
//         Log.v(TAG,"In the onItemClickListener!");
//                Toast.makeText(TypeOfMusicActivity.this, musicGenres, Toast.LENGTH_LONG).show();
//            }
//        });
        Log.d(TAG, "In the onCreate method!");
        Intent intent = getIntent();
        String musicGenres = intent.getStringExtra("musicGenres");
        mMusicGenresTextView.setText("Here are all the Music Genres Available :" + musicGenres);
    }
}
