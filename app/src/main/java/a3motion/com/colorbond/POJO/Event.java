package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Event {

    @SerializedName("id")
    @Expose
    private String id;
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
    @SerializedName("attendee")
    @Expose
    private String attendee;
    @SerializedName("joinevent")
    @Expose
    private String joinevent;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("fileimg")
    @Expose
    private String fileimg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAttendee() {
        return attendee;
    }

    public void setAttendee(String attendee) {
        this.attendee = attendee;
    }

    public String getJoinevent() {
        return joinevent;
    }

    public void setJoinevent(String joinevent) {
        this.joinevent = joinevent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileimg() {
        return fileimg;
    }

    public void setFileimg(String fileimg) {
        this.fileimg = fileimg;
    }



}
