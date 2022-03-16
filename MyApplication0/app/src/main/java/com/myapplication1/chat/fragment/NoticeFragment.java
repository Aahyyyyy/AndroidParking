package com.myapplication1.chat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.myapplication1.R;

/**
 * @author : Aahyyyyy
 * @date : 2022/2/6 18:34
 */
public class NoticeFragment extends Fragment {
    public NoticeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notice, container, false);
    }
}
