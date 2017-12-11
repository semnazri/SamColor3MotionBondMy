package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class TeamAchivement {
    String team_name, team_position, team_order_q, team_point;

    public TeamAchivement() {

    }

    public TeamAchivement(String team_name, String team_position, String team_order_q, String team_point) {
        this.team_name = team_name;
        this.team_position = team_position;
        this.team_order_q = team_order_q;
        this.team_point = team_point;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_order_q() {
        return team_order_q;
    }

    public void setTeam_order_q(String team_order_q) {
        this.team_order_q = team_order_q;
    }

    public String getTeam_point() {
        return team_point;
    }

    public void setTeam_point(String team_point) {
        this.team_point = team_point;
    }

    public String getTeam_position() {
        return team_position;
    }

    public void setTeam_position(String team_position) {
        this.team_position = team_position;
    }
}
