
package com.assignmentchuyennt.ui.latest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Links_ {

    @SerializedName("self")
    @Expose
    private List<Self_> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection_> collection = null;

    public List<Self_> getSelf() {
        return self;
    }

    public void setSelf(List<Self_> self) {
        this.self = self;
    }

    public List<Collection_> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection_> collection) {
        this.collection = collection;
    }

}
