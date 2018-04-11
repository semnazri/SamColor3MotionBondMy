package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 18/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class HomeResponse {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("Event")
    @Expose
    private List<Event> event = null;
    @SerializedName("Profile")
    @Expose
    private HomeProfile profile;
    @SerializedName("Latest Project")
    @Expose
    private List<HomeLatestProject> latestProject = null;
    @SerializedName("Image")
    @Expose
    private HomeImage image;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public HomeProfile getProfile() {
        return profile;
    }

    public void setProfile(HomeProfile profile) {
        this.profile = profile;
    }

    public List<HomeLatestProject> getLatestProject() {
        return latestProject;
    }

    public void setLatestProject(List<HomeLatestProject> latestProject) {
        this.latestProject = latestProject;
    }

    public HomeImage getImage() {
        return image;
    }

    public void setImage(HomeImage image) {
        this.image = image;
    }

}
