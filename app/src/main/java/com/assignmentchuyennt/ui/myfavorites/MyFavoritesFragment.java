package com.assignmentchuyennt.ui.myfavorites;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.common.SpacesItemDecoration;
import com.assignmentchuyennt.ui.base.BaseFragment;
import com.assignmentchuyennt.ui.imagedetail.ImageDetailActivity;
import com.assignmentchuyennt.ui.imagelatest.adapter.AdapterImageLatest;
import com.assignmentchuyennt.ui.imagelatest.model.ListImageLatets;
import com.assignmentchuyennt.ui.latest.apdater.AdapterListLatest;
import com.assignmentchuyennt.ui.latest.apdater.ItemClick;
import com.assignmentchuyennt.ui.latest.model.Latest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyFavoritesFragment extends BaseFragment<MyFavoritesPresenter> implements MyFavoritesView {

    AdapterImageLatest adapterImageLatest;
    List<ListImageLatets> imageLatetsList = new ArrayList<>();

    @BindView(R.id.rcv_latest)
    RecyclerView rcvFavorites;

    @BindView(R.id.refresh_ListLatest)
    SwipeRefreshLayout refreshListFavorites;

    @Override
    protected int getIdLayout() {
        return R.layout.fragment_latest;
    }

    @Override
    protected void initData(View mView) {
        rcvFavorites = mView.findViewById(R.id.rcv_latest);
        refreshListFavorites = mView.findViewById(R.id.refresh_ListLatest);

        mPresenter = new MyFavoritesPresenter();
        mPresenter.attachView(this);

        initRecycleView();

        mPresenter.fetchImageLatest("377");


        adapterImageLatest.setItemClick(new ItemClick() {
            @Override
            public void onClick(int postion) {
                ListImageLatets imageLatets = imageLatetsList.get(postion);
                Intent intent1 = new Intent(getContext(), ImageDetailActivity.class);
                intent1.putExtra("url", imageLatets.getSourceUrl());
                startActivity(intent1);
            }
        });

        refreshListFavorites.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rcvFavorites.removeAllViewsInLayout();
                adapterImageLatest.clearList();
                mPresenter.fetchImageLatest("377");
            }
        });
    }


    @Override
    public void showLoading() {
        if (!refreshListFavorites.isRefreshing()) {
            refreshListFavorites.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        if (refreshListFavorites.isRefreshing()) {
            refreshListFavorites.setRefreshing(false);
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
        adapterImageLatest = new AdapterImageLatest(imageLatetsList, 0);
        rcvFavorites.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcvFavorites.addItemDecoration(new SpacesItemDecoration(2, 20, false));
        rcvFavorites.setAdapter(adapterImageLatest);
    }


    @Override
    public void showData(List<ListImageLatets> imageLatets) {
        this.imageLatetsList.addAll(imageLatets);
        adapterImageLatest.updateData(imageLatets);
    }
}
