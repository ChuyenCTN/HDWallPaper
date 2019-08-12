package com.assignmentchuyennt.ui.base;

public interface MVPView extends BaseView {
    void showLoading();

    void hideLoading();

    void showListisEmpty(String message);
}
