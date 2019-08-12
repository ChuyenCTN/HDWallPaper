package com.assignmentchuyennt.ui.category;

import android.util.Log;

import com.assignmentchuyennt.network.APIService;
import com.assignmentchuyennt.network.RetrofitClient;
import com.assignmentchuyennt.ui.base.BasePresenter;
import com.assignmentchuyennt.ui.category.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CategoryPresenter extends BasePresenter<CategoryView> {
    String TAG = "CategoryPresenter";

    public CategoryPresenter() {
    }


    public void fetchCatgory(int page, int per_page) {
        getMvpView().showLoading();
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        APIService apiService = retrofit.create(APIService.class);
        Call call = apiService.fetchCategory(page, per_page);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.code() == 200 && response.body() != null) {
                    getMvpView().showData((List<Category>) response.body());
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
