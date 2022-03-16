package com.myapplication1.home.view;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.view.*;
import android.os.Bundle;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.myapplication1.R;
import com.myapplication1.base.BaseFragment;
import com.myapplication1.component.MyNestedScrollView;
import com.myapplication1.home.bean.Community;
import com.myapplication1.home.dao.CommunityDao;
import com.myapplication1.utils.FragmentAdapter;
import com.myapplication1.utils.SharedPreferencesUtil;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * HomeFragment
 *
 * @author lenovo
 * @date 2022/01/20
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private List<Fragment> fragments = new ArrayList<>();
    private List<com.myapplication1.home.bean.Banner> banners = new ArrayList<>();

    private List<Community> comList = new ArrayList<>();
    private SharedPreferencesUtil communityShare;
    private CommunityDao communityDao;

    private ViewPager2 viewPager2;
    private AllComFragment allComFragment;
    private AllParkFragment allParkFragment;

    private SwipeRefreshLayout refresh;
    private MyNestedScrollView scrollView;
    private LinearLayout llallCom, llallPark, llCurrent, llHead1, llHead2, llTitle;
    private LinearLayout llMap;
    private Banner banner;
    private TextView tvallCom, tvallPark, tvCurrent;
    private TextView ivallCom, ivallPark, ivCurrent;
    private Button goMap;

    public HomeFragment() { }

    @SuppressLint("ResourceAsColor")
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        viewPager2 = view.findViewById(R.id.home_viewPager);
        refresh = view.findViewById(R.id.home_Refresh);
        refresh.setColorSchemeColors(R.color.colorWhite, R.color.colorBlack);
        refresh.setOnRefreshListener(this);
        scrollView = view.findViewById(R.id.home_Scroll);

        llHead1 = view.findViewById(R.id.home_llHead1);
        llHead2 = view.findViewById(R.id.home_llHead2);
        llTitle = view.findViewById(R.id.home_llTitle);

        goMap = view.findViewById(R.id.home_goMap);
        llMap = view.findViewById(R.id.home_llMap);

        banner = view.findViewById(R.id.home_Banner);

        llallCom = view.findViewById(R.id.home_llallCom);
        llallPark = view.findViewById(R.id.home_llallPark);
        tvallCom = view.findViewById(R.id.home_tvallCom);
        tvallPark = view.findViewById(R.id.home_tvallPark);
        ivallCom = view.findViewById(R.id.home_ivallCom);
        ivallPark = view.findViewById(R.id.home_ivallPark);
        return view;
    }

    @Override
    protected void initData() {
        communityDao = new CommunityDao(getContext());
        comList = communityDao.getAllCom();
        communityShare = new SharedPreferencesUtil(getContext(), "community");
        communityShare.setDataList("comList", comList);
    }

    private void tipHead() {
        llHead2.setAlpha(0);
        scrollView.setNestedScrollingEnabled(true);
        scrollView.setScrollViewListener(new MyNestedScrollView.ScrollViewListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onScrollChanged(MyNestedScrollView scrollView, int x, int y, int oldx, int oldy) {
                float alpha = 0;
                if (y >= 235) {
                    alpha = 1;
                    if (y >= 1260) {
                        llTitle.setBackgroundColor(Color.WHITE);
                        llTitle.setElevation(5);
                    }
                    else {
                        llTitle.setBackgroundColor(0xF4F4F4);
                    }
                } else {
                    alpha = (y - 20) / (float) 235;
                    llTitle.setBackgroundColor(0xF4F4F4);
                }
                llHead2.setAlpha(alpha);
            }
        });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                comList.clear();
                initData();
                refresh.setRefreshing(false);
            }
        },1000);
    }

    private void initBanner() {
        banners.add(new com.myapplication1.home.bean.Banner("banner1", R.mipmap.banner1));
        banners.add(new com.myapplication1.home.bean.Banner("banner2", R.mipmap.banner2));
        banners.add(new com.myapplication1.home.bean.Banner("banner3", R.mipmap.banner3));
        banner.setAdapter(new BannerImageAdapter<com.myapplication1.home.bean.Banner>(banners) {
            @Override
            public void onBindView(BannerImageHolder holder, com.myapplication1.home.bean.Banner data, int position, int size) {
                //BannerImageHolder 利用banner实现图片加载,也可自己实现图片加载
                Glide.with(getActivity())
                        .load(data.getBaphoto())
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(60)))
                        .into(holder.imageView);
            }
        }).addBannerLifecycleObserver(this)   //添加生命周期观察者
                .setIndicator(new CircleIndicator(getActivity()))
                .setOnBannerListener(new OnBannerListener() {

                    @Override
                    public void OnBannerClick(Object data, int position) {

                    }
                });
    }

    private void initFragment() {
        allComFragment = new AllComFragment();
        allParkFragment = new AllParkFragment();

        fragments.add(allComFragment);
        fragments.add(allParkFragment);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView();
        initData();
        initFragment();
        initBanner();
        tipHead();
        llallCom.setOnClickListener(this);
        llallPark.setOnClickListener(this);

        llallCom.setSelected(true);
        tvallCom.setSelected(true);
        ivallCom.setSelected(true);
        llCurrent = llallCom;
        tvCurrent = tvallCom;
        ivCurrent = ivallCom;

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), getLifecycle(), fragments);
        viewPager2.setAdapter(fragmentAdapter);
        viewPager2.setCurrentItem(0);
        ivallPark.setAlpha(0);
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
        return view;
    }

    @Override
    public void onClick(View v) {
        int idx;
        int id = v.getId();
        switch (id) {
            case R.id.home_llallCom:
                idx = 0;
                break;
            case R.id.home_llallPark:
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
        ivCurrent.setAlpha(0);
        switch (id) {
            case 0:
                llallCom.setSelected(true);
                llCurrent = llallCom;
                tvallCom.setSelected(true);
                tvCurrent = tvallCom;
                ivallCom.setSelected(true);
                ivCurrent = ivallCom;
                ivCurrent.setAlpha(1);
                break;
            case 1:
                llallPark.setSelected(true);
                llCurrent = llallPark;
                tvallPark.setSelected(true);
                tvCurrent = tvallPark;
                ivallPark.setSelected(true);
                ivCurrent = ivallPark;
                ivCurrent.setAlpha(1);
                break;
            default:
                break;
        }
    }
}
