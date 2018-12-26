package com.etherealmobile.crackwatcher_pcgames.model;

public class PopularModel {
    private String title;
    private String image;
    private String drm;
    private String sceneGroup;
    private String cracked;
    private String cImage;

    public PopularModel() {
        // Needed for Firebase
    }

    public PopularModel(String title, String image, String drm, String sceneGroup, String cracked, String cImage) {
        this.title = title;
        this.image = image;
        this.drm = drm;
        this.sceneGroup = sceneGroup;
        this.cracked = cracked;
        this.cImage = cImage;
    }

    public String getCracked() {
        return cracked;
    }

    public void setCracked(String cracked) {
        this.cracked = cracked;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDrm() {
        return drm;
    }

    public void setDrm(String drm) {
        this.drm = drm;
    }

    public String getSceneGroup() {
        return sceneGroup;
    }

    public void setSceneGroup(String sceneGroup) {
        this.sceneGroup = sceneGroup;
    }
}
