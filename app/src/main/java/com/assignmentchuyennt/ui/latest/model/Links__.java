
package com.assignmentchuyennt.ui.latest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Links__ {

    @SerializedName("self")
    @Expose
    private List<Self__> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection__> collection = null;
    @SerializedName("about")
    @Expose
    private List<About_> about = null;
    @SerializedName("author")
    @Expose
    private List<Author__> author = null;
    @SerializedName("replies")
    @Expose
    private List<Reply_> replies = null;

    public List<Self__> getSelf() {
        return self;
    }

    public void setSelf(List<Self__> self) {
        this.self = self;
    }

    public List<Collection__> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection__> collection) {
        this.collection = collection;
    }

    public List<About_> getAbout() {
        return about;
    }

    public void setAbout(List<About_> about) {
        this.about = about;
    }

    public List<Author__> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author__> author) {
        this.author = author;
    }

    public List<Reply_> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply_> replies) {
        this.replies = replies;
    }

}
