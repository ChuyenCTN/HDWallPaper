package com.assignmentchuyennt.ui.myfavorites;

import com.assignmentchuyennt.ui.base.MVPView;
import com.assignmentchuyennt.ui.imagelatest.model.ListImageLatets;

import java.util.List;

public interface MyFavoritesView extends MVPView {

    void showData(List<ListImageLatets> imageLatets);


}
