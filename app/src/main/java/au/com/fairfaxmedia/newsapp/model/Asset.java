
package au.com.fairfaxmedia.newsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Asset {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = null;
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
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("indexHeadline")
    @Expose
    private String indexHeadline;
    @SerializedName("tabletHeadline")
    @Expose
    private String tabletHeadline;
    @SerializedName("theAbstract")
    @Expose
    private String theAbstract;
    @SerializedName("byLine")
    @Expose
    private String byLine;
    @SerializedName("acceptComments")
    @Expose
    private Boolean acceptComments;
    @SerializedName("numberOfComments")
    @Expose
    private Integer numberOfComments;
    @SerializedName("relatedAssets")
    @Expose
    private List<Object> relatedAssets = null;
    @SerializedName("relatedImages")
    @Expose
    private List<RelatedImage> relatedImages = null;
    @SerializedName("companies")
    @Expose
    private List<Object> companies = null;
    @SerializedName("legalStatus")
    @Expose
    private String legalStatus;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("sources")
    @Expose
    private List<Source> sources = null;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("overrides")
    @Expose
    private Overrides overrides;
    @SerializedName("timeStamp")
    @Expose
    private long timeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
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

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getIndexHeadline() {
        return indexHeadline;
    }

    public void setIndexHeadline(String indexHeadline) {
        this.indexHeadline = indexHeadline;
    }

    public String getTabletHeadline() {
        return tabletHeadline;
    }

    public void setTabletHeadline(String tabletHeadline) {
        this.tabletHeadline = tabletHeadline;
    }

    public String getTheAbstract() {
        return theAbstract;
    }

    public void setTheAbstract(String theAbstract) {
        this.theAbstract = theAbstract;
    }

    public String getByLine() {
        return byLine;
    }

    public void setByLine(String byLine) {
        this.byLine = byLine;
    }

    public Boolean getAcceptComments() {
        return acceptComments;
    }

    public void setAcceptComments(Boolean acceptComments) {
        this.acceptComments = acceptComments;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public List<Object> getRelatedAssets() {
        return relatedAssets;
    }

    public void setRelatedAssets(List<Object> relatedAssets) {
        this.relatedAssets = relatedAssets;
    }

    public List<RelatedImage> getRelatedImages() {
        return relatedImages;
    }

    public void setRelatedImages(List<RelatedImage> relatedImages) {
        this.relatedImages = relatedImages;
    }

    public List<Object> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Object> companies) {
        this.companies = companies;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Overrides getOverrides() {
        return overrides;
    }

    public void setOverrides(Overrides overrides) {
        this.overrides = overrides;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

}
