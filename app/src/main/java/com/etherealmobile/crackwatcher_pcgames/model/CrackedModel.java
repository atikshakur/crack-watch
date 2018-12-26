package com.etherealmobile.crackwatcher_pcgames.model;

public class CrackedModel {

    private String title;
    private String pubDate;
    private String image;
    private String imagePoster;
    private String releaseDate;
    private String crackDate;
    private String OriginalPrice;
    private String OriginalPlatform;
    private String DRM1;
    private String SceneGroup1;

    public CrackedModel(String title, String pubDate, String image, String imagePoster, String releaseDate, String crackDate, String originalPrice, String originalPlatform, String DRM1, String sceneGroup1) {
        this.title = title;
        this.pubDate = pubDate;
        this.image = image;
        this.imagePoster = imagePoster;
        this.releaseDate = releaseDate;
        this.crackDate = crackDate;
        OriginalPrice = originalPrice;
        OriginalPlatform = originalPlatform;
        this.DRM1 = DRM1;
        SceneGroup1 = sceneGroup1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagePoster() {
        return imagePoster;
    }

    public void setImagePoster(String imagePoster) {
        this.imagePoster = imagePoster;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCrackDate() {
        return crackDate;
    }

    public void setCrackDate(String crackDate) {
        this.crackDate = crackDate;
    }

    public String getOriginalPrice() {
        return OriginalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        OriginalPrice = originalPrice;
    }

    public String getOriginalPlatform() {
        return OriginalPlatform;
    }

    public void setOriginalPlatform(String originalPlatform) {
        OriginalPlatform = originalPlatform;
    }

    public String getDRM1() {
        return DRM1;
    }

    public void setDRM1(String DRM1) {
        this.DRM1 = DRM1;
    }

    public String getSceneGroup1() {
        return SceneGroup1;
    }

    public void setSceneGroup1(String sceneGroup1) {
        SceneGroup1 = sceneGroup1;
    }
}
