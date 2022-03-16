package com.myapplication1;

import java.util.ArrayList;
import java.util.List;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.graphics.Color;

import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import androidx.appcompat.app.AppCompatActivity;
import com.myapplication1.chat.fragment.ChatFragment;
import com.myapplication1.home.view.HomeFragment;
import com.myapplication1.like.fragment.LikeFragment;
import com.myapplication1.map.fragment.MapFragment;
import com.myapplication1.my.view.MyFragment;
import com.myapplication1.utils.FragmentAdapter;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private static final int REQUEST_PERMISSIONS = 9527;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private ViewPager2 viewPager2;

    private CardView llMap;
    private LinearLayout llTab, llHome, llLike, llChat, llMy;
    private ImageView ivHome, ivLike, ivMap, ivChat, ivMy, ivCurrent;
    private TextView tvHome, tvLike, tvChat, tvMy, tvCurrent;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        SQLiteStudioService.instance().start(this);
        initView();
        initFragment();
        requestPermission();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SQLiteStudioService.instance().stop();
    }

    private void initView() {
        viewPager2 = (ViewPager2) findViewById(R.id.main_viewPager);
        llTab = (LinearLayout) findViewById(R.id.llTab);
        llTab.getBackground().setAlpha(255);

        llHome = (LinearLayout) findViewById(R.id.llHome);
        llLike = (LinearLayout) findViewById(R.id.llLike);
        llMap = (CardView) findViewById(R.id.llMap);
        llChat = (LinearLayout) findViewById(R.id.llChat);
        llMy = (LinearLayout) findViewById(R.id.llMy);

        llHome.setOnClickListener(this);
        llLike.setOnClickListener(this);
        llMap.setOnClickListener(this);
        llChat.setOnClickListener(this);
        llMy.setOnClickListener(this);

        ivHome = (ImageView) findViewById(R.id.ivHome);
        ivLike = (ImageView) findViewById(R.id.ivLike);
        ivMap = (ImageView) findViewById(R.id.ivMap);
        ivChat = (ImageView) findViewById(R.id.ivChat);
        ivMy = (ImageView) findViewById(R.id.ivMy);

        tvHome = (TextView) findViewById(R.id.tvHome);
        tvLike = (TextView) findViewById(R.id.tvLike);
        tvChat = (TextView) findViewById(R.id.tvChat);
        tvMy = (TextView) findViewById(R.id.tvMy);

        ivHome.setSelected(true);
        tvHome.setSelected(true);
        ivCurrent = ivHome;
        tvCurrent = tvHome;
    }

    private void initFragment() {
        Fragment homeFragment = new HomeFragment();
        Fragment likeFragment = new LikeFragment();
        Fragment mapFragment = new MapFragment();
        Fragment chatFragment = new ChatFragment();
        Fragment myFragment = new MyFragment();

        fragments.add(homeFragment);
        fragments.add(likeFragment);
        fragments.add(mapFragment);
        fragments.add(chatFragment);
        fragments.add(myFragment);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        viewPager2.setAdapter(fragmentAdapter);
        // 预加载所有fragments
        viewPager2.setOffscreenPageLimit(fragments.size());
        // 禁止滑动
        viewPager2.setUserInputEnabled(false);
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

    @Override
    public void onClick(View v) {
        int idx;
        int id = v.getId();
        switch (id) {
            case R.id.llHome:
                idx = 0;
                break;
            case R.id.llLike:
                idx = 1;
                break;
            case R.id.llMap:
                idx = 2;
                break;
            case R.id.llChat:
                idx = 3;
                break;
            case R.id.llMy:
                idx = 4;
                break;
            default:
                idx = 0;
        }
        changeTab(idx);
        viewPager2.setCurrentItem(idx, false);
    }

    private void changeTab(int id) {
        ivCurrent.setSelected(false);
        tvCurrent.setSelected(false);
        switch (id) {
            case 0:
                ivHome.setSelected(true);
                ivCurrent = ivHome;
                tvHome.setSelected(true);
                tvCurrent = tvHome;
                break;
            case 1:
                ivLike.setSelected(true);
                ivCurrent = ivLike;
                tvLike.setSelected(true);
                tvCurrent = tvLike;
                break;
            case 2:
                ivMap.setSelected(true);
                ivCurrent = ivMap;
                tvCurrent.setSelected(false);
                break;
            case 3:
                ivChat.setSelected(true);
                ivCurrent = ivChat;
                tvChat.setSelected(true);
                tvCurrent = tvChat;
                break;
            case 4:
                ivMy.setSelected(true);
                ivCurrent = ivMy;
                tvMy.setSelected(true);
                tvCurrent = tvMy;
                break;
            default:
                break;
        }
    }

    @AfterPermissionGranted(REQUEST_PERMISSIONS)
    private void requestPermission() {
        String[] permissions = {
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,

                Manifest.permission.SEND_SMS,
                Manifest.permission.READ_SMS,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.BROADCAST_SMS
        };

        if (EasyPermissions.hasPermissions(this, permissions)) {
            //true 有权限 开始定位
        } else {
            //false 无权限
            EasyPermissions.requestPermissions(this, "需要权限", REQUEST_PERMISSIONS, permissions);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //设置权限请求结果
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private void showMsg(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
}
