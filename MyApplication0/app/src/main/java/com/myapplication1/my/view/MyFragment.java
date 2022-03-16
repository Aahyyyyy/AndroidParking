package com.myapplication1.my.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.myapplication1.R;
import com.myapplication1.component.MyScrollView;

import java.util.Objects;

/**
 * @author : Aahyyyyy
 * @date : 2022/1/18 20:43
 */
public class MyFragment extends Fragment {
    private boolean isLogin = false;
    private boolean isFirst = true;
    private RelativeLayout llHead;
    private MyScrollView scrollView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        scrollView = (MyScrollView) view.findViewById(R.id.my_Scroll);
        llHead = (RelativeLayout) view.findViewById(R.id.my_llHead);
        llHead.setAlpha(0);

        scrollView.setScrollViewListener(new MyScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
                float alpha = 0;
                if (y >= 205) {
                    alpha = 1;
                } else {
                    System.out.println(y);
                    alpha = (y - 20) / (float) 235;
                }
                llHead.setAlpha(alpha);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences preferences = getActivity().getSharedPreferences("ownerState", Activity.MODE_PRIVATE);
        isLogin = preferences.getBoolean("isLogin", false);
        if (!isLogin && isFirst) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        isFirst = false;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button my_gotolog = (Button) Objects.requireNonNull(getActivity()).findViewById(R.id.my_gotolog);

        my_gotolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
