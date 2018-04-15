package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.TeamAchivementResponse;
import a3motion.com.colorbond.View.AchievementVIew;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class AchievementPresenterImp implements AchievementPresenter, AchievementInteractor.OnSuccessgetAchievementListener {
    private AchievementVIew achievementVIew;
    private AchievementInteractor achievementInteractor;

    public AchievementPresenterImp(AchievementVIew achievementVIew) {
        this.achievementVIew = achievementVIew;
        this.achievementInteractor = new AchievementInteractorImp();
    }

    @Override
    public void getAchievement(String token) {
        achievementInteractor.getAchievement(token, this);
    }

    @Override
    public void onDestroy() {
        achievementVIew = null;
    }


    @Override
    public void onSuccess(String response_message, TeamAchivementResponse teamAchivementResponse) {
        if (achievementVIew != null){
            achievementVIew.ResultAchievement(response_message,teamAchivementResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (achievementVIew != null) {
            achievementVIew.setelseEror(response_message);
        }
    }
}
