package com.assignmentchuyennt.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.ui.widget.ErrorView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<K> extends Fragment {
    protected K mPresenter;

    protected View mView;

    private ErrorView mErrorView;

    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter instanceof BasePresenter) {
            ((BasePresenter) mPresenter).subscribe();
        }
    }

    protected abstract int getIdLayout();

    protected abstract void initData(View mView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getIdLayout(), container, false);
        mUnbinder = ButterKnife.bind(mView);
        initData(mView);
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        if (mPresenter instanceof BasePresenter) {
            ((BasePresenter) mPresenter).unSubscribe();
        }
    }

    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showSnackbar(CoordinatorLayout coordinatorLayout, String message) {
        if (coordinatorLayout != null) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, message, Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
    }

    public void showErrorScreen() {
        if (mView != null) {
            mErrorView = mView.findViewById(R.id.viewError);
            if (mErrorView != null) {
                mErrorView.setVisibility(View.VISIBLE);
            }
        }

    }

    private void hideErrorView() {
        if (mView != null) {
            mErrorView = mView.findViewById(R.id.viewError);
            if (mErrorView != null) {
                mErrorView.setVisibility(View.GONE);
            }
        }
    }
}