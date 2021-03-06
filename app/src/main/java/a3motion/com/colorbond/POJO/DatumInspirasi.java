package a3motion.com.colorbond.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumInspirasi {

    @SerializedName("id_inspirasi")
    @Expose
    private String idInspirasi;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("image_top")
    @Expose
    private String imageTop;
    @SerializedName("image_slider")
    @Expose
    private String imageSlider;
    @SerializedName("image_bottom")
    @Expose
    private String imageBottom;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("date_submit")
    @Expose
    private String dateSubmit;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("status")
    @Expose
    private String status;

    public String getIdInspirasi() {
        return idInspirasi;
    }

    public void setIdInspirasi(String idInspirasi) {
        this.idInspirasi = idInspirasi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageTop() {
        return imageTop;
    }

    public void setImageTop(String imageTop) {
        this.imageTop = imageTop;
    }

    public String getImageSlider() {
        return imageSlider;
    }

    public void setImageSlider(String imageSlider) {
        this.imageSlider = imageSlider;
    }

    public String getImageBottom() {
        return imageBottom;
    }

    public void setImageBottom(String imageBottom) {
        this.imageBottom = imageBottom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(String dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
