package com.myapplication1.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.myapplication1.R;

/**
 * @author : Aahyyyyy
 * @date : 2022/2/8 9:24
 */
public class AllParkFragment extends Fragment {
    public AllParkFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_allpark, container, false);
    }
}
