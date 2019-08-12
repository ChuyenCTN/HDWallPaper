package com.assignmentchuyennt.ui.latest;

import com.assignmentchuyennt.ui.base.MVPView;
import com.assignmentchuyennt.ui.latest.model.Latest;

import java.util.List;

public interface LatestView extends MVPView {
    void showData(List<Latest> latestList);

}
