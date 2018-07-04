
package au.com.fairfaxmedia.newsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("authors")
    @Expose
    private List<Object> authors = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("lastModified")
    @Expose
    private long lastModified;
    @SerializedName("onTime")
    @Expose
    private long onTime;
    @SerializedName("sponsored")
    @Expose
    private Boolean sponsored;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("assets")
    @Expose
    private List<Asset> assets = null;
    @SerializedName("relatedAssets")
    @Expose
    private List<Object> relatedAssets = null;
    @SerializedName("relatedImages")
    @Expose
    private List<Object> relatedImages = null;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("timeStamp")
    @Expose
    private long timeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public List<Object> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Object> authors) {
        this.authors = authors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Integer lastModified) {
        this.lastModified = lastModified;
    }

    public long getOnTime() {
        return onTime;
    }

    public void setOnTime(long onTime) {
        this.onTime = onTime;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Object> getRelatedAssets() {
        return relatedAssets;
    }

    public void setRelatedAssets(List<Object> relatedAssets) {
        this.relatedAssets = relatedAssets;
    }

    public List<Object> getRelatedImages() {
        return relatedImages;
    }

    public void setRelatedImages(List<Object> relatedImages) {
        this.relatedImages = relatedImages;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

}
