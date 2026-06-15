package com.difa.endemikdb.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Entity(tableName = "endemik")
public class Endemik implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int internalId;

    @SerializedName("id")
    private String id;
    
    @SerializedName("tipe")
    private String category;
    
    @SerializedName("nama")
    private String name;
    
    @SerializedName("nama_latin")
    private String latinName;
    
    @SerializedName("famili")
    private String family;
    
    @SerializedName("genus")
    private String genus;
    
    @SerializedName("deskripsi")
    private String description;
    
    @SerializedName("asal")
    private String region;
    
    @SerializedName("sebaran")
    private String distribution;
    
    @SerializedName("foto")
    private String imageUrl;
    
    @SerializedName("sumber_foto")
    private String photoSource;
    
    @SerializedName("vidio")
    private String videoUrl;
    
    @SerializedName("sumber_vidio")
    private String videoSource;
    
    @SerializedName("status")
    private String status;

    public int getInternalId() { return internalId; }
    public void setInternalId(int internalId) { this.internalId = internalId; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
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