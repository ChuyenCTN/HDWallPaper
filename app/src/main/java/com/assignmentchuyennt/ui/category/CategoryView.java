package com.assignmentchuyennt.ui.category;

import com.assignmentchuyennt.ui.base.MVPView;
import com.assignmentchuyennt.ui.category.model.Category;

import java.util.List;

public interface CategoryView extends MVPView {
    void showData(List<Category> categoryList);

}
