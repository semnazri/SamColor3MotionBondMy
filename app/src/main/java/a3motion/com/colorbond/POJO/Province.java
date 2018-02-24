package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 24/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Province {

    @SerializedName("id_project")
    @Expose
    private String idProject;
    @SerializedName("id_users")
    @Expose
    private String idUsers;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("phase")
    @Expose
    private String phase;
    @SerializedName("imgfiles")
    @Expose
    private String imgfiles;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("member_device_token")
    @Expose
    private String memberDeviceToken;
    @SerializedName("status")
    @Expose
    private String status;

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

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getImgfiles() {
        return imgfiles;
    }

    public void setImgfiles(String imgfiles) {
        this.imgfiles = imgfiles;
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

    public String getMemberDeviceToken() {
        return memberDeviceToken;
    }

    public void setMemberDeviceToken(String memberDeviceToken) {
        this.memberDeviceToken = memberDeviceToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
