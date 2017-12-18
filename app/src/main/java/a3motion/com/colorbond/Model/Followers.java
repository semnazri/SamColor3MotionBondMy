package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Followers {
    String followers_name, followers_job, followers_company;

    public Followers() {
    }

    public Followers(String followers_name, String followers_job, String followers_company) {
        this.followers_name = followers_name;
        this.followers_job = followers_job;
        this.followers_company = followers_company;
    }

    public void setFollowers_company(String followers_company) {
        this.followers_company = followers_company;
    }

    public String getFollowers_company() {
        return followers_company;
    }

    public void setFollowers_job(String followers_job) {
        this.followers_job = followers_job;
    }

    public String getFollowers_job() {
        return followers_job;
    }

    public void setFollowers_name(String followers_name) {
        this.followers_name = followers_name;
    }

    public String getFollowers_name() {
        return followers_name;
    }
}
