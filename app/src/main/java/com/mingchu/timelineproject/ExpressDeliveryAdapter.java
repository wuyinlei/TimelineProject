package com.mingchu.timelineproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingchu.timelineproject.bean.JavaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyinlei on 2017/5/10.
 */

public class ExpressDeliveryAdapter extends RecyclerView.Adapter<ExpressDeliveryAdapter.ViewHolder> {

    private List<JavaBean.DatasBean> mJavaBeen = new ArrayList<>();


    public void setJavaBeen(List<JavaBean.DatasBean> javaBeen) {
        mJavaBeen = javaBeen;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.express_delivery_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JavaBean.DatasBean javaBean = mJavaBeen.get(position);
        if (javaBean.getType().equals("0")){
            //发出图片

        } else if (javaBean.getType().equals("1")){
            //运送中图片

        } else if (javaBean.getType().equals("2")){
            //派送中图片

        } else if (javaBean.getType().equals("3")){
            //签收中图片

        }
        holder.mTvData.setText(javaBean.getDataAndTime()[0]);
        holder.mTvTime.setText(javaBean.getDataAndTime()[1]);
        holder.mTvAddressDetail.setText(javaBean.getAddress());

    }

    @Override
    public int getItemCount() {
        return mJavaBeen == null ? 0 : mJavaBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mExpressDeliveryImg;
        TextView mTvTime,mTvData,mTvAddressDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            mExpressDeliveryImg = (ImageView) itemView.findViewById(R.id.express_delivery_img);
            mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
            mTvData = (TextView) itemView.findViewById(R.id.tv_data);
            mTvAddressDetail = (TextView) itemView.findViewById(R.id.tv_address_detail);
        }
    }
}
