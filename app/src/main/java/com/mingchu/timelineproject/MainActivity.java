package com.mingchu.timelineproject;

import android.os.BaseBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.mingchu.timelineproject.bean.BaseBean;
import com.mingchu.timelineproject.bean.JavaBean;

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
    }

    public void requestData(View view){
        initRecyclerView();
        initData();
    }

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
        Collections.reverse(datasBeen);  //数组反转
        mExpressDeliveryAdapter.setJavaBeen(datasBeen);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }
}
