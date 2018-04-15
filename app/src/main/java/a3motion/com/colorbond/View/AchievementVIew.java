package a3motion.com.colorbond.View;

import a3motion.com.colorbond.Model.TeamAchivement;
import a3motion.com.colorbond.POJO.TeamAchivementResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface AchievementVIew {

    void ResultAchievement(String response_message, TeamAchivementResponse teamAchivement);

    void setelseEror(String response_message);
}
