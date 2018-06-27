package com.gallery.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by yuan.zhen.xing on 2018-06-27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private int[] icon ;
    private Context mContext;
    private LayoutInflater inflater ;
    private ImageView iv_view;

    public MyAdapter(int[] icon, MainActivity mainActivity) {
        this.icon = icon ;
        mContext = mainActivity ;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder ;
        viewHolder.iv_view.setImageResource(icon[position]);
        if (onIvItemClickListener != null) {
            viewHolder.iv_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onIvItemClickListener.onIvClick(view,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return icon.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_view ;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_view = itemView.findViewById(R.id.iv_view);
        }
    }

    //回调
    private OnIvItemClickListener onIvItemClickListener ;

    public void setOnIvItemClickListener(OnIvItemClickListener onIvItemClickListener) {
        this.onIvItemClickListener = onIvItemClickListener ;
    }
    public interface OnIvItemClickListener{
        void onIvClick(View v,int position);
    }
}
