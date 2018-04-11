package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 18/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class HomeLatestProject {


    @SerializedName("id_project")
    @Expose
    private String idProject;
    @SerializedName("id_users")
    @Expose
    private String idUsers;
    @SerializedName("project_name")
    @Expose
    private String projectName;
    @SerializedName("project_type")
    @Expose
    private String projectType;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("building_category")
    @Expose
    private String buildingCategory;
    @SerializedName("size_category")
    @Expose
    private String sizeCategory;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("phase")
    @Expose
    private String phase;
    @SerializedName("material_1")
    @Expose
    private String material1;
    @SerializedName("material_2")
    @Expose
    private String material2;
    @SerializedName("imgfiles")
    @Expose
    private String imgfiles;
    @SerializedName("delivery_img")
    @Expose
    private String deliveryImg;
    @SerializedName("suport_img")
    @Expose
    private String suportImg;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("poin")
    @Expose
    private String poin;

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBuildingCategory() {
        return buildingCategory;
    }

    public void setBuildingCategory(String buildingCategory) {
        this.buildingCategory = buildingCategory;
    }

    public String getSizeCategory() {
        return sizeCategory;
    }

    public void setSizeCategory(String sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getMaterial1() {
        return material1;
    }

    public void setMaterial1(String material1) {
        this.material1 = material1;
    }

    public String getMaterial2() {
        return material2;
    }

    public void setMaterial2(String material2) {
        this.material2 = material2;
    }

    public String getImgfiles() {
        return imgfiles;
    }

    public void setImgfiles(String imgfiles) {
        this.imgfiles = imgfiles;
    }

    public String getDeliveryImg() {
        return deliveryImg;
    }

    public void setDeliveryImg(String deliveryImg) {
        this.deliveryImg = deliveryImg;
    }

    public String getSuportImg() {
        return suportImg;
    }

    public void setSuportImg(String suportImg) {
        this.suportImg = suportImg;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoin() {
        return poin;
    }

    public void setPoin(String poin) {
        this.poin = poin;
    }


}
