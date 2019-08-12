package com.assignmentchuyennt.ui.category;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.ui.base.BaseFragment;
import com.assignmentchuyennt.ui.category.adapter.AdapterListCategory;
import com.assignmentchuyennt.ui.category.model.Category;
import com.assignmentchuyennt.widget.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CategoryFragment extends BaseFragment<CategoryPresenter> implements CategoryView {

    AdapterListCategory adapter;
    List<Category> categoryList = new ArrayList<>();

    @BindView(R.id.rcv_latest)
    RecyclerView rcvCategory;

    @BindView(R.id.refresh_ListLatest)
    SwipeRefreshLayout refreshListCategory;

    private EndlessRecyclerOnScrollListener scrollListener;
    int page = 1;


    @Override
    protected int getIdLayout() {
        return R.layout.fragment_latest;
    }

    @Override
    protected void initData(View mView) {
        rcvCategory = mView.findViewById(R.id.rcv_latest);
        refreshListCategory = mView.findViewById(R.id.refresh_ListLatest);
        mPresenter = new CategoryPresenter();
        mPresenter.attachView(this);

        initRecycleView();

        mPresenter.fetchCatgory(page, 20);

        refreshListCategory.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                rcvCategory.removeAllViewsInLayout();
                adapter.clearList();
                mPresenter.fetchCatgory(page, 20);
            }
        });


    }


    @Override
    public void showLoading() {
        if (!refreshListCategory.isRefreshing()) {
            refreshListCategory.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        if (refreshListCategory.isRefreshing()) {
            refreshListCategory.setRefreshing(false);
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
        adapter = new AdapterListCategory(categoryList);
        rcvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvCategory.setAdapter(adapter);
    }


    @Override
    public void showData(List<Category> categoryList) {
        adapter.updateList(categoryList);
    }
}
