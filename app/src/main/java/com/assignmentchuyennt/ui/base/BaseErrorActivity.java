package com.assignmentchuyennt.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.ui.error.IDataError;
import com.assignmentchuyennt.ui.widget.ErrorView;


/**
 * Created by tuanlq@mobgame.vn on 14/5/2019.
 */
public abstract class BaseErrorActivity<K extends BasePresenter> extends BaseActivity<K> implements IDataError {

    protected ErrorView mErrorView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mErrorView = findViewById(R.id.viewError);
        if (mErrorView != null) {
            mErrorView.getBtnAction().setOnClickListener(view -> onTryAgainClick());
//            mErrorView.getBtnClose().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                }
//            });
        }
    }

    public void showErrorScreen() {
        if (mErrorView != null) {
            mErrorView.setVisibility(View.VISIBLE);
            onErrorShow();
        }
    }

    public void hideErrorView() {
        if (mErrorView != null) {
            mErrorView.setVisibility(View.GONE);
            onErrorHide();
        }
    }

    @Override
    public void onTryAgainClick() {
        hideErrorView();
    }

    @Override
    public void onErrorShow() {

    }

    @Override
    public void onErrorHide() {

    }
}
