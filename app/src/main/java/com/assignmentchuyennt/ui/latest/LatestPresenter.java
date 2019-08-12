package com.assignmentchuyennt.ui.latest;

import com.assignmentchuyennt.network.APIService;
import com.assignmentchuyennt.network.RetrofitClient;
import com.assignmentchuyennt.ui.base.BasePresenter;
import com.assignmentchuyennt.ui.category.model.Category;
import com.assignmentchuyennt.ui.latest.model.Latest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LatestPresenter extends BasePresenter<LatestView> {


    public void fetchLatest() {
        getMvpView().showLoading();
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        APIService apiService = retrofit.create(APIService.class);
        Call call = apiService.getLastest();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.code() == 200 && response.body() != null) {
                    getMvpView().showData((List<Latest>) response.body());
                    getMvpView().hideLoading();
                } else {
                    getMvpView().showError();
                    getMvpView().hideLoading();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                getMvpView().hideLoading();
                getMvpView().showError();
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
