
package com.assignmentchuyennt.ui.latest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Links___ {

    @SerializedName("self")
    @Expose
    private List<Self___> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection___> collection = null;
    @SerializedName("about")
    @Expose
    private List<About__> about = null;
    @SerializedName("wp:post_type")
    @Expose
    private List<WpPostType> wpPostType = null;
    @SerializedName("curies")
    @Expose
    private List<Cury_> curies = null;

    public List<Self___> getSelf() {
        return self;
    }

    public void setSelf(List<Self___> self) {
        this.self = self;
    }

    public List<Collection___> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection___> collection) {
        this.collection = collection;
    }

    public List<About__> getAbout() {
        return about;
    }

    public void setAbout(List<About__> about) {
        this.about = about;
    }

    public List<WpPostType> getWpPostType() {
        return wpPostType;
    }

    public void setWpPostType(List<WpPostType> wpPostType) {
        this.wpPostType = wpPostType;
    }

    public List<Cury_> getCuries() {
        return curies;
    }

    public void setCuries(List<Cury_> curies) {
        this.curies = curies;
    }

}
