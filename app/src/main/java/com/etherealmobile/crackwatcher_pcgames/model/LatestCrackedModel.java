package com.etherealmobile.crackwatcher_pcgames.model;

public class LatestCrackedModel {

    private String title;
    private String sceneGroup;
    private String date;
    private String image;

    public LatestCrackedModel(String title, String sceneGroup, String date, String image) {
        this.title = title;
        this.sceneGroup = sceneGroup;
        this.date = date;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSceneGroup() {
        return sceneGroup;
    }

    public void setSceneGroup(String sceneGroup) {
        this.sceneGroup = sceneGroup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
