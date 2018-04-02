package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RewardSliderResponse;
import a3motion.com.colorbond.View.RewardSliderVIew;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class RewardSliderPresenterImp implements RewardSliderPresenter, RewardSliderInteractor.OnSuccessgetEventListener {
    private RewardSliderVIew rewardSliderVIew;
    private RewardSliderInteractor rewardSliderInteractor;

    public RewardSliderPresenterImp(RewardSliderVIew rewardSliderVIew) {
        this.rewardSliderVIew = rewardSliderVIew;
        this.rewardSliderInteractor = new RewardSliderInteractorImp();
    }


    @Override
    public void getListEvent(String token, String type) {
        rewardSliderInteractor.getSlider(token, type, this);
    }

    @Override
    public void onDestroy() {
        rewardSliderVIew = null;
    }


    @Override
    public void onSuccess(String response_message, RewardSliderResponse rewardSliderResponse) {
        if (rewardSliderVIew != null) {
            rewardSliderVIew.ResultSlider(response_message, rewardSliderResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (rewardSliderVIew != null) {
            rewardSliderVIew.setelseEror(response_message);
        }
    }
}
