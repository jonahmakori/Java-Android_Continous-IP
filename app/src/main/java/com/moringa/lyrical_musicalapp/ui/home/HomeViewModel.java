package com.moringa.lyrical_musicalapp.ui.home;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moringa.lyrical_musicalapp.MainActivity;
import com.moringa.lyrical_musicalapp.MusicGenresArrayAdapter;
import com.moringa.lyrical_musicalapp.R;
import com.moringa.lyrical_musicalapp.TypeOfMusicActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeViewModel extends ViewModel implements View.OnClickListener {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    public void onClick(View view) {

    }

    private class Button {
    }
}