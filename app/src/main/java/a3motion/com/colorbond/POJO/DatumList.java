package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumList {
    @SerializedName("id_master_reward")
    @Expose
    private String idMasterReward;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("poin")
    @Expose
    private String poin;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("type_reward")
    @Expose
    private String typeReward;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("type_user")
    @Expose
    private String typeUser;

    public String getIdMasterReward() {
        return idMasterReward;
    }

    public void setIdMasterReward(String idMasterReward) {
        this.idMasterReward = idMasterReward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoin() {
        return poin;
    }

    public void setPoin(String poin) {
        this.poin = poin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTypeReward() {
        return typeReward;
    }

    public void setTypeReward(String typeReward) {
        this.typeReward = typeReward;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

}
