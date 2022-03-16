package com.myapplication1.utils;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.myapplication1.home.bean.Community;

import java.util.List;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/12 21:45
 */
public class DiffCallback extends DiffUtil.Callback {
    private List<Community> oldList;
    private List<Community> newList;

    public DiffCallback(List<Community> oldList, List<Community> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Community oldItem = oldList.get(oldItemPosition);
        Community newItem = newList.get(newItemPosition);
        return oldItem.getCno().equals(newItem.getCno());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Community oldItem = oldList.get(oldItemPosition);
        Community newItem = newList.get(newItemPosition);
        if (!TextUtils.equals(oldItem.getCname(), newItem.getCname())) {
            return false;
        }
        if (!TextUtils.equals(oldItem.getCaddress(), newItem.getCaddress())) {
            return false;
        }
        return true;
    }
}
