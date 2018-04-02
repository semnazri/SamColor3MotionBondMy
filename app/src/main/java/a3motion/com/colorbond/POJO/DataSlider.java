package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSlider {

    @SerializedName("id_reward_slider")
    @Expose
    private String idRewardSlider;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("type")
    @Expose
    private String type;

    public String getIdRewardSlider() {
        return idRewardSlider;
    }

    public void setIdRewardSlider(String idRewardSlider) {
        this.idRewardSlider = idRewardSlider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
