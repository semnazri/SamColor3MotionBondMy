package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.SubmitResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface RewardReedemInteractor {

    void doRequest(String token, String id_master_reward, String status, OnSuccessOrderRewardListener listener);

    interface OnSuccessOrderRewardListener {

        void onSuccess(String response_message, SubmitResponse submitResponse);

        void onelseError(String response_message);

    }

}
