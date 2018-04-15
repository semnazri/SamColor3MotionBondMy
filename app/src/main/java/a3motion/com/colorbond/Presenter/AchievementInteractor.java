package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.TeamAchivementResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 09/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface AchievementInteractor {

    void getAchievement(String token, AchievementInteractor.OnSuccessgetAchievementListener listener);

    interface OnSuccessgetAchievementListener {
        void onSuccess(String response_message, TeamAchivementResponse teamAchivementResponse);

        void onelseError(String response_message);
    }

}
