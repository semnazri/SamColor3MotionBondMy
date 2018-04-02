package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RewardSliderResponse {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("Data")
    @Expose
    private List<DataSlider> data = null;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<DataSlider> getData() {
        return data;
    }

    public void setData(List<DataSlider> data) {
        this.data = data;
    }
}
