
package au.com.fairfaxmedia.newsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Author {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("relatedAssets")
    @Expose
    private List<Object> relatedAssets = null;
    @SerializedName("relatedImages")
    @Expose
    private List<Object> relatedImages = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
