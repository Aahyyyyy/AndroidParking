package com.myapplication1.home.view;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.myapplication1.R;
import com.myapplication1.base.BaseFragment;
import com.myapplication1.home.adapter.ComAdapter;
import com.myapplication1.home.bean.Community;
import com.myapplication1.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @author : Aahyyyyy
 * @date : 2022/2/8 9:24
 */
public class AllComFragment extends BaseFragment {
    private List<Community> comList = new ArrayList<>();
    private SharedPreferencesUtil communityShare;
    private ComAdapter adapter = null;
    private RecyclerView listView;

    public AllComFragment() { }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_allcom, null);
        listView = view.findViewById(R.id.allcom_list);
        return view;
    }

    @Override
    protected void initData() {
        communityShare = new SharedPreferencesUtil(getContext(), "community");
        comList = communityShare.getDataList("comList", Community.class);
    }

    private void initAdapter() {
        listView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new ComAdapter(comList);
        listView.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView();
        initData();
        initAdapter();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        initAdapter();
    }

}
