
package au.com.fairfaxmedia.newsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RelatedImage {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("brands")
    @Expose
    private List<Object> brands = null;
    @SerializedName("authors")
    @Expose
    private List<Object> authors = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("lastModified")
    @Expose
    private long lastModified;
    @SerializedName("sponsored")
    @Expose
    private Boolean sponsored;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photographer")
    @Expose
    private String photographer;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("xLarge@2x")
    @Expose
    private String xLarge2x;
    @SerializedName("large@2x")
    @Expose
    private String large2x;
    @SerializedName("timeStamp")
    @Expose
    private long timeStamp;
    @SerializedName("xLarge")
    @Expose
    private String xLarge;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("thumbnail@2x")
    @Expose
    private String thumbnail2x;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

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

    public List<Object> getBrands() {
        return brands;
    }

    public void setBrands(List<Object> brands) {
        this.brands = brands;
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

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getXLarge2x() {
        return xLarge2x;
    }

    public void setXLarge2x(String xLarge2x) {
        this.xLarge2x = xLarge2x;
    }

    public String getLarge2x() {
        return large2x;
    }

    public void setLarge2x(String large2x) {
        this.large2x = large2x;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getXLarge() {
        return xLarge;
    }

    public void setXLarge(String xLarge) {
        this.xLarge = xLarge;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getThumbnail2x() {
        return thumbnail2x;
    }

    public void setThumbnail2x(String thumbnail2x) {
        this.thumbnail2x = thumbnail2x;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
