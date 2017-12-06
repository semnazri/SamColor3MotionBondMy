package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/3/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LatestProject {

    String project_name, project_desc;

    public LatestProject() {
    }

    public LatestProject(String project_name, String project_desc) {

        this.project_name = project_name;
        this.project_desc = project_desc;
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
