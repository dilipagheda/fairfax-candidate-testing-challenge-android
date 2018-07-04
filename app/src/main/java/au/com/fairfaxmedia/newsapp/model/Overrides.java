
package au.com.fairfaxmedia.newsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Overrides {

    @SerializedName("overrideHeadline")
    @Expose
    private String overrideHeadline;
    @SerializedName("overrideIdentifier")
    @Expose
    private String overrideIdentifier;
    @SerializedName("overrideAbstract")
    @Expose
    private String overrideAbstract;

    public String getOverrideHeadline() {
        return overrideHeadline;
    }

    public void setOverrideHeadline(String overrideHeadline) {
        this.overrideHeadline = overrideHeadline;
    }

    public String getOverrideIdentifier() {
        return overrideIdentifier;
    }

    public void setOverrideIdentifier(String overrideIdentifier) {
        this.overrideIdentifier = overrideIdentifier;
    }

    public String getOverrideAbstract() {
        return overrideAbstract;
    }

    public void setOverrideAbstract(String overrideAbstract) {
        this.overrideAbstract = overrideAbstract;
    }

}
