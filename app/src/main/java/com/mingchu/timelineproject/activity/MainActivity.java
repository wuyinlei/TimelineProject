package com.mingchu.timelineproject.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.mingchu.timelineproject.R;
import com.mingchu.timelineproject.adapter.ExpressDeliveryAdapter;
import com.mingchu.timelineproject.bean.JavaBean;
import com.mingchu.timelineproject.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExpressDeliveryAdapter mExpressDeliveryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRecyclerView();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        },3000);

    }

//    public void requestData(View view){
//        initRecyclerView();
//        initData();
//    }

    private void initRecyclerView() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mExpressDeliveryAdapter = new ExpressDeliveryAdapter();
        mRecyclerView.setAdapter(mExpressDeliveryAdapter);
    }

    private void initData() {
        String result = JsonUtils.getJson(this, "express_delivery.json");
        Gson gson = new Gson();
        JavaBean javaBean = gson.fromJson(result, JavaBean.class);
        List<JavaBean.DatasBean> datasBeen = new ArrayList<>();
        datasBeen = javaBean.getDatas();
        Collections.reverse(datasBeen);  //数组反转  这个到真实环境的时候就看请求回来的数据和产品的排版方式了
        mExpressDeliveryAdapter.setJavaBeen(datasBeen);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }
}
