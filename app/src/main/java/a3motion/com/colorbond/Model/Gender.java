package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/19/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Gender {

    String tipe_name, tipe_id;

    public Gender() {
    }

    public Gender(String tipe_name, String tipe_id) {
        this.tipe_name = tipe_name;
        this.tipe_id = tipe_id;
    }

    public String getTipe_id() {
        return tipe_id;
    }

    public void setTipe_id(String tipe_id) {
        this.tipe_id = tipe_id;
    }

    public String getTipe_name() {
        return tipe_name;
    }

    public void setTipe_name(String tipe_name) {
        this.tipe_name = tipe_name;
    }
}
