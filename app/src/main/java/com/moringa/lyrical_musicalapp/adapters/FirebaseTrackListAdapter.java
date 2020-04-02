package com.moringa.lyrical_musicalapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.models.TrackList;
import com.moringa.lyrical_musicalapp.util.ItemTouchHelperAdapter;
import com.moringa.lyrical_musicalapp.util.OnStartDragListener;

public class FirebaseTrackListAdapter extends FirebaseRecyclerAdapter<TrackList, FireBaseTrackViewHolder> implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseTrackListAdapter(FirebaseRecyclerOptions<TrackList> options,
                                    DatabaseReference ref,
                                    OnStartDragListener onStartDragListener,
                                    Context context) {
        super(options);
        mRef = ref;
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onBindViewHolder(@NonNull final FireBaseTrackViewHolder fireBaseTrackViewHolder, int position, @NonNull TrackList trackList) {
        fireBaseTrackViewHolder.bindTrack(trackList);
        fireBaseTrackViewHolder.mArtistTextView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(fireBaseTrackViewHolder);
                }
                return false;
            }
        });

    }

    @NonNull
    @Override
    public FireBaseTrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_list_drag_item, parent, false);
        return new FireBaseTrackViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        getRef(position).removeValue();
    }
}
