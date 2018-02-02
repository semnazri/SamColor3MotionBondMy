package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 01/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Sliderpoto {
    int count;
    String title, subtitle;

    public Sliderpoto() {
    }

    public Sliderpoto(int count, String title, String subtitle) {
        this.count = count;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
