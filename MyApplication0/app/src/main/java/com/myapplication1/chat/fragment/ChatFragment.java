package com.myapplication1.chat.fragment;

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
 * @date : 2022/1/18 20:43
 */
public class ChatFragment extends Fragment implements View.OnClickListener {
    private ViewPager2 viewPager2;
    private List<Fragment> fragments = new ArrayList<>();
    private LinearLayout llMsg, llNot, llCurrent;
    private TextView tvMsg, tvNot, tvCurrent;
    private TextView ivMsg, ivNot, ivCurrent;

    public ChatFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        viewPager2 = (ViewPager2) view.findViewById(R.id.chat_viewPager);

        llMsg = (LinearLayout) view.findViewById(R.id.chat_llMsg);
        llNot = (LinearLayout) view.findViewById(R.id.chat_llNot);

        llMsg.setOnClickListener(this);
        llNot.setOnClickListener(this);

        tvMsg = (TextView) view.findViewById(R.id.chat_tvMsg);
        tvNot = (TextView) view.findViewById(R.id.chat_tvNot);

        ivMsg = (TextView) view.findViewById(R.id.chat_ivMsg);
        ivNot = (TextView) view.findViewById(R.id.chat_ivNot);

        llMsg.setSelected(true);
        tvMsg.setSelected(true);
        ivMsg.setSelected(true);
        llCurrent = llMsg;
        tvCurrent = tvMsg;
        ivCurrent = ivMsg;
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
        MsgFragment msgFragment = new MsgFragment();
        NoticeFragment noticeFragment = new NoticeFragment();

        fragments.add(msgFragment);
        fragments.add(noticeFragment);
    }

    @Override
    public void onClick(View v) {
        int idx;
        int id = v.getId();
        switch (id) {
            case R.id.chat_llMsg:
                idx = 0;
                break;
            case R.id.chat_llNot:
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
                llMsg.setSelected(true);
                llCurrent = llMsg;
                tvMsg.setSelected(true);
                tvCurrent = tvMsg;
                ivMsg.setSelected(true);
                ivCurrent = ivMsg;
                break;
            case 1:
                llNot.setSelected(true);
                llCurrent = llNot;
                tvNot.setSelected(true);
                tvCurrent = tvNot;
                ivNot.setSelected(true);
                ivCurrent = ivNot;
                break;
            default:
                break;
        }
    }
}
