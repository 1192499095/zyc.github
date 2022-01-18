package com.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Viewpager2Adapter extends RecyclerView.Adapter<Viewpager2Adapter.ViewHolder> {
    private ArrayList arrayList1 = new ArrayList();
    private ArrayList arrayList2 = new ArrayList();

    public Viewpager2Adapter() {
        arrayList1.add("Xiaomi");
        arrayList1.add("Huawei");
        arrayList1.add("Apple");
        arrayList1.add("Oppo");
        arrayList1.add("Vivo");
        arrayList2.add(R.drawable.xiaomi);
        arrayList2.add(R.drawable.huawei);
        arrayList2.add(R.drawable.apple);
        arrayList2.add(R.drawable.oppo);
        arrayList2.add(R.drawable.vivo);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder=new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewpage,parent,false));
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mtext.setText((CharSequence) arrayList1.get(position));
        holder.mimageView.setImageResource((Integer) arrayList2.get(position));

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtext;
        ImageView mimageView;
        LinearLayout mlinear;
        ViewPager2 mview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtext=itemView.findViewById(R.id.text);
            mlinear=itemView.findViewById(R.id.linear);
            mimageView=itemView.findViewById(R.id.image);
            mview=itemView.findViewById(R.id.itemxiaomi);
        }
    }
}
