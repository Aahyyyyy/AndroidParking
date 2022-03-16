package com.myapplication1.like.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.myapplication1.R;

/**
 * @author : Aahyyyyy
 * @date : 2022/2/8 9:05
 */
public class ParkFragment extends Fragment {
    public ParkFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_park, container, false);
    }
}
