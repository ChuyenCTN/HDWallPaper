package com.assignmentchuyennt.ui.latest;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.common.SpacesItemDecoration;
import com.assignmentchuyennt.ui.base.BaseFragment;
import com.assignmentchuyennt.ui.imagelatest.ImageLatestActivity;
import com.assignmentchuyennt.ui.latest.apdater.AdapterListLatest;
import com.assignmentchuyennt.ui.latest.apdater.ItemClick;
import com.assignmentchuyennt.ui.latest.model.Latest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LatestFragment extends BaseFragment<LatestPresenter> implements LatestView {

    AdapterListLatest adapterListLatest;
    List<Latest> latestList = new ArrayList<>();

    @BindView(R.id.rcv_latest)
    RecyclerView rcvLatest;

    @BindView(R.id.refresh_ListLatest)
    SwipeRefreshLayout refreshListLatest;

    @Override
    protected int getIdLayout() {
        return R.layout.fragment_latest;
    }

    @Override
    protected void initData(View mView) {
        rcvLatest = mView.findViewById(R.id.rcv_latest);
        refreshListLatest = mView.findViewById(R.id.refresh_ListLatest);
        mPresenter = new LatestPresenter();
        mPresenter.attachView(this);
        initRecycleView();

        mPresenter.fetchLatest();


        refreshListLatest.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rcvLatest.removeAllViewsInLayout();
                adapterListLatest.clearList();
                mPresenter.fetchLatest();
            }
        });

        adapterListLatest.setItemClick(new ItemClick() {
            @Override
            public void onClick(int postion) {
                Latest latest = latestList.get(postion);
                Intent intent = new Intent(getContext(), ImageLatestActivity.class);
                intent.putExtra("title", latest.getTitle().getRendered());
                intent.putExtra("parent", latest.getId().toString());
                startActivity(intent);

            }
        });
    }


    @Override
    public void showLoading() {
        if (!refreshListLatest.isRefreshing()) {
            refreshListLatest.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        if (refreshListLatest.isRefreshing()) {
            refreshListLatest.setRefreshing(false);
        }
    }

    @Override
    public void showListisEmpty(String message) {

    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
    }

    void initRecycleView() {
        adapterListLatest = new AdapterListLatest(latestList);
        rcvLatest.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcvLatest.addItemDecoration(new SpacesItemDecoration(2, 20, false));
        rcvLatest.setAdapter(adapterListLatest);
    }

    @Override
    public void showData(List<Latest> latestList) {
        this.latestList.addAll(latestList);
        adapterListLatest.updateList(latestList);
    }
}
