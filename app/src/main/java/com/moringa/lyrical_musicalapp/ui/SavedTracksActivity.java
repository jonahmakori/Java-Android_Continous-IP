package com.moringa.lyrical_musicalapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.lyrical_musicalapp.Constants;
import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.adapters.FireBaseTrackViewHolder;
import com.moringa.lyrical_musicalapp.models.TrackList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedTracksActivity extends AppCompatActivity {
    private DatabaseReference mTracksReference;
    private FirebaseRecyclerAdapter<TrackList, FireBaseTrackViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_list);
        ButterKnife.bind(this);

        hideProgressBar();
        mRecyclerView.setVisibility(View.VISIBLE);

        mTracksReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRACKS);
        setUpFireBaseAdapter();
    }

    private void setUpFireBaseAdapter() {
        FirebaseRecyclerOptions<TrackList> options = new FirebaseRecyclerOptions.Builder<TrackList>()
                .setQuery(mTracksReference,  TrackList.class)
                .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<TrackList, FireBaseTrackViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FireBaseTrackViewHolder fireBaseTrackAdapter, int i, @NonNull TrackList trackList) {
                fireBaseTrackAdapter.bindTrack(trackList);
            }

            @NonNull
            @Override
            public FireBaseTrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_list_item, parent, false);
                return new FireBaseTrackViewHolder(view);
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

    }

    @Override
    protected void onStart() {

        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {

        super.onStop();
        mFirebaseAdapter.stopListening();
    }


    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
























//package com.moringa.lyrical_musicalapp.ui;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ProgressBar;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.moringa.lyrical_musicalapp.Constants;
//import com.moringa.lyrical_musicalapp.R;
//import com.moringa.lyrical_musicalapp.adapters.FirebaseTrackListAdapter;
//import com.moringa.lyrical_musicalapp.models.TrackList;
//import com.moringa.lyrical_musicalapp.util.OnStartDragListener;
//import com.moringa.lyrical_musicalapp.util.SimpleItemTouchHelperCallback;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class SavedTracksActivity extends AppCompatActivity implements OnStartDragListener {
//    private DatabaseReference mTracksReference;
//    private FirebaseTrackListAdapter mFirebaseAdapter;
//    private ItemTouchHelper mItemTouchHelper;
//
//    @BindView(R.id.recyclerView)
//    RecyclerView mRecyclerView;
//    @BindView(R.id.progressBar)
//    ProgressBar mProgressBar;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_track_list);
//        ButterKnife.bind(this);
//
//        hideProgressBar();
//        mRecyclerView.setVisibility(View.VISIBLE);
//
//        //mTracksReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRACKS);
//        setUpFireBaseAdapter();
//    }
//
//    private void setUpFireBaseAdapter() {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        mTracksReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRACKS).child(uid);
//        FirebaseRecyclerOptions<TrackList> options = new FirebaseRecyclerOptions.Builder<TrackList>()
//                .setQuery(mTracksReference,  TrackList.class)
//                .build();
//
//
////        mFirebaseAdapter = new FirebaseRecyclerAdapter<TrackList, FireBaseTrackViewHolder>(options) {
////            @Override
////            protected void onBindViewHolder(@NonNull FireBaseTrackViewHolder fireBaseTrackAdapter, int i, @NonNull TrackList trackList) {
////                fireBaseTrackAdapter.bindTrack(trackList);
////            }
////
////            @NonNull
////            @Override
////            public FireBaseTrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_list_drag_item, parent, false);
////                return new FireBaseTrackViewHolder(view);
////            }
////        };
//
//
//
//        mFirebaseAdapter = new FirebaseTrackListAdapter(options, mTracksReference, this, this);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(mFirebaseAdapter);
//        mRecyclerView.setHasFixedSize(true);
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mFirebaseAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (mFirebaseAdapter != null){
//            mFirebaseAdapter.stopListening();
//        }
//
//    }
//
//
//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
//        mItemTouchHelper.startDrag(viewHolder);
//    }
//}