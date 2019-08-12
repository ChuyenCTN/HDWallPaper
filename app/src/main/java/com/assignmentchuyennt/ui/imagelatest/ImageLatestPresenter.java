package com.assignmentchuyennt.ui.imagelatest;

import com.assignmentchuyennt.network.APIService;
import com.assignmentchuyennt.network.RetrofitClient;
import com.assignmentchuyennt.ui.base.BasePresenter;
import com.assignmentchuyennt.ui.imagelatest.model.ListImageLatets;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ImageLatestPresenter extends BasePresenter<ImageLatestView> {

    public void fetchImageLatest(String parent) {
        getMvpView().showLoading();
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        APIService apiService = retrofit.create(APIService.class);
        Call call = apiService.getListImageLatest(parent);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.code() == 200 && response != null) {
                    getMvpView().showData((List<ListImageLatets>) response.body());
                    getMvpView().hideLoading();
                } else {
                    getMvpView().showError();
                    getMvpView().hideLoading();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                getMvpView().showError();
                getMvpView().hideLoading();
            }
        });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
