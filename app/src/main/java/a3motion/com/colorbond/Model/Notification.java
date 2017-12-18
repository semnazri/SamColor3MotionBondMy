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

    public Notification(){}

    public Notification(String title, String headline, String desc){

        this.title = title;
        this.headline = headline;
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public String getHeadline() {
        return headline;
    }

    public String getTitle() {
        return title;
    }
}
