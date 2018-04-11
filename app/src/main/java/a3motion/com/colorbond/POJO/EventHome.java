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

public class EventHome {
    @SerializedName("id_events")
    @Expose
    private String idEvents;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tema")
    @Expose
    private String tema;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("cp")
    @Expose
    private String cp;
    @SerializedName("followers")
    @Expose
    private String followers;
    @SerializedName("fileimg")
    @Expose
    private String fileimg;
    @SerializedName("type")
    @Expose
    private String type;

    public String getIdEvents() {
        return idEvents;
    }

    public void setIdEvents(String idEvents) {
        this.idEvents = idEvents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFileimg() {
        return fileimg;
    }

    public void setFileimg(String fileimg) {
        this.fileimg = fileimg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
