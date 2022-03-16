package com.myapplication1.home.adapter;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.myapplication1.R;

import java.util.List;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/5 22:56
 */
public class ImageAdapter extends BaseAdapter {

    private Activity mContext;

    private LayoutInflater mInflater;

    private List<String> mDatas;

    private int width;

    public ImageAdapter(Activity context, List<String> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mDatas = datas;

        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);

        width = dm.widthPixels;
    }

    private void changeData(List<String> datas) {
        mDatas = datas;
    }

    public void addData(List<String> datas) {
        if (mDatas != null) {
            mDatas.addAll(datas);
        } else {
            changeData(datas);
        }
    }

    @Override
    public int getCount() {
        return (mDatas != null ? mDatas.size() : 0);
    }

    @Override
    public Object getItem(int position) {
        return (mDatas != null ? mDatas.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            // 下拉项布局
            convertView = mInflater.inflate(R.layout.allcom_cominfo, null);

            holder = new ViewHolder();

            holder.img_list = (ImageView) convertView.findViewById(R.id.allcom_Cphoto);

            int screenWidth = width;

            ViewGroup.LayoutParams lp = holder.img_list.getLayoutParams();
            lp.width = screenWidth;
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;

            holder.img_list.setLayoutParams(lp);

            holder.img_list.setMaxWidth(screenWidth);
            holder.img_list.setMaxHeight((int) (screenWidth * 5));// 这里其实可以根据需求而定，我这里测试为最大宽度的1.5倍

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //ImageLoaderUtil.getInstance().displayListItemImage(imgUrl, holder.img_list);

        return convertView;
    }

    static class ViewHolder {

        ImageView img_list;
    }
}
