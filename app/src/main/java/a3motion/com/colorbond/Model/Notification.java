package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Notification {

    String title, headline, desc;
    int notif_Code;

    public Notification() {
    }

    public Notification(String title, String headline, String desc, int notif_Code) {

        this.title = title;
        this.headline = headline;
        this.desc = desc;
        this.notif_Code = notif_Code;
    }

    public int getNotif_Code() {
        return notif_Code;
    }

    public void setNotif_Code(int notif_Code) {
        this.notif_Code = notif_Code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
