package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Event {
    String date, jam, nama_event, temaevent, pic, location;

    public Event() {
    }

    public Event(String date, String jam, String nama_event, String temaevent, String pic, String location) {
        this.date = date;
        this.jam = jam;
        this.nama_event = nama_event;
        this.temaevent = temaevent;
        this.pic = pic;
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getJam() {
        return jam;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setNama_event(String nama_event) {
        this.nama_event = nama_event;
    }

    public String getNama_event() {
        return nama_event;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setTemaevent(String temaevent) {
        this.temaevent = temaevent;
    }

    public String getTemaevent() {
        return temaevent;
    }

}
