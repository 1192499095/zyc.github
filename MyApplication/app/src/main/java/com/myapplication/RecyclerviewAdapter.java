package com.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.LinearViewHolder> {
    private Context mContext;
    private List mdata=new ArrayList();
    private OnItemClickListener onItemClickListener;

    public RecyclerviewAdapter(Context mContext,List mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_recycle, null);
        LinearViewHolder myViewHoder = new LinearViewHolder(view);
        return myViewHoder;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    public void setOnItemClickListener(RecyclerviewAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        holder.mtext.setText(((Data)mdata.get(position)).getText());
        holder.mimageView.setImageResource(((Data)mdata.get(position)).getImagesrc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, pos);
                }
                //表示此事件已经消费，不会触发单击事件
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        TextView mtext;
        ImageView mimageView;
        LinearLayout mlinear;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            mtext=itemView.findViewById(R.id.textrecy);
            mlinear=itemView.findViewById(R.id.linearrecy);
            mimageView=itemView.findViewById(R.id.imagerecy);
        }
    }
}
