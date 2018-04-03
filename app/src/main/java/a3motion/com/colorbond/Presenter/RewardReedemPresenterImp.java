package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.SubmitResponse;
import a3motion.com.colorbond.View.RewardReedemView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class RewardReedemPresenterImp implements RewardReedemPresenter, RewardReedemInteractor.OnSuccessOrderRewardListener {
    private RewardReedemView rewardReedemView;
    private RewardReedemInteractor rewardReedemInteractor;

    public RewardReedemPresenterImp(RewardReedemView rewardReedemView) {
        this.rewardReedemView = rewardReedemView;
        this.rewardReedemInteractor = new RewardReedemInteractorImp();
    }

    @Override
    public void doOrderReward(String token, String id_master_reward, String status) {
        rewardReedemInteractor.doRequest(token, id_master_reward, status, this);
    }

    @Override
    public void onDestroy() {
        rewardReedemView = null;
    }


    @Override
    public void onSuccess(String response_message, SubmitResponse submitResponse) {
        if (rewardReedemView != null) {
            rewardReedemView.ResultList(response_message, submitResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (rewardReedemView != null) {
            rewardReedemView.setelseEror(response_message);
        }
    }
}
