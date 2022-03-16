package com.myapplication1.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.myapplication1.R;
import com.myapplication1.home.bean.Community;

import java.util.List;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/4 19:21
 */
public class ComAdapter extends RecyclerView.Adapter<ComAdapter.ComView>{
    private List<Community> communities;

    public ComAdapter(List<Community> list) {
        communities = list;
    }

    @Override
    public ComView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.allcom_cominfo, viewGroup, false);
        return new ComView(view);
    }

    @Override
    public void onBindViewHolder(ComView comView, int position) {
        comView.Cname.setText(communities.get(position).getCname());
        comView.Caddress.setText(communities.get(position).getCaddress());
    }

    @Override
    public int getItemCount() {
        return communities.size();
    }

    static class ComView extends  RecyclerView.ViewHolder {
        TextView Cname;
        TextView Caddress;

        ComView(View view){
            super(view);
            Cname = view.findViewById(R.id.allcom_Cname );
            Caddress = view.findViewById(R.id.allcom_Caddress);
        }

    }
}
