package com.myapplication1.like.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.myapplication1.R;
import com.myapplication1.utils.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Aahyyyyy
 * @date : 2022/1/21 16:46
 */
public class LikeFragment extends Fragment implements View.OnClickListener {
    private ViewPager2 viewPager2;
    private List<Fragment> fragments = new ArrayList<>();
    private LinearLayout llCom, llPark, llCurrent;
    private TextView tvCom, tvPark, tvCurrent;
    private TextView ivCom, ivPark, ivCurrent;

    public LikeFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, container, false);
        viewPager2 = (ViewPager2) view.findViewById(R.id.like_viewPager);

        llCom = (LinearLayout) view.findViewById(R.id.like_llCom);
        llPark = (LinearLayout) view.findViewById(R.id.like_llPark);

        llCom.setOnClickListener(this);
        llPark.setOnClickListener(this);

        tvCom = (TextView) view.findViewById(R.id.like_tvCom);
        tvPark = (TextView) view.findViewById(R.id.like_tvPark);

        ivCom = (TextView) view.findViewById(R.id.like_ivCom);
        ivPark = (TextView) view.findViewById(R.id.like_ivPark);

        llCom.setSelected(true);
        tvCom.setSelected(true);
        ivCom.setSelected(true);
        llCurrent = llCom;
        tvCurrent = tvCom;
        ivCurrent = ivCom;
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), getLifecycle(), fragments);
        initPager();
        viewPager2.setAdapter(fragmentAdapter);
        viewPager2.setCurrentItem(0);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void initPager() {
        ComFragment comFragment = new ComFragment();
        ParkFragment parkFragment = new ParkFragment();

        fragments.add(comFragment);
        fragments.add(parkFragment);
    }

    @Override
    public void onClick(View v) {
        int idx;
        int id = v.getId();
        switch (id) {
            case R.id.like_llCom:
                idx = 0;
                break;
            case R.id.like_llPark:
                idx = 1;
                break;
            default:
                idx = 0;
        }
        changeTab(idx);
        viewPager2.setCurrentItem(idx, false);
    }

    private void changeTab(int id) {
        llCurrent.setSelected(false);
        tvCurrent.setSelected(false);
        ivCurrent.setSelected(false);
        switch (id) {
            case 0:
                llCom.setSelected(true);
                llCurrent = llCom;
                tvCom.setSelected(true);
                tvCurrent = tvCom;
                ivCom.setSelected(true);
                ivCurrent = ivCom;
                break;
            case 1:
                llPark.setSelected(true);
                llCurrent = llPark;
                tvPark.setSelected(true);
                tvCurrent = tvPark;
                ivPark.setSelected(true);
                ivCurrent = ivPark;
                break;
            default:
                break;
        }
    }
}
