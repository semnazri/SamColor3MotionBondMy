package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 13/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Datum {

    @SerializedName("id_notification")
    @Expose
    private String idNotification;
    @SerializedName("id_users")
    @Expose
    private String idUsers;
    @SerializedName("id_owner")
    @Expose
    private String idOwner;
    @SerializedName("id_project")
    @Expose
    private String idProject;
    @SerializedName("title_notification")
    @Expose
    private String titleNotification;
    @SerializedName("notification")
    @Expose
    private String notification;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type_notification")
    @Expose
    private String typeNotification;
    @SerializedName("project_location")
    @Expose
    private String projectLocation;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("sales_incharge")
    @Expose
    private String salesIncharge;

    public String getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(String idNotification) {
        this.idNotification = idNotification;
    }

    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    public String getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(String idOwner) {
        this.idOwner = idOwner;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public String getTitleNotification() {
        return titleNotification;
    }

    public void setTitleNotification(String titleNotification) {
        this.titleNotification = titleNotification;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(String typeNotification) {
        this.typeNotification = typeNotification;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSalesIncharge() {
        return salesIncharge;
    }

    public void setSalesIncharge(String salesIncharge) {
        this.salesIncharge = salesIncharge;
    }
}
