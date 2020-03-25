package com.moringa.lyrical_musicalapp.models;

import android.os.Parcel;

import org.parceler.ParcelConverter;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

class ItemListParcelConverter implements ParcelConverter<List<Track>> {
    @Override
    public void toParcel(List<Track> input, Parcel parcel) {
        if (input == null) {
            parcel.writeInt(-1);
        }
        else {
            parcel.writeInt(input.size());
            for (Track track : input) {
                parcel.writeParcelable(Parcels.wrap(track), 0);
            }
        }
    }

    @Override
    public List<Track> fromParcel(Parcel parcel) {
        int size = parcel.readInt();
        if (size < 0) return null;
        List<Track> items = new ArrayList<Track>();
        for (int i = 0; i < size; ++i) {
            items.add((Track) Parcels.unwrap(parcel.readParcelable(Track.class.getClassLoader())));
        }
        return items;
    }
    }
