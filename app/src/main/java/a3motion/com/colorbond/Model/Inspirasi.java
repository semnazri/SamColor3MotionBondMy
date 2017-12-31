package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Inspirasi {
    String InspirasiTitle, Inspirasi_creator_name, Inspirasi_creator_job;

    public Inspirasi() {
    }

    public Inspirasi(String inspirasiTitle, String inspirasi_creator_name, String inspirasi_creator_job) {
        this.InspirasiTitle = inspirasiTitle;
        this.Inspirasi_creator_name = inspirasi_creator_name;
        this.Inspirasi_creator_job = inspirasi_creator_job;
    }

    public String getInspirasi_creator_job() {
        return Inspirasi_creator_job;
    }

    public void setInspirasi_creator_job(String inspirasi_creator_job) {
        Inspirasi_creator_job = inspirasi_creator_job;
    }

    public String getInspirasi_creator_name() {
        return Inspirasi_creator_name;
    }

    public void setInspirasi_creator_name(String inspirasi_creator_name) {
        Inspirasi_creator_name = inspirasi_creator_name;
    }

    public String getInspirasiTitle() {
        return InspirasiTitle;
    }

    public void setInspirasiTitle(String inspirasiTitle) {
        InspirasiTitle = inspirasiTitle;
    }
}
