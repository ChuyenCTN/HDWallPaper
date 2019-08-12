package com.assignmentchuyennt.ui.base;

public interface Presenter<V extends MVPView> {
    void attachView(V mvpView);

    void detachView();

    void subscribe();

    void unSubscribe();
}
