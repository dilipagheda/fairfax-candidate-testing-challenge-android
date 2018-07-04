
package au.com.fairfaxmedia.newsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sectionPath")
    @Expose
    private String sectionPath;
    @SerializedName("orderNum")
    @Expose
    private Integer orderNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSectionPath() {
        return sectionPath;
    }

    public void setSectionPath(String sectionPath) {
        this.sectionPath = sectionPath;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

}
