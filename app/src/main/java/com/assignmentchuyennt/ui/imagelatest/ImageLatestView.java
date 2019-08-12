package com.assignmentchuyennt.ui.imagelatest;

import com.assignmentchuyennt.ui.base.MVPView;
import com.assignmentchuyennt.ui.imagelatest.model.ListImageLatets;

import java.util.List;

public interface ImageLatestView extends MVPView {
    void showData(List<ListImageLatets> imageLatets);

}
