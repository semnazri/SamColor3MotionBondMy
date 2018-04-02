package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RewardListResponse;
import a3motion.com.colorbond.POJO.RewardSliderResponse;
import a3motion.com.colorbond.View.RewardListVIew;
import a3motion.com.colorbond.View.RewardSliderVIew;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class RewardListPresenterImp implements RewardListPresenter, RewardListInteractor.OnSuccessgetEventListener {
    private RewardListVIew rewardListVIew;
    private RewardListInteractor rewardListInteractor;

    public RewardListPresenterImp(RewardListVIew rewardListVIew) {
        this.rewardListVIew = rewardListVIew;
        this.rewardListInteractor = new RewardListInteractorImp();
    }


    @Override
    public void getListRewards(String token, String type_user, String type_reward) {
        rewardListInteractor.getSlider(token, type_user ,type_reward, this);
    }

    @Override
    public void onDestroy() {
        rewardListVIew = null;
    }


    @Override
    public void onSuccess(String response_message, RewardListResponse rewardListResponse) {
        if (rewardListVIew != null) {
            rewardListVIew.ResultList(response_message, rewardListResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (rewardListVIew != null) {
            rewardListVIew.setelseEror(response_message);
        }
    }
}
