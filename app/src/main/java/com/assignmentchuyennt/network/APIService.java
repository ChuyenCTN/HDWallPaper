package com.assignmentchuyennt.network;

import com.assignmentchuyennt.ui.category.model.Category;
import com.assignmentchuyennt.ui.imagelatest.model.ListImageLatets;
import com.assignmentchuyennt.ui.latest.model.Latest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("wp-json/wp/v2/categories")
    Call<List<Category>> fetchCategory(@Query("page") int page, @Query("per_page") int per_page);

    @GET("wp-json/wp/v2/posts?_embed")
    Call<List<Latest>> getLastest();

    @GET("wp-json/wp/v2/media")
    Call<List<ListImageLatets>> getListImageLatest(
            @Query("parent") String parent);

}
