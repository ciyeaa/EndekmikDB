package com.difa.endemikdb.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "favorit")
public class Favorit implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int internalId;
    
    private String endemikId;
    private String category;
    private String name;
    private String latinName;
    private String family;
    private String genus;
    private String description;
    private String region;
    private String distribution;
    private String imageUrl;
    private String photoSource;
    private String videoUrl;
    private String videoSource;
    private String status;

    public int getInternalId() { return internalId; }
    public void setInternalId(int internalId) { this.internalId = internalId; }
    public String getEndemikId() { return endemikId; }
    public void setEndemikId(String endemikId) { this.endemikId = endemikId; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLatinName() { return latinName; }
    public void setLatinName(String latinName) { this.latinName = latinName; }
    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }
    public String getGenus() { return genus; }
    public void setGenus(String genus) { this.genus = genus; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getDistribution() { return distribution; }
    public void setDistribution(String distribution) { this.distribution = distribution; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getPhotoSource() { return photoSource; }
    public void setPhotoSource(String photoSource) { this.photoSource = photoSource; }
    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
    public String getVideoSource() { return videoSource; }
    public void setVideoSource(String videoSource) { this.videoSource = videoSource; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}