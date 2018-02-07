package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/3/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LatestProject_ {

    String place, detail_place, date, project_name, project_desc;
    int statusnya;

    public LatestProject_() {
    }

    public LatestProject_(String place, String detail_place, String date, int statusnya) {

        this.place = place;
        this.detail_place = detail_place;
        this.date = date;
        this.statusnya = statusnya;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatusnya() {
        return statusnya;
    }

    public void setStatusnya(int statusnya) {
        this.statusnya = statusnya;
    }

    public String getDetail_place() {
        return detail_place;
    }

    public void setDetail_place(String detail_place) {
        this.detail_place = detail_place;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
