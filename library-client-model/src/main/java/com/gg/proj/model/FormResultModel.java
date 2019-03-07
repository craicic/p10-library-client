package com.gg.proj.model;

public class FormResultModel {

    private Integer languageId;
    private Integer libraryId;
    private Integer topicId;
    private boolean available;

    public FormResultModel() {
    }

    public FormResultModel(Integer languageId, Integer libraryId, Integer topicId, boolean available) {
        this.languageId = languageId;
        this.libraryId = libraryId;
        this.topicId = topicId;
        this.available = available;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
