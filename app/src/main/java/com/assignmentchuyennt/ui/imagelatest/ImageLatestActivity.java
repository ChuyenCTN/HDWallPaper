package com.assignmentchuyennt.ui.imagelatest;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.common.SpacesItemDecoration;
import com.assignmentchuyennt.ui.base.BaseActivity;
import com.assignmentchuyennt.ui.imagedetail.ImageDetailActivity;
import com.assignmentchuyennt.ui.imagelatest.adapter.AdapterImageLatest;
import com.assignmentchuyennt.ui.imagelatest.model.ListImageLatets;
import com.assignmentchuyennt.ui.latest.apdater.ItemClick;

import java.util.ArrayList;
import java.util.List;

public class ImageLatestActivity extends BaseActivity<ImageLatestPresenter> implements ImageLatestView {
    private SwipeRefreshLayout refreshListImageLatest;
    private RecyclerView rcvListImageLatest;
    private Toolbar toolBarImageLatest;
    private TextView tvTitleImageLatest;


    private AdapterImageLatest adapterImageLatest;
    private List<ListImageLatets> imageLatetsList = new ArrayList<>();
    String parent = "";


    @Override
    protected int getIdLayout() {
        return R.layout.activity_image_latest;
    }

    @Override
    protected void initData() {
        refreshListImageLatest = (SwipeRefreshLayout) findViewById(R.id.refresh_ListImageLatest);
        rcvListImageLatest = (RecyclerView) findViewById(R.id.rcv_ListImageLatest);
        toolBarImageLatest = (Toolbar) findViewById(R.id.toolBarImageLatest);
        tvTitleImageLatest = (TextView) findViewById(R.id.tv_title_ImageLatest);
        setSupportActionBar(toolBarImageLatest);

        mPresenter = new ImageLatestPresenter();
        mPresenter.attachView(this);

        initRecycleView();

        Intent intent = getIntent();
        tvTitleImageLatest.setText(intent.getStringExtra("title"));
        parent = intent.getStringExtra("parent");
        mPresenter.fetchImageLatest(parent);


        adapterImageLatest.setItemClick(new ItemClick() {
            @Override
            public void onClick(int postion) {
                ListImageLatets imageLatets = imageLatetsList.get(postion);
                Intent intent1 = new Intent(getApplicationContext(), ImageDetailActivity.class);
                intent1.putExtra("url", imageLatets.getSourceUrl());
                startActivity(intent1);
            }
        });

        refreshListImageLatest.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rcvListImageLatest.removeAllViewsInLayout();
                adapterImageLatest.clearList();
                mPresenter.fetchImageLatest(parent);
            }
        });

    }

    private void initRecycleView() {
        adapterImageLatest = new AdapterImageLatest(imageLatetsList,1);
        rcvListImageLatest.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rcvListImageLatest.addItemDecoration(new SpacesItemDecoration(2, 20, false));
        rcvListImageLatest.setAdapter(adapterImageLatest);
    }


    @Override
    public void showLoading() {
        if (!refreshListImageLatest.isRefreshing()) {
            refreshListImageLatest.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        if (refreshListImageLatest.isRefreshing()) {
            refreshListImageLatest.setRefreshing(false);
        }
    }

    @Override
    public void showListisEmpty(String message) {

    }

    @Override
    public void showError() {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(List<ListImageLatets> imageLatets) {
        this.imageLatetsList.addAll(imageLatets);
        adapterImageLatest.updateData(imageLatets);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void backActivity(View view) {
        onBackPressed();
    }
}
